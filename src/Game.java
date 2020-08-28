import javax.swing.JOptionPane;

public class Game {
	
	public Snake snake;
	public Bait bait; //Redo with random int to start randomly

	
	public Game(){
		snake = new Snake(400,400);
		bait = new Bait(50, 50);
	}
	

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
	
	public void showGameOverMessage(){
		JOptionPane.showMessageDialog(null,"Game Over", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void moveBait(int x, int y){
		System.out.println("("+x+" ,"+y+" )");
		bait.moveBait(x, y);
	}
	
	public void grow(int x, int y){
		snake.grow(x, y);
	}
	
}
