package com.jamesrupa.pokemon.Worlds;

import com.jamesrupa.pokemon.Launcher.Handler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class World {

    private Handler handler;
    public static int height, width;

    public World(Handler handler) {
        this.handler = handler;
    }

    public void tick() {

    }

    public static void render(Graphics g) {
        BufferedImage world = null;
        try {
            world = ImageIO.read(new File("res/map/town.png"));
        } catch (IOException e) {
            System.out.println("De World Is Broken...");
        }
        if (world != null) {
            width = world.getWidth();
            height = world.getHeight();
        }
        g.drawImage(world,100,100,null);
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }
}
