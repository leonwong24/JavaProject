public class Game implements Runnable{

    //using display class
    private Display display;

    //variable
    public int width,height;
    public String title;

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

    }
    //run
    public void run(){
        init();

        while(running){
            update();
            render();
        }
    }

    public synchronized  void start(){
        if(running)
            return; //if game is running , don't do anything below
        running = true;
        thread = new Thread(this); //this = game class
        thread.start(); //start run() method
    }

    public synchronized  void stop(){
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
