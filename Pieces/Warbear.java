package Pieces;

public class Warbear extends Piece
{
	public Warbear(int x, int y, int width, int height, boolean white)
	{
		super("assets/BlackWarbear.png", x, y, width, height, 1, 0, 5, white);
		
		if(white)
			setImageString("assets/WhiteWarbear.png");
	}
}
