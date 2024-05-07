package com.luke.pong.gameobjects;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Player extends ApplicationAdapter {
    ShapeRenderer playerShape;
    Rectangle playerRectangle;
    float paddleWidth = 25.0f, paddleHeight = 25.0f;
    float dt;
    boolean moveUp, moveDown;

    @Override
    public void create() {
        playerShape = new ShapeRenderer();
        playerRectangle = new Rectangle(20.0f, 20.0f, paddleWidth, paddleHeight);

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override public boolean keyDown(int keycode) {
                if (keycode == Input.Keys.UP) {
                    moveUp = true;
                }
                if (keycode == Input.Keys.DOWN) {
                    moveDown = true;
                }
                return true;
            }

            @Override public boolean keyUp(int keycode) {
                if (keycode == Input.Keys.UP) {
                    moveUp = false;
                }
                if (keycode == Input.Keys.DOWN) {
                    moveDown = false;
                }
                return true;
            }
        });
    }

    public void render() {
        dt = Gdx.graphics.getDeltaTime();

        playerShape.begin(ShapeRenderer.ShapeType.Filled);
        playerShape.rect(playerRectangle.x, playerRectangle.y, playerRectangle.width, playerRectangle.height);
        playerShape.end();

        handleInput();
    }

    public void handleInput() {
        float playerSpeed = 250.0f;
        if (moveUp) {
            playerRectangle.y += playerSpeed * dt;
        }
        if (moveDown) {
            playerRectangle.y -= playerSpeed * dt;
        }
    }

    @Override
    public void dispose() {

    }
}
