package com.jamesrupa.pokemon.States;


import com.jamesrupa.pokemon.Input.Audio;
import com.jamesrupa.pokemon.Launcher.Handler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SplashScreenState extends State {

    public SplashScreenState(Handler handler) {
        super(handler);
    }

    public void tick() {

        if (handler.getClock() == 2) {
            State.setState(handler.getGame().gamefreakState);
            Audio.splashscreen.play();
        }
    }

    public void render(Graphics g) {
        BufferedImage splashscreen = null;
        try {
            splashscreen = ImageIO.read(new File("res/textures/screens/splashscreen.png"));
        } catch (IOException e) {
            System.out.println("SplashScreen Is Broken...");
        }
        g.drawImage(splashscreen,0,0,null);
    }
}
