public class Board {
	// I'm not sure if height and width need to be switched around here. 
	private Tile[][] tiles = new Tile[GamePanel.NUM_TILES_HEIGHT][GamePanel.NUM_TILES_WIDTH];
	private int numSquares = GamePanel.NUM_TILES_HEIGHT * GamePanel.NUM_TILES_WIDTH;
	
	public Tile getTile(int x, int y)
	{
		return this.tiles[x][y];
	}
	public Piece getPieceAtLocation(int x, int y)
	{
		return this.tiles[x][y].getPieceOnTile();
	}
	public int getNumSquares()
	{
		return this.numSquares;
	}
	
	public void addTile(Tile newTile, int x, int y)
	{
		this.tiles[x][y] = newTile;
		newTile.setX(x);
		newTile.setY(y);
	}
		
}
