package com.gaminmasters.spacegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by Adam on 2016. 12. 28..
 */

public class SplashScreen implements Screen {
    private Stage stage;
    private ShapeRenderer shapeRenderer;

    private float width = Gdx.graphics.getWidth();
    private float height = Gdx.graphics.getHeight();

    private float var = 1, var2 = 1;
    private float speed = height * 2, speed2 = width;

    public SplashScreen(){
        stage = new Stage();
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(stage.getCamera().combined);
    }

    @Override
    public void show() {
            stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(0, 0, width, var);
        shapeRenderer.rect(0, height - var, width, var);
        if (var > height / 2 - 5) {
            var = height / 2 - 1;
            shapeRenderer.rect(0, height / 2 - 1, var2, 2);
            shapeRenderer.rect(width - var2, height / 2 - 1, var2, 2);
            var2 += speed2 * Gdx.graphics.getDeltaTime();
        } else {
            var += speed * Gdx.graphics.getDeltaTime();
            speed -= speed / 20;
        }

        shapeRenderer.end();

        stage.act();
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
