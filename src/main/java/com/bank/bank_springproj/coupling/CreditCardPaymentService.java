package com.bank.bank_springproj.coupling;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary   // 👈 This one will be chosen by default
public class CreditCardPaymentService implements PaymentService {
    @Override
    public void pay() {
        System.out.println("Paying with Credit Card");
    }
}