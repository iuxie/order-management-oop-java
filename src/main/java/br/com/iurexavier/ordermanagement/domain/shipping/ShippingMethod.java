package br.com.iurexavier.ordermanagement.domain.shipping;

import br.com.iurexavier.ordermanagement.domain.order.Order;

public interface ShippingMethod {
    ShippingResult ship(Order order);
}
