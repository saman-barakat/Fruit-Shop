package eu.asaitec.offer;

import eu.asaitec.product.Product;
import eu.asaitec.purchase.Purchase;
import eu.asaitec.utility.Utility;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OfferTest {

    @Test
    void getDiscount() {

    }

    @Test
    void getFreeProducts() {



    }

    @Test
    void buyXProductsPayY() {
        Offer offerUnderTest = new Offer();

        Product orange = new Product("Orange", 1.2);
        Product apple = new Product("Apple", 0.9);

        int appleQuantity = 5;
        int orangeQuantity = 9;
        Purchase purchaseApple = new Purchase(apple, appleQuantity);
        Purchase purchaseOrange = new Purchase(orange, orangeQuantity);

        List<Purchase> purchases = new ArrayList<>();
        purchases.add(purchaseApple);
        purchases.add(purchaseOrange);

        offerUnderTest.buyXProductsPayY(apple, 5, 3,purchases);

        Double expectedDiscount = 1.8;
        assertEquals(expectedDiscount, offerUnderTest.getDiscount());

        offerUnderTest.buyXProductsPayY(orange,4,3,purchases);

        expectedDiscount = 4.2;
        assertEquals(expectedDiscount, offerUnderTest.getDiscount());
    }

    @Test
    void reduceXWhenBuyYProducts() {
        Offer offerUnderTest = new Offer();

        Product orange = new Product("Orange", 1.2);
        Product apple = new Product("Apple", 0.9);

        int appleQuantity = 5;
        int orangeQuantity = 9;
        Purchase purchaseApple = new Purchase(apple, appleQuantity);
        Purchase purchaseOrange = new Purchase(orange, orangeQuantity);

        List<Purchase> purchases = new ArrayList<>();
        purchases.add(purchaseApple);
        purchases.add(purchaseOrange);

        offerUnderTest.reduceXWhenBuyYProducts(apple,1,5,purchases);

        Double expectedDiscount = 1.0;
        assertEquals(expectedDiscount, offerUnderTest.getDiscount());

    }

    @Test
    void getFreeProductWhenBuyXProducts() {
        Offer offerUnderTest = new Offer();

        Product orange = new Product("Orange", 1.2);
        Product apple = new Product("Apple", 0.9);

        int appleQuantity = 9;
        int orangeQuantity = 4;
        Purchase purchaseApple = new Purchase(apple, appleQuantity);
        Purchase purchaseOrange = new Purchase(orange, orangeQuantity);

        List<Purchase> purchases = new ArrayList<>();
        purchases.add(purchaseApple);
        purchases.add(purchaseOrange);

        offerUnderTest.getFreeProductWhenBuyXProducts(orange,3,apple,purchases);
        List<Product> freeProducts = offerUnderTest.getFreeProducts();

        int expectedFreeProducts = 3;
        assertEquals(expectedFreeProducts, freeProducts.size());
    }
}