package javaproject.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;


public class KeyManager implements KeyListener{
    //variable
    private boolean[] keys;
    public boolean up,down,left,right,shop;

    public KeyManager(){
        keys = new boolean[256]; //assuming we only use 265 keycode in keyevent
    }

    public void tick(){
        //keyinput
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        shop = keys[KeyEvent.VK_P];
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}
