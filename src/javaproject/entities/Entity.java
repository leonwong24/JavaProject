package javaproject.entities;

import javaproject.main.TickAndRender;

import java.awt.*;

/**All object that will be shown in the game panel are the subclass of this class.*/
public abstract class Entity implements TickAndRender {

    protected float x, y; //position of entity
    protected int width,height; //size of the entity


    public Entity(float x, float y, int width, int height){
        this.x=x;
        this.y=y;
        this.width = width;
        this.height = height;
    }
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public abstract void tick();

    public abstract void render(Graphics g);
}
