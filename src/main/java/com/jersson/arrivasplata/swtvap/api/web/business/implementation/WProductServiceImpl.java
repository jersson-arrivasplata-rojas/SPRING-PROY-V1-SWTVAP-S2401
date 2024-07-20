package com.jersson.arrivasplata.swtvap.api.web.business.implementation;

import com.jersson.arrivasplata.swtvap.api.web.business.service.WProductService;
import com.jersson.arrivasplata.swtvap.api.web.enums.Lang;
import com.jersson.arrivasplata.swtvap.api.web.enums.Status;
import com.jersson.arrivasplata.swtvap.api.web.exception.CustomException;
import com.jersson.arrivasplata.swtvap.api.web.model.WProduct;
import com.jersson.arrivasplata.swtvap.api.web.repository.WProductRepository;
import com.jersson.arrivasplata.swtvap.api.web.util.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WProductServiceImpl implements WProductService {
    private final WProductRepository WProductRepository;

    @Autowired
    public WProductServiceImpl(WProductRepository WProductRepository) {
        this.WProductRepository = WProductRepository;
    }

    @Override
    public Flux<WProduct> getAllProducts() {
        return Flux.fromIterable(WProductRepository.findAll())
                .flatMap(product -> {
                    WProduct productFilter = Common.builder().build().filterProduct(product);
                    return Mono.just(productFilter);
                });
    }

    public Mono<WProduct> getProductByName(String name, String lang) {
        WProduct product = new WProduct();
        if (Lang.valueOf(lang) == Lang.ES) {
            product = WProductRepository.findByNameAndStatusAndDeletedAtIsNull(name, Status.ACTIVE);
        } else if (Lang.valueOf(lang) == Lang.EN) {
            product = WProductRepository.findByNameEnAndStatusAndDeletedAtIsNull(name, Status.ACTIVE);
        }

        return Mono.just(product)
                .flatMap(response -> {
                    if (response == null) {
                        return Mono.error(new CustomException("Product not found with name: " + name));
                    }

                    WProduct productFilter = Common.builder().build().filterProduct(response);

                    return Mono.just(productFilter);
                });
    }

    public Mono<WProduct> getProductByPath(String path) {
        WProduct product = WProductRepository.findByPathAndStatusAndDeletedAtIsNull(path, Status.ACTIVE);

        return Mono.just(product)
                .flatMap(response -> {
                    if (response == null) {
                        return Mono.error(new CustomException("Product not found with name: " + path));
                    }

                    WProduct productFilter = Common.builder().build().filterProduct(response);

                    return Mono.just(productFilter);
                });
    }
}
