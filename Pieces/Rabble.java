package Pieces;

public class Rabble extends Piece
{
	public Rabble(int x, int y, int width, int height, boolean white)
	{
		super("assets/BlackRabble.png", x, y, width, height, 1, 0, 1, white);
		
		if(white)
			setImageString("assets/WhiteRabble.png");
	}
}
