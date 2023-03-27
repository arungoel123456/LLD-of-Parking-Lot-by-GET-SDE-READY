package com.demo.paymentMethods;

public class Cash extends PaymentMethod{
    @Override
    public boolean initiatePayment(int amount) {
        System.out.println("making payment by cash of Rs " + amount);
        return true;
    }
}
