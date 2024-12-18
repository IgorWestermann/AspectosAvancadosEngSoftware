package exercicio1.cart;
import exercicio1.interfaces.PaymentMethod;

public abstract class ShoppingCart {
    protected PaymentMethod paymentMethod;

    protected ShoppingCart(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public abstract void checkout(double amount);
}
