package com.company;

import java.awt.*;

public class SmartEnemy extends GameObject {
    private GameObject player;
    private Handler handler;

    public SmartEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id, handler);

        this.handler = handler;

        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);
            if(tempObject.getId() == ID.Player){
                this.player = tempObject;
            }
        }
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        float diffX = x - player.getX() - 16;
        float diffY = y - player.getY() - 16;
        float distance = (float) Math.sqrt(
                ((x - player.getX()) * (x - player.getX()))
                + ((y - player.getY()) * (y - player.getY()))
        );

        velX = (float) ((-1.0/distance) * diffX);
        velY = (float) ((-1.0/distance) * diffY);

//        if(y <= 0 || y >= Game.HEIGHT -64) velY *= -1;
//        if(x <= 0 || x >= Game.WIDTH -32) velX *= -1;

        handler.addObject(new Trail(x, y, ID.Trail, Color.green, 16, 16, 0.02f, handler ));

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect((int)x,(int)y,16,16);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,16,16);
    }
}
