package javaproject.entities.creatures;

import javaproject.assets.Asset;
import javaproject.main.Game;

import java.awt.*;

public class Player extends Creature {
    private Game game;

    public Player(Game game,float x, float y) {
        super(x, y);
        health = 100;
        this.game = game;
        movementSpeed = 1f;
    }

    @Override
    public void tick() {
        if(game.getKeyManager() == null){
            System.out.println("the keymanager is null");
        }
        else{
            System.out.println("received the keymanager");
        }

        if(game.getKeyManager().up){
            this.y -= (3*movementSpeed);
            System.out.println("Up key pressed!");
        }

        if(game.getKeyManager().down){
            this.y += (3*movementSpeed);
        }

        if(game.getKeyManager().left){
            this.x -= (3*movementSpeed);
        }

        if(game.getKeyManager().right){
            this.x += (3*movementSpeed);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Asset.player,(int)x,(int)y,null);

    }
}
