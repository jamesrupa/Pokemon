package com.jamesrupa.pokemon.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys;
    public boolean up, down, left, right, enter;

    public KeyManager() {
        keys = new boolean[256];
    }

    public boolean enterPressed() {
        return enter;
    }

    public void tick() {
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
    }

    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;

        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            enter = true;
        }

    }

    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;

        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            enter = false;
        }

    }

    public void keyTyped(KeyEvent e) {

    }
}