package com.jamesrupa.pokemon.Launcher;

import com.jamesrupa.pokemon.Sound.Sound;

public class Pokemon {
    public static void main(String[] args) {
        // MAIN CLASS
        // FIND DIMENSIONS TO DISPLAY
        Game game = new Game("Pokémon", 1400, 746);
        game.start();
        Sound.startscreen.loop();
    }
}
