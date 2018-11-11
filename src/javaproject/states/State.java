package javaproject.states;
import java.awt.*;
import javaproject.main.Game;

public abstract class State {

    //Variable
    protected Game game;

    //Constructor
    public State(Game game){
        this.game = game;
    }

    //methods
    public abstract void tick();

    public abstract void render(Graphics g);

    private static State currentState = null;

    public static void setState(State state){
        currentState = state;
    }

    public static State getCurrentState() {
        return currentState;
    }
}
