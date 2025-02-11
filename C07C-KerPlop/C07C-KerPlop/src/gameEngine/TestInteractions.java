package gameEngine;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import levelPieces.Coin;
import levelPieces.Jellyfish;
import levelPieces.SeaMine;
import levelPieces.Shark;
import levelPieces.TreasureChest;
import levelPieces.Whirlpool;

class TestInteractions {
    private Drawable[] gameBoard;
    
	/*
	 * Testing procedure:
	 * These tests should validate that the correct interaction result occurs with each game piece.
	 */

    @BeforeEach
    void setUp() {
        gameBoard = new Drawable[GameEngine.BOARD_SIZE];
    }

    @Test
    void testSharkInteraction() {
        Shark shark = new Shark('^', "Shark", 9);
        gameBoard[9] = shark;
        
        // Assert that the shark damages the player when in range
        assertEquals(InteractionResult.HIT, shark.interact(gameBoard, 10));

        // The shark should not attack outside its range
        assertEquals(InteractionResult.NONE, shark.interact(gameBoard, 7));
        assertEquals(InteractionResult.NONE, shark.interact(gameBoard, 12));
    }

    @Test
    void testSeaMineInteraction() {
        SeaMine mine = new SeaMine('M', "Mine", 10);
        gameBoard[10] = mine;

        // Assert that the player is killed when on top of the mine
        assertEquals(InteractionResult.KILL, mine.interact(gameBoard, 10));
    }

    @Test
    void testJellyfishInteraction() {
        Jellyfish jelly = new Jellyfish('J', "Jelly", 11);
        gameBoard[11] = jelly;

        // First turn should be a miss.
        assertEquals(InteractionResult.NONE, jelly.interact(gameBoard, 10));
        
        // Second turn should be a hit
        assertEquals(InteractionResult.HIT, jelly.interact(gameBoard, 10));

        // Jellyfish shouldn't attack outside its range
        assertEquals(InteractionResult.NONE, jelly.interact(gameBoard, 8));
        assertEquals(InteractionResult.NONE, jelly.interact(gameBoard, 12));
    }

    @Test
    void testCoinPickup() {
        Coin coin = new Coin('*', "Coin", 10);
        gameBoard[10] = coin;

        // Assert that the coin increases score when the player lands on it
        assertEquals(InteractionResult.GET_POINT, coin.interact(gameBoard, 10));
    }

    @Test
    void testTreasureChest() {
        TreasureChest chest = new TreasureChest('$', "Treasure Chest", 10);
        gameBoard[10] = chest;
        
        // Assert that the player advances when collecting the treasure chest
        assertEquals(InteractionResult.ADVANCE, chest.interact(gameBoard, 10));
    }

    @Test
    void testWhirlpool() {
        Whirlpool whirlpool1 = new Whirlpool('@', "Whirlpool", 10);
        Whirlpool whirlpool2 = new Whirlpool('@', "Whirlpool", 20);
        gameBoard[10] = whirlpool1;
        gameBoard[20] = whirlpool2;

        // Player should warp when interacting with a whirlpool
        assertEquals(InteractionResult.WARPF, whirlpool1.interact(gameBoard, 10));
        
        // Player should not warp when not standing on a whirlpool
        assertEquals(InteractionResult.NONE, whirlpool2.interact(gameBoard, 4));
    }
}
