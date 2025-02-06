package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

// Sea Mines will kill the player if they land on them

public class SeaMine extends GamePiece {
	
	// Sea Mine Constructor
	public SeaMine(char symbol, String label, int location) {
		super(symbol, label, location);
	}
	
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		// If the player lands on the mine, they die!
		if(playerLocation == this.getLocation()) {
			return InteractionResult.KILL;
		} else {
			return InteractionResult.NONE;
		}

	}
	

}