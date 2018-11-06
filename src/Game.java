import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{

    //using display class
    private Display display;

    //variable
    public int width,height;
    public String title;
    private BufferStrategy bs;
    private Graphics g;

    //creating a thread
    private Thread thread;
    //boolean for checking if the game is running
    private boolean running = false;

    //Constructor
    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
    }

    //initiate everything include graphics before the game loop start
    private void init(){
        display = new Display(title, width, height);
    }

    //update everything in render
    private void update(){

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
        //Start drawing graphics

        g.setColor(Color.blue);
        g.fillRect(10,50,200,100);
        g.setColor(Color.GREEN);
        g.fillRect(-30,70,200,300);

        //end drawing!
        bs.show();
        g.dispose();
    }
    //run the program
    public void run(){
        init();

        while(running){
            update();
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
}
