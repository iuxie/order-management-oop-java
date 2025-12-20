package br.com.iurexavier.ordermanagement.domain.order;

public enum OrderStatus {
    CREATED,
    PAID,
    SHIPPED,
    DELIVERED,
    CANCELED;

    public boolean isFinal() {
        return this == DELIVERED || this == CANCELED;
    }
}
