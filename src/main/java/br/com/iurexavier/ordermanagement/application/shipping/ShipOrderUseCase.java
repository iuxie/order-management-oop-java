package br.com.iurexavier.ordermanagement.application.shipping;

import br.com.iurexavier.ordermanagement.domain.order.Order;
import br.com.iurexavier.ordermanagement.domain.shipping.ShippingMethod;
import br.com.iurexavier.ordermanagement.domain.shipping.ShippingProcessor;
import br.com.iurexavier.ordermanagement.domain.shipping.ShippingResult;

public class ShipOrderUseCase {
    public ShippingResult execute(Order order, ShippingMethod shippingMethod) {
        ShippingProcessor shippingProcessor = new ShippingProcessor(order, shippingMethod);
        return shippingProcessor.execute();
    }
}
