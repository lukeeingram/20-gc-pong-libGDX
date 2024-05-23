package com.luke.pong.gamescreens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.luke.pong.gameobjects.*;
import com.luke.pong.gamescoring.*;
import com.luke.pong.gameutils.*;

public class PongGame2PScreen extends ScreenAdapter {
	PongGame game;
	Player2P player;
	Enemy2P enemy;
	Ball ball;
	Scoring gameScore;
	PlayerScoreArea playerScoreArea;
	EnemyScoreArea enemyScoreArea;
	ScreenDivider divider;
	Vector2 ballStartPos = new Vector2(GameConstants.SCREEN_WIDTH / 2, GameConstants.SCREEN_HEIGHT / 2);
	Sound colSound;
	Sound endSound;

	public PongGame2PScreen(PongGame game) {
		this.game = game;

		player = new Player2P(20, 20, 25.0f, 100.0f, 200.0f);
		enemy = new Enemy2P(GameConstants.SCREEN_WIDTH - 40.0f, GameConstants.SCREEN_HEIGHT / 2, 25.0f, 100.0f, 200.0f);
		ball = new Ball(ballStartPos.x, ballStartPos.y, 20.0f, 20.0f, 100.0f);
		gameScore = new Scoring(0, 0);
		divider = new ScreenDivider();
		playerScoreArea = new PlayerScoreArea();
		enemyScoreArea = new EnemyScoreArea();
		colSound = Gdx.audio.newSound(Gdx.files.internal("blip.wav"));
		endSound = Gdx.audio.newSound(Gdx.files.internal("end_finish.wav"));
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(Color.BLACK);
		player.update();
		enemy.update();
		ball.update();

		// Render screen objects
		player.draw();
		enemy.draw();
		ball.draw();
		gameScore.draw();
		divider.draw();
		playerScoreArea.draw();
		enemyScoreArea.draw();

		// Handle collisions with paddles
		checkPlayerCollision();
		checkEnemyCollision();

		// Handle scoring
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
			colSound.play(0.1f);
		}
	}

	public void checkEnemyCollision() {
		if (ball.getBallX() + ball.getBallWidth() >= enemy.getEnemyX() &&
				ball.getBallY() >= enemy.getEnemyY() &&
				ball.getBallY() <= enemy.getEnemyY() + enemy.getEnemyHeight()) {
			ball.flipXDirection();
			ball.increaseBallSpeed();
			colSound.play(0.1f);
		}
	}

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

		// Game over
		if (gameScore.getPlayerScore() >= 5 || gameScore.getEnemyScore() >= 5) {
			game.setScreen(new GameOverScreen(game));
			endSound.play(0.1f);
		}
	}

	@Override
	public void dispose() {
		player.dispose();
		enemy.dispose();
		ball.dispose();
		playerScoreArea.dispose();
		enemyScoreArea.dispose();
		divider.dispose();
		gameScore.dispose();
		endSound.dispose();
		colSound.dispose();
	}
}
