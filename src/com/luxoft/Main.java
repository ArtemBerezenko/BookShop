package com.luxoft;

import com.luxoft.Controller.Controller;
import com.luxoft.Controller.ControllerInterface;
import com.luxoft.Model.ShopInterface;
import com.luxoft.Model.ShopModel;
/**
 * Created by Home on 29.11.2016.
 */
public class Main {

    public static void main(String[] args) {
        ShopInterface shop = new ShopModel();
        ControllerInterface controller = new Controller(shop);
    }
}
