package eu.asaitec.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testProductConstructor() {
        Product product = new Product("Apple", 0.9);
        String productName = "Apple";

        assertEquals(productName,product.getName());
    }

    @Test
    void testGetName() {
        Product product = new Product("Apple", 0.9);
        String productName = "Apple";
        Double productPrice = 0.9;

        assertEquals(productName,product.getName());
        assertEquals(productPrice,product.getPrice());
    }

    @Test
    void setName() {
        Product product = new Product("Orang", 1);
        String productName = "Orange";
        product.setName("Orange");

        assertEquals(productName,product.getName());
    }

    @Test
    void getPrice() {
        Product product = new Product("Apple", 0.9);
        Double productPrice = 0.9;

        assertEquals(productPrice,product.getPrice());
    }

    @Test
    void setPrice() {
        Product product = new Product("Orange", 1);
        Double productPrice = 1.2;
        product.setPrice(1.2);

        assertEquals(productPrice,product.getPrice());
    }

    @Test
    void testEquals() {
        Product apple1 = new Product("Apple", 0.9);
        Product apple2 = new Product("Apple", 0.9);


        assertEquals(apple1,apple2);
    }
}