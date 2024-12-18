package exercicio1.cart;

import java.util.ArrayList;
import java.util.List;

import exercicio1.interfaces.Product;

public class ShoppingCartSingleton {
    private static ShoppingCartSingleton instance;
    private List<Product> items;

    private ShoppingCartSingleton() {
        items = new ArrayList<>();
    }

    public static ShoppingCartSingleton getInstance() {
        if (instance == null) {
            instance = new ShoppingCartSingleton();
        }
        return instance;
    }

    public void addItem(Product item) {
        items.add(item);
    }

    public List<Product> getItems() {
        return items;
    }

    public double getTotal() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void showCart() {
        if (items.isEmpty()) {
            System.out.println("Your shopping cart is empty.");
        } else {
            System.out.println("Items in your shopping cart:");
            for (Product item : items) {
                System.out.printf("- %s: $%.2f\n", item.getName(), item.getPrice());
            }
        }
    }

    public void clear() {
        items.clear();
    }
}
