package com.jamesrupa.pokemon.Entities;

import com.jamesrupa.pokemon.Launcher.Handler;

import java.awt.*;

public abstract class Entity {

    protected Handler handler;
    protected float x, y;

    public Entity(Handler handler,float x,float y) {
        this.handler = handler;
        this.x = x;
        this.y = y;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
}
