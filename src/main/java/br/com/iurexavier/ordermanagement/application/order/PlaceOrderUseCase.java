package br.com.iurexavier.ordermanagement.application.order;

import br.com.iurexavier.ordermanagement.domain.order.Order;
import br.com.iurexavier.ordermanagement.domain.order.OrderItem;

import java.util.List;

public class PlaceOrderUseCase {
    public Order execute(List<OrderItem> items) {
        validateItems(items);
        Order order = new Order();
        for (OrderItem item : items) {
            order.addItem(item);
        }
        return order;
    }

    private void validateItems(List<OrderItem> items) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("A lista de itens do pedido não pode ser nula ou vazia.");
        }
    }
}
