package com.luxoft.Model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Home on 28.11.2016.
 */
public class Shop {
    private static final int TITLE = 0;
    private static final int PRICE = 1;
    private Customer currentCustomer;
    private List<Book> books = new ArrayList<>();
    private List<Book> currentBooks = new ArrayList<>();
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

    public List<Book> getCurrentBooks() {
        return currentBooks;
    }

    public void createCustomer(String name){
        currentCustomer = new Customer(name);
        customers.add(currentCustomer);
    }

    public void removeBook(Book book){
        currentBooks.remove(book);
    }


    public void checkout() {
        float amount = getAmountOrder();
        Order order = new Order(currentCustomer, currentBooks, amount);
        allOrders.add(order);
    }

    private float getAmountOrder(){
        float amount = 0;
        for(Book order : currentBooks){
            amount += order.getPrice();
        }
        return amount;
    }

    public List<Order> getAllOrders() {
        return allOrders;
    }

    public void update() {
        this.currentCustomer = new Customer();
        this.currentBooks = new ArrayList<>();
    }

    public List<String> createListString() {
        List<String> strings = new ArrayList<>();
        for (Order order : allOrders) {
            strings.add(order.createString());
        }
        return strings;
    }

//    public void parseFeedOrders(String string) {
//        Date date = null;
//        String[] newLine = string.split(";");
//        for(String line : newLine) {
//            String[] str = line.split("=");
//            if ("Book".equals(str[0])) {
//                String[] ln = string.split(" - ");
//                currentBooks.add(new Book(ln[TITLE], Float.parseFloat(ln[PRICE])));
//            }
//            if ("Date".equals(newLine[0])) {
//                date = Date.from(Instant.parse(str[1]));
//            }
//            if ("Customer".equals(str[0])) {
//                currentCustomer = new Customer(str[0]);
//            }
//        }
//            allOrders.add(new Order(date, currentCustomer, currentBooks, getAmountOrder()));
//    }

}
