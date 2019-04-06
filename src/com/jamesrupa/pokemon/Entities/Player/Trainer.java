package com.jamesrupa.pokemon.Entities.Player;

import com.jamesrupa.pokemon.GFX.Assets;
import com.jamesrupa.pokemon.Launcher.Handler;

import java.awt.*;

public class Trainer extends Player {


    public Trainer(Handler handler,float x,float y) {
        super(handler,x,y);
    }

    public void tick() {
        if (handler.getKeyManager().up) {
            y -= 3;
        }
        if (handler.getKeyManager().down) {
            y += 3;
        }
        if (handler.getKeyManager().left) {
            x -= 3;
        }
        if (handler.getKeyManager().right) {
            x += 3;
        }

    }

    public void render(Graphics g) {
        g.drawImage(Assets.playerStill, (int) x, (int) y,null);
    }
}
