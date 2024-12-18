package exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exercicio1.cart.SeasonalDiscount;
import exercicio1.cart.ShoppingCartSingleton;
import exercicio1.cart.previousPurchases.PreviousPurchases;
import exercicio1.factory.ClothingFactory;
import exercicio1.factory.ElectronicsFactory;
import exercicio1.factory.ProductFactory;
import exercicio1.interfaces.Discount;
import exercicio1.interfaces.Product;
import exercicio1.products.DiscountedProduct;

public class Main {
    public static void main(String[] args) {
        PreviousPurchases previousPurchases = new PreviousPurchases();
        List<Product> availableProducts = new ArrayList<>();
        ProductFactory eletronicFactory = new ElectronicsFactory();
        ProductFactory clothingFactory = new ClothingFactory();

        availableProducts.add(eletronicFactory.createProduct("IPhone", 699.99));
        availableProducts.add(eletronicFactory.createProduct("MacBook", 2999.99));
        availableProducts.add(clothingFactory.createProduct("T-Shirt", 29.99));
        availableProducts.add(clothingFactory.createProduct("Jeans", 99.99));

        Discount seasonalDiscount = new SeasonalDiscount();

        ShoppingCartSingleton cart = ShoppingCartSingleton.getInstance();
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Show Shopping Cart");
            System.out.println("2. Previous Purchases");
            System.out.println("3. Add Product to Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    cart.showCart();
                    break;
                case 2:
                    previousPurchases.showPurchases();
                    break;
                case 3:
                    System.out.println("Available Products with discount:");
                    for (int i = 0; i < availableProducts.size(); i++) {
                        Product product = availableProducts.get(i);
                        if (product != null) {
                            System.out.printf("%d. %s: From $%.2f\n",
                                    i + 1,
                                    product.getName(),
                                    product.getPrice());
                        }
                    }
                    System.out.print("Select a product number to add to cart: ");
                    int productNumber = scanner.nextInt();
                    scanner.nextLine();

                    if (productNumber > 0 && productNumber <= availableProducts.size()) {
                        Product selectedProduct = availableProducts.get(productNumber - 1);
                        if (selectedProduct != null) {
                            Product discountedProduct = new DiscountedProduct(selectedProduct, seasonalDiscount);

                            cart.addItem(discountedProduct);
                            System.out.println(discountedProduct.getName() + " added to cart.");
                        } else {
                            System.out.println("Selected product is not available. Please try again.");
                        }
                    } else {
                        System.out.println("Invalid product selection. Please try again.");
                    }
                    break;
                case 4:
                    double totalAmount = cart.getTotal();
                    if (totalAmount == 0) {
                        System.out.println("Your cart is empty. Cannot checkout.");
                    } else {
                        System.out.printf("Your total amount is: $%.2f\n", totalAmount);
                        System.out.print("Choose payment method (credit/paypal): ");
                        String paymentMethod = scanner.nextLine();
                        String purchaseDetails = String.format("Total: $%.2f\n Payment Method: %s\n Items: ",
                                totalAmount,
                                paymentMethod);
                        for (Product item : cart.getItems()) {
                            purchaseDetails += item.getName() + " ($" + item.getPrice() + ")\n ";
                        }
                        previousPurchases.addPurchase(purchaseDetails);
                        System.out.println("Checkout successful!");
                        cart.getItems().clear();
                    }
                    break;
                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}