package com.luke.pong.gamescreens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.luke.pong.gameobjects.*;
import com.luke.pong.gamescoring.EnemyScoreArea;
import com.luke.pong.gamescoring.PlayerScoreArea;
import com.luke.pong.gamescoring.Scoring;
import com.luke.pong.gameutils.GameConstants;

public class PongGameAIScreen extends ScreenAdapter {
	PongGame game;
	Player player;
	Ball ball;
	EnemyAI enemy;
	Scoring gameScore;
	PlayerScoreArea playerScoreArea;
	EnemyScoreArea enemyScoreArea;
	ScreenDivider divider;
	Vector2 ballStartPos = new Vector2(GameConstants.SCREEN_WIDTH / 2, GameConstants.SCREEN_HEIGHT / 2);

	public PongGameAIScreen(PongGame game) {
		this.game = game;

		player = new Player(20, 20, 25.0f, 100.0f, 200.0f);
		ball = new Ball(ballStartPos.x, ballStartPos.y, 20.0f, 20.0f, 100.0f);
		enemy = new EnemyAI(GameConstants.SCREEN_WIDTH - 40, GameConstants.SCREEN_HEIGHT / 2, 25.0f, 100.0f, 200.0f);
		gameScore = new Scoring(0, 0);
		divider = new ScreenDivider();
		playerScoreArea = new PlayerScoreArea();
		enemyScoreArea = new EnemyScoreArea();
	}

	@Override
	public void render (float delta) {
		ScreenUtils.clear(Color.BLACK);
		player.update();
		ball.update();

		// Render objects to the screen
		player.draw();
		ball.draw();
		enemy.draw();
		gameScore.draw();
		divider.draw();
		playerScoreArea.draw();
		enemyScoreArea.draw();

		// Move the enemy paddle
		handleEnemyMovement();

		// Handle collisions with the paddles
		checkPlayerCollision();
		checkEnemyCollision();

		// Handle scoring.
		handleScoring();

		// Go to the main menu if ESC is pressed
		if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
			game.setScreen(new MainMenuScreen(game));
		}
	}

	public void checkPlayerCollision() {
		if (ball.getBallX() <= player.getPlayerX() + player.getPlayerWidth() &&
			ball.getBallY() >= player.getPlayerY() &&
			ball.getBallY() <= player.getPlayerY() + player.getPlayerHeight()) {
				ball.flipXDirection();
				ball.increaseBallSpeed();
		}
	}

	public void handleEnemyMovement() {
		if (ball.getBallX() >= GameConstants.SCREEN_WIDTH / 2 && ball.getBallY() > enemy.getEnemyY()) {
			enemy.moveUp();
		}

		if (ball.getBallX() >= GameConstants.SCREEN_WIDTH / 2 && ball.getBallY() < enemy.getEnemyY()) {
			enemy.moveDown();
		}
	}

	public void checkEnemyCollision() {
		if (ball.getBallX() + ball.getBallWidth() >= enemy.getEnemyX() &&
				ball.getBallY() >= enemy.getEnemyY() &&
				ball.getBallY() <= enemy.getEnemyY() + enemy.getEnemyHeight()) {
			ball.flipXDirection();
			ball.increaseBallSpeed();
		}
	}

	// Rough idea is that if the ball collides with the score areas, increase and display appropriate score
	// then reset ball pos/speed
	public void handleScoring() {
		// Player
		if (ball.getBallX() >= playerScoreArea.getX()) {
			gameScore.playerScored();
			ball.resetBall();
		}

		// Enemy
		if (ball.getBallX() <= enemyScoreArea.getX()) {
			gameScore.enemyScored();
			ball.resetBall();
		}

		// Trigger a game over
		if (gameScore.getPlayerScore() >= 5 || gameScore.getEnemyScore() >= 5) {
			game.setScreen(new GameOverScreen(game));
		}
	}

	@Override
	public void dispose () {
		player.dispose();
		ball.dispose();
		enemy.dispose();
		playerScoreArea.dispose();
		enemyScoreArea.dispose();
	}

}