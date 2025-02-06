package levelPieces;

import gameEngine.Drawable;
import gameEngine.Moveable;
import java.util.ArrayList;

public class LevelSetup {
	
	//Stores the current game board
	public int playerStart;
	public Drawable[] level;
	public ArrayList<Moveable> movingPieces;
	public ArrayList<GamePiece> gamePieces;
	
	// Creates a level based on the input number 
	public void createLevel(int levelNum) {
		// If level 1 chosen
		if (levelNum == 1) {
			//board size 21
			level = new Drawable[21];
			movingPieces = new ArrayList<Moveable>();
			gamePieces = new ArrayList<GamePiece>();
			
			level[3] = new Coral('C', "Coral", 3);
			
			gamePieces.add(new Coin('*', "Coin", 8));
			level[8] = gamePieces.get(0);
			
			gamePieces.add(new Jellyfish('J', "Jelly", 20));
			level[20] = gamePieces.get(1);
			
			gamePieces.add(new SeaMine('M', "Mine", 4));
			level[4] = gamePieces.get(2);
			
			// Only 2 Whirlpools.
			gamePieces.add(new Whirlpool('@', "Whirlpool", 1));
			level[1] = gamePieces.get(3);
			
			gamePieces.add(new Whirlpool('@', "Whirlpool", 11));
			level[11] = gamePieces.get(4);
			
			gamePieces.add(new TreasureChest('$', "TreasureChest", 13));
			level[13] = gamePieces.get(5);
			
			Shark shark1 = new Shark('^', "Shark", 16);
			//gamePieces.add(shark1);
			movingPieces.add(shark1);
			level[16] = shark1;
			
			playerStart = 0;
			//add game pieces
			
		//If level 2 chosen
		} else if (levelNum == 2) {
			//board size 29
			this.level = new Drawable[21];
			this.movingPieces = new ArrayList<Moveable>();
			this.gamePieces = new ArrayList<GamePiece>();
			//Player starting position
			gamePieces.add(new Whirlpool('@', "Whirlpool", 1));
			level[1] = gamePieces.get(0);
			
			gamePieces.add(new Whirlpool('@', "Whirlpool", 11));
			level[11] = gamePieces.get(1);
			playerStart = 0;
			//add game pieces
		}
		return;
	}
	
	// Returns the current game board
	public Drawable[] getBoard() {
		return this.level;
	}
	
	// Returns the list of moveable pieces in the level
	public ArrayList<Moveable> getMovingPieces() {
		return this.movingPieces;
	}
	
	// Returns the list of interactable pieces in the level
	public ArrayList<GamePiece> getInteractingPieces() {
		return this.gamePieces;
	}
	
	// Returns the player's starting location for the level
	public int getPlayerStartLoc() {
		return playerStart;
	}
	
	
	
}

