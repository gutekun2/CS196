import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

public class Board
{
	private int x, y;
	private int width, height;
	private int currentPhase;
	private ArrayList<Tile> validMoveLocations, validAttackLocations;
	private Tile currentlySelected;
	private Tile[][] tiles;
	
	public Board(int x, int y, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.x=x;
		this.y=y;
		currentPhase = 0;
		validMoveLocations = new ArrayList<Tile>();
		validAttackLocations = new ArrayList<Tile>();
		currentlySelected = null;
		tiles = new Tile[8][8];
		double tileHeight = height / (tiles[0].length * 1.0);
		double tileWidth = width / (tiles.length * 1.0);
		
		
		for(int i = 0; i < tiles.length; i++)
		{
			for(int j = 0; j < tiles[i].length; j++)
			{
				tiles[i][j] = new Tile((int)(i * tileWidth) + x , (int)(j * tileHeight) + y , (int)tileWidth, (int)tileHeight, i, j);
			}
		}
	}
	
	public void draw(Graphics g, ImageObserver io)
	{
		for(int i = 0; i < tiles.length; i++)
		{
			for(int j = 0; j < tiles[i].length; j++)
			{
				Tile t = tiles[i][j];
				t.draw(g,io);
				
				if(t.getSelected())
					g.setColor(Color.MAGENTA);
				else if(validMoveLocations.contains(t))
					g.setColor(Color.CYAN);
				else
					g.setColor(Color.WHITE);
				
				g.drawRect(t.getX(), t.getY(), t.getWidth(), t.getHeight());
			}
		}
	}
	
	public void update(int x, int y, int width, int height)
	{
		this.x=x;
		this.y=y;
		this.width = width;
		this.height = height;
		double tileHeight = height / (tiles[0].length * 1.0);
		double tileWidth = width / (tiles.length * 1.0);	
		for(int i = 0; i < tiles.length; i++)
		{
			for(int j = 0; j < tiles[i].length; j++)
			{
				Tile t = tiles[i][j]; 
				t.setX((int)(i*tileWidth)+x);
				t.setY((int)(j*tileHeight)+y);
				t.setWidth((int)(tileWidth));
				t.setHeight((int)(tileHeight));
			}
		}
	}
	
	public void clicked(int x, int y, boolean leftClick)
	{
		int i = x/(width/8);
		int j = y/(height/8);
		Tile t = tiles[i][j];
		
		if(currentPhase == 1 || currentPhase == 2)
		{
			if(!t.getHidden())
			{
				if(leftClick)
				{
					t.nextType();
				}
				else
				{
					if(currentPhase == 1)
						t.nextPiece(true);
					else
						t.nextPiece(false);
				}
			}
		}
		if(currentPhase == 3) //White select phase
		{
			if(t.getSelected())
			{
				t.setSelected(false);
				validMoveLocations = new ArrayList<Tile>();
				currentlySelected = null;
			}
			else
			{
				deselectAll();
				t.setSelected(true);
				if(t.getPieceOnTile() != null && t.getPieceOnTile().getWhite()){
					validMoveLocations = getValidMoveLocations(t.getGridX(), t.getGridY(),t.getPieceOnTile().getMoveRange());
					currentlySelected = t;
					
				}
			}
		}
		if(currentPhase == 4) //White move phase
		{
			if(validMoveLocations.contains(t))
			{
				t.addPiece(currentlySelected.getPieceOnTile().getValue(), true);
				currentlySelected.removePiece();
				currentlySelected.setSelected(false);
				t.setSelected(true);
				currentlySelected = t;
				validMoveLocations = new ArrayList<Tile>();
				currentPhase++;
			}
		}
		
	}
	
	public ArrayList<Tile> getValidMoveLocations(int x, int y, int range)
	{
		ArrayList<Tile> validLocations = new ArrayList<Tile>();
		ArrayList<Tile> temp = new ArrayList<Tile>();
		
		
		if(range !=0)
			validLocations = getValidAdjacentMoveTiles(x,y,true);
		range--;
		
		
		while(range > 0)
		{
			int size = validLocations.size();
			for(int i = 0; i<size; i++)
			{
				Tile t = validLocations.get(i);
				temp = getValidAdjacentMoveTiles(t.getGridX(), t.getGridY(), false);
				
				
				for(int j = 0; j<temp.size(); j++)
				{
					if(!validLocations.contains(temp.get(j)))
						validLocations.add(temp.get(j));
				}
			}
			range--;
		}
		return validLocations;
	}

	private ArrayList<Tile> getValidAdjacentMoveTiles(int x, int y, boolean ignoreWater)
	{
		ArrayList<Tile> adjacent = new ArrayList<Tile>();
		
		if(tiles[x][y].getType() != 2 || ignoreWater)
		{
			if(x+1 < tiles.length && tiles[x+1][y].getType() != 1)
				adjacent.add(tiles[x+1][y]);
			if(x-1 >= 0 && tiles[x-1][y].getType() != 1)
				adjacent.add(tiles[x-1][y]);
			if(y+1 < tiles[x].length && tiles[x][y+1].getType() != 1)
				adjacent.add(tiles[x][y+1]);
			if(y-1 >= 0 && tiles[x][y-1].getType() != 1)
				adjacent.add(tiles[x][y-1]);
		}
		return adjacent;
	}
	
	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}
	
	public int getPhase()
	{
		return currentPhase;
	}
	
	public void setPhase(int phase)
	{
		currentPhase=phase;
		if(phase==1)
		{
			for(int i = 0; i<tiles.length; i++)
			{
				for(int j = 0; j<tiles[i].length/2; j++)
					tiles[i][j].setHidden(true);
			}
		}
		if(phase==2)
		{
			for(int i = 0; i<tiles.length; i++)
			{
				for(int j = 0; j<tiles[i].length; j++)
				{
					if(j<tiles[i].length/2)
						tiles[i][j].setHidden(false);
					else
						tiles[i][j].setHidden(true);
				}
			}
		}
		if(phase>=3)
		{
			for(int i = 0; i<tiles.length; i++)
			{
				for(int j = 0; j<tiles[i].length; j++)
					tiles[i][j].setHidden(false);
			}
		}
	}

	public Tile[][] getTopTiles()
	{
		Tile[][] result = new Tile[tiles.length][tiles[0].length/2];
		for(int i = 0; i<tiles.length; i++)
		{
			for(int j = 0; j<tiles[i].length/2; j++)
			{
				result[i][j] = tiles[i][j];
			}
		}
		return result;
	}

	public Tile[][] getBottomTiles()
	{
		Tile[][] result = new Tile[tiles.length][tiles[0].length/2];
		for(int i = 0; i<tiles.length; i++)
		{
			for(int j = 0; j<tiles[i].length/2; j++)
			{
				result[i][j] = tiles[i][j+tiles[i].length/2];
			}
		}
		return result;
	}

	public int[] getTopTileCount()
	{
		int[] result = new int[7];
		for(int i = 0; i<tiles.length; i++)
		{
			for(int j = 0; j<tiles[i].length/2; j++)
			{
				result[tiles[i][j].getType()]++;
			}
		}
		return result;
	}

	public int[] getBottomTileCount()
	{
		int[] result = new int[7];
		for(int i = 0; i<tiles.length; i++)
		{
			for(int j = tiles[i].length/2; j<tiles[i].length; j++)
			{
				result[tiles[i][j].getType()]++;
			}
		}
		return result;
	}

	public void deselectAll()
	{
		for(int i = 0; i<tiles.length; i++)
			for(int j = 0; j<tiles[i].length; j++)
				tiles[i][j].setSelected(false);
		validMoveLocations = new ArrayList<Tile>();
	}

}
