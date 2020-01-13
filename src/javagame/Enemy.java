package javagame;
/*@author Matt Trebing, Ben Strodel
 * ITec 220
 * Project 5
 * Enemy.java
 */
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Enemy 
{
	private int health;
	private int moneyDrop;
	private int attack;
	private int xpos;
	private int ypos;
	private int[] time1 ={200,200,200};//e
	private Animation foe, movingUp, movingDown, movingLeft, movingRight, attackingLeft, attackingRight, deathAnimetion,magicBlast, otherMagicBlast;
	private Image[] moveUp,moveDown,moveRight ,moveLeft, attackRight,attackLeft;
	private int delta;
	
	/**Constructor
	 * This method initializes several values
	 * @throws SlickException
	 */
	public Enemy() throws SlickException
	{
		xpos=448;
		ypos= 270;
		attack =15;
		moneyDrop=5;
		health=Character.getXP()+1;
		
	}
	
	/**
	 * this method is used to pass the delta value along so it may be used in other places in the play class
	 * this method returns nothing
	 * @param delta
	 */
	public void passDelta(int delta)
	{
		delta = delta;
	}
	
	/**
	 * this method is used to pass the delta value along so it may be used in other places in the play class
	 * this method takes no parameters
	 * @return delta
	 */
	public int getDelta()
	{
		return delta;
	}
	
	/**
	 * this method is used to pass along animations
	 * this method takes no parameters
	 * @return movingUp
	 */
	public Animation upAnime()
	{
		return movingUp;
	}
	
	/**
	 * this method returns the x value of the enemy
	 * this method takes no parameters
	 * @return xpos
	 */
	public int xposReturn()
	{
		return xpos;
	}
	
	/**
	 * this method returns the Y position of the enemy
	 * this method takes no parameters
	 * @return ypos
	 */
	public int yposReturn()
	{
		return ypos;
	}
	
	/**
	 * this method is used to return the current health of the enemy
	 * this method takes no parameters
	 * @return health
	 */
	public int getHealth()
	{
		return health;
	}
	
	/**
	 * this method is used to reduce the health of the enemy
	 * this method returns nothing
	 * @param hit
	 */
	public void takeDamage(int hit)
	{
		health-=hit;
	}
	
	public int dealDamage()
	{
		return attack;
	}
	
	/**
	 * this method returns the money drop from when the enemy is killed
	 * this method takes no parameters
	 * @return moneyDrop
	 */
	public int getDrop()
	{
		return moneyDrop;
	}
}
