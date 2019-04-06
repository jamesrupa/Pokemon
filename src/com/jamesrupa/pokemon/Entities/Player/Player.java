package com.jamesrupa.pokemon.Entities.Player;

import com.jamesrupa.pokemon.Entities.Entity;
import com.jamesrupa.pokemon.Launcher.Handler;

public abstract class Player extends Entity {
    public Player(Handler handler,float x,float y) {
        super(handler,x,y);
    }
}