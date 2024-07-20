package com.jersson.arrivasplata.swtvap.api.web.util;

import com.jersson.arrivasplata.swtvap.api.web.enums.Status;
import com.jersson.arrivasplata.swtvap.api.web.model.*;
import lombok.Builder;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    public WParameter createStoreResponse() {
        WParameter proposalSecurity = new WParameter(101L, 99L, null, "SITIO SEGURO", "Protegemos tus datos, comprá tranquila desde la comodidad de tu casa.", "fas fa-shield-alt", "es", "PROPOSAL_SECURITY", null, Status.ACTIVE, null, new HashSet<>());
        WParameter proposalPayment = new WParameter(102L, 99L, null, "OPCIONES DE PAGO", "Tarjetas de crédito: Visa, Master Card Depósitos: Scotiabank", "fas fa-credit-card", "es", "PROPOSAL_PAYMENT", null, Status.ACTIVE, null, new HashSet<>());
        WParameter proposalExperienceES = new WParameter(103L, 99L, null, "EXPERIENCIA DE USUARIO", "Manejamos una mejor experiencia de usuario para mostrar los productos.", "fas fa-smile-beam", "es", "PROPOSAL_EXPERIENCE", null, Status.ACTIVE, null, new HashSet<>());
        WParameter proposalExperienceEN = new WParameter(107L, 99L, null, "USER EXPERIENCE", "We manage a better user experience to show the products.", "fas fa-smile-beam", "en", "PROPOSAL_EXPERIENCE", null, Status.ACTIVE, null, new HashSet<>());
        WParameter proposalPoliticEN = new WParameter(104L, 99L, null, "RETURNS", "Easy exchanges and returns", "fas fa-redo", "en", "PROPOSAL_POLITIC", null, Status.ACTIVE, null, new HashSet<>());
        WParameter proposalPaymentEN = new WParameter(106L, 99L, null, "PAYMENT OPTIONS", "Credit cards: Visa, Mastercard Deposits: Scotiabank", "fas fa-credit-card", "en", "PROPOSAL_PAYMENT", null, Status.ACTIVE, null, new HashSet<>());
        WParameter proposalSecurityEN = new WParameter(105L, 99L, null, "SAFE PLACE", "We protect your data, buy with peace of mind from the comfort of your home.", "fas fa-shield-alt", "en", "PROPOSAL_SECURITY", null, Status.ACTIVE, null, new HashSet<>());
        WParameter proposalPoliticES = new WParameter(100L, 99L, null, "DEVOLUCIONES", "Cambios y devoluciones fáciles", "fas fa-redo", "es", "PROPOSAL_POLITIC", null, Status.ACTIVE, null, new HashSet<>());

        Set<WParameter> proposalChildren = new HashSet<>(Arrays.asList(proposalSecurity, proposalPayment, proposalExperienceES, proposalExperienceEN, proposalPoliticEN, proposalPaymentEN, proposalSecurityEN, proposalPoliticES));
        WParameter proposal = new WParameter(99L, 16L, null, null, null, null, null, "PROPOSAL", null, Status.ACTIVE, null, proposalChildren);

        WParameter carrouselStep1 = new WParameter(95L, 92L, null, "https://chascaperuart.sfo3.digitaloceanspaces.com/Chascaperuart/store/arte-banner.png", "Lorem ipsum nature|Lorem ipsum dolor sit amet consectetur.|Comprar ahora", "", "es", "CARROUSEL_STEP", 2L, Status.ACTIVE, null, new HashSet<>());
        WParameter carrouselStep2 = new WParameter(93L, 92L, null, "https://chascaperuart.sfo3.digitaloceanspaces.com/Chascaperuart/store/artesania-banner.PNG", "Lorem ipsum nature|Lorem ipsum dolor sit amet consectetur.|Comprar ahora", "", "es", "CARROUSEL_STEP", 0L, Status.ACTIVE, null, new HashSet<>());
        //WParameter carrouselStep3 = new WParameter(96L, 92L, null, "https://wowslider.com/sliders/demo-80/data1/images/nature497978_1920.jpg", "Lorem ipsum nature|Lorem ipsum dolor sit amet consectetur.|Buy now", "", "en", "CARROUSEL_STEP", 0L, Status.ACTIVE, null, new HashSet<>());
        WParameter carrouselStep4 = new WParameter(98L, 92L, null, "https://chascaperuart.sfo3.digitaloceanspaces.com/Chascaperuart/store/arte-banner.png", "Lorem ipsum nature|Lorem ipsum dolor sit amet consectetur.|Buy now", "", "en", "CARROUSEL_STEP", 2L, Status.ACTIVE, null, new HashSet<>());
        WParameter carrouselStep5 = new WParameter(94L, 92L, null, "https://chascaperuart.sfo3.digitaloceanspaces.com/Chascaperuart/store/artesania-banner.PNG", "", "", "en", "CARROUSEL_STEP", 1L, Status.ACTIVE, null, new HashSet<>());
        //WParameter carrouselStep6 = new WParameter(97L, 92L, null, "https://wowslider.com/sliders/demo-80/data1/images/sheet546475_1920.jpg", "", "", "en", "CARROUSEL_STEP", 1L, Status.ACTIVE, null, new HashSet<>());

        Set<WParameter> carrouselChildren = new HashSet<>(Arrays.asList(carrouselStep1,carrouselStep2, carrouselStep4,carrouselStep5));
        WParameter carrousel = new WParameter(92L, 16L, null, null, null, null, null, "CARROUSEL", null, Status.ACTIVE, null, carrouselChildren);

        WParameter localeEN = new WParameter(50L, 48L, null, "Ingles", "en", "1", "0", "LOCALE_EN", null, Status.ACTIVE, null, new HashSet<>());
        WParameter localeES = new WParameter(49L, 48L, null, "Español", "es", "0", "0", "LOCALE_ES", null, Status.ACTIVE, null, new HashSet<>());
        Set<WParameter> localeChildren = new HashSet<>(Arrays.asList(localeEN, localeES));
        WParameter locale = new WParameter(48L, 16L, null, "Idiomas Permitidos", "Locale", null, null, "LOCALE", null, Status.ACTIVE, null, localeChildren);

        WParameter currencyEUR_ES = new WParameter(53L, 51L, null, "Moneda en Euros", "€", "Euros (€)", "es", "CURRENCY_EUR", null, Status.ACTIVE, null, new HashSet<>());
        WParameter currencyUSD_ES = new WParameter(52L, 51L, null, "Moneda en Dólares", "$", "Dólares ($)", "es", "CURRENCY_USD", null, Status.ACTIVE, null, new HashSet<>());
        WParameter currencyPEN_EN = new WParameter(90L, 51L, null, "Moneda en Soles", "PEN", "Soles (PEN)", "en", "CURRENCY_PEN", null, Status.ACTIVE, null, new HashSet<>());
        WParameter currencyEUR_EN = new WParameter(91L, 51L, null, "Moneda en Euros", "€", "Euros (€)", "en", "CURRENCY_EUR", null, Status.ACTIVE, null, new HashSet<>());
        WParameter currencyUSD_EN = new WParameter(89L, 51L, null, "Moneda en Dólares", "$", "Dollars ($)", "en", "CURRENCY_USD", null, Status.ACTIVE, null, new HashSet<>());
        WParameter currencyPEN_ES = new WParameter(54L, 51L, null, "Moneda en Soles", "PEN", "Soles (PEN)", "es", "CURRENCY_PEN", null, Status.ACTIVE, null, new HashSet<>());
        Set<WParameter> currencyChildren = new HashSet<>(Arrays.asList(currencyEUR_ES, currencyUSD_ES, currencyPEN_EN, currencyEUR_EN, currencyUSD_EN, currencyPEN_ES));
        WParameter currency = new WParameter(51L, 16L, null, "Tipo de moneda", "Currency", null, null, "CURRENCY", null, Status.ACTIVE, null, currencyChildren);

        WParameter profileAddress = new WParameter(85L, 80L, null, "Ubicación de la Empresa", "El Rosario 376, Chaclacayo 15472", null, null, "ADDRESS", null, Status.ACTIVE, null, new HashSet<>());
        WParameter profileCellphone = new WParameter(83L, 80L, null, "Número de Celular", "+51 903485023", null, null, "CELLPHONE", null, Status.ACTIVE, null, new HashSet<>());
        WParameter profileCompany = new WParameter(84L, 80L, null, "Nombre de la Empresa", "Sumac Chasca Perú S.A.C.", null, null, "COMPANY", null, Status.ACTIVE, null, new HashSet<>());
        WParameter profileAddressMap = new WParameter(115L, 80L, null, "Ubicación de la Empresa en Google", "https://maps.app.goo.gl/7Ym7NL8CtXgBRj2v9", null, null, "ADDRESS_MAP", null, Status.ACTIVE, null, new HashSet<>());
        WParameter profileWhatsapp = new WParameter(82L, 80L, null, "Whatsapp", "1", null, null, "WHATSAPP", null, Status.ACTIVE, null, new HashSet<>());
        WParameter profileEmail = new WParameter(81L, 80L, null, "Correo electrónico", "contacto@uma.pe", null, null, "EMAIL", null, Status.ACTIVE, null, new HashSet<>());
        Set<WParameter> profileChildren = new HashSet<>(Arrays.asList(profileAddress, profileCellphone, profileCompany, profileAddressMap, profileWhatsapp, profileEmail));
        WParameter profile = new WParameter(80L, 16L, null, "Perfil de la Tienda", "Profile", null, null, "PROFILE", null, Status.ACTIVE, null, profileChildren);

        WParameter retail = new WParameter(79L, 77L, null, "Venta al por menor", "Venta al por menor", "1", null, "RETAIL", null, Status.ACTIVE, null, new HashSet<>());
        WParameter wholesale = new WParameter(78L, 77L, null, "Venta al por mayor", "Venta al por mayor", "0", null, "WHOLESALE", null, Status.ACTIVE, null, new HashSet<>());
        Set<WParameter> typeOfSaleChildren = new HashSet<>(Arrays.asList(retail, wholesale));
        WParameter typeOfSale = new WParameter(77L, 16L, null, "Tipo de Venta", "Tipo de Venta", null, null, "TYPE_OF_SALE", null, Status.ACTIVE, null, typeOfSaleChildren);

        Set<WParameter> storeChildren = new HashSet<>(Arrays.asList(proposal, carrousel, locale, currency, profile, typeOfSale));
        return new WParameter(16L, null, null, "Parametros de Tienda", "Store", null, null, "STORE", null, Status.ACTIVE, null, storeChildren);
    }
}
