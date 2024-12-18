package exercicio1.payment;

import exercicio1.interfaces.PaymentMethod;

public class CreditCard implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("------------");
        System.out.printf("Value: $%.2f  \nMethod: Credit Card\n", amount);
        System.out.println("------------");
    }
}
