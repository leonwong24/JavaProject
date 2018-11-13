package javaproject.assets;


import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet){
        this.sheet = sheet;
    }

    public BufferedImage crop(int x,int y,int width,int height){ //crop the image from the sprite sheet
        return sheet.getSubimage(x,y,width,height);
    }
}
