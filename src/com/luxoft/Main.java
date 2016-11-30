package com.luxoft;

import com.luxoft.Controller.Controller;
import com.luxoft.Model.Feed;
import com.luxoft.View.View;

/**
 * Created by Home on 29.11.2016.
 */
public class Main {

    public static void main(String[] args) {
        Feed feed = new Feed();
        feed.loadFeed(Feed.file);
        feed.loadFromFile(Feed.document);
        View dialog = new View();
        dialog.pack();
        dialog.setVisible(true);
        dialog.repaint();

    }
}
