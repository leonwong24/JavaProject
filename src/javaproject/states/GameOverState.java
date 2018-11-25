package javaproject.states;

import javaproject.main.Game;

import java.awt.*;
import java.io.*;

/**
 * A state class that only will be run after the player is dead , it shows the game over message and the high score to the player
 */
public class GameOverState extends State implements Serializable {

    /**
     * The high score input from the highScore data file
     */
    public static int highScore;
    //set up import file and stream
    File inFile = new File("C:/Users/leonw/OneDrive/Desktop/JavaProject/src/javaproject/highScore.data");
    FileInputStream inputStream;
    {
        try {
            inputStream = new FileInputStream(inFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    //set up input stream
    /*int fileSize = (int)inFile.length();
    byte[] byteArray = new byte[fileSize];
    FileInputStream inputStream;
    {
        try {
            inputStream = new FileInputStream(inFile);


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }*/


    //Object input stream
    ObjectInputStream inObjectStream;
    {
        try {
            inObjectStream = new ObjectInputStream(inputStream);
            try {
                highScore = (int)inObjectStream.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            inObjectStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //input done, close the stream*/


    public GameOverState(Game game) {
        super(game);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,1600,900);
        Font font = new Font(Font.MONOSPACED,Font.PLAIN,50);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("Game Over!",800,200);

        //break high score
        if(GameState.getScore()>highScore){
            g.drawString("Congratulation, you broke the high score",300,400);
            g.drawString("Your high score is " + GameState.getScore(),300,500);
            try {
                save(GameState.getScore());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else{
            g.drawString("Your high score is " + GameState.getScore(),300,500);
        }

    }


    /**
     * If the player broke the high score , this method will be called to save the high score into the highScore data file
     * @param highScore
     * @throws IOException
     */
    public void save(int highScore) throws IOException {
        ObjectOutputStream outputStreams;
        outputStreams = new ObjectOutputStream(new FileOutputStream ("C:/Users/leonw/OneDrive/Desktop/JavaProject/src/javaproject/highScore.data"));

        outputStreams.writeObject(highScore);
        outputStreams.close();
    }
}
