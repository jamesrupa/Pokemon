package com.jamesrupa.pokemon.Launcher;

import com.jamesrupa.pokemon.Display.Display;
import com.jamesrupa.pokemon.GFX.Assets;
import com.jamesrupa.pokemon.States.GameState;
import com.jamesrupa.pokemon.States.State;
import com.jamesrupa.pokemon.States.TitleState;

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
    // Thread == mini program
    private boolean running = false;
    private Thread thread;

    // Buffer + Graphics Variables
    private BufferStrategy bs;
    private Graphics g;

    // STATES
    private State gameState;
    private State titleState;




    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    private void init() {
        display = new Display(title, width, height);
        Assets.init();

        gameState = new GameState();
        titleState = new TitleState();
        State.setState(titleState);
    }

    private void tick() {

        if (State.getState() != null) {
            State.getState().tick();
        }
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
        g.clearRect(0,0, width, height);
        // Draw Here

        if (State.getState() != null) {
            State.getState().render(g);
        }

        // End Drawing
        bs.show();
        g.dispose();
    }


    // BASIC GAME LOOP TO RUN THE GAME AND UPDATE IT
    public void run() {

        init();

        // VARIABLES
        int UPS = 30;
        int FPS = 30;

        // CONSTANT VARIABLES
        long initialTime = System.nanoTime();
        final double timeU = 1000000000 / UPS;
        final double timeF = 1000000000 / FPS;
        double deltaU = 0, deltaF = 0;
        int frames = 0, ticks = 0;
        long timer = 0;

        while(running) {

            long currentTime = System.nanoTime();
            deltaU += (currentTime - initialTime) / timeU;
            deltaF += (currentTime - initialTime) / timeF;
            timer += currentTime - initialTime;
            initialTime = currentTime;

            if (deltaU >= 1) {
                tick();
                render();
                ticks++;
                deltaU--;
            }

            if (deltaF >= 1) {
                tick();
                render();
                frames++;
                deltaF--;
            }

            if(timer >= 1000000000) {
                System.out.println("UPS: " + ticks);
                System.out.println("FPS: " + frames + "\n");
                ticks = 0;
                frames = 0;
                timer = 0;
            }

        }

        stop();
    }


    public synchronized void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    // THESE TWO METHODS WORK TOGETHER


    public synchronized void stop() {
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
