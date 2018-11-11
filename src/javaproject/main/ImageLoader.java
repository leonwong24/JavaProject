package javaproject.main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {

    public static BufferedImage loadImage(String path){
        //path will be the location of the image
        try {
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException e) {
            //if image is not loaded into the game , the game will exit
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

}
