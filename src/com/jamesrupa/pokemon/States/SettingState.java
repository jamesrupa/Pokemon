package com.jamesrupa.pokemon.States;

import com.jamesrupa.pokemon.Launcher.Handler;

import java.awt.*;

public class SettingState extends State{

    public SettingState (Handler handler) {
        super(handler);

    }

    public void tick() {
        if (handler.getClock() >= 1) {
            if (handler.getKeyManager().menuPressed()) {
                State.setState(handler.getGame().gameState);
            }
        }
    }

    public void render (Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0,0,handler.getWidth(),handler.getHeight());
    }
}
