package com.gaminmasters.spacegame;

import com.badlogic.ashley.core.PooledEngine;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.ScreenAdapter;

/**
 * Created by Gabriel025 on 2016.12.17.
 */

public class GameScreen extends ScreenAdapter {
    Game game;

    PooledEngine engine;

    public GameScreen(Game game)
    {
        super();

        this.game = game;
    }

    public void update()
    {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();


    }
}
