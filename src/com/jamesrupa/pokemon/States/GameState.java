package com.jamesrupa.pokemon.States;

import com.jamesrupa.pokemon.Entities.Player.Trainer;
import com.jamesrupa.pokemon.GFX.Assets;
import com.jamesrupa.pokemon.Launcher.Handler;

import java.awt.*;

public class GameState extends State {

    private Trainer trainer;

    public GameState(Handler handler) {
        super(handler);
        trainer = new Trainer(handler,500,500);

    }

    public void tick() {
        trainer.tick();
    }

    public void render(Graphics g) {
        trainer.render(g);
    }
}
