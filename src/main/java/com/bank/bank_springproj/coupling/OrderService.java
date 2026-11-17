package com.bank.bank_springproj.coupling;

import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private final PaymentService paymentService;

    // Spring injects CreditCardPaymentService because of @Primary
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void checkout() {
        paymentService.pay();
    }
}