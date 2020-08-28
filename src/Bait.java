import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Bait {
	public Rectangle pos;
	
	public Bait(int x, int y){
		pos = new Rectangle(x,y,20,20);
	}
	
	public void moveBait(int x, int y){
		pos.setLocation(x, y);
	}
	
	public void draw(Graphics g){
		Graphics2D g1 = (Graphics2D)g;
		g1.fill(pos);
	}
	
}
