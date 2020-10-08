import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * 
 * @author ckwilliams396
 * This class contains the game logic for the Snake game such as when when a game over occurs. Also handles the instantiation of a snake and bait object. 
 */
public class Game {
	
	public Snake snake;
	public Bait bait; //Redo with random int to start randomly
	public Random rand;
	public final int baitSize;
	private final int scaleSize;
	/**
	 * Creates a new instance of snake and bait.
	 */
	public Game(){
		snake = new Snake(400,400);
		bait = new Bait(300, 300);
		baitSize = bait.getBaitSize();
		scaleSize = snake.getScaleSize();
		rand = new Random();
	}
	
	/**
	 * Logic for determining when a game over occurs. 
	 * Checks for when the direction is suddenly changed in the opposite direction, when the snake leaves the window, and when the snake's head encounters any other part of the body.
	 * @param prev The direction the snake was traveling. 
	 * @param curr The direction the snake is currently traveling.
	 * @param w The width of the window.
	 * @param h The height of the window.
	 * @return Returns a boolean value, true if a game over occurs else returns false.
	 */
	public boolean checkForGameOver(int w, int h){
		boolean gameover = false;
		if(snake.body.get(0).y < 0 || snake.body.get(0).y+scaleSize > h){
			return true;
		}else if(snake.body.get(0).x < 0 || snake.body.get(0).x+scaleSize > w){
			return true;
		}
		for(int i = 40; i < snake.body.size() - 1; i++){
			if(snake.body.get(0).intersects(snake.body.get(i))){
				gameover = true;
				break;
			}
		}
		return gameover;
	}
	
	/**
	 * A JOptionPane that lets the player know a game over has occurred.
	 */
	public void showGameOverMessage(){
		JOptionPane.showMessageDialog(null,"Game Over", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Calls the moveBait method in the Bait class.
	 * @param x The new x coordinate of the bait object.
	 * @param y The new y coordinate of the bait object.
	 */
	public void moveBait(int x, int y){
		//System.out.println("("+x+" ,"+y+" )");
		ArrayList<Rectangle> body = snake.body;
		boolean broke = false;
		for(int i = 0; i < snake.body.size(); i++) {
			if (body.get(i).contains(x,y) || 
					body.get(i).contains(x+baitSize,y+baitSize) ||
					body.get(i).contains(x,y+baitSize) ||
					body.get(i).contains(x+baitSize,y)){
				System.out.println("try again...");
				broke = true;
				break;
			}
		}
		if(broke){
			moveBait(rand.nextInt(560),rand.nextInt(560));
		}else{
			bait.moveBait(x, y);
		}
	}
	
	/**
	 * Calls the grow method in the Snake class.
	 */
	public void grow(){
		int end = snake.body.size() - 1;
		snake.grow(snake.body.get(end).x, snake.body.get(end).y);
	}
	
}
