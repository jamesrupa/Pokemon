package com.jamesrupa.pokemon.States;

import com.jamesrupa.pokemon.Entities.Player.Trainer;
import com.jamesrupa.pokemon.Launcher.Game;
import com.jamesrupa.pokemon.Launcher.Handler;
import com.jamesrupa.pokemon.Worlds.World;

import java.awt.*;

public class GameState extends State {

    private Trainer trainer;

    public GameState(Handler handler) {
        super(handler);
        trainer = new Trainer(handler,500,500);

    }

    public void tick() {
        trainer.tick();
        if (handler.getClock() >= 2) {
            if (handler.getKeyManager().menuPressed()) {
                State.setState(handler.getGame().settingState);
                Game.clock = 0;
            }
        }
    }

    public void render(Graphics g) {
        World.render(g);
        trainer.render(g);
    }
}
