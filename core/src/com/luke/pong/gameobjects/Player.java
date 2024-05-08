package com.luke.pong.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.luke.pong.gameutils.GameConstants;

public class Player {
    private Rectangle playerRect;
    private final float movementSpeed;
    private ShapeRenderer shapeRenderer;
    private float screenHeight;
    private float screenWidth;

    public Player(float x, float y, float width, float height, float speed) {
        playerRect = new Rectangle(x, y, width, height);
        movementSpeed = speed;
        shapeRenderer = new ShapeRenderer();
        this.screenHeight = GameConstants.SCREEN_HEIGHT;
        this.screenWidth = GameConstants.SCREEN_WIDTH;
    }

    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            playerRect.y += movementSpeed * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            playerRect.y -= movementSpeed * Gdx.graphics.getDeltaTime();
        }
        playerRect.y = MathUtils.clamp(playerRect.y, 0.0f, screenHeight - playerRect.height);
    }

    public void draw() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(playerRect.x, playerRect.y, playerRect.width, playerRect.height);
        shapeRenderer.end();
    }

    public void dispose() {
        shapeRenderer.dispose();
    }
}
