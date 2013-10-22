public class Piece {
	private Tile currentTile;
	private String type; // This might be unnecessary. Does this belong in the specific piece class instead?
	
	// public Image image --> Not sure if this is how it would be implemented.
	
	public Tile getCurrentTile()
	{
		return this.currentTile;
	}
	public String getType()
	{
		return this.type;
	}
	
}
