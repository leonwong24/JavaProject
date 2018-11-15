package javaproject.states;

import javaproject.assets.Asset;
import javaproject.entities.creatures.Player;
import javaproject.entities.creatures.Walker;
import javaproject.main.Game;

import java.awt.*;

public class GameState extends State {

    private Player player;
    private Walker walker;
    public GameState(Game game){
        super(game);
        player = new Player(game,500,500);
        walker = new Walker(game,300,300,player);
    }


    @Override
    public void tick() {
        player.tick();
        walker.tick();
    }

    @Override
    public void render(Graphics g) {
        player.render(g);
        walker.render(g);
    }
}
