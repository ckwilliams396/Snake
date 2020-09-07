import javax.swing.JOptionPane;

/**
 * 
 * @author ckwilliams396
 * This class contains the game logic for the Snake game such as when when a game over occurs. Also handles the instantiation of a snake and bait object. 
 */
public class Game {
	
	public Snake snake;
	public Bait bait; //Redo with random int to start randomly

	/**
	 * Creates a new instance of snake and bait.
	 */
	public Game(){
		snake = new Snake(400,400);
		bait = new Bait(400, 350);
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
	public boolean checkForGameOver(Direction prev, Direction curr, int w, int h){
		boolean gameover = false;
		if(prev == Direction.UP && curr == Direction.DOWN){
			gameover = true;
		}else if(prev == Direction.DOWN && curr == Direction.UP){
			gameover = true;
		}else if(prev == Direction.RIGHT && curr == Direction.LEFT){
			gameover = true;
		}else if( prev == Direction.LEFT && curr == Direction.RIGHT){
			gameover = true;
		}
		if(snake.body.get(0).y < 0 || snake.body.get(0).y+20 > h){
			return true;
		}else if(snake.body.get(0).x < 0 || snake.body.get(0).x+20 > w){
			return true;
		}
		for(int i = 1; i < snake.body.size() - 1; i++){
			//TODO if the head is equal to any part of the body return true
			//then break
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
		bait.moveBait(x, y);
	}
	
	/**
	 * Calls the grow method in the Snake class.
	 */
	public void grow(){
		int end = snake.body.size() - 1;
		snake.grow(snake.body.get(end).x, snake.body.get(end).y);
	}
	
}
