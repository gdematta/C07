package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

// Whirlpools will teleport the player to the other whirlpool, which are a always 12 spaces apart. There can only be 2 of them on the map

public class Whirlpool extends GamePiece {
	// Flag to check if the player already warped in one turn
	public static boolean moved = false;
	// Counter for how many whirlpools can be made (max 2)
	public static int instanceCounter = 0;
	// Holds the locations of both whirlpools
	public static int[] locations = new int[2];
	
	// Whirlpool Constructor
	public Whirlpool(char symbol, String label, int location) {
		super(symbol, label, location);
		// Update the location and instance counters.
		locations[instanceCounter] = location;
		instanceCounter++;
		//Reset after 2 whirlpools made (i.e, new level)
		if(instanceCounter > 1) {
			instanceCounter = 0;
		}
	}
	
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		// If at the player lands on the whirlpool
		if(playerLocation == this.getLocation()) {
			// Check which location they are at...
			// If at the first whirlpool, jump forward
			// Else jump back
			if (playerLocation == locations[0] && moved == false) {
				moved = true; 
				return InteractionResult.WARPF;	
			} else if (moved == false) {
				moved = true; 
				return InteractionResult.WARPBACK;
			}
		}
		moved = false; 
		return InteractionResult.NONE;
	}
	

}