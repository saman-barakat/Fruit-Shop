package eu.asaitec.purchase;

import eu.asaitec.product.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseTest {

    @Test
    void testPurchaseConstructor(){
        Product apple = new Product("Apple", 0.9);
        int productQuantity = 5;
        Purchase purchase = new Purchase(apple, productQuantity);

        assertEquals(apple,purchase.getProduct());
        assertEquals(productQuantity, purchase.getQuantity());
    }

    @Test
    void testGetProduct() {
        Product apple = new Product("Apple", 0.9);
        int productQuantity = 5;
        Purchase purchase = new Purchase(apple, productQuantity);

        assertEquals(apple,purchase.getProduct());
    }

    @Test
    void testSetProduct() {
        Product apple = new Product("Apple", 0.9);
        int productQuantity = 5;
        Purchase purchase = new Purchase(apple, productQuantity);
        Product orange = new Product("Orange", 1);

        assertEquals(apple,purchase.getProduct());

    }

    @Test
    void getQuantity() {
        Product apple = new Product("Apple", 0.9);
        int productQuantity = 5;
        Purchase purchase = new Purchase(apple, productQuantity);

        assertEquals(productQuantity, purchase.getQuantity());
    }

    @Test
    void setQuantity() {
        Product apple = new Product("Apple", 0.9);
        int productQuantity = 5;
        Purchase purchase = new Purchase(apple, productQuantity);
        int productQuantityUpdated = 12;
        purchase.setQuantity(productQuantityUpdated);


        assertEquals(productQuantityUpdated, purchase.getQuantity());
    }
}