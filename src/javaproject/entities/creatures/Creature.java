package javaproject.entities.creatures;

import javaproject.entities.Entity;

import java.awt.*;

public abstract class Creature extends Entity {
    protected static float health,movementSpeed;

    public Creature(float x, float y,int width, int height) {
        super(x, y,width,height);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }

}
