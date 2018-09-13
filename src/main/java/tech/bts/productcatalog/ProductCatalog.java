package tech.bts.productcatalog;

import com.google.gson.Gson;
import java.io.PrintWriter;
import java.util.*;

public class ProductCatalog {

    public static void main(String[] args) throws Exception {

        Product p1 = new Product("iPhone X", 1000, 50);
        Product p2 = new Product("MacBook Pro", 1500, 30);
        Product p3 = new Product("Mouse", 20, 55);

        List<Product> products = new ArrayList<Product>();
        products.add(p1);
        products.add(p2);
        products.add(p3);

        writeJSON(products);
        writeCSV(products);

    }

    private static void writeJSON(List<Product> products) throws Exception {
        // JSON - JavaScript Object Notation
        Gson gson = new Gson();
        String json = gson.toJson(products);

        PrintWriter writer = new PrintWriter("products.json");

        writer.println(json);
        writer.close();

    }

    private static void writeCSV(List<Product> products) throws Exception {
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
