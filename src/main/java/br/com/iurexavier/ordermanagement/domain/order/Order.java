package br.com.iurexavier.ordermanagement.domain.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private final List<OrderItem> items;
    private OrderStatus status;

    public Order() {
        this.items = new ArrayList<>();
        this.status = OrderStatus.CREATED;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(OrderItem item) {
        if (status != OrderStatus.CREATED) {
            throw new IllegalArgumentException("Não é possível adicionar itens após o pedido ser pago.");
        } else if (item == null) {
            throw new IllegalArgumentException("O item não pode ser nulo.");
        }
        items.add(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getTotal();
        }
        return total;
    }

    public void pay() {
        validateStatus(OrderStatus.CREATED);
        this.status = OrderStatus.PAID;
    }

    public void ship() {
        validateStatus(OrderStatus.PAID);
        this.status = OrderStatus.SHIPPED;
    }

    public void deliver() {
        validateStatus(OrderStatus.SHIPPED);
        this.status = OrderStatus.DELIVERED;
    }

    public void cancel() {
        if (status.isFinal()) {
            throw new IllegalStateException("Pedido finalizado não pode ser cancelado.");
        }
        this.status = OrderStatus.CANCELED;
    }

    private void validateStatus(OrderStatus expected) {
        if (this.status != expected) {
            throw new IllegalStateException("Ação inválida para o status atual: " + status);
        }
    }
}
