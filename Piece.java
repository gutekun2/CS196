import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;

public abstract class Piece {
	private Image image;
	
	int x,y,width,height,moveRange,attackRange;
	
	public Piece()
	{
		image=null;
		x=0;
		y=0;
		width=0;
		height=0;
	}
	
	public Piece(String imageName, int x, int y, int width, int height, int moveRange, int attackRange)
	{
		setImageString(imageName);
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.moveRange=moveRange;
		this.attackRange=attackRange;
	}
	
	public void setImageString(String filename)
	{
		image = (new ImageIcon(filename)).getImage();
	}
	
	public void draw(Graphics g, ImageObserver io)
	{
		g.drawImage(image, x, y, width, height, io);
	}
	
	public int getMoveRange()
	{
		return moveRange;
	}
	
	public int getAttackRange()
	{
		return attackRange;
	}
}
