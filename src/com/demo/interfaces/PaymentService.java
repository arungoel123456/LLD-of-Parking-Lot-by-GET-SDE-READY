package com.demo.interfaces;

public interface PaymentService {
    void acceptCash(int amount);
    void acceptCreditCard(String cardNumber, int cvv, int amount);
}
