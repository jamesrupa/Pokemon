package com.jamesrupa.pokemon.Launcher;

import com.jamesrupa.pokemon.Display.Display;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{

    // VARIABLES
    // Width, Height, and Title Variables
    public int width, height;
    public String title;

    // Display Variables
    private Display display;

    // Running Variables
    private boolean running = false;
    private Thread thread;

    // Buffer + Graphics Variables
    private BufferStrategy bs;
    private Graphics g;

    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        display = new Display(title, width, height);
    }

    private void init() {
        display = new Display(title, width, height);
    }

    private void tick() {

    }

    // What Can Be Seen On Screen
    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        // Clear Screen
        g.clearRect(0,0,width, height);
        // Draw Here
        /*

        */
        // End Drawing
        bs.show();
        g.dispose();
    }

    // BASIC GAME LOOP TO RUN THE GAME AND UPDATE IT
    public void run() {

        init();

        // FPS
        int fps = 30;
        // Max Time for FPS Target - execute the FPS
        double timePerTick = 1000000000 / fps;
        // Amount of Time we have until we have to call the tick and render methods again
        double delta = 0;
        // current time of our computer
        long now;
        // last time since last running code
        long lastTime = System.nanoTime();
        // Just for FPS Counter
        // FOR VISUAL
        long timer = 0;
        int ticks = 0;

        while(running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1000000000) {
                System.out.println("FPS: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }

    public synchronized void start() {
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    // THESE TWO METHODS WORK TOGETHER

    public synchronized void stop() {
        if(running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
