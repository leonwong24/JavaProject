package javaproject.entities.creatures;

import javaproject.assets.Asset;
import javaproject.entities.object.Bullet;
import javaproject.main.Game;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Walker extends Creature{

    public Player target;
    private double angle;
    private double diffrX,diffrY;

    public Walker(Game game, float x, float y,Player player) {
        super(x, y, 64, 64);
        this.setHealth(50);
        this.setMovementSpeed(1f);
        target = player;
        this.setDamage(10f);
        this.setAttackRate(2000000000L); //2sec
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
    public void render(Graphics g) {
        if(alive){
            g.drawImage(Asset.walker,(int)x,(int)y,width,height,null);
        }

    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    private void chaseTarget(){
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
        //A walker has slightly slowed the movement speed after being hit by bullet
        setMovementSpeed(0.75f);
        setHealth(health - Bullet.getDamage());


        //set back the movement speed after 1 sec delay
        Timer t = new Timer();
        TimerTask restoreSpeed = new TimerTask(){
            int count = 0;
            @Override
            public void run() {
                setMovementSpeed(1f);
                count++;
                if(count > 1)
                    t.cancel();
                t.purge();
            }
        };
        t.schedule(restoreSpeed,1000);
    }
}
