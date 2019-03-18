package com.gamehackers.oakville.Launcher;

import com.gamehackers.oakville.Launcher.Game;

public class Oakville {
    public static void main(String[] args) {
        // MAIN CLASS
        // FIND DIMENSIONS TO DISPLAY
        Game game = new Game("GAME", 1400, 746);
        game.start();
    }
}
