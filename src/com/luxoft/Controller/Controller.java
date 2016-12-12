package com.luxoft.Controller;

import com.luxoft.Model.*;
import com.luxoft.Model.DAO.FeedFromOrders;
import com.luxoft.Model.DAO.FeedFromProducts;
import com.luxoft.Model.DAO.ParseFeed;
import com.luxoft.View.View;

import javax.swing.*;
import java.util.List;

import static com.sun.activation.registries.LogSupport.log;

/**
 * Created by Home on 28.11.2016.
 */
public class Controller implements ControllerInterface{
    private View view;
    private ShopInterface shop;


    public Controller(ShopInterface shop) {
        this.shop = shop;
        this.loadFromFiles();
        view = new View(this, shop);
        this.showProducts();
        view.createView();
        view.setVisible(true);
    }

    public void showOrdersOnPanel(JTextPane textPane1){
        textPane1.setText(String.valueOf(getAllOrders()));
        CreateNewOrder();
    }

    public void loadFromFiles() {
        ParseFeed fromProducts = new FeedFromProducts();
        ParseFeed fromOrders = new FeedFromOrders();
        fromProducts.loadFeed(FeedFromProducts.file, shop);
        fromOrders.loadFeed(FeedFromOrders.file, shop);
    }

    public void onRemove(Object elem) {
        shop.removeBook((Book) elem);
    }

    public void onBuy() {
        shop.checkout();
        view.disableEditListOrders();
        view.disableEditListProducts();
        view.disabledButtonBuy();
        view.disabledEditButtonAdd();
        view.disabledEditButtonRemove();
    }

    public void addCurrentOrder(Object order){
        shop.getCurrentProducts().add((Book) order);
        view.addOnList(order);
    }

    public List<Product> getCurrentBooks(){
        return shop.getCurrentProducts();
    }

    public List<Product> getBooks(){
        return shop.getProducts();
    }

    public void setCustomer(String sting){
        shop.createCustomer(sting);
        view.disableEditTextField();
    }

    public List<Order> getAllOrders(){
        List<Order> orders;
        orders = shop.getAllOrders();
        return orders;
    }


    public void CreateNewOrder() {
        shop.update();
        view.update();
        view.enableEditTextField();
        view.enabledEditListProducts();
        view.enableEditListOrders();
        view.enabledEditButtonAdd();
        view.enabledEditButtonBuy();
        view.enabledEditButtonRemove();
    }

    public List<String> getListStrings(){
       return shop.createListString();
    }

    public void loadInFile(){
        ParseFeed feed = new FeedFromOrders();
        feed.writeOnFile(getListStrings());
    }

    public void setEnabledComponent(JList list, JButton button){
        view.setEnabledList(list, button);
    }

    public void showProducts(){
        view.showProducts();
    }
}
