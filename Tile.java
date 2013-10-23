import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;

public class Tile 
{
	private int x, y;
	private int width, height;
	private boolean isSelected;
	private Piece pieceOnTile;
	
	public Tile (int start_x, int start_y, int startWidth, int startHeight, boolean startSelected)
	{
		x = start_x;
		y = start_y;
		width = startWidth;
		height = startHeight;
		isSelected = startSelected;
	}
	
	// Getters
	public int get_x_position()
	{
		return this.x;
	}
	public int get_y_position()
	{
		return this.y;
	}
	public int get_width()
	{
		return this.width;
	}
	public int get_height()
	{
		return this.height;
	}
	public boolean get_selected()
	{
		return this.isSelected;
	}
	public Piece getPieceOnTile()
	{
		return this.pieceOnTile;
	}
	
	// Setters
	public void setX(int x)
	{
		this.x = x;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public void setHeight(int height)
	{
		this.height = height;
	}
	public void setWidth(int width)
	{
		this.width = width;
	}
	public void setIsSelected(boolean isSelected)
	{
		this.isSelected = isSelected;
	}
	
	public void addPawn()
	{
		pieceOnTile = new Pawn(x+width/4, y+height/4, width/2, height/2);
	}
	
	public boolean isIn(int xPoint, int yPoint)
	{
		return (xPoint > x)&&(xPoint < x + width)&&(yPoint > y) && (yPoint < y + height);
	}
	
	// Draw method
	public void draw(Graphics g, ImageObserver io)
	{
		if(isSelected)
		{
			g.setColor(Color.GREEN);
			g.fillRect(this.x, this.y, width, height);
		}
		else
		{
			g.setColor(Color.BLACK);
			g.fillRect(this.x, this.y, width, height);
		}
		if(pieceOnTile!=null)
			pieceOnTile.draw(g, io);
	}
	
}

