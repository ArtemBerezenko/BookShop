package com.luxoft.Model;

import java.util.List;

/**
 * Created by Home on 30.11.2016.
 */
public interface ShopInterface {
    void removeBook(Product product);
    void checkout();
    List<Product> getCurrentProducts();
    List<Product> getProducts();
    void createCustomer(String name);
    List<Order> getAllOrders();
    void update();
    List<String> createListString();
    void parseFeed(String string);
    void parseFeedOrders(String string);
}
