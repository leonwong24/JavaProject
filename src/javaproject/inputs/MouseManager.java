package javaproject.inputs;

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
