package javaproject.states;

import javaproject.assets.Asset;
import javaproject.entities.creatures.*;
import javaproject.entities.object.Bullet;
import javaproject.inputs.BulletController;
import javaproject.main.Game;
import java.awt.*;
import java.util.ArrayList;

public class GameState extends State {

    public Player player;
    private BulletController bc;



    public int enemyCount = 5;
    //spawn point



    //create an array list that stores enemies,bullet
    private ArrayList<Creature> enemies = new ArrayList<Creature>();
    private ArrayList<Bullet> bullets = new ArrayList<>();


    public GameState(Game game){
        super(game);
        player = new Player(game,800,450);
        bc = new BulletController(game,player);

        //bullet
        /*if(game.getKeyManager().up){
            System.out.println("up key  pressed");
            bullets.add(new Bullet(game,player,(int)player.getX(),(int)player.getY(),game.getMouseManager().mouseClickedX,game.getMouseManager().mouseClickedY));
        }*/

        //enemies
        for(int i = 0 ; i < enemyCount ; i++){
            //pick random enemy, 3 is the maximum number and 1 is the minimum
            int enemyPicker = (int)(Math.random() * 3) + 1;

            //a holder for spawnSpotx
            int spawnX = spawnSpotX();
            if(enemyPicker == 1){
                //spawn walker
                enemies.add(new Walker(game,spawnX,spawnSpotY(spawnX),player));
            }

            else if(enemyPicker == 2){
                //spawn crawler
                enemies.add(new Crawler(game,spawnX,spawnSpotY(spawnX),player));
            }

            else{
                //spawn tanker
                enemies.add(new Tank(game,spawnX,spawnSpotY(spawnX),player));
            }
        }
    }


    @Override
    public void tick() {
        player.tick();

        for(int i = 0 ; i < enemies.size() ; i++){
            enemies.get(i).tick();
        }

        bc.tick();
    }

    @Override
    public void render(Graphics g) {
        g.fillOval(750, 350, 125, 125); //center block
        g.drawImage(Asset.floor,0,0,1600,900,null);//floor*/
        g.drawImage(Asset.wall,0,0,300,100,null); //top left block
        g.drawImage(Asset.wall,0,800,300,100,null); //bot left block
        g.drawImage(Asset.wall,1300,0,300,100,null); //top right block
        g.drawImage(Asset.wall,1300,800,300,100,null); //bot right block*/
        g.setColor(Color.BLACK);
        g.fillRect(750, 350, 125, 125); //center block
        g.drawString("Player health:" +player.getHeight(),1300,50);
        player.render(g);

        for(int i = 0 ; i < enemies.size() ; i++){
            enemies.get(i).render(g);
        }

        bc.render(g);
    }

    private int spawnSpotX(){
        //this return 1 - 3 randomize number
        int x = (int)(Math.random()*3)+1;
        int result = 0;

        if(x == 1){
            //return spawning spot
            result = 800;
        }

        else if(x == 2){
           result = 0;
        }

        else{
            result = 1600;
        }
        return result;

    }

    private int spawnSpotY(int spawnSpotX) {

        int result = 0;
        if (spawnSpotX == 800){
            //this return only two randomize number
            int y = (int)(Math.random()*2) +1;
            if( y == 1){
                result = 0;
            }
            else if (y == 2)
                result = 900;
        }
        else
            result = 450;

        return result;
    }
}
