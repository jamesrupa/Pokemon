package com.jamesrupa.pokemon.States;

import com.jamesrupa.pokemon.Input.Audio;
import com.jamesrupa.pokemon.Launcher.Handler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameFreakState extends State {

    public GameFreakState(Handler handler) {
        super(handler);
    }

    public void tick() {

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
