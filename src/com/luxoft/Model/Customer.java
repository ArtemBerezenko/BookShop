package com.luxoft.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 28.11.2016.
 */
public class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public Customer() {}


    public String toString(){
        return this.name;
    }
}
