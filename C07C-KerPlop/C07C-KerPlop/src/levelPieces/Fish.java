package levelPieces

import gameEngine.Drawable;

public class Fish extends GamePiece implements Moveable {

// Constructor for Fish
	public Fish(char symbol, String label, int location) {
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
	
	public InteractionResult interact() {
			return InteractionResult.NONE;
		}
}