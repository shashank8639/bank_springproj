package com.bank.bank_springproj;

import com.bank.bank_springproj.coupling.OrderService;
import com.bank.bank_springproj.service.GreetCustomer;
import com.bank.bank_springproj.service.MailService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankSpringprojApplication {

    public static void main(String[] args) {

          var ctx= SpringApplication.run(BankSpringprojApplication.class, args);
    
          ctx.getBean(GreetCustomer.class).wishCustomer();
          
          ctx.getBean(MailService.class).printMailConfig();
    }

}
