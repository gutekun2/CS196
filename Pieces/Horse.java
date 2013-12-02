package Pieces;

public class Horse extends Piece
{
	public Horse(int x, int y, int width, int height, boolean white)
	{
		super("assets/BlackHorse.png", x, y, width, height, 3, 0, 4, white);
		
		if(white)
			setImageString("assets/WhiteHorse.png");
	}
}
