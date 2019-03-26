package com.jamesrupa.pokemon.States;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TitleState extends State {

    public TitleState() {

    }


    public void tick() {

    }

    public void render(Graphics g) {
        BufferedImage titlescreen = null;
        try {
            titlescreen = ImageIO.read(new File("res/textures/screens/titlescreen.png"));
        } catch (IOException e) {
            System.out.println("Title Screen Is Broken...");
        }
        g.drawImage(titlescreen,0,0,null);
    }
}
