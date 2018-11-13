package javaproject.states;

import javaproject.assets.Asset;
import javaproject.entities.creatures.Player;
import javaproject.main.Game;

import java.awt.*;

public class GameState extends State {

    private Player player;
    public GameState(Game game){
        super(game);
        player = new Player(game,500,500);

    }


    @Override
    public void tick() {
        player.tick();
    }

    @Override
    public void render(Graphics g) {
        player.render(g);
    }
}
