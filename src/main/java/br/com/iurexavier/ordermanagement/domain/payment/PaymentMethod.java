package br.com.iurexavier.ordermanagement.domain.payment;

import br.com.iurexavier.ordermanagement.domain.order.Order;

public interface PaymentMethod {
    PaymentResult pay(Order order);
}
