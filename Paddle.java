import java.awt.Graphics2D;
import java.awt.Color;
public class Paddle
{
	public double velocity = 7;

	public static double x;
	public static double y = 560;
	public static double width;
	public static double height;

	public Paddle()
	{
		this.x = 20;
		this.width = 50;
		this.height = 10;
	}

	public void drawMe(Graphics2D g)
	{
		g.setColor(Color.white);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
	}

	public void moveLeft()
	{
		if(Screen.left == true)
		{
			if(x - velocity < 0)
			{
				x = 0;
			}
			else if(x > 0)
			{
				x -= velocity;
			}
		}
		
	}

	public void moveRight()
	{
		if(Screen.right == true)
		{
			if(x + velocity > Screen.screenWidth - width)
			{
				x = Screen.screenWidth - width;

			}
			else if(x < Screen.screenWidth - width)
			{
				x += velocity;
			}
		}
		
	}
}