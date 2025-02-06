package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

// Jellyfish will sting the player for 1 hit if they are touching its 3 adjacent tiles after 1 turn has passed

public class Jellyfish extends GamePiece {
	
	// Flag to check if the player has been within range for more than one turn
	public boolean Active = false;
	
	// Constructor for Jellyfish
	public Jellyfish(char symbol, String label, int location) {
		super(symbol, label, location);
	}
	
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		// If the flag is marked and the player is still within range, then they will take a hit
		if(Active == true && Math.abs(playerLocation - this.getLocation()) < 2) {
			return InteractionResult.HIT;
		// If the player has been in range for one turn, mark the flag true
		} else if (Math.abs(playerLocation - this.getLocation()) < 2) {
			Active = true;
			System.out.println("\nYou feel like you might get stung...\n"); // Tell the player they will take damage next turn if they are still in range
			return InteractionResult.NONE;
		// Clear the flag if the player leaves the range
		} else {
			Active = false;
			return InteractionResult.NONE;
		}
	}
	
}