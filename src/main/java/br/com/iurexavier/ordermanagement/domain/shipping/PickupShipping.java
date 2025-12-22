package br.com.iurexavier.ordermanagement.domain.shipping;

import br.com.iurexavier.ordermanagement.domain.order.Order;

public class PickupShipping implements  ShippingMethod {
    @Override
    public ShippingResult ship(Order order) {
        return new ShippingResult(true, "Retirada realizada com sucesso!");
    }
}
