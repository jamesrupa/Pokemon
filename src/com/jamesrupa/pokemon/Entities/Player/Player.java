package com.jamesrupa.pokemon.Entities.Player;

import com.jamesrupa.pokemon.Entities.Entity;
import com.jamesrupa.pokemon.Launcher.Handler;

public abstract class Player extends Entity {

    public static final float DEFAULT_SPEED = 3.5f;
    public static final int DEFAULT_PLAYER_WIDTH = 64;
    public static final int DEFAULT_PLAYER_HEIGHT = 64;
    protected float speed;
    protected float xMove, yMove;

    public Player(Handler handler,float x,float y,int width,int height) {
        super(handler,x,y,width,height);
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

}