package com.luke.pong.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.luke.pong.gameutils.GameConstants;

public class Ball {
    private Rectangle ballRect;
    private final float ballSpeed;
    private Vector2 ballDirection;
    private ShapeRenderer shapeRenderer;
    private float screenWidth, screenHeight;

    public Ball(float x, float y, float width, float height, float speed) {
        ballRect = new Rectangle(x, y, width, height);
        ballSpeed = speed;
        shapeRenderer = new ShapeRenderer();
        ballDirection = new Vector2(1, 0);
        this.screenHeight = GameConstants.SCREEN_HEIGHT;
        this.screenWidth = GameConstants.SCREEN_WIDTH;
    }

    public void update() {
        ballRect.x += ballSpeed * ballDirection.x * Gdx.graphics.getDeltaTime();
        ballRect.y += ballSpeed * ballDirection.y * Gdx.graphics.getDeltaTime();
        ballRect.y = MathUtils.clamp(ballRect.y, 0, screenHeight - ballRect.height);

        if (ballRect.y <= 0 || ballRect.y >= screenHeight - ballRect.height) {
            ballDirection.y *= -1;
        }
    }

    public void draw() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(ballRect.x, ballRect.y, ballRect.width, ballRect.height);
        shapeRenderer.end();
    }

    public void flipXDirection() {
        ballDirection.x *= -1;
    }

    public float getBallX() {
        return ballRect.x;
    }

    public float getBallY() {
        return ballRect.y;
    }

    public float getBallWidth() {
        return ballRect.width;
    }

    public float getBallHeight() {
        return ballRect.height;
    }

    public void dispose() {
        shapeRenderer.dispose();
    }
}
