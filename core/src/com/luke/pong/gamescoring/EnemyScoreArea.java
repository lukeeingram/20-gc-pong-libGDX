package com.luke.pong.gamescoring;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.luke.pong.gameutils.GameConstants;

public class EnemyScoreArea {
	private Rectangle enemyScoreRect;
	private ShapeRenderer shapeRenderer;

	public EnemyScoreArea() {
		enemyScoreRect = new Rectangle(-15.0f, 0.0f, 25.0f, GameConstants.SCREEN_HEIGHT);
		shapeRenderer = new ShapeRenderer();
	}

	public void draw() {
		shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
		shapeRenderer.rect(enemyScoreRect.x, enemyScoreRect.y, enemyScoreRect.width, enemyScoreRect.height);
		shapeRenderer.end();
	}

	public float getX() {
		return enemyScoreRect.x;
	}

	public float getY() {
		return enemyScoreRect.y;
	}

	public void dispose() {
		shapeRenderer.dispose();
	}

}
