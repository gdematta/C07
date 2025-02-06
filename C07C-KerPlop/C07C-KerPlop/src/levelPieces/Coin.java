package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

//Coins give a point if the player lands on it 

public class Coin extends GamePiece {
	
	// Flag to mark if the coin has been collected
	public boolean collected = false;
	
	// Coin Constructor
	public Coin(char symbol, String label, int location) {
		super(symbol, label, location);
	}
	
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		//If the player lands on the coin and it hasn't already been collected, increase score by 1
		if(playerLocation == this.getLocation() && collected == false) {
			collected = true;
			return InteractionResult.GET_POINT;
		} else {
			return InteractionResult.NONE;
		}

	}
	

}