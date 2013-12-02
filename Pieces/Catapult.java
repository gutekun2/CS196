package Pieces;

public class Catapult extends Piece
{
	public Catapult(int x, int y, int width, int height, boolean white)
	{
		super("assets/BlackCatapult.png", x, y, width, height, 1, 2, 6, white);
		
		if(white)
			setImageString("assets/WhiteCatapult.png");
	}
}
