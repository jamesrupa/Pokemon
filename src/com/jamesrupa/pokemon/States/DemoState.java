package com.jamesrupa.pokemon.States;

import com.jamesrupa.pokemon.Input.Audio;
import com.jamesrupa.pokemon.Launcher.Game;
import com.jamesrupa.pokemon.Launcher.Handler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DemoState extends State {

    public DemoState(Handler handler) {
        super(handler);

    }

    public void tick() {
        if (handler.getClock() >= 1) {
            if (handler.getClock() == 12 || handler.getKeyManager().enterPressed()) {
                State.setState(handler.getGame().titleState);
                Audio.demoscreen.stop();
                Audio.titlescreen.loop();
                Game.clock = 0;
            }
        }
    }

    public void render(Graphics g) {
        BufferedImage demo = null;
        try {
            demo = ImageIO.read(new File("res/textures/screens/demo.png"));
        } catch (IOException e) {
            System.out.println("DemoScreen Is Broken...");
        }
        g.drawImage(demo,0,0,null);
    }
}
