package com.jersson.arrivasplata.swtvap.api.web.util;

import com.jersson.arrivasplata.swtvap.api.web.enums.Status;
import com.jersson.arrivasplata.swtvap.api.web.model.*;
import lombok.Builder;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Builder
public class Common {

    public LocalDate getCurrentDate() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/Lima"));
        LocalDate localDate = zonedDateTime.toLocalDate();
        return localDate;
    }

    public WProduct filterProduct(WProduct product) {

        LocalDate now = getCurrentDate();

        // Filtrar las unidades que tienen 'deletedAt' como no null
        List<WUnit> filteredUnits = product.getUnits().stream()
                .filter(unit -> unit.getDeletedAt() == null && unit.getStatus() == Status.ACTIVE)
                .collect(Collectors.toList());
        product.setUnits(new HashSet<>(filteredUnits));

        // Filtrar las imagenes que tienen 'deletedAt' como no null
        List<WProductImage> filteredImages = product.getProductImages().stream()
                .filter(image -> image.getDeletedAt() == null)
                .collect(Collectors.toList());
        product.setProductImages(filteredImages);

        // Filtrar los descuentos que tienen 'deletedAt' como no null
        List<WProductDiscount> filteredDiscounts = product.getProductDiscounts().stream()
                .filter(discount -> discount.getDeletedAt() == null
                        && (discount.getStartDate().isEqual(now) || discount.getStartDate().isBefore(now))
                        && (discount.getEndDate().isEqual(now) || discount.getEndDate().isAfter(now)))
                .collect(Collectors.toList());
        product.setProductDiscounts(filteredDiscounts);

        // Filtrar los parametros que tienen 'deletedAt' como no null
        List<WParameterProduct> filteredParameters = product.getParameters().stream()
                .filter(image -> image.getDeletedAt() == null && image.getStatus() == Status.ACTIVE)
                .collect(Collectors.toList());
        product.setParameters(new HashSet<>(filteredParameters));


        // Filtrar los parametros que tienen 'deletedAt' como no null
        List<WComment> filteredComments = product.getProductComments().stream()
                .filter(image -> image.getDeletedAt() == null && image.getStatus() == Status.ACTIVE)
                .collect(Collectors.toList());
        product.setProductComments(filteredComments);

        return product;
    }
}
