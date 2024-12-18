package exercicio1.factory;

import exercicio1.interfaces.Product;
import exercicio1.products.Clothing;

public class ClothingFactory extends ProductFactory {

    @Override
    public Product createProduct(String name, double price) {
        return new Clothing(name, price);
    }
}
