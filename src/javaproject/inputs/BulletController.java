package javaproject.inputs;

import javaproject.entities.creatures.Player;
import javaproject.entities.object.Bullet;
import javaproject.main.Game;
import javaproject.main.TickAndRender;

import java.awt.*;
import java.util.LinkedList;

public class BulletController implements TickAndRender {



    public LinkedList<Bullet> bullets = new LinkedList<Bullet>();
    private Game game;
    private Player player;
    private long fireRate = 200000000L; //0.2 sec
    public long lastShot;

    private float playerX,playerY;


    public BulletController(Game game, Player player){
        this.game = game;
        this.player = player;
    }
    public void tick(){
        //add bullet
        if(game.getMouseManager().leftPressed){
            playerX = player.getX();
            playerY = player.getY();
            if(System.nanoTime() - lastShot >= fireRate) {
                bullets.add(new Bullet(game, player, playerX, playerY, game.getMouseManager().mouseClickedX, game.getMouseManager().mouseClickedY));
                lastShot = System.nanoTime();
            }
        }

        //tick bullet
        for(int i = 0 ; i < bullets.size() ; i++){

            //remove bullet or keep them

            //keep the bullet and tick
            if(bullets.get(i).getX() >= -50 && bullets.get(i).getX() <=1650 && bullets.get(i).getY()>=-50 && bullets.get(i).getY() <= 950){
                bullets.get(i).tick();
            }

            else{
                //bullet out of screen
                bullets.remove(i);
            }
        }
    }

    public void render(Graphics g){
        for(int i = 0 ; i < bullets.size() ; i++){
            bullets.get(i).render(g);
        }
    }

    public LinkedList<Bullet> getBullets() {
        return bullets;
    }

}
