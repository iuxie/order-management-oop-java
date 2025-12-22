package br.com.iurexavier.ordermanagement.domain.payment;

import br.com.iurexavier.ordermanagement.domain.order.Order;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public PaymentResult pay(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("O pedido não pode ser nulo!");
        }

        if (order.calculateTotal() <= 0) {
            return new PaymentResult(false, "Pedido sem valor para pagamento.");
        }
        return new PaymentResult(true, "Pagamento efetuado com sucesso via Cartão de Crédito.");
    }
}
