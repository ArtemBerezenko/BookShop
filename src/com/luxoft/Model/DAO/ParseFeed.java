package com.luxoft.Model.DAO;

import com.luxoft.Model.Product;
import com.luxoft.Model.ShopInterface;

import java.io.File;
import java.util.List;

/**
 * Created by Home on 30.11.2016.
 */
public interface ParseFeed {
    void loadFeed(File file, ShopInterface shop);
    void writeOnFile(List<String> strings);
}
