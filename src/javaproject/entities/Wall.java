package javaproject.entities;

import javaproject.assets.Asset;
import javaproject.entities.Entity;

import java.awt.*;

public class Wall extends Entity {
    public Wall(float x, float y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Asset.wall,(int)x,(int)y,width,height,null);
    }
}
