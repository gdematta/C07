package levelPieces;
import gameEngine.Drawable;

// Coral does not move and does not interact with the player

public class Coral implements Drawable {
	
	// No inherited constructor, just add the symbol
	public char symbol;
	public String label;
	public int location;
	
	public Coral(char symbol, String label, int location) {
		this.symbol = symbol;
		this.label = label;
		this.location = location;
	}
	public void draw() {
		System.out.print(symbol);
	}
	
}