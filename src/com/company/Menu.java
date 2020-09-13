package com.company;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {

    private Game game;
    private Handler handler;
    private Random r = new Random();

    public Menu(Game game, Handler handler) {
        this.game = game;
        this.handler = handler;
    }

    public void mousePressed(MouseEvent e){
        int mX = e.getX();
        int mY = e.getY();

        //play btn
        if(mouseOver(mX, mY,210,150,200,64 )){
            System.out.println("mouse pressed in play button");
            System.out.println("window width is " + Window.WIDTH + " window height is " + Window.HEIGHT);
            game.gameState = Game.STATE.Game;
            handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH -32), r.nextInt(Game.HEIGHT -64), ID.BasicEnemy, handler));

        }

        //quit button
        if(mouseOver(mX, mY,210,350,200,64 )){
            System.exit(1);
        }

        //help button
        if(mouseOver(mX, mY,210, 250, 200, 64 )){
            game.gameState = Game.STATE.Help;
        }
    }

    public void mouseReleased(MouseEvent e){

    }

    private boolean mouseOver(int mX, int mY, int x, int y, int width, int height){
        if((mX > x) && (mX < (x + width))){
            if((mY > y) && (mY < (y + height))){
                return true;
            } else {
                return false;
            }
        }else{
            return false;
        }
    }

    public void tick(){

    }

    public void render(Graphics g){
        if(game.gameState == Game.STATE.Menu) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Menu", 230, 70);


            g.setFont(fnt2);
            g.drawRect(210, 150, 200, 64);
            g.drawString("Play", 270, 190);

            g.setFont(fnt2);
            g.drawRect(210, 250, 200, 64);
            g.drawString("Help", 270, 290);

            g.setFont(fnt2);
            g.drawRect(210, 350, 200, 64);
            g.drawString("Quit", 270, 390);
        }else if(game.gameState == Game.STATE.Help){
            Font fnt = new Font("arial", 1, 50);


            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Help", 270, 290);
        }

    }
}
