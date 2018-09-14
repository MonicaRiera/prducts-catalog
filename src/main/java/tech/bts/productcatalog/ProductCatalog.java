package tech.bts.productcatalog;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.sql.SQLOutput;
import java.util.*;

public class ProductCatalog {

    /**
     * This program can read products from keyboard and store them in a file (products.json).
     *
     * When the program starts it will ask "What do you want to do?".
     * You can say "add" (add product) or "list" (display products).
     *
     * If you say "add" the program will ask for the product data (name, price, units).
     *
     * > What do you want to do? add
     * > Tell me the product name: iPhone
     * > Price: 1000
     * > Units: 5
     * > Product added
     * > What do you want to do? list
     * iPhone - 1000€ - 5 units
     * ....
     * > What do you want to do?
     */

    public static void main(String[] args) throws Exception {


        List<Product> products = readJSON();

        while (true) {

            System.out.println("Welcome! What do you want to do? ");
            Scanner input = new Scanner(System.in);
            String action = input.nextLine();

            if (action.equals("exit")) {
                writeJSON(products);
                break;
            }

            if (action.equals("add")) {
                System.out.print("What product? ");
                String name = input.nextLine();

                System.out.print("At what price? ");
                double price = Double.parseDouble(input.nextLine());

                System.out.print("Any stock? ");
                int stock = Integer.parseInt(input.nextLine());

                Product p = new Product(name, price, stock);
                products.add(p);
                System.out.println("Added: " + p);

                writeJSON(products);
            }

            if (action.equals("list")) {
                readJSON();
                for (Product p : products) {
                    System.out.println(p);
                    }
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
}
