package com.gaminmasters.spacegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Adam on 2016. 12. 28..
 */

public class StarFieldAnimation {
    private ShapeRenderer shapeRenderer;

    float speed = 50f;
    int starNum = 500;

    Array<Star> stars;

    public StarFieldAnimation(ShapeRenderer sr){
        shapeRenderer = sr;
        stars = new Array<Star>();

        for (int i = 0; i < starNum; i++)
            stars.add(new Star());
    }

    public void render(){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for (Star star : stars){
            star.update(speed);
            star.draw(shapeRenderer);
        }
        shapeRenderer.end();
    }

    public void changeSpeed(float d){
        speed += d;
    }
}

 class Star{
     private Vector3 position, velocity;
     private float width, height;
     private float depth_end = 1000, depth_start = 100;
     private float velocity_min = 0.5f, velocity_max = 5f;

     private float maxRadius = 5f;

     public Star(){
         position = new Vector3();
         velocity = new Vector3();
         init();
     }
     private void init(){
         width = Gdx.graphics.getWidth();
         height = Gdx.graphics.getHeight();

         position.x = MathUtils.random(-width, width);
         position.y = MathUtils.random(-height, height);
         position.z = MathUtils.random(depth_start, depth_end);
         velocity.z = MathUtils.random(velocity_min, velocity_max);
     }

     public void update(float speed){
         if (position.z < 0 || position.z > depth_end || position.y > height || position.x > width)
             init();
         float t = Gdx.graphics.getDeltaTime();
         position.sub(velocity.x * speed * t, velocity.y * speed * t, velocity.z * speed * t);
     }

     public void draw(ShapeRenderer shapeRenderer){
         float color = (1.0f - position.z * .001f * velocity.z) * 1.0f;
         float x = position.x / position.z * 100 + width / 2f;
         float y = position.y / position.z * 100 + height / 2f;
         float radius = (maxRadius - position.z * maxRadius * .001f) * velocity.z * 0.2f;
         shapeRenderer.setColor(color, color, color, 1f);
         shapeRenderer.circle(x, y, radius);
     }




}
