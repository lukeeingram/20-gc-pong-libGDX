package com.luke.pong.gameobjects;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.luke.pong.gameutils.GameConstants;


public class ScreenDivider {
	private Rectangle dividerRect;
	private ShapeRenderer shapeRenderer;

	public ScreenDivider() {
		dividerRect = new Rectangle(GameConstants.SCREEN_WIDTH / 2, 30.0f, 15.0f, 50.0f);
		shapeRenderer = new ShapeRenderer();
	}

	public void draw() {
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.rect(dividerRect.x, dividerRect.y, dividerRect.width, dividerRect.height);
		shapeRenderer.rect(dividerRect.x, dividerRect.y + 100.0f, dividerRect.width, dividerRect.height);
		shapeRenderer.rect(dividerRect.x, dividerRect.y + 200.0f, dividerRect.width, dividerRect.height);
		shapeRenderer.rect(dividerRect.x, dividerRect.y + 300.0f, dividerRect.width, dividerRect.height);
		shapeRenderer.rect(dividerRect.x, dividerRect.y + 400.0f, dividerRect.width, dividerRect.height);
		shapeRenderer.rect(dividerRect.x, dividerRect.y + 500.0f, dividerRect.width, dividerRect.height);
		shapeRenderer.end();
	}

	public void dispose() {
		shapeRenderer.dispose();
	}
}

