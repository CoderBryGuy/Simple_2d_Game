package com.company;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {

    //field already exists in Canvas ??
    private static final long serialVersionUID = -240840600533728354L;
    private int width;
    private int height;
    private String title;

    public Window(int width, int height, String title, Game game) {
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();



    }
}
