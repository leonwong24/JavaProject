package javaproject.states;
import java.awt.*;

import javaproject.entities.creatures.Player;
import javaproject.main.Game;
import javaproject.main.TickAndRender;

public abstract class State implements TickAndRender {

    //Variable
    protected Game game;

    //Constructor
    public State(Game game){
        this.game = game;
    }

    //methods
    public abstract void tick();

    public abstract void render(Graphics g);

    //variable
    private static State currentState = null;

    public static void setState(State state){
        currentState = state;
    }

    public static State getCurrentState() {
        return currentState;
    }

}
