package com.jamesrupa.pokemon.GFX;

import java.awt.image.BufferedImage;

public class Assets {

    // PLAYER HEIGHT AND WIDTH VARIABLES
    private static final int cwidth = 64, cheight = 64;

    // BUFFERED IMAGE VARIABLES
    public static BufferedImage[] playerUp, playerDown, playerLeft, playerRight;
    public static BufferedImage playerStill;

    public static void init() {

        SpriteSheet PLAYERUP = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheets/playerD.png"));
        SpriteSheet PLAYERDOWN = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheets/playerA.png"));
        SpriteSheet PLAYERLEFT = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheets/playerB.png"));
        SpriteSheet PLAYERRIGHT = new SpriteSheet(ImageLoader.loadImage("/textures/spritesheets/playerC.png"));


        // PLAYER -->
        /*
        PLAYERDOWN = new BufferedImage[4];
        PLAYERUP = new BufferedImage[4];
        PLAYERLEFT = new BufferedImage[4];
        PLAYERRIGHT = new BufferedImage[4];

        ////////////////////////////////////////////////////
        playerUp[0] = PLAYERUP.crop(0,0, cwidth, cheight);
        playerUp[1] = PLAYERUP.crop(cwidth * 1,0, cwidth, cheight);
        playerUp[2] = PLAYERUP.crop(cwidth * 2 ,0, cwidth, cheight);
        playerUp[3] = PLAYERUP.crop(cwidth * 3, 0, cwidth, cheight);
        ////////////////////////////////////////////////////
        playerDown[0] = PLAYERDOWN.crop(0,0, cwidth, cheight);
        playerDown[1] = PLAYERDOWN.crop(cwidth * 1,0, cwidth, cheight);
        playerDown[2] = PLAYERDOWN.crop(cwidth * 2 ,0, cwidth, cheight);
        playerDown[3] = PLAYERDOWN.crop(cwidth * 3, 0, cwidth, cheight);
        ////////////////////////////////////////////////////
        playerLeft[0] = PLAYERLEFT.crop(0,0, cwidth, cheight);
        playerLeft[1] = PLAYERLEFT.crop(cwidth * 1,0, cwidth, cheight);
        playerLeft[2] = PLAYERLEFT.crop(cwidth * 2 ,0, cwidth, cheight);
        playerLeft[3] = PLAYERLEFT.crop(cwidth * 3, 0, cwidth, cheight);
        ////////////////////////////////////////////////////
        playerRight[0] = PLAYERRIGHT.crop(0,0, cwidth, cheight);
        playerRight[1] = PLAYERRIGHT.crop(cwidth * 1,0, cwidth, cheight);
        playerRight[2] = PLAYERRIGHT.crop(cwidth * 2 ,0, cwidth, cheight);
        playerRight[3] = PLAYERRIGHT.crop(cwidth * 3, 0, cwidth, cheight);
        ////////////////////////////////////////////////////
        */
        playerStill = PLAYERDOWN.crop(cwidth * 2,0, cwidth, cheight);

    }
}
