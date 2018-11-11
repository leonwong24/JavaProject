package javaproject.main;

import javaproject.main.Game;

public class Launcher {

    public static void main(String[] args) {
        Game game = new Game("Shooting javaproject.main.Game",1600,900);
        game.start();
    }
}
