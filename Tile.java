import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

import Pieces.*;

public class Tile 
{
	private int x, y;
	private int gridX, gridY;
	private int width, height;
	private boolean selected;
	private boolean hidden;
	private int type; //0-Unselected, 1-Mountain, 2-Water, 3-Forest, 4-Grass, 5-Fortress, 6-Broken Fortress
	private Image image;
	private Piece pieceOnTile;
	
	public Tile (int start_x, int start_y, int startWidth, int startHeight, int gridX, int gridY)
	{
		x = start_x;
		y = start_y;
		width = startWidth;
		height = startHeight;
		this.gridX = gridX;
		this.gridY = gridY;
		type = 0;
		selected = false;
	}
	
	// Getters
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public int getHeight()
	{
		return this.height;
	}
	
	public int getGridX()
	{
		return gridX;
	}
	
	public int getGridY()
	{
		return gridY;
	}
	
	public boolean getSelected()
	{
		return this.selected;
	}
	
	public int getType()
	{
		return type;
	}
	
	public Piece getPieceOnTile()
	{
		return this.pieceOnTile;
	}
	
	public boolean getHidden()
	{
		return hidden;
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
	
	public void setSelected(boolean selected)
	{
		this.selected = selected;
	}
	
	public void setHidden(boolean hidden)
	{
		this.hidden = hidden;
	}
	
	public void setPieceOnTile(Piece p)//Don't use this method.
	{
		this.pieceOnTile = p;
	}
	
	public void setImageString(String filename)
	{
		image = (new ImageIcon(filename)).getImage();
	}
	
	public void nextType()
	{
		type++;
		if(type>5)
			type=1;
	}
	
	public void removePiece()
	{
		pieceOnTile = null;
	}
	
	public void addPiece(int choice, boolean white)
	{
		if(choice==1)
			pieceOnTile = new Rabble(x+width/4, y+height/4, width/2, height/2, white);
		if(choice==2)
			pieceOnTile = new Spearman(x+width/4, y+height/4, width/2, height/2, white);
		if(choice==3)
			pieceOnTile = new Crossbowman(x+width/4, y+height/4, width/2, height/2, white);
		if(choice==4)
			pieceOnTile = new Horse(x+width/4, y+height/4, width/2, height/2, white);
		if(choice==5)
			pieceOnTile = new Warbear(x+width/4, y+height/4, width/2, height/2, white);
		if(choice==6)
			pieceOnTile = new Catapult(x+width/4, y+height/4, width/2, height/2, white);
		if(choice==7)
			pieceOnTile = new Trebuchet(x+width/4, y+height/4, width/2, height/2, white);
		if(choice==8)
			pieceOnTile = new Dragon(x+width/4, y+height/4, width/2, height/2, white);
		if(choice==9)
			pieceOnTile = new King(x+width/4, y+height/4, width/2, height/2, white);
	}
	
	public void nextPiece(boolean white)
	{	
		int val = 0;
		if(pieceOnTile != null)
			val = pieceOnTile.getValue();
		if(val==0)
			pieceOnTile = new Rabble(x+width/4, y+height/4, width/2, height/2, white);
		else  if(val==1)
			pieceOnTile = new Spearman(x+width/4, y+height/4, width/2, height/2, white);
		else if(val==2)
			pieceOnTile = new Crossbowman(x+width/4, y+height/4, width/2, height/2, white);
		else if(val==3)
			pieceOnTile = new Horse(x+width/4, y+height/4, width/2, height/2, white);
		else if(val==4)
			pieceOnTile = new Warbear(x+width/4, y+height/4, width/2, height/2, white);
		else if(val==5)
			pieceOnTile = new Catapult(x+width/4, y+height/4, width/2, height/2, white);
		else if(val==6)
			pieceOnTile = new Trebuchet(x+width/4, y+height/4, width/2, height/2, white);
		else if(val==7)
			pieceOnTile = new Dragon(x+width/4, y+height/4, width/2, height/2, white);
		else if(val==8)
			pieceOnTile = new King(x+width/4, y+height/4, width/2, height/2, white);
		else
			pieceOnTile = null;
	}
	
	public boolean isIn(int xPoint, int yPoint)
	{
		return (xPoint > x)&&(xPoint < x + width)&&(yPoint > y) && (yPoint < y + height);
	}
	
	// Draw method
	public void draw(Graphics g, ImageObserver io)
	{		
		switch(type) {
		case 0:
			g.setColor(Color.DARK_GRAY);
			g.fillRect(this.x, this.y, width, height);
			break;
		case 1: 
			setImageString("assets/Mountain.png");
			g.drawImage(image, x, y, width, height, io);
			break;
		case 2:
			setImageString("assets/Water.png");
			g.drawImage(image, x, y, width, height, io);
			break;
		case 3:
			setImageString("assets/Forest.png");
			g.drawImage(image, x, y, width, height, io);
			break;
		case 4:
			setImageString("assets/Grass.png");
			g.drawImage(image, x, y, width, height, io);
			break;
		case 5:
			setImageString("assets/Fortress.png");
			g.drawImage(image, x, y, width, height, io);
			break;
		case 6:
			setImageString("assets/Broken Fortress.png");
			g.drawImage(image, x, y, width, height, io);
			break;
		default:
			g.setColor(Color.BLACK);
			g.fillRect(this.x, this.y, width, height);
			break;
		}
		
		if(hidden)
		{
			g.setColor(Color.BLACK);	
			g.fillRect(this.x, this.y, width, height);
		}
		
		if(pieceOnTile!=null && !hidden)
			pieceOnTile.draw(g, io);
	}
	
}

