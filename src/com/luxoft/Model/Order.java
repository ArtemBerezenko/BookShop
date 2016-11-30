package com.luxoft.Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Home on 28.11.2016.
 */
public class Order {
    private Date date;
    private Customer customer;
    private List<Book> customerBooks = new ArrayList<>();
    private float amountOrder = 0;


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
        str.append(" Date: " + DateFormat.getDateInstance().format(date) + " Client: " + this.getCustomer());
        str.append("\n");
        for(Book book : customerBooks){
            str.append(" Book: " + book.toString());
        }
        str.append("TOTAL AMOUNT: " + "$" + this.amountOrder + "\n");
        str.append("\n");
        return str.toString();
    }

    public String createString(){
        StringBuilder str = new StringBuilder();
        str.append("Date=" + DateFormat.getDateInstance().format(date) + ";"+ "Customer=" + this.getCustomer() + ";");
        for(Book book : customerBooks){
            str.append("Book=" + book.createStringBook() + ";");
        }
        str.append("TOTAL AMOUNT=" + this.amountOrder + ";");
        return str.toString();
    }

    public Order(String string, Customer customer, List<Book> customerBooks, float amountOrder) {

        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        try {
            this.date = format.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.customer = customer;
        this.customerBooks = customerBooks;
        this.amountOrder = amountOrder;
    }

}
