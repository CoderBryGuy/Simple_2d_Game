package com.company;

import java.awt.*;
import java.util.Random;

public class Boss1Bullet extends GameObject {

    private Handler handler;
    private Random r = new Random();

    public Boss1Bullet(float x, float y, ID id, Handler handler) {
        super(x, y, id, handler);
        this.handler = handler;
        velX = (r.nextInt(5 - -5) + -5);
        velY = 5;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

//        if(y <= 0 || y >= Game.HEIGHT -64) velY *= -1;
        if(x <= 0 || x >= Game.WIDTH -32) velX *= -1;

        if(y >= Game.HEIGHT){
            handler.removeObject(this);
        }

        handler.addObject(new Trail(x,y, ID.Trail, Color.red, 16, 16, 0.02f, handler ));

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int)x,(int)y,16,16);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,16,16);
    }
}
