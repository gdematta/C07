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
		
		if (direction == 0 && (this.getLocation() + 2) < GameEngine.BOARD_SIZE) {
			this.setLocation(this.getLocation() + 2);
		} else if (direction == 0 && ((this.getLocation() + 2) == (GameEngine.BOARD_SIZE - 1))) {
			this.setLocation(this.getLocation() + 2);
			this.direction = 0;
		} else if (direction == 0 && ((this.getLocation() + 2) >= GameEngine.BOARD_SIZE)) {
			direction = 1;
			this.setLocation(this.getLocation() - 2);
			
		} else if (direction == 1 && (this.getLocation() - 2) > 0) {
			this.setLocation(this.getLocation() - 2);
		} else if (direction == 1 && ((this.getLocation() - 2) == 0)) {
			this.setLocation(this.getLocation() - 2);
			direction = 0;
		} else if (direction == 1 && ((this.getLocation() - 2) < 0)) {
			direction = 0;
			this.setLocation(this.getLocation() + 2);
		}
		System.out.println(this.getLocation());
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