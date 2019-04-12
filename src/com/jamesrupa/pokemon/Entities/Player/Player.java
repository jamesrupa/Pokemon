package com.jamesrupa.pokemon.Entities.Player;

import com.jamesrupa.pokemon.Entities.Entity;
import com.jamesrupa.pokemon.Launcher.Handler;

public abstract class Player extends Entity {

    public static final float DEFAULT_SPEED = 3.5f;
    public static final int DEFAULT_CREATURE_WIDTH = 52;
    public static final int DEFAULT_CREATURE_HEIGHT = 72;
    protected float speed;

    public Player(Handler handler,float x,float y) {
        super(handler,x,y);
    }
}