package com.gaminmasters.spacegame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

/**
 * Created by Gabriel025 on 2016.12.17.
 */

public class GameScreen implements Screen {
    Game game;

    public GameScreen(Game game)
    {
        this.game = game;
    }

    public void update()
    {

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update();


    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
