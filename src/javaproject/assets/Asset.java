package javaproject.assets;

import javaproject.main.ImageLoader;

import java.awt.image.BufferedImage;

public class Asset {
    public static BufferedImage player,wall,floor,bullet;

    public static void init(){
       SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spitesheet.png"));

       player = sheet.crop(0,0,32,32);
       wall = sheet.crop(0,32,32,32);
       floor = sheet.crop(32,32,32,32);
       bullet = sheet.crop(32,0,32,32);
    }
}