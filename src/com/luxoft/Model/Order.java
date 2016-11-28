package com.luxoft.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 28.11.2016.
 */
public class Order {
    List<Customer> orders = new ArrayList<>();

    private void addOrder(Customer customer){
        orders.add(customer);
    }
}
