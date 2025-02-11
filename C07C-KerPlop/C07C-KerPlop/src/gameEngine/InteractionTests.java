import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GamePieceInteractionTests {
    private Drawable[] gameBoard;
    private Player player;

    @BeforeEach
    void setUp() {
        gameBoard = new Drawable[GameEngine.BOARD_SIZE];
        player = new Player(10, 3); // Player starts at position 10 with 3 health
    }

    @Test
    void testSharkInteraction() {
        Shark shark = new Shark(9);
        gameBoard[9] = shark;

        assertEquals(InteractionResult.HIT, shark.interact(gameBoard, 10));
        player.reduceHealth(1);
        assertEquals(2, player.getHealth());

        assertEquals(InteractionResult.NONE, shark.interact(gameBoard, 7));
        assertEquals(InteractionResult.NONE, shark.interact(gameBoard, 12));
    }

    @Test
    void testSeaMineInteraction() {
        SeaMine mine = new SeaMine(10);
        gameBoard[10] = mine;

        assertEquals(InteractionResult.HIT, mine.interact(gameBoard, 10));
        player.reduceHealth(player.getHealth());
        assertEquals(0, player.getHealth());
    }

    @Test
    void testJellyfishInteraction() {
        Jellyfish jelly = new Jellyfish(11);
        gameBoard[11] = jelly;

        assertEquals(InteractionResult.HIT, jelly.interact(gameBoard, 10));
        player.reduceHealth(1);
        assertEquals(2, player.getHealth());

        assertEquals(InteractionResult.NONE, jelly.interact(gameBoard, 8));
        assertEquals(InteractionResult.NONE, jelly.interact(gameBoard, 12));
    }

    @Test
    void testCoinPickup() {
        Coin coin = new Coin(10);
        gameBoard[10] = coin;

        assertEquals(InteractionResult.PICKUP, coin.interact(gameBoard, 10));
        player.increaseScore(1);
        assertEquals(1, player.getScore());
    }

    @Test
    void testTreasureChest() {
        TreasureChest chest = new TreasureChest(10);
        gameBoard[10] = chest;

        assertEquals(InteractionResult.NEXT_LEVEL, chest.interact(gameBoard, 10));
    }

    @Test
    void testWhirlpool() {
        Whirlpool whirlpool1 = new Whirlpool(5, 20);
        Whirlpool whirlpool2 = new Whirlpool(20, 5);
        gameBoard[5] = whirlpool1;
        gameBoard[20] = whirlpool2;

        assertEquals(InteractionResult.TELEPORT, whirlpool1.interact(gameBoard, 5));
        player.setPosition(20);
        assertEquals(20, player.getPosition());
    }
}
