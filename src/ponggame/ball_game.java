package ponggame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class ball_game extends JFrame {

 private Image i;
 private Graphics gp;
 Rectangle startButton = new Rectangle(150,100,100,25);
 Rectangle quitButton = new Rectangle(150,150,100,25);
 
 //ball object
  static ball b2 = new ball(193,143);

 	public ball_game(){
		setTitle("Pong Ball Game");
		setSize(400,300);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(new AL());
		addMouseListener(new MouseHandler());
		}
	
		public void paint(Graphics g){
		    i = createImage(getWidth() , getHeight());
		    gp =i.getGraphics();
		    paintComponent(gp);
		    g.drawImage(i,0,0,this);
			}
		public void paintComponent(Graphics g){
			g.setFont(new Font("Arial",Font.BOLD,26));
			g.setColor(Color.YELLOW);
			g.drawString("PONG GAME...!!!",125,75);
			g.setColor(Color.CYAN);
			g.fillRect(startButton.x,startButton.y,startButton.width,startButton.height);
			g.setFont(new Font("Arial",Font.BOLD,12));
			g.setColor(Color.GRAY);
			g.drawString("Start Game", startButton.x+20,startButton.y+17);
			g.setColor(Color.PINK);
			g.fillRect(quitButton.x,quitButton.y,quitButton.width,quitButton.height);
			g.setColor(Color.GRAY);
			g.drawString("Quit",quitButton.x+20,quitButton.y+17);
			
			
			b2.paintComponent1(g);
			b2.p.draw(g);
			b2.p1.draw(g);
			
			g.setColor(Color.BLACK);
			g.drawString(""+b2.pScore,15,50);
			g.drawString(""+b2.p1Score,370,50);
			repaint();
		}
public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e){
				b2.p.keyPressed(e);
				b2.p1.keyPressed(e);
				}
		public void keyReleased(KeyEvent e){
				b2.p.keyReleased(e);
				b2.p1.keyReleased(e);
				
			}
		}
public class MouseHandler extends MouseAdapter{
	public void mouseMoved(MouseEvent e){
		
	}
public void mousePressed(MouseEvent e){
		
	}
}
	public static void main(String args[]){
		ball_game b1= new ball_game();
		//create and start thread
		Thread ball = new Thread(b2);
		ball.start();
		Thread t1 = new Thread(b2.p);
		Thread t2 = new Thread(b2.p1);
		t1.start();
		t2.start();
			}
	}