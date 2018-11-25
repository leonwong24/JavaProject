package javaproject.entities.creatures;

import javaproject.entities.Entity;
import javaproject.entities.object.Bullet;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/** An abstract class that contains the method and variable for all the creature in the game */

public abstract class Creature extends Entity{



    protected float health;
    protected float movementSpeed;
    protected float xMove;  //how many pixel x move
    protected float yMove;  //how many pixel y move
    protected float damage; //amount of reduce health when attack
    protected long attackRate;  // cooldown timer after attack player
    protected int killScore;    //amount of point rewarded after being killed by player

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


    /**
     *
     * @param x creature x position
     * @param y creature y position
     * @param width creature width size
     * @param height creature height size
     */
    public Creature(float x, float y,int width, int height) {
        super(x, y,width,height);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }

    /**
     * This method will return the creature current health
     * @return creature health
     */
    public float getHealth() {
        return health;
    }

    /**
     * This set the creature health to the given parameter value
     * @param health health to be set for the creature
     */
    public void setHealth(float health) {
        this.health = health;
    }

    /**
     * This return the creature current movement speed
     * @return creature movementspeed
     */
    public float getMovementSpeed() {
        return movementSpeed;
    }

    /**
     * This set the creature movement speed to the given parameter value
     * @param movementSpeed movement speed to be set to the creature
     */
    public void setMovementSpeed(float movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    /**
     * This will move the creature to the given xMove
     */
    public void move(){
        x += xMove;
        y += yMove;
    }

    /**
     *
     * @param damage value of health to be reduced to the target creature
     * @param attackRate value of time to be waited before the next attack to the creature
     */
    public void damage(float damage,long attackRate){
        //if enemies intersect with player
    }

    /**
     * action after getting hit by the bullet
     */
    public void hitByBullet(){
        //if enemy hit by bullet
    }

    /**
     * check if the creature is alive , if not set the boolean alive to false
     */
    public void checkAlive(){
        //health lower than 0
        if(health <= 0)
            alive = false;
    }

    /**
     * This return the alive status of the creature
     * @return alive status of the creature
     */
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
