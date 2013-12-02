package Pieces;

public class Crossbowman extends Piece
{
	public Crossbowman(int x, int y, int width, int height, boolean white)
	{
		super("assets/BlackCrossbowman.png", x, y, width, height, 1, 1, 3, white);
		
		if(white)
			setImageString("assets/WhiteCrossbowman.png");
	}
}
