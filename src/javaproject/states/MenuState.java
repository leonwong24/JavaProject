package javaproject.states;



import javaproject.main.Game;

import java.awt.*;

public class MenuState extends State {
    Game game;
    //draw a start button rectangular border
    public Rectangle playButton;
    public MenuState(Game game) {
        super(game);
        playButton = new Rectangle(650,500,200,100);
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
        g.drawString("Shooting GAME!!!!",500,200);

        Graphics2D g2d = (Graphics2D)g;
        g2d.draw(playButton);

        g.drawString("Play",playButton.x+35,playButton.y+65);

    }

}
