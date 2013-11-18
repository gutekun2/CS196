import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class ControlPanel extends JPanel
{
	private JButton nextPhase;
	private GamePanel gamePanel;
	public ControlPanel(GamePanel p)
	{
		nextPhase = new JButton("Next Phase");
		nextPhase.setActionCommand("nextPhase");
		nextPhase.addActionListener(new ButtonListener());
		
		
		add(nextPhase);
		gamePanel = p;
	}
	
	class ButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			String command = arg0.getActionCommand();
			if(command.equals(nextPhase.getActionCommand()))
				gamePanel.setPhase(gamePanel.getPhase()+1);
		}
		
	}
}
