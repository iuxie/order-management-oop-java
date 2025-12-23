package br.com.iurexavier.ordermanagement.application.order;

import br.com.iurexavier.ordermanagement.domain.order.Order;

public class DeliverOrderUseCase {
    public void execute(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Pedido não pode ser nulo.");
        }
        order.deliver();
    }
}

