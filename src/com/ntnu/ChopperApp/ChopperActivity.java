package com.ntnu.ChopperApp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import sheep.game.Game;
import android.graphics.Canvas;

public class ChopperActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create the game.
        Game game = new Game(this, null);
        // Push the main state
        game.pushState(new ChopperState());
        // View the game.
        setContentView(game);
    }


}
