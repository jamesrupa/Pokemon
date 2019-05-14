package com.jamesrupa.pokemon.World;

import com.jamesrupa.pokemon.Entities.Player.Trainer;

import java.awt.*;

public class Tile {

    private Terrain terrain;
    private Trainer trainer;

    public Tile(Terrain terrain) {
        this.terrain = terrain;
    }

    public void render(Graphics g) {

    }

    public Terrain getTerrain() {
        return terrain;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
