package com.company;

import java.awt.*;

public class BasicEnemy extends GameObject {

    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);
        velX = 5;
        velY = 5;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if(y <= 0 || y >= Game.HEIGHT -64) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH -32) velX *= -1;

        handler.addObject(new Trail(x,y, ID.Trail, Color.red, 16, 16, 0.01f, handler ));

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x,y,16,16);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,16,16);
    }
}
