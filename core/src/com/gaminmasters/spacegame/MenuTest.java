package com.gaminmasters.spacegame;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;

/**
 * Created by Adam on 2016. 12. 28..
 */

public class MenuTest implements Screen {
    ShapeRenderer shapeRenderer;
    StarFieldAnimation starFieldAnimation;

    Stage stage;

    public MenuTest(){
        stage = new Stage();

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(stage.getCamera().combined);
        starFieldAnimation = new StarFieldAnimation(shapeRenderer);
    }

    @Override
    public void show() {
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        starFieldAnimation.render();
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            starFieldAnimation.changeSpeed(-1f);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            starFieldAnimation.changeSpeed(1f);
        }

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
