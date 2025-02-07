<<<<<<< HEAD
package levelPieces;

import java.util.Random;

import gameEngine.GameEngine;
import gameEngine.Drawable;
import gameEngine.Moveable;
import gameEngine.InteractionResult;
=======
package levelPieces

import gameEngine.Drawable;
>>>>>>> branch 'master' of https://github.com/gdematta/C07

public class Fish extends GamePiece implements Moveable {
<<<<<<< HEAD
	
	// Constructor for Fish
=======

// Constructor for Fish
>>>>>>> branch 'master' of https://github.com/gdematta/C07
	public Fish(char symbol, String label, int location) {
		super(symbol, label, location);
	}
	
	public void move(Drawable[] gameBoard, int playerLocation) {
<<<<<<< HEAD
		int init = this.getLocation();
		Random random = new Random();
		int randomNumber = random.nextInt(4 + 4) - 4 + this.getLocation();
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
=======
			
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
	
	public InteractionResult interact() {
			return InteractionResult.NONE;
		}
>>>>>>> branch 'master' of https://github.com/gdematta/C07
}