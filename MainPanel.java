import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JPanel;


public class MainPanel extends JPanel
{
	private GamePanel gamePanel;
	private ControlPanel controlPanel;
	
	public MainPanel()
	{
		gamePanel = new GamePanel();
		controlPanel = new ControlPanel(gamePanel);
		
		setLayout(new BorderLayout());
		
		add(gamePanel, BorderLayout.CENTER);
		add(controlPanel, BorderLayout.SOUTH);
	}
	
	public void paintComponent(Graphics g)
	{
		draw(g);
	}
	
	public void draw(Graphics g)
	{
		gamePanel.draw(g);
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
}
