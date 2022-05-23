package eu.asaitec.fruitshop.manager;

import eu.asaitec.product.Product;
import eu.asaitec.purchase.Purchase;
import eu.asaitec.utility.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Utility u = new Utility();
        List<Product> products = u.readProducts("src/main/resources/products.txt");

        List<Purchase> purchases = u.purchaseProducts("src/main/resources/purchase.txt");

        u.totalPrice(purchases);
        System.out.println("Thank you for visiting Fruit Shope");

    }
}
