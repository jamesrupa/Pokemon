package com.jamesrupa.pokemon.Entities.Player;

import com.jamesrupa.pokemon.GFX.Assets;
import com.jamesrupa.pokemon.Launcher.Handler;

import java.awt.*;

public class Trainer extends Player {

    public static final float PLAYER_SPEED = 3.5f;

    public Trainer(Handler handler,float x,float y) {
        super(handler,x,y);
        speed = PLAYER_SPEED;

    }

    public void tick() {

        if (handler.getKeyManager().up) {
            y -= speed;
        }
        if (handler.getKeyManager().down) {
            y += speed;
        }
        if (handler.getKeyManager().left) {
            x -= speed;
        }
        if (handler.getKeyManager().right) {
            x += speed;
        }

    }

    public void render(Graphics g) {
        g.drawImage(Assets.playerStill, (int) x, (int) y,null);
    }
}
