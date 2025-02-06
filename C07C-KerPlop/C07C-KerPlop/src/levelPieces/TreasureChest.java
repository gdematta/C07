package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

//Treasure Chests advance the player to the next level if they land on it

public class TreasureChest extends GamePiece {
	
	// Treasure Chest Constructor
	public TreasureChest(char symbol, String label, int location) {
		super(symbol, label, location);
	}
	
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {

		if(playerLocation == this.getLocation()) {
			return InteractionResult.ADVANCE;
		} else {
			return InteractionResult.NONE;
		}

	}
	

}