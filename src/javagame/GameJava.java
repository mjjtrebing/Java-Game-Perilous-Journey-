package javagame;

/*@author Matt Trebing, Ben Strodel
 * ITec 220
 * Project 5
 * GameJava.java
 */

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
//state based game has changing screens
public class GameJava extends StateBasedGame
{//fps counter comes by default
	public static String gameName = "Perilous Journey";
	public static int menu = 0;
	public static int play = 1;
	//private Grid ray;
	//Room[][] many;
	
	/**Constructor
	 * The purpose of this method is to create and add the 2 game states (menu, and Play)
	 * @param gameName
	 * @throws SlickException
	 */
	public GameJava(String gameName) throws SlickException
	{
		super(gameName);//calls constructor to make game name

		this.addState(new Menu(menu)); //these add states that operate the game.
		this.addState(new Play(menu));
		
		
	}
	
	/**
	 * This method initializes both games states and enters the menu state to start.
	 * @param GameContainer gc
	 * @return void
	 */
	public void initStatesList(/*maintains many behind the scenes crap*/GameContainer gc) throws SlickException
	{
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);//initializes states
		
		this.enterState(menu);//what screen should i first show the user?
		
		gc.setVSync(true);                     // Turn VSync
		gc.setMaximumLogicUpdateInterval(800); // Max. 200 miliseconds can pass
		gc.setMinimumLogicUpdateInterval(10); 
	}
	
	
	/**Main
	 * In the main this starts the game.
	 * It also sets the size of the game window
	 * @param args
	 */
	public static void main(String[] args) 
	{
		AppGameContainer appgc;
		try
		{
			appgc = new AppGameContainer(new GameJava(gameName));//what game will be in this window?
			appgc.setDisplayMode(950, 660, false/*for full screen*/);//setting size
			appgc.start();
			
			
			
		}catch(SlickException e)
		{
			e.printStackTrace();
		}
		
	}
		
}


