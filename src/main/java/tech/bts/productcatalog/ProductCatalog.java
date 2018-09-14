package tech.bts.productcatalog;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.*;

public class ProductCatalog {

    /**
     * This program can read products from keyboard and store them in a file (products.json).
     * When the program starts it will ask "What do you want to do?".
     * You can say "add" (add product) or "list" (display products).
     * If you say "add" the program will ask for the product data (name, price, units).
     */

    public static void main(String[] args) throws Exception {

        List<Product> products = readJSON();

        while (true) {

            System.out.print("Welcome! What do you want to do? (add/list/exit) ");
            Scanner input = new Scanner(System.in);
            String action = input.nextLine();

            if (action.equals("exit")) {
                writeJSON(products);
                writeHTML(products);
                break;

            } else if (action.equals("add")) {
                Product p = createProduct(input);
                products.add(p);
                System.out.println("Added: " + p);

            } else if (action.equals("list")) {
                for (Product p : products) {
                    System.out.println(p);
                    }
            } else if (action.equals("html")) {
                writeHTML(products);
            }
        }
    }

    private static void writeJSON(List<Product> products) throws Exception {
        // JSON - JavaScript Object Notation
        Gson gson = new Gson();
        String json = gson.toJson(products); // serializing (object to String)

        PrintWriter writer = new PrintWriter("products.json");

        writer.println(json);
        writer.close();

    }

    private static List<Product> readJSON() throws Exception {
        Gson gson = new Gson();

        BufferedReader reader = new BufferedReader( new FileReader("products.json"));

        String json = reader.readLine();

        Type type = new TypeToken<List<Product>>(){}.getType();
        List<Product> products = gson.fromJson(json, type);

        return products;
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

    private static Product createProduct(Scanner input){

        System.out.print("What product? ");
        String name = input.nextLine();

        System.out.print("At what price? ");
        double price = Double.parseDouble(input.nextLine());

        System.out.print("Any stock? ");
        int stock = Integer.parseInt(input.nextLine());

        Product p = new Product(name, price, stock);

        return p;
    }

    private static void writeHTML(List<Product> products) throws Exception{
        PrintWriter writer = new PrintWriter("products.html");
        writer.println("<h1>Products</h1>");
        writer.println("<h3>Available products</h3>");
        writer.println("<ul>");

        for (Product product : products) {
            writer.println("<li>" + product + "</li>");
        }
        writer.println("</ul>");
        writer.close();

    }
}
