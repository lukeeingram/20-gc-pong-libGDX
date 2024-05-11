package com.luke.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.luke.pong.gameobjects.*;
import com.luke.pong.gameutils.GameConstants;

public class MyPongGame extends ApplicationAdapter {
	Player player;
	Ball ball;
	EnemyAI enemy;
	Vector2 ballStartPos = new Vector2(GameConstants.SCREEN_WIDTH / 2, GameConstants.SCREEN_HEIGHT / 2);

	@Override
	public void create () {
		player = new Player(20, 20, 25.0f, 100.0f, 200);
		ball = new Ball(ballStartPos.x, ballStartPos.y, 20.0f, 20.0f, 100.0f);

		// Get keyboard input for specific presses.
		Gdx.input.setInputProcessor(new InputAdapter() {
			@Override public boolean keyDown(int keycode) {
				if (keycode == Input.Keys.ESCAPE) {
					dispose();
				}
				return true;
			}
		});
	}

	@Override
	public void render () {
		ScreenUtils.clear(Color.BLACK);
		player.update();
		ball.update();

		// Render objects to the screen
		player.draw();
		ball.draw();

		checkPlayerCollision();
		checkEnemyCollision();
	}

	public void checkPlayerCollision() {
		if (ball.getBallX() <= player.getPlayerX() + player.getPlayerWidth() &&
			ball.getBallY() <= player.getPlayerY() + player.getPlayerHeight()) {
			ball.flipXDirection();
		}
	}

	public void checkEnemyCollision() {

	}

	@Override
	public void dispose () {
		player.dispose();
		ball.dispose();
		Gdx.app.exit();
		System.exit(0);
	}
}