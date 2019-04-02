package com.jamesrupa.pokemon.States;

import com.jamesrupa.pokemon.Input.Audio;
import com.jamesrupa.pokemon.Launcher.Game;
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
    }

    public void render(Graphics g) {
        BufferedImage splashscreen = null;
        try {
            splashscreen = ImageIO.read(new File("res/textures/screens/pokemon.png"));
        } catch (IOException e) {
            System.out.println("Title Screen Is Broken...");
        }
        g.drawImage(splashscreen,0,0,null);
    }
}
