package br.com.iurexavier.ordermanagement.domain.payment;

import br.com.iurexavier.ordermanagement.domain.order.Order;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public PaymentResult pay(Order order) {
        return new PaymentResult(true, "Pagamento efetuado com sucesso via Cartão de Crédito.");
    }
}
