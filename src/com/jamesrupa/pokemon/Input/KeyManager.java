package com.jamesrupa.pokemon.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys;
    public boolean up, up1, down, down1, left, left1, right, right1, enter, menu;

    public KeyManager() {
        keys = new boolean[256];
    }

    public boolean enterPressed() {
        return enter;
    }

    public boolean menuPressed() {
        return menu;
    }

    public void tick() {
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        up1 = keys[KeyEvent.VK_UP];
        down1 = keys[KeyEvent.VK_DOWN];
        left1 = keys[KeyEvent.VK_LEFT];
        right1 = keys[KeyEvent.VK_RIGHT];
    }

    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            enter = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_M) {
            menu = true;
        }

    }

    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;

        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            enter = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_M) {
            menu = false;
        }

    }

    public void keyTyped(KeyEvent e) {

    }
}