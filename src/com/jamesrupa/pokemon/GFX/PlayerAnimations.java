package com.jamesrupa.pokemon.GFX;

import java.awt.image.BufferedImage;

public class PlayerAnimations {
    private int speed, index;
    private long lastTime, timer;
    private BufferedImage[] frames;

    public PlayerAnimations(int speed, BufferedImage[] frames){
        this.speed = speed;
        this.frames = frames;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
    }

    public void tick() {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if(timer > speed){
            index++;
            timer = 0;
            if(index >= frames.length)
                index = 0;
        }
    }

    public BufferedImage getCurrentFrame() {
        return frames[index];
    }
}
