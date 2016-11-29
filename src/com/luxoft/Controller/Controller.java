package com.luxoft.Controller;

import com.luxoft.Model.*;
import com.luxoft.View.View;

import java.util.List;

import static com.sun.activation.registries.LogSupport.log;

/**
 * Created by Home on 28.11.2016.
 */
public class Controller {
    public static View view;
    public static Shop shop = new Shop();

    public static void onRemove(Object elem) {
        shop.removeBook((Book) elem);
    }

    public static void onBuy() {
        shop.checkout();
    }

    public static void addCurrentOrder(Object order){
        shop.getCurrentOrder().add((Book) order);
    }

    public static List<Book> displayCurrentOrder(){
        List<Book> books;
        books = shop.getCurrentOrder();
        return books;
    }

    public static List<Book> getBooks(){
        List<Book> books;
        books = shop.getBooks();
        return books;
    }

    public static void addCustomer(String sting){
        shop.createCustomer(sting);
    }

    public static List<Order> getAllOrders(){
        List<Order> orders;
        orders = shop.getAllOrders();
        return orders;
    }


    public static void createNewOrder() {
        shop.update();
    }
}
