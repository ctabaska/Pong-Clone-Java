import java.awt.*;
import javax.swing.*;
public class Ball
{
	public static double xVelocity = 0;
	public static double yVelocity = 0;

	public double x;
	public double y;
	public double width;
	public double height;

	private Color ballColor;

	public Ball(double x, double y, double width, double height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void drawMe(Graphics2D g)
	{
		g.setColor(Color.white);
		g.fillOval((int)x, (int)y, (int)width, (int)height);
	}

	public void move()
	{
		x += xVelocity;
		y += yVelocity;

		if(this.y >= Paddle.y - height - 5)
		{
			detectCollision();
		}
		bounceBounds();
	}

	public void setVelocity(double xVelocity, double yVelocity)
	{
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
	}

	public void detectCollision()
	{
		//System.out.println("collision check");
		double centerX = this.x + (width / 2.0);
		if(centerX  >= Paddle.x && centerX <= Paddle.x + Paddle.width)
		{
			//System.out.println("In between");
			if(y + height >= Paddle.y && y+height <= Paddle.y + Paddle.height)
			{
				yVelocity = -Math.abs(yVelocity);
				double paddleCenter = Paddle.x + Paddle.width / 2.0;
				xVelocity = -(paddleCenter - centerX) / 2.0;
				System.out.println(xVelocity);
				if(xVelocity > 0)
				{

				}
				else if(xVelocity <= 0)
				{

				}
			}
		}
	}

	public void bounceBounds()
	{
		if(x + width >= Screen.screenWidth)
		{
			xVelocity = -Math.abs(xVelocity);
		}
		if(x <= 0)
		{
			xVelocity = Math.abs(xVelocity);
		}
		if(y <= 0)
		{
			yVelocity = Math.abs(yVelocity);
		}

		if( y > Screen.screenHeight)
		{
			y = 0; x = 0; yVelocity = 0; xVelocity = 0; Screen.startGame = false;
		}
	}
}