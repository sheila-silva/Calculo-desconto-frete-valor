package br.com.desafio.a.service;

import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(double valueAfterDiscount) {
        if (valueAfterDiscount <= 100.0) {
            return 20.0;
        } else if (valueAfterDiscount <= 200.0) {
            return 12.0;
        } else {
            return 0.0;
        }
    }
}
