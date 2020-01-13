package javagame;

/*@author Matt Trebing, Ben Strodel
 * ITec 220
 * Project 5
 * Menu.java
 */

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

public class Menu extends BasicGameState
{
	public String mouse = "no input yet";
	//Image face;
	
	//int faceX = 200;
	//int faceY=200;//these values change
	private Image playNow;
	private Image exitGame;
	private Image setting;
	private Music music;
	private Sound noise;
	private Image title;
	private Animation curr,movingRight,deathAnimetion, movingDown;
	private int[] dur2 = {100,100,100,100,100,100,200};
	private int[] dur1 = {200,200};
	private int x=455;
	private int y=580;
	private Image finalDoom;
	public Menu(int state)
	{}

	/**
	 * these values are the first to be initialized when then Menu state is entered.
	 * This method initializes many values such as images, and animations which will be drawn later.
	 * This method returns nothing
	 * @param GameContainer
	 * @param StateBasedGame
	 */
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		//face= new Image("res/cAFDkQf.png");
		playNow=new Image("res/PlayNow.png");
		exitGame = new Image("res/NewExit.png");
		setting = new Image("res/magic background.png");
		title = new Image("res/Title.png");
		
		Atmo music = new Atmo();
		music.playMain();
		
		finalDoom= new Image("res/Doom Monster/Death anime/death7.png");
		Image[] moveRight = {new Image("res/Doom Monster/Right movement/right1.png"), new Image("res/Doom Monster/Right movement/right 2.png"), new Image("res/Doom Monster/Right movement/right3.png"), new Image("res/Doom Monster/Right movement/right4.png")};
		Image[] death = {new Image("res/Doom Monster/Death anime/death1.png"),new Image("res/Doom Monster/Death anime/death2.png"),new Image("res/Doom Monster/Death anime/death3.png"),new Image("res/Doom Monster/Death anime/death4.png"),new Image("res/Doom Monster/Death anime/death5.png"),new Image("res/Doom Monster/Death anime/death6.png"), finalDoom};
		Image[] moveDown = {new Image("res/Doom Monster/Down movement/down 1.png"), new Image("res/Doom Monster/Down movement/Down 2.png")};
		//movingRight= new Animation(moveRight, dur2, false);
		deathAnimetion= new Animation(death, dur2, false);
		movingDown= new Animation(moveDown, dur1, false);
		curr=movingDown;
	}
	
	/**
	 * This method draws several values on screen 
	 * @param GameContainer
	 * @param StateBasedGame
	 * @param Graphics
	 * 
	 */
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException//initially draws things on the screen
	{
		
		setting.draw(0,60);
		//g.drawString("Welcome to your doom mortal",375,50);
		playNow.draw(290,200);
		exitGame.draw(290,300);
		title.draw(160,50);
		gc.setShowFPS(false);
		curr.draw(x,y);
		//g.drawString(mouse, 0,0);
		
	}
	
	/**
	 * This method updates all images on screen and monitors all mouse movement and clicks in the game window.
	 * @param GameContainer
	 * @param StateBasedGame
	 * @param int delta
	 */
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException//updates imagery
	{
		int xpos=Mouse.getX();
		int ypos=Mouse.getY();
		mouse = "mouse pos: " + xpos +", " + ypos;// constantly updates user to mous position
		
		Input input =gc.getInput();
		
		//play now button
		if((xpos>300)&&(xpos<650)&&(ypos>390&&ypos<450))
		{
			//this happens when the mouse is in the circle and when you click
			if(input.isMouseButtonDown(0))// zero means left click, 1 means right click
			{
				sbg.enterState(1);//
			}
		}
		
		//exit now button
		if((xpos>360)&&(xpos<615)&&(ypos>290&&ypos<350))
		{
			if(input.isMouseButtonDown(0))
			{
				System.exit(0);
			}
		}
		
		//System.out.println("X: " +x + "y: " + y);
		Input in = gc.getInput();
		/*if(x<=990)//&&in.isKeyDown(Input.KEY_RIGHT))
			{
			curr=movingRight;
			x += delta *.1f;
			curr.update(delta);
			}*/
	
		boolean death =false;
		if(xpos>455&&xpos<500 &&ypos>15 &&ypos<77)
		{
			if(in.isMouseButtonDown(0))
			{
				death=true;
				curr.update(delta);
			}
		}
		if(death)
		{
			curr=deathAnimetion;
			
			if(curr.getCurrentFrame().equals(finalDoom))
			{
				x=1000;
				y=1000;
			}
		}
		
		
	}
	
	/**
	 * this method returns the state ID
	 * this method takes no parameters
	 * @return 0
	 */
	public int getID()
	{
		return 0;
	}
	
}
