package com.jamesrupa.pokemon.Entities.Player;

import com.jamesrupa.pokemon.GFX.Assets;
import com.jamesrupa.pokemon.GFX.PlayerAnimations;
import com.jamesrupa.pokemon.Launcher.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Trainer extends Player {

    public static final float TRAINER_SPEED = 3.5f;
    private static int clear = 0;

    // ANIMATIONS
    private PlayerAnimations animDown;
    private PlayerAnimations animUp;
    private PlayerAnimations animLeft;
    private PlayerAnimations animRight;

    public Trainer(Handler handler,float x,float y) {
        super(handler,x,y,Player.DEFAULT_PLAYER_WIDTH,Player.DEFAULT_PLAYER_HEIGHT);
        speed = TRAINER_SPEED;

        animDown = new PlayerAnimations(250, Assets.playerDown);
        animUp = new PlayerAnimations(250, Assets.playerUp);
        animLeft = new PlayerAnimations(250, Assets.playerLeft);
        animRight = new PlayerAnimations(250, Assets.playerRight);
    }

    public void tick() {
        animDown.tick();
        animUp.tick();
        animLeft.tick();
        animRight.tick();

        getInput();
        handler.getGameCamera().centerOnEntity(this);
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;


        if(handler.getKeyManager().up) {
            yMove += -speed;
            xMove = clear;
        }
        if(handler.getKeyManager().down) {
            yMove += speed;
            xMove = clear;

        }
        if(handler.getKeyManager().left) {
            xMove += -speed;
            yMove = clear;

        }
        if(handler.getKeyManager().right) {
            xMove += speed;
            yMove = clear;

        }
    }

    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()),
                width, height,null);
    }

    private BufferedImage getCurrentAnimationFrame() {
        if(xMove < 0){
            return animLeft.getCurrentFrame();
        } else if(xMove > 0){
            return animRight.getCurrentFrame();
        } else if(yMove < 0){
            return animUp.getCurrentFrame();
        } else if (yMove > 0){
            return animDown.getCurrentFrame();
        } else {
            return Assets.playerStill;
        }
    }
}
