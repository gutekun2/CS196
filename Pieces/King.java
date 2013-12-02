package Pieces;

public class King extends Piece
{
	public King(int x, int y, int width, int height, boolean white)
	{
		super("assets/BlackKing.png", x, y, width, height, 1, 0, 9, white);
		
		if(white)
			setImageString("assets/WhiteKing.png");
	}
}
