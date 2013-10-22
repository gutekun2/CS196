import java.awt.Color;
import java.awt.Graphics;

public class Tile 
{
	private int x_position, y_position;
	private int width, height;
	private boolean isSelected;
	private Piece pieceOnTile;
	
	public Tile (int start_x, int start_y, int startWidth, int startHeight, boolean startSelected)
	{
		x_position = start_x;
		y_position = start_y;
		width = startWidth;
		height = startHeight;
		isSelected = startSelected;
	}
	
	// Getters
	public int get_x_position()
	{
		return this.x_position;
	}
	public int get_y_position()
	{
		return this.y_position;
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
	public void set_x_position(int x_position)
	{
		this.x_position = x_position;
	}
	public void set_y_position(int y_position)
	{
		this.y_position = y_position;
	}
	public void set_height(int height)
	{
		this.height = height;
	}
	public void set_width(int width)
	{
		this.width = width;
	}
	public void set_selection(boolean isSelected)
	{
		this.isSelected = isSelected;
	}
	
	public boolean isIn(int x, int y)
	{
		return (x > x_position)&&(x < x_position + width)&&(y > y_position) && (y < y_position + height);
	}
	
	// Draw method
	public void draw(Graphics g)
	{
		if(isSelected)
		{
			g.setColor(Color.GREEN);
			g.fillRect(this.x_position, this.y_position, width, height);
		}
		else
		{
			g.setColor(Color.BLACK);
			g.fillRect(this.x_position, this.y_position, width, height);
		}
	}
	
}

