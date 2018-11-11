package javaproject.entities.creatures;

import javaproject.main.Game;

import java.awt.*;

public class Player extends Creature {
    private Game game;

    public Player(Game game,float x, float y) {
        super(x, y);
        health = 100;
        this.game = game;
        movementSpeed = 1;
    }

    @Override
    public void tick() {
        if(game.getKeyManager().up){
             y -= (3*movementSpeed);
        }

        if(game.getKeyManager().down){
            y += (3*movementSpeed);
        }

        if(game.getKeyManager().left){
            x -= (3*movementSpeed);
        }

        if(game.getKeyManager().right){
            x += (3*movementSpeed);
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect((int)x,(int)y,100,100);
    }
}
