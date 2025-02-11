package levelPieces;

import java.util.Random;

import gameEngine.GameEngine;
import gameEngine.Drawable;
import gameEngine.Moveable;
import gameEngine.InteractionResult;

public class Fish extends GamePiece implements Moveable {
// Constructor for Fish
	public Fish(char symbol, String label, int location) {
		super(symbol, label, location);
	}
	
	public void move(Drawable[] gameBoard, int playerLocation) {
		int init = this.getLocation();
		Random random = new Random();
		int randomNumber = random.nextInt(21);
		if ((randomNumber >= 0) && (randomNumber < GameEngine.BOARD_SIZE) && gameBoard[randomNumber] == null) {
			this.setLocation(randomNumber);
			gameBoard[randomNumber] = this;
			gameBoard[init] = null;
		}
	}
	
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		// Fish don't interact with the player
		return InteractionResult.NONE;
	}

}