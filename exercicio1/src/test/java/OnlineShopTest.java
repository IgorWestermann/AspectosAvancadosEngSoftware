import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exercicio1.cart.SeasonalDiscount;
import exercicio1.cart.ShoppingCartSingleton;
import exercicio1.factory.ClothingFactory;
import exercicio1.factory.ElectronicsFactory;
import exercicio1.factory.ProductFactory;
import exercicio1.interfaces.Discount;
import exercicio1.interfaces.Product;
import exercicio1.products.DiscountedProduct;

public class OnlineShopTest {
    private ProductFactory electronicsFactory;
    private ProductFactory clothingFactory;
    private ShoppingCartSingleton cart;

    @BeforeEach
    public void setUp() {
        electronicsFactory = new ElectronicsFactory();
        clothingFactory = new ClothingFactory();
        cart = ShoppingCartSingleton.getInstance();
        cart.clear();
    }

    @Test
    public void testProductCreation() {
        Product phone = electronicsFactory.createProduct("Smartphone", 699.99);
        assertNotNull(phone);
        assertEquals("Smartphone", phone.getName());
        assertEquals(699.99, phone.getPrice());

        Product shirt = clothingFactory.createProduct("T-Shirt", 19.99);
        assertNotNull(shirt);
        assertEquals("T-Shirt", shirt.getName());
        assertEquals(19.99, shirt.getPrice());
    }

    @Test
    public void testDiscountApplication() {
        Product phone = electronicsFactory.createProduct("Smartphone", 699.99);
        Discount seasonalDiscount = new SeasonalDiscount();
        Product discountedPhone = new DiscountedProduct(phone, seasonalDiscount);

        assertEquals(629.99, discountedPhone.getPrice(), 0.01); // Expecting 10% off
    }

    @Test
    public void testShoppingCartFunctionality() {
        Product phone = electronicsFactory.createProduct("Smartphone", 699.99);
        Product shirt = clothingFactory.createProduct("T-Shirt", 19.99);

        cart.addItem(phone);
        cart.addItem(shirt);

        assertEquals(2, cart.getItems().size());
        assertEquals(719.98, cart.getTotal());
    }

    @Test
    public void testSingletonBehavior() {
        ShoppingCartSingleton anotherCart = ShoppingCartSingleton.getInstance();

        assertSame(cart, anotherCart, "Both instances should be the same");
    }

    @Test
    public void testClearCart() {
        Product phone = electronicsFactory.createProduct("Smartphone", 699.99);
        cart.addItem(phone);
        assertEquals(1, cart.getItems().size());

        cart.clear();
        assertEquals(0, cart.getItems().size());
    }
}