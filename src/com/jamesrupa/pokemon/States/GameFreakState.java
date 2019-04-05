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

        if (handler.getKeyManager().enterPressed() || (handler.getClock() == 10)) {
            State.setState(handler.getGame().demoState);
            Audio.splashscreen.stop();
            Audio.demoscreen.play();
        }
    }

    public void render(Graphics g) {
        BufferedImage gamefreak = null;
        try {
            gamefreak = ImageIO.read(new File("res/textures/screens/gamefreak.png"));
        } catch (IOException e) {
            System.out.println("LogoScreen Is Broken...");
        }
        g.drawImage(gamefreak,-25,0,null);

    }
}
