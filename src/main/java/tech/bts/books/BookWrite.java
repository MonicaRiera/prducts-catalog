package tech.bts.books;

import com.google.gson.Gson;

import java.io.PrintWriter;

public class BookWrite {
    public static void main(String[] args) throws Exception{

        Book book = new Book("The Spy", "Paulo Coelho", 254);

        System.out.println(book);
        writeJSON(book);

    }

    private static void writeJSON (Book book) throws Exception {

        Gson gson = new Gson();
        String json = gson.toJson(book);

        PrintWriter writer = new PrintWriter("books.json");

        writer.println(json);
        writer.close();

    }
}
