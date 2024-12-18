package exercicio1.products;

import exercicio1.interfaces.Discount;
import exercicio1.interfaces.Product;

public class DiscountedProduct implements Product {

    private Product product;
    private Discount discount;

    public DiscountedProduct(Product product, Discount discount) {
        this.product = product;
        this.discount = discount;
    }

    @Override
    public String getName() {
        return product.getName();
    }

    @Override
    public double getPrice() {
        return discount.applyDiscount(product.getPrice());
    }
}
