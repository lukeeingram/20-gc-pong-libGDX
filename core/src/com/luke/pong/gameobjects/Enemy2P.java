package com.luke.pong.gameobjects;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.luke.pong.gameutils.GameConstants;

public class Enemy2P {
	private Rectangle enemyRect;
	private final float movementSpeed;
	private ShapeRenderer shapeRenderer;

	public Enemy2P(float x, float y, float width, float height, float speed) {
		enemyRect = new Rectangle(x, y, width, height);
		movementSpeed = speed;
		shapeRenderer = new ShapeRenderer();
	}

	public void update() {
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			enemyRect.y += movementSpeed * Gdx.graphics.getDeltaTime();
			enemyRect.y = MathUtils.clamp(enemyRect.y, 0.0f, GameConstants.SCREEN_HEIGHT - enemyRect.height);
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			enemyRect.y -= movementSpeed * Gdx.graphics.getDeltaTime();
			enemyRect.y = MathUtils.clamp(enemyRect.y, 0.0f, GameConstants.SCREEN_HEIGHT - enemyRect.height);
		}
	}

	public void draw() {
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.rect(enemyRect.x, enemyRect.y, enemyRect.width, enemyRect.height);
		shapeRenderer.end();
	}

	public float getEnemyX() {
		return enemyRect.x;
	}

	public float getEnemyY() {
		return enemyRect.y;
	}

	public float getEnemyWidth() {
		return enemyRect.width;
	}

	public float getEnemyHeight() {
		return enemyRect.height;
	}

	public void dispose() {
		shapeRenderer.dispose();
	}
}
