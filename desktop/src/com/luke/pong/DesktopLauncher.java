package com.luke.pong;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.luke.pong.gamescreens.PongGame;
import com.luke.pong.gameutils.GameConstants;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Pong");
		config.setWindowedMode((int) GameConstants.SCREEN_WIDTH, (int) GameConstants.SCREEN_HEIGHT);
		new Lwjgl3Application(new PongGame(), config);
	}
}
