package Pieces;

public class Spearman extends Piece
{
	public Spearman(int x, int y, int width, int height, boolean white)
	{
		super("assets/BlackSpearman.png", x, y, width, height, 1, 0, 2, white);
		
		if(white)
			setImageString("assets/WhiteSpearman.png");
	}
}
