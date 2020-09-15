package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Handler {
    ArrayList<GameObject> objects = new ArrayList<>();

    public void tick(){
        for (int i = 0; i < objects.size() ; i++) {
            GameObject tempObject = objects.get(i);
            tempObject.tick();
        }
    }
    public void render(Graphics g){
        for (int i = 0; i < objects.size() ; i++) {

            GameObject tempObject;
            tempObject = objects.get(i);
             tempObject.render(g);


        }
    }

    public void addObject(GameObject object){
        this.objects.add(object);
    }

    public void removeObject(GameObject object){
        this.objects.remove(object);
    }

    public void clearEnemies() {
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);

            if((tempObject.getId() == ID.Player)){
                objects.clear();
                if(Game.gameState != Game.STATE.End) {
                    addObject(new Player((int) tempObject.getX(), (int) tempObject.getY(), ID.Player, this));
                }
            }
        }
    }
}
