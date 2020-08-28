import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Snake {

	public ArrayList<Rectangle> body = new ArrayList<>();
	private Direction direction = Direction.UP;
	
	
	public Snake(int x, int y){
		for(int i = 0; i < 80; i++){
			body.add(new Rectangle(x,y+i,20,20));
		}
	}
	
//gets the second from the last rect in the body. keeps getting out of bounds exception...	
	public void grow(int x, int y){
		int end = body.size()-1;
		if(body.get(end-2).x == x+1){
			body.add(new Rectangle(x-1,y,20,20));
		}else if(body.get(end-2).x == x-1){
			body.add(new Rectangle(x+1,y,20,20));
		}else if(body.get(end-2).y == y+1){
			body.add(new Rectangle(x,y-1,20,20));
		}else{
			body.add(new Rectangle(x,y+1,20,20));
		}
		System.out.println(body.size());
	}
	
	public void draw(Graphics g){
		Graphics2D g1 = (Graphics2D)g;
		for(int i = 0; i < body.size() - 1; i++){
			g1.fill(body.get(i));
		}
	}
	
	public void setDirection(Direction d){
		direction = d;
	}
	
	public Direction getDirection(){
		return direction;
	}
	
	
	public String toString(Point p){
		return "("+p.x+" , "+ p.y+")";
	}
}
