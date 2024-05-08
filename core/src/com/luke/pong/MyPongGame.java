package com.luke.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.luke.pong.gameobjects.*;

public class MyPongGame extends ApplicationAdapter {
	float screenHeight, screenWidth;
	Player player;

	@Override
	public void create () {
		screenHeight = Gdx.graphics.getHeight();
		screenWidth = Gdx.graphics.getWidth();

		player = new Player(20, 20, 25.0f, 100.0f, 200);

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

		// Render objects to the screen
		player.draw();
	}

	@Override
	public void dispose () {
		player.dispose();
		Gdx.app.exit();
	}
}

