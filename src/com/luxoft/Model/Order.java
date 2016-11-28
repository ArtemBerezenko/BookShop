package com.luxoft.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 28.11.2016.
 */
public class Order {
    private float totalAmount;
    List<Customer> customersOrders = new ArrayList<>();

    private void addOrder(Customer customer){
        customersOrders.add(customer);
    }

    private float setTotalAmount(List<Customer> orders){
        float amount = 0;
        for(Customer customer : customersOrders){
            amount = customer.getAmount(customer.getCurrentOrder());
        }
        return amount;
    }

    public float getTotalAmount() {
        return totalAmount;
    }
}
