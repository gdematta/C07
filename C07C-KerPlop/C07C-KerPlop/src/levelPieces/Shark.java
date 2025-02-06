package levelPieces;

import gameEngine.Drawable;
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
		
		if (direction == 0 && (this.getLocation() + 2) < gameBoard.length) {
			this.setLocation(this.getLocation() + 2);
		} else if (direction == 0 && ((this.getLocation() + 2) == (gameBoard.length -1))) {
			this.setLocation(this.getLocation() + 1);
		} else if (direction == 0 && ((this.getLocation() + 2) == gameBoard.length)) {
				direction = 1;
				this.setLocation(this.getLocation() -2);	
		} else if (direction == 1 && (this.getLocation() - 2) < 0) {
			this.setLocation(this.getLocation() - 2);
		} else if (direction == 1 && ((this.getLocation() - 2) == 1)) {
			this.setLocation(this.getLocation() - 1);
			direction = 0;
		} else if (direction == 1 && ((this.getLocation() - 2) == 0)) {
			direction = 0;
			this.setLocation(this.getLocation() + 2);
		}
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