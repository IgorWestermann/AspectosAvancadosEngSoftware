package exercicio1.cart;

import exercicio1.interfaces.PaymentMethod;

public class OnlineShoppingCart extends ShoppingCart {
    public OnlineShoppingCart(PaymentMethod paymentMethod) {
        super(paymentMethod);
    }

    public void checkout(double amount) {
        paymentMethod.pay(amount);
    }
}
