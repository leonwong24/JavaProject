package javaproject.inputs;

import javaproject.main.Game;
import javaproject.states.GameState;
import javaproject.states.State;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MouseManager implements MouseListener {
    //variable
    public boolean leftPressed;
    private boolean[] mouseClick;

    //mouse position
    public int mouseClickedX, mouseClickedY;

    public MouseManager(){
        mouseClick = new boolean[1]; //we only use left click
    }

    public void tick(){
        leftPressed = mouseClick[0];
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
       mouseClick[0] = true;
       mouseClickedX = e.getX();
       mouseClickedY = e.getY();

       //for starting the game in menu
        if(State.getCurrentState() == Game.menuState){
            if(e.getX()>=650 && e.getX() <=850 && e.getY()>=500 && e.getY() <= 600){
                //start button pressed
                State.setState(Game.getGameState());
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseClick[0] = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }




}
