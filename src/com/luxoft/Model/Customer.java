package com.luxoft.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 28.11.2016.
 */
public class Customer {
    private String name;
//    private float purchaseAmount;
    List<Book> currentOrder = new ArrayList<>();

    public void addBook(Book book){
        currentOrder.add(book);
    }

    public void removeBook(Book book){
        currentOrder.remove(book);
    }

    public List<Book> getCurrentOrder() {
        return currentOrder;
    }

    //    public void setPurchaseAmount(float purchaseAmount) {
//        this.purchaseAmount = purchaseAmount;
//    }

    public float getAmount(List<Book> currentOrder){
        float amount = 0;
        for(Book book : currentOrder){
            amount = book.getPrice();
        }
        return amount;
    }

}
