package javaproject.entities.object;

import javaproject.assets.Asset;
import javaproject.entities.Entity;
import javaproject.entities.creatures.Player;
import javaproject.main.Game;

import java.awt.*;


public class Bullet extends Entity {
    private Game game;
    private Player player;
    private double diffrX,diffrY,angle;
    private int mouseClickedX , mouseClickedY;
    private float speed;
    private float damage;
    private float xMove , yMove;

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }


    public Bullet(Game game, Player player, float x, float y,int ClickedX , int ClickedY) {
        super(x, y, 16, 16);
        this.game = game;
        this.player = player;
        //angle = bulletFire();
        mouseClickedX = ClickedX;
        mouseClickedY = ClickedY;
        setDamage(10f);
        setSpeed(3f);
    }

    @Override
    public void tick() {
        bulletFire();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Asset.bullet,(int)x,(int)y,null);
    }


    private void bulletFire(){
        //find distance between player and mouseclicked position
        diffrX = mouseClickedX - player.getX();
        diffrY = mouseClickedY - player.getY();

        //angle between player and mouseclicked position
        angle = Math.atan2(diffrY,diffrX);
        System.out.println("Angle " + Math.toDegrees(angle));
        //return (angle);
        x += (speed*(float)Math.cos(angle));
        y += (speed*(float)Math.sin(angle));



    }

    public void fire(double angle){

        x += (speed*(float)Math.cos(angle));
        y += (speed*(float)Math.sin(angle));
    }



}