package com.luxoft.Model;

/**
 * Created by Home on 28.11.2016.
 */
public class Book implements Product {
    private String title;
    private float price;


    public Book(String title, float price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public float getPrice() {
        return price;
    }
    @Override
    public String toString(){
        return this.title + " - $" + this.price + "\n";
    }

    @Override
    public String createString(){
        return this.title + " - " + this.price;
    }
}
