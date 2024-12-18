package exercicio1.factory;

import exercicio1.interfaces.Product;
import exercicio1.products.Electronics;

public class ElectronicsFactory extends ProductFactory {

    @Override
    public Product createProduct(String name, double price) {
        return new Electronics(name, price);
    }

}
