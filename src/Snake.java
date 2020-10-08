import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
/**
 * 
 * @author ckwilliams396
 * The Snake class is designed as part of the Snake game. It handles the length of the snake. 
 * The body of the snake is an ArrayList of Rectangle objects. 
 */
public class Snake {

	public ArrayList<Rectangle> body = new ArrayList<>();
	private final int scaleSize = 20;  
	
	/**
	 * Creates a new snake object with the head at position x and y.
	 * @param x The X coordinate of the head of the snake.
	 * @param y The Y coordinate of the head of the snake.
	 */
	public Snake(int x, int y){
		for(int i = 0; i < 80; i++){
			body.add(new Rectangle(x,y+i,scaleSize,scaleSize));
		}
	}
	
	/**
	 * Increases the number of rectangles in the snake's body by one at the position (x,y).
	 * @param x The X coordinate of the last rectangle in the body ArrayList.
	 * @param y The Y coordinate of the last rectangle in the body ArrayList.
	 */	
	public void grow(int x, int y){
		int end = body.size()-1;
		if(body.get(end-1).x == x+1){
			body.add(new Rectangle(x-1,y,scaleSize,scaleSize));
		}else if(body.get(end-1).x == x-1){
			body.add(new Rectangle(x+1,y,scaleSize,scaleSize));
		}else if(body.get(end-1).y == y+1){
			body.add(new Rectangle(x,y-1,scaleSize,scaleSize));
		}else{
			body.add(new Rectangle(x,y+1,scaleSize,scaleSize));
		}
	}
	
	/**
	 * Draws all the rectangles in the body ArrayList.
	 * @param g Graphics object for drawing.
	 */
	public void draw(Graphics g){
		Graphics2D g1 = (Graphics2D)g;
		for(int i = 0; i < body.size() - 1; i++){
			g1.fill(body.get(i));
		}
	}
	
	public int getScaleSize(){
		return scaleSize;
	}

	
}
