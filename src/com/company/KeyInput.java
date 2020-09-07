package com.company;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        super.keyPressed(e);
        int key = e.getKeyCode();

        for (int i = 0; i < handler.objects.size(); i++) {
               GameObject tempObject = handler.objects.get(i);

               if(tempObject.getId() == ID.Player){
                   //key events for player 1
                   if(key == KeyEvent.VK_W) tempObject.setVelY(-5);
                   if(key == KeyEvent.VK_S) tempObject.setVelY(5);
                   if(key == KeyEvent.VK_D) tempObject.setVelX(5);
                   if(key == KeyEvent.VK_A) tempObject.setVelX(-5);

                   if(key == KeyEvent.VK_H) HUD.HEALTH = 100;

               }
        }

        if(key == KeyEvent.VK_ESCAPE) System.exit(1);
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        super.keyReleased(e);
        int key = e.getKeyCode();

        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);

            if(tempObject.getId() == ID.Player){
                //key events for player 1
                if(key == KeyEvent.VK_W) tempObject.setVelY(0);
                if(key == KeyEvent.VK_S) tempObject.setVelY(0);
                if(key == KeyEvent.VK_D) tempObject.setVelX(0);
                if(key == KeyEvent.VK_A) tempObject.setVelX(0);

            }


        }

    }

}
