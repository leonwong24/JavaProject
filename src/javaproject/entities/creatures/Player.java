package javaproject.entities.creatures;

import javaproject.assets.Asset;
import javaproject.main.Game;
import javaproject.states.GameState;
import javaproject.states.State;

import java.awt.*;

public class Player extends Creature{
    private Game game;

    public Player(Game game,float x, float y) {
        super(x,y,64,64);
        this.game = game;
        this.setHealth(100);
        this.setMovementSpeed(2f);

    }

    @Override
    public void tick() {
       checkAlive();
        if(alive){
           getInput();
           move();
       }

    }

    @Override
    public void render(Graphics g) {
        if(alive){
            g.drawImage(Asset.player,(int)x,(int)y,width,height,null);
        }
    }

    private void getInput(){
        xMove = 0;
        yMove = 0;

        if(game.getKeyManager().up){
            //prevent player walks out of screen
            if(y >= 0f){
                yMove += -movementSpeed;
            }
        }

        if(game.getKeyManager().down){
            if( y <= (900f-this.getHeight())){
                yMove += movementSpeed;
            }
        }

        if(game.getKeyManager().left){
            if(x >= 0f ){
                xMove -= movementSpeed;
            }
        }

        if(game.getKeyManager().right){
            if(x <= 1600f-this.getWidth()){
                xMove += movementSpeed;
            }
        }
    }

    @Override
    public void damage(float damage,long attackRate,long lastAttack){
        if(System.nanoTime() - lastAttack >= attackRate) {
            setHealth((health) - damage);
            setLastAttack(System.nanoTime());
        }
    }

}
