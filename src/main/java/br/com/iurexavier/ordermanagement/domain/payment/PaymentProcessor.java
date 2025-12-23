package br.com.iurexavier.ordermanagement.domain.payment;

import br.com.iurexavier.ordermanagement.domain.order.Order;

public class PaymentProcessor {
    private final Order order;
    private final PaymentMethod paymentMethod;

    public PaymentProcessor(Order order, PaymentMethod paymentMethod) {
        validateFields(order, paymentMethod);
        this.order = order;
        this.paymentMethod = paymentMethod;
    }

    public PaymentResult process() {
        validateOrderForPayment(order);
        PaymentResult result = paymentMethod.pay(order);
        if (result.isSuccess()) {
            order.pay();
        }
        return result;
    }

    private void validateFields(Order order, PaymentMethod paymentMethod) {
        if (order == null) {
            throw new IllegalArgumentException("O pedido não pode ser nulo!");
        }
        if (paymentMethod == null) {
            throw new IllegalArgumentException("O método de pagamento não pode ser nulo!");
        }
    }

    private void validateOrderForPayment(Order order) {
        if (order.calculateTotal() <= 0) {
            throw new IllegalStateException("Pedido sem valor para pagamento.");
        }
    }
}
