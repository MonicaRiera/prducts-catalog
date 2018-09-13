package tech.bts.productcatalog;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.*;

public class ProductCatalogRead {

    public static void main(String[] args) throws Exception {
        Gson gson = new Gson();

        BufferedReader reader = new BufferedReader( new FileReader("products.json"));

        String json = reader.readLine();

        Type type = new TypeToken<List<Product>>(){}.getType();
        List<Product> products = gson.fromJson(json, type);

        for (int i = 0; i < products.size(); i ++) {
            System.out.println(products.get(i));

        }

        // another way of doing the loop
        for (Product p : products) {
            System.out.println(p);
        }


    }
}
