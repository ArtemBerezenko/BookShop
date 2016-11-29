package com.luxoft.Model;

import java.text.DateFormat;
import java.util.*;

/**
 * Created by Home on 28.11.2016.
 */
public class Order {
    private Date date;
    private Customer customer;
    private List<Book> customerBooks = new ArrayList<>();
    private float amountOrder = 0;

    public Date getDate() {
        return date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public float getAmountOrder() {
        return amountOrder;
    }

    public Order(Customer customer, List<Book> customerBooks, float amountOrder) {
        this.date = new Date();
        this.customer = customer;
        this.customerBooks = customerBooks;
        this.amountOrder = amountOrder;
    }


    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Date: " + DateFormat.getTimeInstance().format(date) + " Client: " + this.getCustomer());
        str.append("\n");
        for(Book order : customerBooks){
            str.append(" Book: " + order.toString());
        }
        str.append("\n");
        str.append("TOTAL AMOUNT: " + "$" + this.amountOrder);
        return str.toString();
    }
//    public float getAmount(){
//        float amount = 0;
//        for(Book book : customerBooks){
//            amount = book.getPrice();
//        }
//        return amount;
//    }

//    private Map<Book, Integer> order = new HashMap<>();
//
//    public void addBook(Book book, int count){
//        int countBook = 0;
//        int newCount = 0;
//        if(this.order.containsKey(book)){
//            countBook = order.get(book);
//            newCount = countBook + count;
//            order.replace(book, countBook, newCount);
//        }
//        order.put(book, count);
//    }

//    public void removeBook(Book book){
//        order.remove(book);
//    }
//
//    public Map<Book, Integer> getBooks() {
//        return order;
//    }
//
//    public float getAmount(){
//        float amount, summ = 0;
//        for(Book book : order.keySet()){
//            amount = book.getPrice() * order.get(book);
//            summ += amount;
//        }
//        return summ;
//    }




//    private List<Book> books = new ArrayList<>();
//
//    public void addBook(Book book){
//        books.add(book);
//    }
//
//    public void removeBook(Book book){
//        books.remove(book);
//    }
//
//    public List<Book> getBooks() {
//        return books;
//    }

}
