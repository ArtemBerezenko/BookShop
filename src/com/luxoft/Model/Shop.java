package com.luxoft.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 28.11.2016.
 */
public class Shop {
    private static final int TITLE = 0;
    private static final int PRICE = 1;
    private Customer currentCustomer;
    private List<Book> books = new ArrayList<>();
    private List<Book> currentOrder = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Order> allOrders = new ArrayList<>();

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void parseFeed(String string) {
            String[] newLine = string.split(";");
            Book book = new Book(newLine[TITLE], Float.parseFloat(newLine[PRICE]));
            books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Book> getCurrentOrder() {
        return currentOrder;
    }

    public void createCustomer(String name){
        currentCustomer = new Customer(name);
        customers.add(currentCustomer);
    }

    public void removeBook(Book book){
        currentOrder.remove(book);
    }


    public void checkout() {
        float amount = getAmountOrder();
        Order order = new Order(currentCustomer, currentOrder, amount);
        allOrders.add(order);
    }

    private float getAmountOrder(){
        float amount = 0;
        for(Book order : currentOrder){
            amount += order.getPrice();
        }
        return amount;
    }

    public List<Order> getAllOrders() {
        return allOrders;
    }

    public void update() {
        this.currentCustomer = null;
        this.currentOrder = null;
    }

    //    public void setAmount(){
//        float amount = 0;
//        for(Book book : customerBooks){
//            amount += book.getPrice();
//        }
//        this.amountOrder = amount;
//    }
}
