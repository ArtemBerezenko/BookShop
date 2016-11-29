package com.luxoft.Model;

/**
 * Created by Home on 28.11.2016.
 */
public class Book {
    private String title;
    private float price;
//    private int count;

//    public Book(String title, float price, int count) {
//        this.title = title;
//        this.price = price;
//        this.count = count;
//    }

    public Book(String title, float price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public float getPrice() {
        return price;
    }

    public String toString(){
        return this.title + " $" + this.price + "\n";
    }
}
