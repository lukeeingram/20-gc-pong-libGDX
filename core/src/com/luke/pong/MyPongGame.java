package com.luke.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.math.MathUtils;

public class MyPongGame extends ApplicationAdapter {
	ShapeRenderer playerShape, enemyShape, ballShape;
	Rectangle player, enemy, ball;
	float screenHeight, screenWidth;
	float dt;
	float paddleWidth = 25.0f, paddleHeight = 100.f;
	boolean moveUp, moveDown;

	@Override
	public void create () {
		screenHeight = Gdx.graphics.getHeight();
		screenWidth = Gdx.graphics.getWidth();

		playerShape = new ShapeRenderer();
		player = new Rectangle(20.0f, 20.0f, paddleWidth, paddleHeight);

		enemyShape = new ShapeRenderer();
		enemy = new Rectangle(screenWidth - 40.0f, 20.0f, paddleWidth, paddleHeight);

		ballShape = new ShapeRenderer();
		ball = new Rectangle(screenWidth / 2, screenHeight / 2, 10.0f, 10.f);

		// Get keyboard input for specific presses.
		Gdx.input.setInputProcessor(new InputAdapter() {
			@Override public boolean keyDown(int keycode) {
				if (keycode == Input.Keys.UP)  {
					moveUp = true;
				}
				if (keycode == Input.Keys.DOWN) {
					moveDown = true;
				}
				if (keycode == Input.Keys.ESCAPE) {
					dispose();
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

	@Override
	public void render () {
		ScreenUtils.clear(Color.BLACK);

		dt = Gdx.graphics.getDeltaTime();

		// Render objects to the screen
		playerShape.begin(ShapeRenderer.ShapeType.Filled);
		playerShape.rect(player.x, player.y, player.width, player.height);
		playerShape.end();

		enemyShape.begin(ShapeRenderer.ShapeType.Filled);
		enemyShape.rect(enemy.x, enemy.y, enemy.width, enemy.height);
		enemyShape.end();

		ballShape.begin(ShapeRenderer.ShapeType.Filled);
		ballShape.rect(ball.x, ball.y, ball.width, ball.height);
		ballShape.end();

		handleInput();

		handleCollision();
	}

	public void handleInput() {
		float playerSpeed = 250.0f;

		if (moveUp) {
			player.y += playerSpeed * dt;
		}
		if (moveDown) {
			player.y -= playerSpeed * dt;
		}
		float clampedY = MathUtils.clamp(player.y, 0, screenHeight - player.height);
		player.setPosition(player.getX(), clampedY);
	}

	public void handleBallMovement() {
		// Movement: position + direction * speed * dt
		float ballSpeed;
	}

	public void handleCollision() {

	}

	@Override
	public void dispose () {
		Gdx.app.exit();
	}
}

