package eu.asaitec.utility;

import eu.asaitec.product.Product;
import eu.asaitec.purchase.Purchase;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UtilityTest {

    @Test
    void testFileInputStream() throws FileNotFoundException {
        String fileLocation = "src/main/resources/products.txt";
        FileInputStream fis = new FileInputStream(fileLocation);


        Scanner scanner = new Scanner(fis);
        scanner.useDelimiter(" ");

        assertTrue(scanner.hasNext());
        assertEquals("Hello,", scanner.next());
        assertEquals("world!", scanner.next());

        scanner.close();
    }

    @Test
    void testReadProducts() throws FileNotFoundException {
        Utility utilityUnderTest = new Utility();
        String fileLocation = "src/main/resources/products.txt";

        List<Product> products = utilityUnderTest.readProducts(fileLocation);
        List<Product> expectedProducts = new ArrayList<>();


        FileInputStream fis = new FileInputStream(fileLocation);


        Scanner sc = new Scanner(fis); //file to be scanned
        //returns true if there is another line to read
        while (sc.hasNextLine()) {
            String product = sc.nextLine();
            String[] productAsArray = product.split(",");
            expectedProducts.add(new Product(productAsArray[0], Double.parseDouble(productAsArray[1])));
        }

        sc.close();     //closes the scanner


        assertEquals(products.size(), expectedProducts.size());

    }

    @Test
    void purchaseProducts() throws FileNotFoundException {
        Utility utilityUnderTest = new Utility();
        String productFileLocation = "src/main/resources/products.txt";

        List<Product> products = utilityUnderTest.readProducts(productFileLocation);
        String fileLocation = "src/main/resources/purchase.txt";

        List<Purchase> purchases = utilityUnderTest.purchaseProducts(fileLocation);
        List<Purchase> expectedPurchase = new ArrayList<>();


        FileInputStream fis = new FileInputStream(fileLocation);


        Scanner sc = new Scanner(fis); //file to be scanned
        //returns true if there is another line to read
        while (sc.hasNextLine()) {
            String product = sc.nextLine();
            String[] productAsArray = product.split(",");
             Product p = utilityUnderTest.getProductByName(productAsArray[0]);
            expectedPurchase.add(new Purchase(p, Integer.parseInt(productAsArray[1])));
        }

        sc.close();     //closes the scanner


        assertEquals(purchases.size(), expectedPurchase.size());
    }

    @Test
    void totalPrice() {
    }
}