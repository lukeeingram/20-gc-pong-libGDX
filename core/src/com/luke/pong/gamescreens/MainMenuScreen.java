package com.luke.pong.gamescreens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.luke.pong.gameutils.GameConstants;

public class MainMenuScreen extends ScreenAdapter {
	PongGame game;
	private final Texture logo;

	public MainMenuScreen(PongGame game) {
		this.game = game;
		logo = new Texture("logo.png");
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(Color.BLACK);

		game.batch.begin();
		game.batch.draw(logo, GameConstants.SCREEN_WIDTH / 2, GameConstants.SCREEN_HEIGHT / 2 + 60.0f);
		game.font.draw(game.batch, "Press 1 to play against the AI", GameConstants.SCREEN_WIDTH * 0.25f, GameConstants.SCREEN_HEIGHT * 0.45f);
		game.font.draw(game.batch, "Press 2 to play against another player", GameConstants.SCREEN_WIDTH * 0.25f, GameConstants.SCREEN_HEIGHT * 0.40f);
		game.font.draw(game.batch, "Press ESC or Q to quit", GameConstants.SCREEN_WIDTH * 0.25f, GameConstants.SCREEN_HEIGHT * 0.35f);
		game.batch.end();

		if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
			game.setScreen(new PongGameAIScreen(game));
		}

		if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
			game.setScreen(new PongGame2PScreen(game));
		}

		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE) || Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
			dispose();
		}
	}

	public void dispose() {
		logo.dispose();
		Gdx.app.exit();
		System.exit(0);
	}
}
