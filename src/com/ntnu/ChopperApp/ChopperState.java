package com.ntnu.ChopperApp;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import com.ntnu.MyGame.R;
import sheep.graphics.Font;
import sheep.graphics.Image;
import sheep.game.State;

/**
 * This class represents the main state of the game
 *
 * Created by Lars on 01.02.2016.
 */
public class ChopperState extends State {


    private int canvasWidth;
    private int canvasHeight;

    private Chopper chopper_right;
    private Chopper chopper_left;
    private Chopper current_chopper;
    private int chopperBounces;

    public ChopperState(){
        // Initiates an Chopper with an image of a Chopper that travels to the right
        Image chopperImage_right = new Image(R.drawable.chopper_right);
        Image chopperImage_left = new Image(R.drawable.chopper_left);
        chopper_right = new Chopper(chopperImage_right);
        chopper_left = new Chopper(chopperImage_left);

        // Sets the initial speed of the chopper, travels to the right
        current_chopper = chopper_right;
        current_chopper.setSpeed(220, 220);
        current_chopper.setPosition(current_chopper.chopperImage.getWidth(), current_chopper.chopperImage.getHeight());
    }

    public void draw(Canvas canvas){
        canvas.drawColor(Color.WHITE);
        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();
        current_chopper.draw(canvas);

        canvas.drawText("Bounces: " + chopperBounces, 10, canvasHeight - 10, new Font(0, 0, 0, 32, Typeface.SANS_SERIF, Typeface.BOLD));
    }

    public void update(float dt){

        if(current_chopper.getX() > canvasWidth - current_chopper.chopperImage.getWidth()/2){
            if(current_chopper.getSpeed().getX() > 0){
                current_chopper.setXSpeed(-current_chopper.getSpeed().getX());
                setCurrentChopperToLeft();
                incrementChopperBounces();
            }
        }
        else if(current_chopper.getX() < 0 + current_chopper.chopperImage.getWidth()/2){
            if(current_chopper.getSpeed().getX() < 0){
                current_chopper.setXSpeed(-current_chopper.getSpeed().getX());
                setCurrentChopperToRight();
                incrementChopperBounces();
            }
        }
        if(current_chopper.getY() > canvasHeight - + current_chopper.chopperImage.getHeight()/2){
            if(current_chopper.getSpeed().getY() > 0){
                current_chopper.setYSpeed(-current_chopper.getSpeed().getY());
                incrementChopperBounces();
            }
        }
        else if(current_chopper.getY() < 0 + + current_chopper.chopperImage.getHeight()/2) {
            if(current_chopper.getSpeed().getY() < 0){
                current_chopper.setYSpeed(-current_chopper.getSpeed().getY());
                incrementChopperBounces();
            }
        }

        // Updates the position and redraws the chopper
        current_chopper.update(dt);
    }


    public void incrementChopperBounces(){
        this.chopperBounces++;
    }

    public void setCurrentChopperToRight(){
        chopper_right.setPosition(current_chopper.getPosition());
        chopper_right.setSpeed(current_chopper.getSpeed());
        chopper_right.setAcceleration(current_chopper.getAcceleration());
        current_chopper = chopper_right;
    }

    public void setCurrentChopperToLeft(){
        chopper_left.setPosition(current_chopper.getPosition());
        chopper_left.setSpeed(current_chopper.getSpeed());
        chopper_left.setAcceleration(current_chopper.getAcceleration());
        current_chopper = chopper_left;
    }


}
