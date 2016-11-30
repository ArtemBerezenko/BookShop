package com.luxoft.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 28.11.2016.
 */
public class Shop implements ShopInterface {
    private static final int TITLE = 0;
    private static final int PRICE = 1;
    private Customer currentCustomer;
    private List<Product> products = new ArrayList<>();
    private List<Product> currentProducts = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Order> allOrders = new ArrayList<>();

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    public List<Product> getCurrentProducts() {
        return currentProducts;
    }
    @Override
    public void createCustomer(String name){
        currentCustomer = new Customer(name);
        customers.add(currentCustomer);
    }
    @Override
    public void removeBook(Product product){
        currentProducts.remove(product);
    }

    @Override
    public void checkout() {
        float amount = getAmountOrder();
        Order order = new Order(currentCustomer, currentProducts, amount);
        allOrders.add(order);
    }

    private float getAmountOrder(){
        float amount = 0;
        for(Product product : currentProducts){
            amount += product.getPrice();
        }
        return amount;
    }

    @Override
    public List<Order> getAllOrders() {
        return allOrders;
    }

    @Override
    public void update() {
        this.currentCustomer = new Customer();
        this.currentProducts = new ArrayList<>();
    }

    @Override
    public List<String> createListString() {
        List<String> strings = new ArrayList<>();
        for (Order order : allOrders) {
            strings.add(order.createString());
        }
        return strings;
    }
    @Override
    public void parseFeed(String string) {
        String[] newLine = string.split(";");
        products.add(new Book(newLine[TITLE], Float.parseFloat(newLine[PRICE])));
    }
    @Override
    public void parseFeedOrders(String string) {
        String[] newLine = string.split(";");
        String date = "";
        for(String line : newLine) {
            String[] str = line.split("=");
            if ("Book".equals(str[0])) {
                String bookLine = str[1];
                String[] ln = bookLine.split(" - ");
                Book book = new Book(ln[TITLE], Float.parseFloat(ln[PRICE]));
                currentProducts.add(book);
            }
            if ("Date".equals(str[0])) {
                date = str[1];
            }
            if ("Customer".equals(str[0])) {
                currentCustomer = new Customer(str[1]);
            }
        }
        allOrders.add(new Order(date, currentCustomer, currentProducts, getAmountOrder()));
        currentProducts = new ArrayList<>();

    }

}
