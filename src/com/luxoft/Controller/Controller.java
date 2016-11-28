package com.luxoft.Controller;

import com.luxoft.Model.Shop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.sun.activation.registries.LogSupport.log;

/**
 * Created by Home on 28.11.2016.
 */
public class Controller {
    public static File file = new File("C:\\Users\\Home\\IdeaProjects\\BookShop\\feeds\\books.txt");
    public static Shop shop = new Shop();
//    public static List<String> stringFromFile =  new ArrayList<>();

    public void loadFeed(File file) {
        try {
            BufferedReader in =
                    new BufferedReader(
                            new FileReader(file));
            String line;
            while( (line = in.readLine()) != null) {
//                stringFromFile.add(line);
                shop.parseFeed(line);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
