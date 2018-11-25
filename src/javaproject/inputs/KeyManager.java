package javaproject.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class implements the interface KeyListener for receiving keyboard events (keystroke). It stores key as boolean and will be turned to true if is called by a responding key event.
 */
public class KeyManager implements KeyListener{
    //variable
    private boolean[] keys;
    public boolean up,down,left,right,shop;

    public KeyManager(){
        keys = new boolean[256]; //assuming we only use 265 keycode in keyevent
    }

    /**
     * set the boolean key to the boolean array index
     */
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

    /**
     * Invoke when a key is pressed , it gets the keycode of the keyevent ,set the corresponding boolean array index to true
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    /**
     * Invoke when a key is released , it gets the keycode of the keyevent ,set the corresponding boolean array index to false
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}
