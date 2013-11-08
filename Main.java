import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;

public class Main
{

	public static void main(String[] args)
	{
		JFrame w = new JFrame("Cyvasse");
		w.setBounds(0, 0, 800, 800);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setResizable(true);
		Container c = w.getContentPane();
		MainPanel panel = new MainPanel();
		panel.setBackground(Color.WHITE);
		c.add(panel);
		w.setVisible(true);
		panel.act();
	}

}
