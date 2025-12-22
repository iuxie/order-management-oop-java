package br.com.iurexavier.ordermanagement.application.payment;

import br.com.iurexavier.ordermanagement.domain.order.Order;
import br.com.iurexavier.ordermanagement.domain.payment.PaymentMethod;
import br.com.iurexavier.ordermanagement.domain.payment.PaymentProcessor;
import br.com.iurexavier.ordermanagement.domain.payment.PaymentResult;

public class PayOrderUseCase {
    public PaymentResult execute(Order order, PaymentMethod paymentMethod) {
        PaymentProcessor paymentProcessor = new PaymentProcessor(order, paymentMethod);
        return paymentProcessor.execute();
    }
}
