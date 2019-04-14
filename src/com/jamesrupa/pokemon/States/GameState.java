package com.jamesrupa.pokemon.States;

import com.jamesrupa.pokemon.Entities.Player.Trainer;
import com.jamesrupa.pokemon.GFX.Assets;
import com.jamesrupa.pokemon.GFX.SpriteSheet;
import com.jamesrupa.pokemon.Launcher.Game;
import com.jamesrupa.pokemon.Launcher.Handler;
import com.jamesrupa.pokemon.World.Settings;
import com.jamesrupa.pokemon.World.Terrain;
import com.jamesrupa.pokemon.World.TileMap;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameState extends State {

    private Trainer trainer;
    TileMap map = new TileMap(10,10);

    public GameState(Handler handler) {
        super(handler);
        trainer = new Trainer(handler,map,0,0);

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
        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {

                g.drawImage(Assets.grass1, x, y, map.getWidth() * (int)Settings.TILE_SIZE, map.getHeight() * (int)Settings.TILE_SIZE,null);
            }
        }
        trainer.render(g);
    }
}
