package eu.asaitec.offer;

import eu.asaitec.product.Product;
import eu.asaitec.purchase.Purchase;

import java.util.ArrayList;
import java.util.List;

public class Offer {
    private final List<Product> freeProducts;
    private Double discount;

    public Offer() {
        this.discount = 0.0;
        this.freeProducts = new ArrayList<>();
    }

    public Double getDiscount() {
        return discount;
    }

    public List<Product> getFreeProducts() {
        return freeProducts;
    }

    public void buyXProductsPayY(Product product, int xProducts, int payY, List<Purchase> purchases) {

        int productQuantity = getProductQuantity(product, purchases);


        Double result = Double.valueOf(productQuantity / xProducts);
        this.discount += ((result * xProducts * product.getPrice()) - (result * payY * product.getPrice()));
    }

    public void reduceXWhenBuyYProducts(Product product, int reduceAmount, int buyYProduct, List<Purchase> purchases) {

        int productQuantity = getProductQuantity(product, purchases);


        Double reduce = (double) (productQuantity / buyYProduct);
        this.discount = this.discount + (reduce * reduceAmount);

    }

    public void getFreeProductWhenBuyXProducts(Product freeProduct, int xProducts, Product product, List<Purchase> purchases) {

        int productQuantity = getProductQuantity(product, purchases);

        int reduce = productQuantity / xProducts;
        for (int i = 0; i < reduce; i++) {
            this.freeProducts.add(freeProduct);
        }
    }

    private int getProductQuantity(Product product, List<Purchase> purchases) {

        for (Purchase p : purchases) {
            if (p.getProduct().getName().equals(product.getName()))
                return p.getQuantity();
        }
        return 0;
    }
}
