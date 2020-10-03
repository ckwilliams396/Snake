import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * 
 * @author ckwilliams396
 * This class encapsulates some of the basic functions of the rectangle class such as setLocation 
 * and drawing the rectangle for easy use in a snake game.
 */
public class Bait {
	public Rectangle pos;
	private final int baitSize = 20;
	
	/**
	 * Creates a rectangle at position x and y with a width and height of 20.
	 * @param x The x position of the rectangle.
	 * @param y The y position of the rectangle.
	 */
	public Bait(int x, int y){
		pos = new Rectangle(x,y,baitSize,baitSize);
	}
	
	/**
	 * Moves the rectangle to the new x and y position.
	 * @param x The new x position of the rectangle.
	 * @param y The new y position of the rectangle.
	 */
	public void moveBait(int x, int y){
		pos.setLocation(x, y);
	}
	
	/**
	 * returns the size of the bait
	 * @return size of the bait
	 */
	public int getBaitSize(){
		return baitSize;
	}
	
	/**
	 * Draws the rectangle.
	 * @param g A Graphics object used for drawing. 
	 */
	public void draw(Graphics g){
		Graphics2D g1 = (Graphics2D)g;
		g1.fill(pos);
	}

	
}
