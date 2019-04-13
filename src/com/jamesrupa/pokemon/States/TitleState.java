package com.jamesrupa.pokemon.States;

import com.jamesrupa.pokemon.Input.Audio;
import com.jamesrupa.pokemon.Launcher.Game;
import com.jamesrupa.pokemon.Launcher.Handler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TitleState extends State {

    public TitleState(Handler handler) {
        super(handler);
    }


    public void tick() {
        if (handler.getClock() >= 1) {
            if (handler.getKeyManager().enterPressed()) {
                State.setState(handler.getGame().gameState);
                Audio.titlescreen.stop();
                Audio.pallettown.loop();
                Game.clock = 0;
            }
        }
    }

    public void render(Graphics g) {

        BufferedImage titlescreen = null;
        try {
            titlescreen = ImageIO.read(new File("res/textures/screens/titlescreen.png"));
        } catch (IOException e) {
            System.out.println("TitleScreen Is Broken...");
        }
        g.drawImage(titlescreen,0,0,null);

    }
}
