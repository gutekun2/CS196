import java.awt.Color;
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
		gameBoard = new Board(getWidth()/16, getHeight()/16,getWidth()/8*7,getHeight()/8*7);
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
	}
	
	public void setPhase(int phase)
	{
		currentPhase=phase;
		gameBoard.setPhase(phase);
	}
	
	public int getPhase()
	{
		return currentPhase;
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
