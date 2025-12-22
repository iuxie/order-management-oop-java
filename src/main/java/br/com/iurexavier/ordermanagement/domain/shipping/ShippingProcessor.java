package br.com.iurexavier.ordermanagement.domain.shipping;

import br.com.iurexavier.ordermanagement.domain.order.Order;

public class ShippingProcessor {
    private final Order order;
    private final ShippingMethod shippingMethod;

    public ShippingProcessor(Order order, ShippingMethod shippingMethod) {
        validateFields(order, shippingMethod);
        this.order = order;
        this.shippingMethod = shippingMethod;
    }

    public ShippingResult execute() {
        ShippingResult result = shippingMethod.ship(order);

        if (result.isSuccess()) {
            order.ship();
        }
        return result;
    }

    private void validateFields(Order order, ShippingMethod shippingMethod) {
        if (order == null) {
            throw new IllegalStateException("O pedido não pode ser nulo!");
        }
        if (shippingMethod == null) {
            throw new IllegalArgumentException("O método de envio não pode ser nulo!");
        }
    }
}
