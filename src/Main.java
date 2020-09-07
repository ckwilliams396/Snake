import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 * 
 * @author ckwilliams369
 * This is the class that ties all the Snake, Bait, and Game classes together. It is responsible all the UI for the game.
 * It implements an ActionListener to use a time to move the snake. The KeyListener is to control the snake. The MouseListener is to gain focus on the window so the KeyListener will work.
 */
public class Main extends JPanel implements ActionListener, KeyListener, MouseListener{
	
	public Timer timer = new Timer(10, this);
	private Game game = new Game();
	public int velX = 0;
	public int velY = -1;
	private Random rand;

	public Main(){
		rand = new Random();
		addKeyListener(this);
		addMouseListener(this);		
	}
	
	@Override
	public void paintComponent(Graphics g){
		int w = getWidth();
		int h = getHeight();
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, w, h);
		g.setColor(Color.RED);
		game.snake.draw(g);
		g.setColor(Color.BLUE);
		game.bait.draw(g);
	}

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setVisible(true);
		window.setTitle("SNAKE");
		window.setContentPane(new Main());
		window.setSize(600, 600);
		window.setResizable(false);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Direction prevDir = game.snake.getDirection();
		int c = e.getKeyCode();
		if(c == KeyEvent.VK_LEFT){
			velX = -1;
			velY = 0;
			game.snake.setDirection(Direction.LEFT);
		}else if(c == KeyEvent.VK_RIGHT){
			velX = 1;
			velY = 0;
			game.snake.setDirection(Direction.RIGHT);
		}else if(c == KeyEvent.VK_UP){
			velX = 0;
			velY = -1;
			game.snake.setDirection(Direction.UP);
		}else if(c == KeyEvent.VK_DOWN){
			velX = 0;
			velY = 1;
			game.snake.setDirection(Direction.DOWN);
		}
		//TODO figure out how to move the gameover to the actionListener...
		if(game.checkForGameOver(prevDir, game.snake.getDirection(), getWidth(), getHeight())){
			timer.stop();
			game.showGameOverMessage();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = game.snake.body.size()-1; i > 0; i--){
			game.snake.body.get(i).x = game.snake.body.get(i-1).x;
			game.snake.body.get(i).y = game.snake.body.get(i-1).y;
		}
		game.snake.body.get(0).y += velY;
		game.snake.body.get(0).x += velX;
		if(game.snake.body.get(0).intersects(game.bait.pos)){
			for(int i = 0; i < 40; i++){
				game.moveBait(rand.nextInt(560), rand.nextInt(560));
				game.grow();
			}
		}
		repaint();

	}

	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {
		requestFocus();
		if(hasFocus() == true){
			timer.start();
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {}

}
