package com.jamesrupa.pokemon.Launcher;

import com.jamesrupa.pokemon.Display.Display;
import com.jamesrupa.pokemon.GFX.Assets;
import com.jamesrupa.pokemon.Input.KeyManager;
import com.jamesrupa.pokemon.States.*;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

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
    private Handler handler;
    public int clock;

    // Buffer + Graphics Variables
    private BufferStrategy bs;
    private Graphics g;

    // STATES
    public State splashscreenState;
    public State gamefreakState;
    public State titleState;
    public State demoState;
    public State gameState;
    public State settingState;

    // INPUT
    private KeyManager keyManager;


    public Game(String title,int width,int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        keyManager = new KeyManager();
    }

    private void init() {
        display = new Display(title,width,height);
        display.getFrame().addKeyListener(keyManager);

        Assets.init();

        handler = new Handler(this);

        splashscreenState = new SplashScreenState(handler);
        gamefreakState = new GameFreakState(handler);
        titleState = new TitleState(handler);
        demoState = new DemoState(handler);
        gameState = new GameState(handler);
        settingState = new SettingState(handler);
        State.setState(splashscreenState);
    }

    private void tick() {
        keyManager.tick();

        if (State.getState() != null) {
            State.getState().tick();
        }
    }


    // What Can Be Seen On Screen
    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        // Clear Screen
        g.clearRect(0,0,width,height);
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


        while (running) {

            long currentTime = System.nanoTime();
            deltaU += (currentTime - initialTime) / timeU;
            deltaF += (currentTime - initialTime) / timeF;
            timer += currentTime - initialTime;
            initialTime = currentTime;

            if (deltaU >= 1) {
                tick();
                ticks++;
                deltaU--;
            }

            if (deltaF >= 1) {
                render();
                frames++;
                deltaF--;
            }

            if (timer >= 1000000000) {
                clock++;
                System.out.println("UPS: " + ticks);
                System.out.println("FPS: " + frames);
                System.out.println("CLOCK: " + clock + "\n");
                ticks = 0;
                frames = 0;
                timer = 0;
            }

        }

        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public int getClock() {
        return clock;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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
