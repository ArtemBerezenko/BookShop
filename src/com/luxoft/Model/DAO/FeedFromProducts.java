package com.luxoft.Model.DAO;



import com.luxoft.Controller.Controller;
import com.luxoft.Model.Book;
import com.luxoft.Model.Product;
import com.luxoft.Model.ShopInterface;
import com.luxoft.Model.ShopModel;


import java.io.*;
import java.util.*;

/**
 * Created by Home on 29.11.2016.
 */
public class FeedFromProducts implements ParseFeed{
    public static File file = new File("C:feeds\\books.txt");


    public void loadFeed(File file, ShopInterface shop) {
        try {
            BufferedReader in =
                    new BufferedReader(
                            new FileReader(file));
            String line;
            while( (line = in.readLine()) != null) {
                 shop.parseFeed(line);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void writeOnFile(List<String> strings) {}
}
