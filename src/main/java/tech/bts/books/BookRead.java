package tech.bts.books;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;


public class BookRead {
    public static void main(String[] args) throws Exception{
        Gson gson = new Gson();

        BufferedReader reader = new BufferedReader( new FileReader("books.json"));

        String json = reader.readLine();

        Type type = new TypeToken<Book>(){}.getType();
        Book book = gson.fromJson(json, type);
        System.out.println(book);

    }
}
