package com.jersson.arrivasplata.swtvap.api.web.business.implementation;

import com.jersson.arrivasplata.swtvap.api.web.business.service.WOrderService;
import com.jersson.arrivasplata.swtvap.api.web.enums.OrderStatus;
import com.jersson.arrivasplata.swtvap.api.web.enums.SourceAggregate;
import com.jersson.arrivasplata.swtvap.api.web.enums.Status;
import com.jersson.arrivasplata.swtvap.api.web.exception.CustomException;
import com.jersson.arrivasplata.swtvap.api.web.model.*;
import com.jersson.arrivasplata.swtvap.api.web.repository.WClientRepository;
import com.jersson.arrivasplata.swtvap.api.web.repository.WOrderDetailRepository;
import com.jersson.arrivasplata.swtvap.api.web.repository.WOrderRepository;
import com.jersson.arrivasplata.swtvap.api.web.repository.WProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class WOrderServiceImpl implements WOrderService {
    private final WOrderRepository WOrderRepository;
    private final WOrderDetailRepository WOrderDetailRepository;
    private final WClientRepository WClientRepository;
    private final WProductRepository WProductRepository;

    private TransactionTemplate transactionTemplate;

    public WOrderServiceImpl(WOrderRepository WOrderRepository, WOrderDetailRepository WOrderDetailRepository, WClientRepository WClientRepository, WProductRepository WProductRepository, TransactionTemplate transactionTemplate) {
        this.WOrderRepository = WOrderRepository;
        this.WOrderDetailRepository = WOrderDetailRepository;
        this.WClientRepository = WClientRepository;
        this.WProductRepository = WProductRepository;
        this.transactionTemplate = transactionTemplate;
    }


    @Override
    public Mono<WOrder> createOrder(WCheckout checkout) {
        return Mono.fromCallable(() -> transactionTemplate.execute(status -> {
            WClient client = addNewClient(checkout.getClient());
            WOrder order = addNewOrder(checkout.getOrder(), client);
            WOrderDetail[] orderDetails = addNewOrderDetails(checkout.getCart(), order);

            return order;
        }));
    }

    public WClient addNewClient(WClient clientRequest) {
        if (clientRequest == null) {
            throw new CustomException("Client is required");
        }
        WClient client = new WClient();
        client.setName(clientRequest.getName());
        client.setAddress(clientRequest.getAddress());
        client.setPhone(clientRequest.getPhone());
        client.setCellphone(clientRequest.getCellphone());
        client.setCountryCode(clientRequest.getCountryCode());
        client.setEmail(clientRequest.getEmail());
        client.setWhatsapp(clientRequest.getWhatsapp());
        client.setDetails(clientRequest.getDetails());
        client.setOtherDetails(clientRequest.getOtherDetails());
        client.setSourceAggregate(SourceAggregate.WEB);

        return WClientRepository.save(client);
    }

    public WOrder addNewOrder(WOrderRequest orderRequest, WClient clientSaved) {
        if (orderRequest == null) {
            throw new CustomException("Order is required");
        }
        WOrder order = new WOrder();
        order.setCode(orderRequest.getCode());
        order.setOrderDate(orderRequest.getOrderDate());
        order.setStatus(OrderStatus.PENDING_PAYMENT);
        order.setPickUp(false);

        order.setTaxes(BigDecimal.valueOf(0));
        order.setTaxesUSD(BigDecimal.valueOf(0));
        order.setTaxesEUR(BigDecimal.valueOf(0));
        order.setDiscountAmount(BigDecimal.valueOf(0));
        order.setSubtotal(BigDecimal.valueOf(0));
        order.setSubtotalUSD(BigDecimal.valueOf(0));
        order.setSubtotalEUR(BigDecimal.valueOf(0));
        order.setTotal(BigDecimal.valueOf(0));
        order.setTotalUSD(BigDecimal.valueOf(0));
        order.setTotalEUR(BigDecimal.valueOf(0));

        order.setAddress(clientSaved.getAddress());
        order.setOtherDetails(clientSaved.getOtherDetails());
        order.setClientId(clientSaved.getClientId());

        return WOrderRepository.save(order);
    }

    public WOrderDetail[] addNewOrderDetails(Map<String, Integer> data, WOrder orderSaved) {
        WOrderDetail[] orderDetails = new WOrderDetail[data.size()];
        int i = 0;
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            WProduct product = WProductRepository.findById(Long.parseLong(entry.getKey())).orElse(null);
            if (product != null && product.getStatus()==Status.ACTIVE && product.getDeletedAt()==null) {
                WOrderDetail orderDetail = new WOrderDetail();
                orderDetail.setOrderId(orderSaved.getOrderId());
                orderDetail.setProductId(product.getProductId());
                orderDetail.setQuantity(Long.valueOf(entry.getValue()));
                orderDetail.setUnitPrice(product.getPrice());
                orderDetail.setUnitPriceUSD(product.getPriceUSD());
                orderDetail.setUnitPriceEUR(product.getPriceEUR());
                orderDetail.setSubtotal(product.getPrice().multiply(BigDecimal.valueOf(entry.getValue())));
                orderDetail.setSubtotalUSD(product.getPriceUSD().multiply(BigDecimal.valueOf(entry.getValue())));
                orderDetail.setSubtotalEUR(product.getPriceEUR().multiply(BigDecimal.valueOf(entry.getValue())));
                orderDetail.setDiscountPercentage(Long.valueOf(0));
                orderDetail.setOtherDetails(product.getOtherDetails());
                orderDetail.setStatus(Status.ACTIVE);

                orderDetails[i] = WOrderDetailRepository.save(orderDetail);
                i += 1;
            }
        }
        return orderDetails;
    }
}