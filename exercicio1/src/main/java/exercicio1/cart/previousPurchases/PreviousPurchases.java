package exercicio1.cart.previousPurchases;

import java.util.ArrayList;
import java.util.List;

public class PreviousPurchases {
    private List<String> purchases;

    public PreviousPurchases() {
        purchases = new ArrayList<>();
    }

    public void addPurchase(String purchase) {
        purchases.add(purchase);
    }

    public void showPurchases() {
        if (purchases.isEmpty()) {
            System.out.println("You have no previous purchases.");
        } else {
            System.out.println("Your previous purchases:");
            for (String purchase : purchases) {
                System.out.println("- " + purchase);
            }
        }
    }
}