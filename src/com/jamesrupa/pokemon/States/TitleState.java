package com.jamesrupa.pokemon.States;

import com.jamesrupa.pokemon.Input.Audio;
import com.jamesrupa.pokemon.Launcher.Handler;

import javax.imageio.ImageIO;
import javax.swing.undo.AbstractUndoableEdit;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TitleState extends State {

    public TitleState(Handler handler) {
        super(handler);
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
