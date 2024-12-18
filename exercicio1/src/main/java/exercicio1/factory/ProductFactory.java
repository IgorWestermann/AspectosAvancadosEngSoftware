package exercicio1.factory;

import exercicio1.interfaces.Product;

public abstract class ProductFactory {
    public abstract Product createProduct(String name, double price);
}
