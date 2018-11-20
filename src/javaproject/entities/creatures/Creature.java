package javaproject.entities.creatures;

import javaproject.entities.Entity;

import java.awt.*;

public abstract class Creature extends Entity {



    protected float health,movementSpeed,xMove,yMove;

    public Creature(float x, float y,int width, int height) {
        super(x, y,width,height);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public float getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(float movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public void move(){
        x += xMove;
        y += yMove;
    }

    public void damage(Player player){
        //if enemies intersect with player
    }
}
