package com.luxoft.Model.DAO;

import com.luxoft.Controller.Controller;
import com.luxoft.Model.ShopInterface;
import com.luxoft.Model.ShopModel;

import java.io.*;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Home on 08.12.2016.
 */
public class FeedFromOrders implements ParseFeed{
    public static File file = new File("C:feeds\\orders.txt");


    public void loadFeed(File file, ShopInterface shop) {

        if(!checkFileIsEmpty(file)) {
            try {
                BufferedReader in =
                        new BufferedReader(
                                new FileReader(file));
                String line;
                while ((line = in.readLine()) != null) {
                    shop.parseFeedOrders(line);
                }
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else{
            shop.getAllOrders();
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


    public void writeOnFile (List<String> strings) {
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
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
