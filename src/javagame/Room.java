package javagame;
/*@author Matt Trebing, Ben Strodel
 * ITec 220
 * Project 5
 * Room.java
 */
import org.newdawn.slick.*;

public class Room 
{
	private Image background;
	private boolean isCharacter;
	private int id;
	private String openDoors;
	private boolean shop;
	private boolean enemyPres;
	private Enemy enemy;
	private boolean start;
	
	/**Constructor
	 * 
	 * This method initializes several values
	 * This method takes no parameters
	 * @throws SlickException
	 */
	public Room() throws SlickException
	{
		background = new Image("res/DUNGEONS/DUNGEON NSEW.png");
		id=0;
		isCharacter = false;
		shop=false;
		enemyPres=true;
		start=false;
		createEnemy();
	}
	
	/**
	 * this method sets the ID of the room to the parameter
	 * this method returns nothing
	 * @param _state
	 */
	public void setID(int _state)
	{
		id=_state;
	}
	
	/**
	 * this method return this ID of the room
	 * this method takes no parameters
	 * @return id
	 */
	public int getID()
	{
		return id;
	}
	
	/**
	 * this method returns the character boolean value
	 * this method takes no parameters
	 * @return isCharacter
	 */
	public boolean getIsCharacter()
	{
		return isCharacter;
	}
	
	/**
	 * this method sets the is character value to the parameter value
	 * this method returns nothing
	 * @param bool
	 */
	public void setIsCharacter(boolean bool)
	{
		isCharacter = bool;
	}
	
	/**
	 * This method is used to change the background picture of the room class
	 * this method returns nothing
	 * @param dungeon
	 */
	public void setImage(Image dungeon)
	{
		background = dungeon;
	}
	
	/**
	 * this method returns the Image being used as the background
	 * this method takes no parameters
	 * @return background
	 */
	public Image getImage()
	{
		return background;
	}
	
	/**
	 * this method sets the shop boolean value.
	 * this method returns nothing
	 * @param bool
	 */
	public void setShop(boolean bool)
	{
		shop=bool;
	}
	
	/**
	 * this method returns the shop boolean value
	 * this method takes no parameters
	 * @return shop
	 */
	public boolean getShopValue()
	{
		return shop;
	}
	
	/**
	 * this method returns the presence of an enemy in the room
	 * this method takes no parameters
	 * @return enemyPres
	 */
	public boolean isEnemy()
	{
		return enemyPres;
	}
	
	/**
	 * this method is used to set the value of the boolean enwmy to the parameter
	 * this method returns nothing
	 * @param bool
	 */
	public void setIsEnemy(boolean bool)
	{
		enemyPres=bool;
	}
	
	/**
	 * if the enemy boolean value is true then an a reference to the enemy class is created here
	 * this method returns nothing
	 * this method takes no parameters
	 * @throws SlickException
	 */
	public void createEnemy() throws SlickException
	{
		if(enemyPres)
		{
			enemy = new Enemy();
		}
	}
	
	/**
	 * this method is used to return the enemy if one is created
	 * this method takes no parameters
	 * @return enemy
	 */
	public Enemy foeReturn()
	{
		return enemy;
	}
	
	public boolean getStart()
	{
		return start;
	}
	
	public void setStart(boolean bool)
	{
		start=bool;
	}
	
	/**
	 * toString()
	 * @return String
	 */
	public String toString()
	{
		return "enemies: " + enemyPres + "\nShop: " +  shop + "\nID: " + id;
	}
	
}
