package com.luke.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.luke.pong.gameobjects.Player;

public class MyPongGame extends ApplicationAdapter {
	float screenHeight, screenWidth;
	float dt;
	Player player;

	@Override
	public void create () {
		screenHeight = Gdx.graphics.getHeight();
		screenWidth = Gdx.graphics.getWidth();

		player = new Player();

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
		dt = Gdx.graphics.getDeltaTime();

		// Render objects to the screen
		player.render();

	}

	@Override
	public void dispose () {
		Gdx.app.exit();
	}
}

