package br.com.iurexavier.ordermanagement.domain.payment;

import br.com.iurexavier.ordermanagement.domain.order.Order;

public class PaymentProcessor {
    private final Order order;
    private final PaymentMethod paymentMethod;

    public PaymentProcessor(Order order, PaymentMethod paymentMethod) {
        if (order == null) {
            throw new IllegalArgumentException("O pedido não pode ser nulo!");
        }
        if (paymentMethod == null) {
            throw new IllegalArgumentException("O método de pagamento não pode ser nulo!");
        }

        this.order = order;
        this.paymentMethod = paymentMethod;
    }

    public PaymentResult execute() {
        PaymentResult result = paymentMethod.pay(order);

        if (result.isSuccess()) {
            order.pay();
        }
        return result;
    }
}
