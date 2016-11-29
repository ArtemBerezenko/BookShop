package com.luxoft.Model;



import com.luxoft.Controller.Controller;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Home on 29.11.2016.
 */
public class Feed {
    public static File file = new File("C:feeds\\books.txt");
    public static File document = new File("C:feeds\\orders.txt");

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

    public static void writeOnFile (List<String> strings) {
        try {
            if(!document.exists()){
                document.createNewFile();
            }
            PrintWriter out = new PrintWriter(document.getAbsoluteFile());
            try {
                for(String string : strings) {
                    out.println(string);
                }
            } finally {
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
