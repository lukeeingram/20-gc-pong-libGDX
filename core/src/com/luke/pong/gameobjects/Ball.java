package com.luke.pong.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Ball {
    private Rectangle ballRect;
    private final float ballSpeed;
    private ShapeRenderer shapeRenderer;
    Vector2 ballDirection = new Vector2(-1, 1);

    public Ball(float x, float y, float width, float height, float speed) {
        ballRect = new Rectangle(x, y, width, height);
        ballSpeed = speed;
        shapeRenderer = new ShapeRenderer();
    }

    public void update() {

    }

    public void draw() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(ballRect.x, ballRect.y, ballRect.width, ballRect.height);
        shapeRenderer.end();
    }

    public void dispose() {
        shapeRenderer.dispose();
    }
}
