package javagame;
/*@author Matt Trebing, Ben Strodel
 * ITec 220
 * Project 5
 * Character.java
 */
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class Character 
{
	private int hp;
	private int damage;
	private static int score;
	private int magic;
	private int magicBlastDMG;
	private int magicFlameDMG;
	private int cash;
	
	/**constructor
	 * this method is used to initialize several value
	 * 
	 */
	public Character()
	{
		hp =100;
		damage=10;
		score=0;
		magic = 100;
		magicBlastDMG=20;
		magicFlameDMG =27;
		cash =100;
	}
	
	/**
	 * this method is used to subtract from the hp value
	 * this method returns nothing
	 * @param hits
	 * @throws SlickException
	 */
	public void takeDamage(int hits) throws SlickException
	{
		hp-=hits;
		
	}
	
	/**
	 * this method is used to deal damage to other units
	 * this method takes no parameters
	 * @return damage
	 */
	public int dealDamage()
	{
		return damage;
	}
	
	/**
	 * this method is used to increase the base damage of the character
	 * this method returns nothing
	 * @param buff
	 */
	public void damageBuff(int buff)
	{
		damage +=buff;
	}
	
	/**
	 * this method returns the current magic pool of the character
	 * this method takes no parameters
	 * @return magic
	 */
	public int getMagic()
	{
		return magic;
	}
	
	/**
	 * this method is used to reduce the magic pool of the character by the value in the parameter
	 * this method returns nothing
	 * @param ded
	 */
	public void reduceMagic(int ded)
	{
		magic-=ded;
	}
	
	/**
	 * this method increases the magic damage
	 * this method returns nothing
	 * @param buff
	 */
	public void magicBuff(int buff)
	{
		magicBlastDMG+=buff;
	}
	
	/**
	 * this method is used to increase the magic pool
	 * this method returns nothing
	 * @param added
	 */
	public void addMagic(int added)
	{
		magic+=added;
	}
	
	/**
	 * this method plays the death sound
	 * this method takes no parameters
	 * this method returns nothing
	 * @throws SlickException
	 */
	public void deathToll() throws SlickException
	{
		Sound otherSound = new Sound("res/Sounds/Demon Death.wav");
		otherSound.play();
	}
	
	/**
	 * This method returns the health of the character
	 * this method takes no parameters
	 * @return hp
	 */
	public int getHP()
	{
		return hp;
	}
	
	/**
	 * this method is used to add health to the character
	 * this method returns nothing
	 * @param boost
	 */
	public void addHealth(int boost)
	{
		hp+=boost;
	}
	
	/**
	 * this method returns the score of the player
	 * this method takes no parameters
	 * @return score
	 */
	static public int getXP()
	{
		return score;
	}
	
	/**
	 * this method is used to increase the XP
	 * this method returns nothing
	 * @param boost
	 */
	public void addXP(int boost)
	{
		score+=boost;
	}
	
	/**
	 * this method is meant to to deal magic damage to the enemy
	 * @return magicBlast DMG
	 */
	public int dealBlastDMG()
	{
		return magicBlastDMG;
	}
	
	/**
	 * this method is meant to deal flame damage to the character
	 * @return magicFlameDMG
	 */
	public int dealMagicFlameDMG()
	{
		return magicFlameDMG;
	}
	
	/**
	 * this method returns the players current amount of cash
	 * this method takes no parameters
	 * @return cash
	 */
	public int getCash()
	{
		return cash;
	}
	
	/**
	 * this method is used to add cash to the player
	 * this method returns nothing
	 * @param invest
	 */
	public void addCash(int invest)
	{
		cash+=invest;
	}
	
	/**
	 * this method is used to reduce the cash value of the player when they buy something
	 * this method returns nothing
	 * @param hit
	 */
	public void spendCash(int hit)
	{
		cash-=hit;
	}
}
