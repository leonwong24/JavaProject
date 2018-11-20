package javaproject.inputs;

import javaproject.entities.creatures.Player;
import javaproject.entities.object.Bullet;
import javaproject.main.Game;

import java.awt.*;
import java.util.LinkedList;

public class BulletController {

    private LinkedList<Bullet> bullets = new LinkedList<Bullet>();
    private Game game;
    private Player player;

    private float playerX,playerY;


    public BulletController(Game game, Player player){
        this.game = game;
        this.player = player;
    }
    public void tick(){
        if(game.getMouseManager().leftPressed){
            playerX = player.getX();
            playerY = player.getY();
            System.out.print("Player x :"+ playerX + "Player Y :" +playerY);
            bullets.add(new Bullet(game, player,playerX, playerY, game.getMouseManager().mouseClickedX, game.getMouseManager().mouseClickedY));


        }

        for(int i = 0 ; i < bullets.size() ; i++){

            //remove bullet or keep them

            //keep the bullet and tick
            if(bullets.get(i).getX() >= 0 && bullets.get(i).getX() <=1600 && bullets.get(i).getY()>=0 && bullets.get(i).getY() <= 900){
                bullets.get(i).tick();
            }
            else{
                bullets.remove(i);
            }
        }
    }

    public void render(Graphics g){
        for(int i = 0 ; i < bullets.size() ; i++){
            bullets.get(i).render(g);
        }
    }
}
