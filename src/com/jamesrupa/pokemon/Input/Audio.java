package com.jamesrupa.pokemon.Input;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio {

    private Clip clip;

    public static Audio titlescreen = new Audio("/audio/Opening.wav");
    public static Audio splashscreen = new Audio("/audio/Game Freak Logo.wav");
    public static Audio demoscreen = new Audio("/audio/Opening Demo.wav");

    public Audio (String fileName) {
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(Audio.class.getResource(fileName));
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        try{
            if(clip != null){
                new Thread(){
                    public void run() {
                        synchronized (clip) {
                            clip.stop();
                            clip.setFramePosition(0);
                            clip.start();
                        }
                    }
                }.start();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void stop() {
        if (clip == null)
            return;
        clip.stop();
    }

    public void loop(){
        try{
            if(clip != null){
                new Thread(){
                    public void run() {
                        synchronized (clip){
                            clip.stop();
                            clip.setFramePosition(0);
                            clip.loop(Clip.LOOP_CONTINUOUSLY);
                        }
                    }
                }.start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean isActive(){
        return clip.isActive();
    }
}

