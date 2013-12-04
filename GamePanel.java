import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements MouseListener
{
	private Board gameBoard;
	private int currentPhase;
	
	public GamePanel()
	{
		super();
		addMouseListener(this);
		gameBoard = new Board(getWidth()/16, getHeight()/16,getWidth()/8*7,getHeight()/8*7,this);
		currentPhase = 0;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		draw(g);
	}
	
	public void draw(Graphics g)
	{
		gameBoard.update(getWidth()/16, getHeight()/16, getWidth()/8*7, getHeight()/8*7);
		gameBoard.draw(g, this);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("MONOSPACED",Font.BOLD,18));
		g.drawString(currentPhase + "", 10, 18);
	}
	
	public void setPhase(int phase)
	{
		//if(canContinue())
		{
			if(phase == 9)
				phase = 3;
			currentPhase=phase;
			gameBoard.setPhase(phase);
		}
	}
	
	public int getPhase()
	{
		return currentPhase;
	}

	public boolean canContinue()
	{
		if(currentPhase==1)
		{
			int[] bot = gameBoard.getBottomTileCount();
			if(bot[1] != 6 || bot[2] != 5 || bot[3] != 6 || bot[4] != 14 || bot[5] != 1)
				return false;
		}
		if(currentPhase==2)
		{
			int[] top = gameBoard.getTopTileCount();
			if(top[1] != 6 || top[2] != 5 || top[3] != 6 || top[4] != 14 || top[5] != 1)
				return false;
		}
		return true;
	}
	
	public void mouseClicked(MouseEvent arg0)
	{
		int x = arg0.getX();
		int y = arg0.getY();
		int gX = gameBoard.getX();
		int gY = gameBoard.getY();
		
		if(x>gX && x<gX + gameBoard.getWidth() && y>gY && y<gY + gameBoard.getHeight())
		{
			gameBoard.clicked(x-gX, y-gY, arg0.getButton()==MouseEvent.BUTTON1);
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
