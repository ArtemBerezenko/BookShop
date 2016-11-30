package com.luxoft.Model;



import com.luxoft.Controller.Controller;


import java.io.*;
import java.util.*;

/**
 * Created by Home on 29.11.2016.
 */
public class Feed implements ParseFeed {
    public static File file = new File("C:feeds\\books.txt");
    public static File document = new File("C:feeds\\orders.txt");

    @Override
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

    @Override
    public void loadFromFile(File file) {
        if(!checkFileIsEmpty(file)) {
            try {
                BufferedReader in =
                        new BufferedReader(
                                new FileReader(file));
                String line;
                while ((line = in.readLine()) != null) {
                    Controller.shop.parseFeedOrders(line);
                }
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else{
                Controller.shop.getAllOrders();
            }
    }

    public boolean checkFileIsEmpty(File file) {
        boolean flag = false;
        try {
            Scanner in =
                    new Scanner(
                            new FileReader(file));
            if(!in.hasNext()){
                flag = true;
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
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
