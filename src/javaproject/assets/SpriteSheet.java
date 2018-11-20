package javaproject.assets;


import java.awt.image.BufferedImage;

/**This is a class that will take an image as a sprite sheet and has a method to allow us to crop the image*/
public class SpriteSheet {
    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet){
        this.sheet = sheet;
    }

    public BufferedImage crop(int x,int y,int width,int height){ //crop the image from the sprite sheet
        return sheet.getSubimage(x,y,width,height);
    }
}
