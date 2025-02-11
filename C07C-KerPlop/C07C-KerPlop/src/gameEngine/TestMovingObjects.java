package gameEngine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import levelPieces.Coral;
import levelPieces.Fish;
import levelPieces.Shark;

class TestMovingObjects {

	
	/*
	 * Testing procedure:
	 * This test should validate that the fish can randomly move to an open space
	 * Make a new game board and completely fill it except for a few spaces.
	 * Add a fish (moves randomly)
	 * Simulate a turn by moving a few hundred times and count the squares it goes to
	 * If it moves out of bounds or onto another piece, send a failure
	 * Assert that each valid space has been visited at least once after the simulation
	 */
	@Test
	void testFish() {
			Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
			
			//Fill the board with spaces so the fish can't move to these
			for (int i = 0; i< 21; i++) {
				gameBoard[i] = new Coral('C', "Coral", i);
			}
			
			// Make a fish to test
			Fish fish = new Fish('<', "Fish", 7);
			
			gameBoard[7] = fish;
			//System.out.println(fish.getLocation());
			// Add some empty spaces the fish can move to
			gameBoard[0] = null;
			gameBoard[3] = null;
			gameBoard[6] = null;
			gameBoard[9] = null;
			gameBoard[12] = null;
			
			//make counters for the empty spaces
			int count7 = 0;
			int count0 = 0;
			int count3 = 0;
			int count6 = 0;
			int count9 = 0;
			int count12 = 0;
			
			// Loop a bunch of times to test the locations. Each spaces should be visited at least once
			for(int i = 0; i < 200; i++) {
				fish.move(gameBoard, 0); // assume the player is at space 0
				int l = fish.getLocation();
				
				//bounds check
				if(l < 0 || l > 20) {
					fail("Fish moved outside the board!");
				}
				
				if(l != 0 && l != 3 && l != 7 && l != 6 && l != 9 && l != 12) {
					fail("Fish moved to an occupied space!");
				}
				
				if (l == 7) count7++;
				if (l == 0) count0++;
				if (l == 3) count3++;
				if (l == 6) count6++;
				if (l == 9) count9++;
				if (l == 12) count12++;
			}
			
			//Check if each one of the spaces has been visited at least once
			assert(count7 > 1);
			assert(count0 > 1);
			assert(count3 > 1);
			assert(count6 > 1);
			assert(count9 > 1);
			assert(count12 > 1);
		}

	
	/*
	 * Testing procedure:
	 * This test should validate that the shark moves correctly back and forth without entering another occupied space
	 * Make a new game board and fill with opposite spaces (shark moves 2 spaces at a time)
	 * Add a shark
	 * Simulate turns by moving a few times back and forth.
	 * If it moves out of bounds or onto another piece, send a failure
	 * Assert that each valid space has been visited at least once after the simulation
	 */
	@Test
	void testShark() {
		Drawable [] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		
		//Fill the board with opposite spaces so the shark can move between them.
		for (int i = 0; i< 21; i+=2) {
			gameBoard[i] = new Coral('C', "Coral", i);
		}
		
		// Make the shark
		Shark shark1 = new Shark('^', "Shark", 1);
		gameBoard[1] = shark1;
		
		// Add counters
		int count1 = 0;
		int count3 = 0;
		int count5 = 0;
		int count7 = 0;
		int count9 = 0;
		int count11 = 0;
		int count13 = 0;
		int count15 = 0;
		int count17 = 0;
		int count19 = 0;
		
		// Loop a bunch of times to test the locations. Each valid space should be visited at least once
		for(int i = 0; i < 200; i++) {
			shark1.move(gameBoard, 0); // assume the player is at space 0, does not matter for this test
			int l = shark1.getLocation();
			
			//bounds check
			if(l < 0 || l > 20) {
				fail("Shark moved outside the board!");
			}
			
			// Valid space check
			if(l != 0 && l % 2 == 0) {
				fail("Shark moved to an occupied space!");
			}
			
			// Increment the respective counter
			if (l == 1) count1++;
			if (l == 3) count3++;
			if (l == 5) count5++;
			if (l == 7) count7++;
			if (l == 9) count9++;
			if (l == 11) count11++;
			if (l == 13) count13++;
			if (l == 15) count15++;
			if (l == 17) count17++;
			if (l == 19) count19++;
		}
		// Assert that every valid space has been visited by the end of the simulation
		assert(count1 > 1);
		assert(count3 > 1);
		assert(count5 > 1);
		assert(count7 > 1);
		assert(count9 > 1);
		assert(count11 > 1);
		assert(count13 > 1);
		assert(count15 > 1);
		assert(count17 > 1);
		assert(count19 > 1);
	}
	
}
