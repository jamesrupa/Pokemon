package com.jamesrupa.pokemon.World;

import com.jamesrupa.pokemon.Entities.Player.Trainer;

public class Tile {

    private Terrain terrain;
    private Trainer trainer;

    public Tile(Terrain terrain) {
        this.terrain = terrain;
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
