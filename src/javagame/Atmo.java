package javagame;
/*@author Matt Trebing, Ben Strodel
 * ITec 220
 * Project 5
 * Atmo.java
 */
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class Atmo 
{
	private Music music1;
	private Music music2;
	private Music music3;
	
	/**
	 * The purpose of this method is to initialize the main title music and to play it on a loop
	 * this method takes no parameters
	 * this method returns nothing
	 * @throws SlickException
	 */
	public void playMain() throws SlickException
	{
		music1 = new Music("res/Sounds/New MainTitle.wav");
		music1.loop();
	}
	
	/**
	 * this method is used to stop the main title music
	 * this method takes no parameters
	 * this method returns nothing
	 */
	public void stopMain()
	{
		music1.stop();
	}
	
	/**
	 * The purpose of this method is to initialize the ancient sorrow music and to play it on a loop.
	 * this method takes no parameters.
	 * this method returns nothing.
	 * @throws SlickException
	 */
	public void playOther() throws SlickException
	{
		music2 = new Music("res/Sounds/Ancient soorow wav.wav");
		music2.loop();
	}
	
	/**
	 * this method is used to stop the ancient sorrow music
	 * this method takes no parameters
	 * this method returns nothing
	 */
	public void stopOther()
	{
		music2.stop();
	}
	
	public void startDeath() throws SlickException
	{
		music3 = new Music("res/Sounds/death.wav");
		music3.play();
	}
}
