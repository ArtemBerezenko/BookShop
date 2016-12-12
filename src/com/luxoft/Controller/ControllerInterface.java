package com.luxoft.Controller;

import com.luxoft.Model.Order;
import com.luxoft.Model.Product;

import javax.swing.*;
import java.util.List;

/**
 * Created by Home on 11.12.2016.
 */
public interface ControllerInterface {
    void loadFromFiles();
    void onRemove(Object elem);
    void onBuy();
    void addCurrentOrder(Object order);
    List<Product> getCurrentBooks();
    List<Product> getBooks();
    void setCustomer(String sting);
    List<Order> getAllOrders();
    void CreateNewOrder();
    List<String> getListStrings();
    void loadInFile();
    void setEnabledComponent(JList list2, JButton buttonRemove);
}
