import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;

public class Main
{

	public static void main(String[] args)
	{
		JFrame w = new JFrame("DGTD");
		w.setBounds(0, 0, 800, 800);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setResizable(true);
		Container c = w.getContentPane();
		GamePanel panel = new GamePanel(c.getHeight(), c.getWidth());
		panel.setBackground(Color.WHITE);
		c.add(panel);
		w.setVisible(true);
		panel.act();
	}

}
