package com.luke.pong.gamescoring;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.luke.pong.gameutils.GameConstants;

public class Scoring {
	private int playerScore, enemyScore;
	private BitmapFont font;
	private SpriteBatch batch;

	public Scoring(int p_score, int e_score) {
		playerScore = p_score;
		enemyScore = e_score;

		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		font.getData().setScale(1.5f, 1.5f);
	}

	public void draw() {
		batch.begin();
		font.draw(batch, String.valueOf(playerScore), 100, GameConstants.SCREEN_HEIGHT - 20);
		font.draw(batch, String.valueOf(enemyScore), GameConstants.SCREEN_WIDTH - 100, GameConstants.SCREEN_HEIGHT - 20);
		batch.end();
	}

	public int getPlayerScore() {
		return playerScore;
	}

	public int getEnemyScore() {
		return enemyScore;
	}

	public int playerScored() {
		return playerScore += 1;
	}

	public int enemyScored() {
		return enemyScore += 1;
	}

	public void dispose() {
		font.dispose();
		batch.dispose();
	}
}
