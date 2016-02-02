package com.ntnu.ChopperApp;
import sheep.collision.Polygon;
import sheep.game.Sprite;
import sheep.graphics.Image;
import android.graphics.Canvas;
import sheep.graphics.SpriteView;

/**
 *
 * This class represents a chopper
 *
 * Created by Lars on 02/02/16.
 */
public class Chopper extends Sprite {

    Image chopperImage;


    public Chopper(Image image) {
        super(image);
        this.chopperImage = image;
    }




}
