package eu.asaitec.fruitshop.manager;

import eu.asaitec.offer.Offer;
import eu.asaitec.product.Product;
import eu.asaitec.purchase.Purchase;
import eu.asaitec.utility.Utility;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Utility u = new Utility();
        Offer offer = new Offer();
        List<Product> products = u.readProducts("src/main/resources/products.txt");

        List<Purchase> purchases = u.purchaseProducts("src/main/resources/purchase.txt");

        //Apply Offers:

        // 1- Buy 3 Apples and pay 2.
        Product apple = u.getProductByName("Apple");
        offer.buyXProductsPayY(apple, 3, 2, purchases);

        // 2- Get a free Orange for every 2 Pears you buy.
        Product orange = u.getProductByName("Orange");
        Product pear = u.getProductByName("Pear");
        orange.setPrice(0);
        offer.getFreeProductWhenBuyXProducts(orange, 2, pear, purchases);

        // 3- For every 4 € spent on Pears, we will deduct one euro from your final invoice.
        offer.reduceXWhenBuyYProducts(pear, 1, 4, purchases);

        List<Purchase> freeProducts = new ArrayList<>();
        for (Product p : offer.getFreeProducts()) {
            freeProducts.add(new Purchase(p, 1));
        }
        purchases.addAll(freeProducts);

        Double discount = offer.getDiscount();
        System.out.println("Purchase List:");
        u.totalPrice(purchases, discount);
        System.out.println("----------------------------------");
        System.out.println("Thank you for visiting Fruit Shop");

    }
}
