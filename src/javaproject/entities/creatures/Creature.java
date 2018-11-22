package javaproject.entities.creatures;

import javaproject.entities.Entity;
import javaproject.entities.object.Bullet;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Creature extends Entity{



    protected float health;
    protected float movementSpeed;
    protected float xMove;
    protected float yMove;
    protected float damage;
    protected long attackRate;
    protected int killScore;

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

    public float getxMove() {
        return xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public float getDamage() {
        return damage;
    }

    protected boolean alive = true;


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

    public void damage(float damage,long attackRate){
        //if enemies intersect with player
    }

    public void hitByBullet(){
        //if enemy hit by bullet
    }

    public void checkAlive(){
        //health lower than 0
        if(health < 0)
            alive = false;
    }

    public boolean isAlive() {
        return alive;
    }


    public long getAttackRate() {
        return attackRate;
    }

    public void setAttackRate(long attackRate) {
        this.attackRate = attackRate;
    }


    public int getKillScore() {
        return killScore;
    }

    public void setKillScore(int killScore) {
        this.killScore = killScore;
    }

}
