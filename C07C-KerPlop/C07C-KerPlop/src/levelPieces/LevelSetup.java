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
		level = new Drawable[21];
		movingPieces = new ArrayList<Moveable>();
		gamePieces = new ArrayList<GamePiece>();
		// If level 1 chosen
		if (levelNum == 1) {
			for (int i = 0; i < 21; i++) {
				level[i] = null;
			}
			movingPieces.clear();
			gamePieces.clear();
			
			level[3] = new Coral('C', "Coral", 3);
			level[15] = new Coral('C', "Coral", 15);
			
			gamePieces.add(new Coin('0', "Coin", 6));
			level[6] = gamePieces.get(0);
			
			gamePieces.add(new Jellyfish('J', "Jelly", 19));
			level[19] = gamePieces.get(1);
			
			gamePieces.add(new SeaMine('M', "Mine", 4));
			level[4] = gamePieces.get(2);
			
			// Only 2 Whirlpools.
			gamePieces.add(new Whirlpool('@', "Whirlpool", 1));
			level[1] = gamePieces.get(3);
			
			gamePieces.add(new Whirlpool('@', "Whirlpool", 11));
			level[11] = gamePieces.get(4);
			
			gamePieces.add(new TreasureChest('$', "TreasureChest", 20));
			level[20] = gamePieces.get(5);
			
			Shark shark1 = new Shark('^', "Shark", 16);
			gamePieces.add(shark1);
			movingPieces.add(shark1);
			level[16] = shark1;
			
			Fish fish1 = new Fish('<', "Fish", 7);
			gamePieces.add(fish1);
			movingPieces.add(fish1);
			level[7] = fish1;
		
			gamePieces.add(new Coin('0', "Coin", 13 ));
			level[13] = gamePieces.get(0);
			
			playerStart = 0;
			//add game pieces
			
		//If level 2 chosen
		} else if (levelNum == 2) {
			
			for (int i = 0; i < 21; i++) {
				level[i] = null;
			}
			movingPieces.clear();
			gamePieces.clear();
			
			//Player starting position
			gamePieces.add(new Whirlpool('@', "Whirlpool", 9));
			level[9] = gamePieces.get(0);
			
			gamePieces.add(new Whirlpool('@', "Whirlpool", 19));
			level[19] = gamePieces.get(1);
			
			level[2] = new Coral('C', "Coral", 2);
			level[8] = new Coral('C', "Coral", 8);
			playerStart = 0;
			
			gamePieces.add(new Jellyfish('J', "Jelly", 17));
			level[17] = gamePieces.get(2);
			
			gamePieces.add(new Jellyfish('J', "Jelly", 5));
			level[5] = gamePieces.get(3);
			
			gamePieces.add(new TreasureChest('$', "TreasureChest", 20 ));
			level[20] = gamePieces.get(4);
			
			gamePieces.add(new Coin('0', "Coin", 10));
			level[10] = gamePieces.get(5);
			
			gamePieces.add(new Coin('0', "Coin", 14));
			level[14] = gamePieces.get(6);
			
			Fish fish1 = new Fish('<', "Fish", 7);
			gamePieces.add(fish1);
			movingPieces.add(fish1);
			level[7] = fish1;
			
			Shark shark1 = new Shark('^', "Shark", 15);
			gamePieces.add(shark1);
			movingPieces.add(shark1);
			level[15] = shark1;
			
			gamePieces.add(new SeaMine('M', "Mine", 2));
			level[2] = gamePieces.get(9);
			
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

