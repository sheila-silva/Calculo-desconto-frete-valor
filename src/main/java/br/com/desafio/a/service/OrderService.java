package br.com.desafio.a.service;

import br.com.desafio.a.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private br.com.desafio.a.service.ShippingService shippingService;

    public Order createOrder(double basic, double discount) {
        Integer code;

        if (discount == 20.0) {
            code = 1034;
        } else if (discount == 10.0) {
            code = 2282;
        } else {
            code = 1309;
        }

        return new Order(code, basic, discount);
    }

    public double total(Order order) {
        double discountValue = order.getBasic() * (order.getDiscount() / 100.0);
        double valueAfterDiscount = order.getBasic() - discountValue;
        double shippingCost = shippingService.shipment(valueAfterDiscount);
        return valueAfterDiscount + shippingCost;
    }
}
