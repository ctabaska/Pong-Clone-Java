import java.awt.*;
import javax.swing.JPanel;
import java.util.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


public class Screen extends JPanel implements KeyListener
{	
	public static int screenHeight = 600;
	public static int screenWidth = 800;
	public static boolean startGame = false;

	public static boolean left = false;
	public static boolean right = false;

	public Ball ball = new Ball(0.0, 0.0, 20.0, 20.0);
	public Paddle p1 = new Paddle();


	public Screen(){
		setLayout(null);
		
		addKeyListener(this);
        setFocusable(true);
	}
	
	public Dimension getPreferredSize(){
		//Sets the size of the panel
        return new Dimension(screenWidth, screenHeight);
	}
	
	public void paintComponent(Graphics gTemp){
		Graphics2D g = (Graphics2D)gTemp;
		super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0,0, screenWidth, screenHeight);
        ball.drawMe(g);
        p1.drawMe(g);
        if(!startGame)
        {
        	g.setColor(Color.white);
        	g.drawString( "Press SPACEBAR to Start", 0, 100);
        }

	}
	public void keyTyped(KeyEvent e){}
	public void keyPressed(KeyEvent e){
		//System.out.println(e.getKeyCode());
		if(!startGame && e.getKeyCode() == 32)
		{
			ball.setVelocity(5,5);
			startGame = true;
		}
		if( e.getKeyCode() == 37 )
		{
			left = true;
		}
		if( e.getKeyCode() == 39 )
		{
			right = true;
		}
	}
	public void keyReleased(KeyEvent e){
		if( e.getKeyCode() == 37 )
		{
			left = false;
		}
		if( e.getKeyCode() == 39 )
		{
			right = false;
		}
	}

	public void animate(){

		while( true ){
			try {
			    Thread.sleep(16);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			p1.moveLeft();
			p1.moveRight();
			ball.move();
			repaint();
		}
	}
}
