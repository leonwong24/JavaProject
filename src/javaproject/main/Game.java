package javaproject.main;

import javaproject.assets.Asset;
import javaproject.inputs.KeyManager;
import javaproject.inputs.MouseManager;
import javaproject.states.GameState;
import javaproject.states.MenuState;
import javaproject.states.ShopState;
import javaproject.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{

    //using display class
    private Display display;

    //variable
    public int width,height;
    public String title;

    //graphics render
    private BufferStrategy bs;
    private Graphics g;

    //creating a thread
    private Thread thread;
    //boolean for checking if the game is running
    private boolean running = false;

    //State
    private static State gameState;
    public static State menuState;
    private static State shopState;

    //Input
    private KeyManager keyManager;
    private MouseManager mouseManager;

    //Constructor
    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;

        //input manager
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }


    //initiate everything include graphics before the game loop start
    private void init(){
        display = new Display(title, width, height);

        //applying keylistener and mouselistener to the game frame
        display.getFrame().addKeyListener(keyManager);
        display.getCanvas().addMouseListener(mouseManager);

        //Setting the state
        gameState = new GameState(this);
        menuState = new MenuState(this);
        shopState = new ShopState(this);
        State.setState(menuState);

        //loading assets
        Asset.init();

    }

    //update everything in render
    private void tick(){
        keyManager.tick();
        mouseManager.tick();

        if(State.getCurrentState() != null){
            State.getCurrentState().tick();
        }
    }

    //render game
    private void render(){
        //get bufferstrategy from the canvas,bufferstrategy tells the comp how to draw thing
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear the screen before drawing
        g.clearRect(0,0,width,height);

        if(State.getCurrentState() != null){
            State.getCurrentState().render(g);
        }

        //Start drawing graphics

        //draw background
        /*g.drawImage(bg,0,0,1600,900,null);

        //spawn block
        g.setColor(Color.BLACK);
        g.fillOval(750, 350, 125, 125); //center block
        g.drawImage(wall,0,0,300,100,null); //top left block
        g.drawImage(wall,0,800,300,100,null); //bot left block
        g.drawImage(wall,1300,0,300,100,null); //top right block
        g.drawImage(wall,1300,800,300,100,null); //bot right block*/

        //end drawing!
        bs.show();
        g.dispose();
    }
    //run the program
    public void run(){
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps; //This return the time that the system should refresh in order to achieve 60fps
        double delta = 0;
        long now;
        long lastTime = System.nanoTime(); //This return the system time in nanosecond
        while(running){
            //fps
            now = System.nanoTime();
            delta += (now-lastTime) / timePerTick; //This return a percentage of time remaining till next refresh
            lastTime = now;

            if(delta >= 1){
                tick();
                render();
                delta --;
            }

            tick();
            render();

        }
    }

    public synchronized void start(){
        if(running)
            return; //if game is running , don't do anything below

        running = true;
        thread = new Thread(this); //this = game class
        thread.start(); //start run() method
    }

    public synchronized void stop(){
        if(!running)
            return; //if game already stop running , don't do anything down below

        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public KeyManager getKeyManager(){
        return keyManager;
    }

    public MouseManager getMouseManager(){
        return mouseManager;
    }

    public static GameState getGameState(){
        return (GameState) gameState;
    }
}
