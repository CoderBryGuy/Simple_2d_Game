package com.company;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;
import java.util.Random;

public class Player extends GameObject {

    Random r = new Random();


    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);

    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH - 48 );
        y = Game.clamp(y, 0, Game.HEIGHT - 72);

        handler.addObject(new Trail(x,y, ID.Trail, Color.white, 32, 32, 0.08f, handler ));

        collision();

    }

    private void collision() {
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);

            if (tempObject.getId() == ID.BasicEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    HUD.HEALTH -= 2;
                } else if (tempObject.getId() == ID.FastEnemy) {
                    if (getBounds().intersects(tempObject.getBounds())) {
                        HUD.HEALTH -= 2;
                    }
                }else if (tempObject.getId() == ID.SmartEnemy) {
                    if (getBounds().intersects(tempObject.getBounds())) {
                        HUD.HEALTH -= 2;
                    }
                }
            }

        }
    }


    @Override
    public void render(Graphics g) {

//        Graphics2D g2d = (Graphics2D) g;
//
//        g.setColor(Color.red);
//        g2d.draw(getBounds());

        g.setColor(Color.white);
        g.fillRect((int)x,(int)y,32,32);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y,32,32);
    }


}
