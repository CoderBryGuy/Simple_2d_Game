package com.company;

import java.awt.*;
import java.util.Random;

public class MenuParticle extends GameObject {

    private Random r = new Random();
    private int red = r.nextInt(255);
    private int green = r.nextInt(255);
    private int blue = r.nextInt(255);
    private Color col;

    int dir = 0;


    public MenuParticle(float x, float y, ID id, Handler handler) {
        super(x, y, id, handler);

            velX = (r.nextInt(5 - -5) + -5);
            velY = (r.nextInt(5 - -5) + -5);
            if(velX == 0) velX = 1;
            if(velY == 0) velY = 1;


        col = new Color(red, green, blue);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if(y <= 0 || y >= Game.HEIGHT -64) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH -32) velX *= -1;

        handler.addObject(new Trail(x,y, ID.Trail, col, 16, 16, 0.05f, handler ));

    }

    @Override
    public void render(Graphics g) {
        g.setColor(col);
        g.fillRect((int)x,(int)y,16,16);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,16,16);
    }
}
