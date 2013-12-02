package Pieces;

public class Dragon extends Piece
{
	public Dragon(int x, int y, int width, int height, boolean white)
	{
		super("assets/BlackDragon.png", x, y, width, height, 4, 1, 8, white);
		
		if(white)
			setImageString("assets/WhiteDragon.png");
	}
}
