package com.luke.pong.gamescreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.ScreenUtils;
import com.luke.pong.gameutils.GameConstants;

public class GameOverScreen extends ScreenAdapter {
	PongGame game;

	public GameOverScreen(PongGame game) {
		this.game = game;
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(Color.BLACK);

		game.batch.begin();
		game.font.draw(game.batch, "GAME OVER!", GameConstants.SCREEN_WIDTH * 0.25f, GameConstants.SCREEN_HEIGHT * 0.45f);
		game.font.draw(game.batch, "Press M to return to the Main Menu", GameConstants.SCREEN_WIDTH * 0.25f, GameConstants.SCREEN_HEIGHT * 0.40f);
		game.batch.end();

		if (Gdx.input.isKeyJustPressed(Input.Keys.M)) {
			game.setScreen(new MainMenuScreen(game));
		}
	}

}
