package com.jersson.arrivasplata.swtvap.api.web.enums;

public enum OrderStatus {
    PENDING_PAYMENT("La orden ha sido realizada por el cliente, pero el pago aún no se ha completado."),
    PAYMENT_RECEIVED("El pago de la orden ha sido recibido y confirmado."),
    PROCESSING("Los productos de la orden están siendo reunidos y preparados para su envío."),
    IN_TRANSIT("La orden ha sido enviada y está en camino hacia la dirección de envío especificada."),
    DELIVERED("La orden ha sido entregada con éxito al cliente."),
    CANCELED_BY_CUSTOMER("El cliente ha solicitado cancelar la orden antes de su envío."),
    CANCELED_BY_COMPANY("La empresa ha cancelado la orden por razones internas, como falta de stock, problemas de pago, etc."),
    WAITING_FOR_PAYMENT_CONFIRMATION("La orden se ha realizado, pero la empresa está esperando la confirmación del pago antes de proceder."),
    REFUNDED("La orden ha sido reembolsada al cliente, ya sea parcial o totalmente."),
    CUSTOMS_PROCESSING("La orden se encuentra en proceso de despacho aduanero antes de su envío internacional."),
    WAITING_FOR_DOCUMENTATION("La orden está pendiente de la documentación necesaria para la exportación."),
    INTERNATIONAL_TRANSIT("La orden ha salido del país y se encuentra en camino hacia su destino internacional."),
    HELD_IN_CUSTOMS("La orden ha llegado al país de destino pero está retenida en la aduana para inspección u otros trámites.");

    private final String descripcion;

    OrderStatus(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
