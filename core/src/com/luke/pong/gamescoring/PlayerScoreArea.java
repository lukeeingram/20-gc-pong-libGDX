package com.luke.pong.gamescoring;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.luke.pong.gameutils.GameConstants;

public class PlayerScoreArea {
	private Rectangle playerScoreRect;
	private ShapeRenderer shapeRenderer;

	public PlayerScoreArea() {
		playerScoreRect = new Rectangle(GameConstants.SCREEN_WIDTH - 10.0f, 0.0f, 25.0f, GameConstants.SCREEN_HEIGHT);
		shapeRenderer = new ShapeRenderer();
	}

	public void draw() {
		shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
		shapeRenderer.rect(playerScoreRect.x, playerScoreRect.y, playerScoreRect.width, playerScoreRect.height);
		shapeRenderer.end();
	}

	public float getX() {
		return playerScoreRect.x;
	}

	public float getY() {
		return playerScoreRect.y;
	}

	public void dispose() {
		shapeRenderer.dispose();
	}
}
