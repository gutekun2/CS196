package Pieces;

public class Trebuchet extends Piece
{
	public Trebuchet(int x, int y, int width, int height, boolean white)
	{
		super("assets/BlackTrebuchet.png", x, y, width, height, 1, 3, 7, white);
		
		if(white)
			setImageString("assets/WhiteTrebuchet.png");
	}
}
