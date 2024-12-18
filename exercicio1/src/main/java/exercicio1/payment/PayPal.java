package exercicio1.payment;

import exercicio1.interfaces.PaymentMethod;

public class PayPal implements PaymentMethod {
    public void pay(double amount) {
        System.out.printf("Value: $%.2f \nMethod: PayPal\n", amount);
        System.out.println("------------");
    }
}
