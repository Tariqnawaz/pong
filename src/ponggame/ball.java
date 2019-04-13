package ponggame;


import java.awt.*;
import java.awt.Rectangle;
import java.util.Random;


public class ball implements Runnable{
static int x,y,xDirection,yDirection;
Rectangle rec;
paddle p = new paddle(15,140,1);
paddle p1 = new paddle(370,140,2);

//for score
int pScore , p1Score;

public ball(int x, int y){
	pScore = p1Score = 0;
	this.x = x;
	this.y = y;
	//set ball moving
	Random r = new Random();
	int rDir = r.nextInt(1);
			if(rDir == 0)
			rDir--;
			setXDirection(rDir);
			int yrDir = r.nextInt(1);
					if(yrDir == 0)
					yrDir--;
					setYDirection(yrDir);
	// creating a ball
			rec =new Rectangle(this.x,this.y,15,15);
	}
public void setXDirection(int xDir){
	xDirection = xDir;
	}
public void setYDirection(int yDir){
	yDirection = yDir;
	}

	/*public void paint(Graphics g){
			    paintComponent();
			    }*/
			public void paintComponent1(Graphics g){
				g.setColor(Color.RED);
				g.fillRect(rec.x,rec.y,rec.width,rec.height);
				//repaint();
		}
			public void collision(){
				if(rec.intersects(p.paddle))
					setXDirection(+1);
				if(rec.intersects(p1.paddle))
					setXDirection(-1);
					
			}
			public void move(){
				collision();
				rec.x += xDirection;
				rec.y += yDirection;
				// bounce the ball when the edge is detected
				if (rec.x <= 0){
					setXDirection(+1);
					//add to score
					p1Score++;
				}
				if (rec.x >= 385){
					setXDirection(-1);
					//add to score
					pScore++;
				}
				if (rec.y <= 25)
					setYDirection(+1);
				if (rec.y >= 285)
					setYDirection(-1);
				
			}
	
public void run(){
try{
while(true){
move();
Thread.sleep(6);
}
}catch(Exception e){

}
}
}