package com.luxoft.Controller;

import com.luxoft.Model.*;
import com.luxoft.View.View;

import java.util.ArrayList;
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
        shop.getCurrentBooks().add((Book) order);
    }

    public static List<Book> getCurrentBooks(){
        return shop.getCurrentBooks();
    }

    public static List<Book> getBooks(){
        return shop.getBooks();
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

    public static List<String> getListStrings(){
       return shop.createListString();
    }

    public static void loadInFile(){
        Feed feed = new Feed();
        feed.writeOnFile(getListStrings());
    }

}
