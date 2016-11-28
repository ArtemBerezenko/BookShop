package com.luxoft.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 28.11.2016.
 */
public class Customer {
    private String name;
    List<Book> currentOrder = new ArrayList<>();

    private void addBook(Book book){
        currentOrder.add(book);
    }

    private void removeBook(Book book){
        currentOrder.remove(book);
    }

}
