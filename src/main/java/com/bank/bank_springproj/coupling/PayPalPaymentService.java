package com.bank.bank_springproj.coupling;

import org.springframework.stereotype.Service;

@Service
public class PayPalPaymentService implements PaymentService {
    @Override
    public void pay() {
        System.out.println("Paying with PayPal");
    }
}