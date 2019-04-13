package com.jamesrupa.pokemon.Entities.Player;

import com.jamesrupa.pokemon.Entities.Entity;
import com.jamesrupa.pokemon.Launcher.Handler;

public abstract class Player extends Entity {

    public static final float DEFAULT_SPEED = 3.5f;
    public static final int DEFAULT_PLAYER_WIDTH = 52;
    public static final int DEFAULT_PLAYER_HEIGHT = 52;
    protected float speed;
    protected float xMove, yMove;

    public Player(Handler handler,float x,float y,int width,int height) {
        super(handler,x,y,width,height);

        xMove = 0;
        yMove = 0;
    }

    public void moveX() {
        x += xMove;
    }

    public void moveY() {
        y += yMove;
    }

}