package com.company;

import java.util.Random;

public class Spawn {
    private Handler handler;
    private HUD hud;
    private int scorekeep = 0;
    private Random r = new Random();

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick(){
        scorekeep++;
        if(scorekeep >= 250){
            scorekeep = 0;
            hud.setLevel(hud.getLevel() +1);
            if(hud.getLevel() == 2) {
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 64), ID.BasicEnemy, handler));
            }else if(hud.getLevel() == 3){
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 64), ID.BasicEnemy, handler));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 64), ID.BasicEnemy, handler));
            }else if(hud.getLevel() == 4){
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 64), ID.FastEnemy, handler));
                handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 32), r.nextInt(Game.HEIGHT - 64), ID.FastEnemy, handler));

            }
        }

    }


}
