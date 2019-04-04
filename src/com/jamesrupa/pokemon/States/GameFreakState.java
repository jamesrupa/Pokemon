package com.jamesrupa.pokemon.States;

import com.jamesrupa.pokemon.Input.Audio;
import com.jamesrupa.pokemon.Launcher.Handler;

import javax.imageio.ImageIO;
import javax.management.StandardEmitterMBean;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameFreakState extends State {

    public GameFreakState(Handler handler) {
        super(handler);
    }

    public void tick() {

        if (handler.getKeyManager().enterPressed() || (handler.getClock() == 300)) {
            State.setState(handler.getGame().titleState);
            Audio.splashscreen.stop();
            Audio.titlescreen.loop();
        }
    }

    public void render(Graphics g) {
        BufferedImage gamefreak = null;
        try {
            gamefreak = ImageIO.read(new File("res/textures/screens/gamefreak.png"));
        } catch (IOException e) {
            System.out.println("Title Screen Is Broken...");
        }
        g.drawImage(gamefreak,0,0,null);

    }
}
