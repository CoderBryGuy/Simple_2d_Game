package com.company;

import java.awt.*;

public class Boss1Enemy extends GameObject {

    private int timer = 100;

    public Boss1Enemy(float x, float y, ID id, Handler handler) {
        super(x, y, id, handler);
        velX = 0;
        velY = 2;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if(timer <= 0){
            velY = 0;
        }else {
            timer--;
        }

//        if(y <= 0 || y >= Game.HEIGHT -64) velY *= -1;
//        if(x <= 0 || x >= Game.WIDTH -32) velX *= -1;

        handler.addObject(new Trail(x,y, ID.Trail, Color.red, 96, 96, 0.02f, handler ));

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)x,(int)y,96,96);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,96,96);
    }
}
