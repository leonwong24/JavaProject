package javaproject.main;

/**
 * Main game launcher that launch the game
 */
public class Launcher {

    public static void main(String args[]) {
        Game game = new Game("Shooting game",1600,900);
        game.start();
    }
}
