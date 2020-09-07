package com.company;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    Random r = new Random();

    public Player(int x, int y, ID id) {
        super(x, y, id);
//        velX = r.nextInt(5) +1;
//        velY = r.nextInt(5);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH - 48 );
        y = Game.clamp(y, 0, Game.HEIGHT - 72);

//        System.out.println("x is " + x + " / Game Width is : " + Game.WIDTH);
//        System.out.println("y is " + y + " / Game Height is : " + Game.HEIGHT);
    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.white);
        g.fillRect(x,y,32,32);
    }


}
