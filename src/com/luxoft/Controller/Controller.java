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
    public static ShopInterface shop = new Shop();


    public static void onRemove(Object elem) {
        shop.removeBook((Book) elem);
    }

    public static void onBuy() {
        shop.checkout();
    }

    public static void addCurrentOrder(Object order){
        shop.getCurrentProducts().add((Book) order);
    }

    public static List<Product> getCurrentBooks(){
        return shop.getCurrentProducts();
    }

    public static List<Product> getBooks(){
        return shop.getProducts();
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
