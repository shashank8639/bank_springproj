package com.bank.bank_springproj.repository;

import com.bank.bank_springproj.model.BankAcc;

import java.util.List;

public interface MyRepo {
    BankAcc registerAcc(BankAcc account);

    List<BankAcc> getAccounts();
}
