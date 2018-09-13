package tech.bts.productcatalog;

import java.io.PrintWriter;
import java.util.*;

public class ProductCatalog {

    public static void main(String[] args) throws Exception {

        Product p1 = new Product("iPhone X", 1000, 50);
        Product p2 = new Product("MacBook Pro", 1500, 30);

        List<Product> products = new ArrayList<Product>();

        products.add(p1);
        products.add(p2);

        System.out.println(p1);

        // CSV - Comma Separated Values
        PrintWriter writer = new PrintWriter("products.csv");

        writer.println("Name;Price;Units");

        for (int i = 0; i < products.size(); i ++) {
            Product product = (products.get(i));
            writer.println(product.name + ";" + product.price + ";" + product.unitsInStock);
        }

        writer.close();
    }
}
