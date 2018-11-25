package javaproject.entities.creatures;

import javaproject.assets.Asset;
import javaproject.entities.object.Bullet;
import javaproject.main.Game;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
/**Slow, strong type of enemy with slow movement speed , slow attack rate but strong attack . This enemy will not be slow after getting hit */
public class Tank extends Creature{

    public Player target;
    private double angle;
    private double diffrX,diffrY;

    public Tank(Game game, float x, float y,Player player) {
        super(x, y, 96, 96);
        this.setHealth(100);
        this.setMovementSpeed(0.5f);
        target = player;
        this.setDamage(20f);
        this.setAttackRate(3000000000L); //3sec
        this.setKillScore(30);//get 10 point after killing it
    }

    @Override
    public void tick() {
        checkAlive();
        if(alive){
            chaseTarget();
            move();
        }

    }

    @Override
    public void render(Graphics g)
    {
        if(alive){
            g.drawImage(Asset.tank,(int)x,(int)y,width,height,null);
        }
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public void chaseTarget(){
        xMove = 0;
        yMove = 0;
        //this is the algorithm of chasing the players

        //first we have to find the distance between the players and the enemies
        diffrX = this.x-target.getX();
        diffrY = this.y-target.getY();

        //calculate the angle between the player and enemies
        angle = Math.atan2(diffrY,diffrX);

        //chase the player using the cos and sin
        //have to put - on Y because Y behave differently (increase while going down)
        yMove += -(movementSpeed*(float)Math.sin(angle));
        xMove += -(movementSpeed*(float)Math.cos(angle));
    }

    @Override
    public void hitByBullet() {
        //A tanker has no side-effect after hit by bullet
        setHealth(health - Bullet.getDamage());
    }
}
