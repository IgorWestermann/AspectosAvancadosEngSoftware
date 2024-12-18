package exercicio1.cart;

import exercicio1.interfaces.Discount;

public class SeasonalDiscount implements Discount {

    @Override
    public double applyDiscount(double price) {
        return price * 0.9;
    }

}
