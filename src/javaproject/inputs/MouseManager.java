package javaproject.inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseManager implements MouseListener {
    public int clicked;
    public int leftClick = MouseEvent.BUTTON1;
    public int x, y;

    public MouseManager(){

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == leftClick){
            //get frame position
            clicked = leftClick;
            x = e.getX();
            y = e.getY();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        clicked = 0;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void tick(){

    }
}
