package br.com.iurexavier.ordermanagement.domain.shipping;

import br.com.iurexavier.ordermanagement.domain.order.Order;

public class PACShipping implements ShippingMethod {
    @Override
    public ShippingResult ship(Order order) {
        return new ShippingResult(true, "Envio realizado com sucesso via PAC.");
    }
}
