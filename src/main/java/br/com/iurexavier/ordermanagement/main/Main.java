package br.com.iurexavier.ordermanagement.main;

import br.com.iurexavier.ordermanagement.application.order.DeliverOrderUseCase;
import br.com.iurexavier.ordermanagement.application.order.PlaceOrderUseCase;
import br.com.iurexavier.ordermanagement.application.payment.PayOrderUseCase;
import br.com.iurexavier.ordermanagement.application.shipping.ShipOrderUseCase;
import br.com.iurexavier.ordermanagement.domain.order.Order;
import br.com.iurexavier.ordermanagement.domain.order.OrderItem;
import br.com.iurexavier.ordermanagement.domain.payment.PIXPayment;
import br.com.iurexavier.ordermanagement.domain.payment.PaymentResult;
import br.com.iurexavier.ordermanagement.domain.shipping.SedexShipping;
import br.com.iurexavier.ordermanagement.domain.shipping.ShippingResult;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Criar itens do pedidos
        OrderItem item1 = new OrderItem("Notebook", 2500, 2);
        OrderItem item2 = new OrderItem("Mousepad", 50, 2);

        //1. Criar pedido
        PlaceOrderUseCase placeOrderUseCase = new PlaceOrderUseCase();
        Order order = placeOrderUseCase.execute(List.of(item1, item2));

        System.out.println("Pedido criado com sucesso!");
        System.out.println("Valor do pedido: R$" + order.calculateTotal());
        System.out.println("Status atual: " + order.getStatus());

        //2. Pagar pedido
        PayOrderUseCase payOrderUseCase = new PayOrderUseCase();
        PaymentResult paymentResult = payOrderUseCase.execute(order, new PIXPayment());

        System.out.println("Pagamento: " + paymentResult.getMessage());
        System.out.println("Status após o pagamento: " + order.getStatus());

        //3. Enviar pedido
        ShipOrderUseCase shipOrderUseCase = new ShipOrderUseCase();
        ShippingResult shippingResult = shipOrderUseCase.execute(order, new SedexShipping());

        System.out.println("Envio: " + shippingResult.getMessage());
        System.out.println("Status após o envio: " + order.getStatus());

        //4. Pedido entregue
        DeliverOrderUseCase deliverOrderUseCase = new DeliverOrderUseCase();
        deliverOrderUseCase.execute(order);

        System.out.println("Status após entrega: " + order.getStatus());
    }
}
