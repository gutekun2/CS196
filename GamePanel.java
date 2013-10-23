import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements MouseListener
{
	//public static int ASSUMED_HEIGHT = 480;
	//public static int ASSUMED_WIDTH = 640;
	public static final int NUM_TILES_HEIGHT = 9;
	public static final int NUM_TILES_WIDTH = 9;
	private Tile[][] tiles;
	
	public GamePanel(int height, int width)
	{
		super();
		addMouseListener(this);
		
		tiles = new Tile[NUM_TILES_WIDTH][NUM_TILES_HEIGHT];
		
		double tileHeight = height / (NUM_TILES_HEIGHT * 1.0 + 2);
		double tileWidth = width / (NUM_TILES_WIDTH * 1.0 + 2);
		
		
		
		for(int i = 0; i < NUM_TILES_WIDTH; i++)
		{
			for(int j = 0; j < NUM_TILES_HEIGHT; j++)
			{
				tiles[i][j] = (new Tile((int)(tileWidth + (i * tileWidth)) , (int)(tileHeight + (j * tileHeight)) , (int)tileWidth, (int)tileHeight, false));
				if(i==3&&j==3);
					tiles[i][j].addPawn();
			}
		}
	}
	
	public void paint(Graphics g)
	{
		draw(g);
	}
	
	public void draw(Graphics g)
	{
		for(int i = 0; i < NUM_TILES_WIDTH; i++)
		{
			for(int j = 0; j < NUM_TILES_HEIGHT; j++)
			{
				Tile t = tiles[i][j];
				t.draw(g,this);
				g.setColor(Color.WHITE);
				g.drawRect(t.get_x_position(), t.get_y_position(), t.get_width(), t.get_height());
			}
		}
	}
	
	public void act()
	{
		while(true)
		{
			long startTime=System.currentTimeMillis();
			
			repaint();
			
			long endTime=System.currentTimeMillis();
		  	try
		  	{
		  		long t=20-(endTime-startTime);
		  		
		  		if(t>0)
		  			Thread.sleep(t);
		  		else
		  			Thread.yield();
		  	} 
		  	catch (InterruptedException e) {}
		}
	}

	
	
	
	public void mouseClicked(MouseEvent arg0)
	{
		int x = arg0.getX();
		int y = arg0.getY();
		
		for(int i = 0; i < NUM_TILES_WIDTH; i++)
		{
			for(int j = 0; j < NUM_TILES_HEIGHT; j++)
			{
				if(tiles[i][j].isIn(x,y))
					tiles[i][j].setIsSelected(!tiles[i][j].get_selected());
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
