package eu.asaitec.utility;

import eu.asaitec.product.Product;
import eu.asaitec.purchase.Purchase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utility {
    List<Product> products = new ArrayList<Product>();
    List<Purchase> purchases = new ArrayList<Purchase>();

    public List<Product> readProducts(String fileLocation) {

        try {
            //the file to be opened for reading
            FileInputStream fis = new FileInputStream(fileLocation);
            Scanner sc = new Scanner(fis);    //file to be scanned
            //returns true if there is another line to read
            while (sc.hasNextLine()) {
                String product = sc.nextLine();
                String[] productAsArray = product.split(",");
                products.add(new Product(productAsArray[0], Double.parseDouble(productAsArray[1])));
            }

            sc.close();     //closes the scanner
            return products;
        } catch (
                IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Purchase> purchaseProducts(String fileLocation) {

        try {
            //the file to be opened for reading
            FileInputStream fis = new FileInputStream(fileLocation);
            Scanner sc = new Scanner(fis);    //file to be scanned
            //returns true if there is another line to read
            while (sc.hasNextLine()) {
                String purchase = sc.nextLine();
                String[] purchaseAsArray = purchase.split(",");
                Product p = getProductByName(purchaseAsArray[0]);
                purchases.add(new Purchase(p, Integer.parseInt(purchaseAsArray[1])));
            }

            sc.close();     //closes the scanner
            return purchases;
        } catch (
                IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Product getProductByName(String name) {
        for (Product p : products) {
            if (p.getName().equals(name))
                return p;
        }
        return null;
    }

    public void totalPrice(List<Purchase> purchases) {
        double total = 0;
        for (Purchase purchase : purchases) {
            Product p = purchase.getProduct();
            int quantity = purchase.getQuantity();

            // Apply offers

            double price = p.getPrice() * quantity;

            System.out.println("Product: " + p.getName() + "Product Price : " + p.getPrice() + " Quantity: " + quantity + " Price: " + price);

            total = total + price;


        }
        System.out.println("Total price: " + total);


    }


}
