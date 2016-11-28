package com.luxoft.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 28.11.2016.
 */
public class Shop implements ShopService{
    private static final int TITLE = 0;
    private static final int PRICE = 1;
    public List<Book> books =  new ArrayList<>();
    List<Order> allOrders = new ArrayList<>();

    public Shop() {
    }

    public Shop(List<Book> books, List<Order> orders) {
        this.books = books;
        this.allOrders = orders;
    }


    public void parseFeed(String string) {
//        for(String line : string) {
            String[] newLine = string.split(";");
            Book book = new Book(newLine[TITLE], Float.parseFloat(newLine[PRICE]));
            books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }
}
