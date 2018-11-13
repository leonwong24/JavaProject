package javaproject.entities.creatures;

import javaproject.assets.Asset;
import javaproject.main.Game;

import java.awt.*;

public class Player extends Creature {
    private Game game;

    public Player(Game game,float x, float y) {
        super(x,y,32,32);
        this.game = game;
        health = 100;
        movementSpeed = 1f;

    }

    @Override
    public void tick() {

        if(game.getKeyManager().up){
            //prevent player walks out of screen
            if(y >= 0f){
                this.y -= (3*movementSpeed);
            }
        }

        if(game.getKeyManager().down){
            if( y <= (900f-32)){
                this.y += (3*movementSpeed);
                System.out.println(getPlayerYPostion());
            }
        }

        if(game.getKeyManager().left){
            if(x >= 0f ){
                this.x -= (3*movementSpeed);
            }
        }

        if(game.getKeyManager().right){
            if(x <= 1600f){
                this.x += (3*movementSpeed);
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Asset.player,(int)x,(int)y,width,height,null);

    }

    public float getPlayerXPostion(){
        return x;
    }

    public float getPlayerYPostion(){
        return y;
    }
}
