package com.luke.pong.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.luke.pong.gameutils.GameConstants;

public class EnemyAI {
	private Rectangle enemyRect;
	private final float movementSpeed;
	private ShapeRenderer shapeRenderer;
	private float screenWidth, screenHeight;

	public EnemyAI(float x, float y, float width, float height, float speed) {
		enemyRect = new Rectangle(x, y, width, height);
		movementSpeed = speed;
		shapeRenderer = new ShapeRenderer();
		this.screenWidth = GameConstants.SCREEN_WIDTH;
		this.screenHeight = GameConstants.SCREEN_HEIGHT;
	}

	public void update() {
		enemyRect.y = MathUtils.clamp(enemyRect.y, 0.0f, screenHeight - enemyRect.height);
	}

	public void draw() {
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.rect(enemyRect.x, enemyRect.y, enemyRect.width, enemyRect.height);
		shapeRenderer.end();
	}
	public void moveUp() {
		enemyRect.y += movementSpeed * Gdx.graphics.getDeltaTime();
	}

	public void moveDown() {
		enemyRect.y -= movementSpeed * Gdx.graphics.getDeltaTime();
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

	public void dispose() { shapeRenderer.dispose(); }

}