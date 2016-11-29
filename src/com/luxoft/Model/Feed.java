package com.luxoft.Model;



import com.luxoft.Controller.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Home on 29.11.2016.
 */
public class Feed {
    public static File file = new File("C:feeds\\books.txt");

    public void loadFeed(File file) {
        try {
            BufferedReader in =
                    new BufferedReader(
                            new FileReader(file));
            String line;
            while( (line = in.readLine()) != null) {
                Controller.shop.parseFeed(line);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
