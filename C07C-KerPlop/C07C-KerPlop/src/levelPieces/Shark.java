package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;
import gameEngine.InteractionResult;



public class Shark extends GamePiece implements Moveable {
	// 0 traveling right, 1 traveling left
	public int direction = 0;
	
	// Constructor for Shark
	public Shark(char symbol, String label, int location) {
		super(symbol, label, location);
	}
	
	public void move(Drawable[] gameBoard, int playerLocation) {
		
		int init = this.getLocation();
		//Facing Right conditions:
		// If facing right and valid location, move right 2
		if (direction == 0 && (this.getLocation() + 2) < GameEngine.BOARD_SIZE && gameBoard[this.getLocation() + 2] == null) {
			this.setLocation(this.getLocation() + 2);
		// If facing right and valid location but at the edge, move right 2 and change directions
		} else if (direction == 0 && ((this.getLocation() + 2) == (GameEngine.BOARD_SIZE - 1)) && gameBoard[this.getLocation() + 2] == null) {
			this.setLocation(this.getLocation() + 2);
			this.direction = 1;
		// If facing right and invalid location, move the remaining spaces and flip direction
		} else if (direction == 0 && ((this.getLocation() + 2) >= GameEngine.BOARD_SIZE) && gameBoard[this.getLocation() + 1] == null) {
			this.setLocation(this.getLocation() + 1);
			direction = 1;
		} else if (direction == 0 && gameBoard[this.getLocation() + 1] == null) {
			this.setLocation(this.getLocation() + 1);
			direction = 1;
		} else if (direction == 0) {
			direction = 1;
			
			
		//Facing Right conditions:
		// If facing left and valid location, move right 2
		}	else if (direction == 1 && (this.getLocation() - 2) > 0 && gameBoard[this.getLocation() - 2] == null) {
			this.setLocation(this.getLocation() - 2);
		// If facing left and valid location but at the edge, move right 2 and change directions
		} else if (direction == 1 && ((this.getLocation() - 2) == 0) && gameBoard[this.getLocation() - 2] == null) {
			this.setLocation(this.getLocation() - 2);
			this.direction = 0;
		// If facing left and invalid location, move the remaining spaces and flip direction
		} else if (direction == 1 && ((this.getLocation() - 2) < 0) && gameBoard[this.getLocation() - 1] == null) {
			this.setLocation(this.getLocation() - 1);
			direction = 0;
		} else if (direction == 0 && gameBoard[this.getLocation() - 1] == null) {
			this.setLocation(this.getLocation() - 1);
			direction = 0;
		} else if (direction == 1) {
			direction = 0;
		}
		
		gameBoard[init] = null;
		gameBoard[this.getLocation()] = this;
	}
	
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		// If the player is still within range, then they will take a hit
		if(Math.abs(playerLocation - this.getLocation()) < 2) {
			return InteractionResult.HIT;
		} else {
			return InteractionResult.NONE;
		}
	}
}