package com.jamesrupa.pokemon.States;

import com.jamesrupa.pokemon.Launcher.Handler;

import java.awt.*;

public abstract class State {

    private static State currentState = null;
    protected Handler handler;

    public State(Handler handler) {
        this.handler = handler;
    }

    public static void setState(State state) {
        currentState = state;
    }

    public static State getState() {
        return currentState;
    }

    // METHODS
    public abstract void tick();
    public abstract void render(Graphics g);
}
