package fr.game.data.game;

import java.awt.Color;

import fr.game.data.ImageLoader;
import fr.umlv.zen5.Application;
import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.Event.Action;
import fr.umlv.zen5.KeyboardKey;

public class GameController {
	
	public GameController() {
	}
	private static boolean gameLoop(ApplicationContext context, GameData data, GameView view) {
		var event = context.pollOrWaitEvent(10);
		if (event == null) {
			return true;
		}
		var action = event.getAction();
		if (action == Action.KEY_PRESSED && event.getKey() == KeyboardKey.Q) {
			return false;
		}
		return true;
		
	}

	private static void backpackHero(ApplicationContext context) {
		var screenInfo = context.getScreenInfo();
		var width = screenInfo.getWidth();
		var height = screenInfo.getHeight();
		var margin = 50;

		var images = new ImageLoader("data", "blank.png", "lego1.png", "lego2.png", "lego3.png", "lego4.png", "lego5.png",
				"lego6.png", "lego7.png", "lego8.png");
		var data = new GameData();
		var view = GameView.initGameGraphics(margin, margin, (int) Math.min(width, height) - 2 * margin, data,
				images);
		GameView.draw(context, data, view);
		while (true) {
			if (!gameLoop(context, data, view)) {
				System.out.println("Thank you for quitting!");
				context.exit(0);
				return;
			}
		}
	}
	public static void main(String[] args) {
		Application.run(Color.WHITE, GameController::backpackHero);
	}
}
