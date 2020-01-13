package javagame;

/*@author Matt Trebing, Ben Strodel
 * ITec 220
 * Project 5
 * Play.java
 */
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;



public class Play extends BasicGameState
{	
	private Enemy n;
	
	private float velocityX= (float) 0.000005;
	private boolean quit = false;
	private boolean shopping =false;
	private Grid grid;
	private Room current;
	private Animation demon, movingUp, movingDown, movingLeft, movingRight, attackingLeft, attackingRight, deathAnimetion,magicBlast, otherMagicBlast;
	private Animation foe, enemyUp,enemyDown,enemyRight,enemyLeft, enemyAttackLeft,enemyAttackRight;
	private Image dungeon;
	private int[] dur1 = {200,200};//duration between up/down animations
	private int[] dur2 = {200,200,200,200};//left right animetions
	private int[] dur3 = {100,100,200,100};//attack patterns
	private int[] dur4 = {200};
	private int[] time1 ={200,200,200};//e
	private int[] enemyDur={100,100,150,100};
	private float demonPositionX =0;//tracks his positions
	private float demonPositionY=0;//tracks his positions
	private float shiftX = demonPositionX+ 448;//starting point on screen
	private float shiftY = demonPositionY+ 270;//starting point on screen
	private float blastPosRight = shiftX +15;
	private float blastPosLeft = shiftX;
	private Atmo music;
	private Character mainMan;
	private int count = 0;
	private Image redButt;
	private Image finalDoom;
	private Image takLeft;
	private Image takRight;
	private int enemyY=270;
	private int enemyX=448;
	private Image go;
	private boolean end;
	public Play(int state) throws SlickException
	{}
	
	/**
	 * these values are the first to be initialized when then Play state is entered.
	 * This method initializes many values such as images, Grids, Characters, and animations which will be drawn later.
	 * This method returns nothing
	 * @param GameContainer
	 * @param StateBasedGame
	 */
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		grid = new Grid();
		Room[][] many = grid.roomReturn();
		int targetID=0;
		Room current = grid.currentRoom();
		mainMan = new Character();
		dungeon = current.getImage();
		finalDoom= new Image("res/Doom Monster/Death anime/death4.png");
		takLeft = new Image("res/Enemy/Attack Left/attackleft4.png");
		takRight=new Image("res/Enemy/Attack Right/attackright4.png");
		
		Image[] moveUp = {new Image("res/Doom Monster/Up movement/up1.png"), new Image("res/Doom Monster/Up movement/up2.png")};
		Image[] moveDown = {new Image("res/Doom Monster/Down movement/down 1.png"), new Image("res/Doom Monster/Down movement/Down 2.png")};
		Image[] moveRight = {new Image("res/Doom Monster/Right movement/right1.png"), new Image("res/Doom Monster/Right movement/right 2.png"), new Image("res/Doom Monster/Right movement/right3.png"), new Image("res/Doom Monster/Right movement/right4.png")};
		Image[] moveLeft = {new Image("res/Doom Monster/Left movement/left1.png"), new Image("res/Doom Monster/Left movement/left 2.png"), new Image("res/Doom Monster/Left movement/Left3.png"), new Image("res/Doom Monster/Left movement/left4.png")};
		Image[] attackRight = {new Image("res/Doom Monster/Attack Right/Attack Right 1.png"), new Image("res/Doom Monster/Attack Right/Attack Right 2.png"), new Image("res/Doom Monster/Attack Right/Attack Right 3.png"),  new Image("res/Doom Monster/Attack Right/Attack Right 2.png")};
		Image[] attackLeft = {new Image("res/Doom Monster/Attack Left/Attack Left 1.png"), new Image("res/Doom Monster/Attack Left/Attack Left 2.png"), new Image("res/Doom Monster/Attack Left/attack left 3.png"), new Image("res/Doom Monster/Attack Left/Attack Left 2.png")};
		Image[] death = {new Image("res/Doom Monster/Death anime/death1.png"),new Image("res/Doom Monster/Death anime/death2.png"),new Image("res/Doom Monster/Death anime/death3.png"), finalDoom};
		Image[] magicRight = {new Image("res/Demon weapons/right blast.png")};
		Image[] magicLeft = {new Image("res/Demon weapons/left blast.png")};
		
		movingUp= new Animation(moveUp, dur1, false);
		movingDown= new Animation(moveDown, dur1, false);
		movingRight= new Animation(moveRight, dur2, false);
		movingLeft= new Animation(moveLeft, dur2, false);
		attackingRight= new Animation(attackRight, dur3, false);
		attackingLeft= new Animation(attackLeft, dur3, false);
		deathAnimetion= new Animation(death, dur2, false);
		magicBlast= new Animation(magicRight, dur4, false);
		otherMagicBlast= new Animation(magicLeft, dur4, false);
		demon = movingDown;
		
		
		Image[] dastardlyWalkUp = {new Image("res/Enemy/Walk Up/walknorth1.png"), new Image("res/Enemy/Walk Up/walknorth2.png"),new Image("res/Enemy/Walk Up/walknorth3.png")};
		Image[] dastardlyWalkDown = {new Image("res/Enemy/Walk Down/walksouth1.png"), new Image("res/Enemy/Walk Down/walksouth2.png"),new Image("res/Enemy/Walk Down/walksouth3.png")};
		Image[] dastardlyWalkRight = {new Image("res/Enemy/Walk Right/walkright1.png"), new Image("res/Enemy/Walk Right/walkright2.png"),new Image("res/Enemy/Walk Right/walkright3.png")};
		Image[] dastardlyWalkLeft = {new Image("res/Enemy/Walk Left/walkleft1.png"), new Image("res/Enemy/Walk Left/walkleft2.png"),new Image("res/Enemy/Walk Left/walkleft3.png")};
		Image[] dastardlyAttackLeft = {new Image("res/Enemy/Attack Left/attackleft1.png"), new Image("res/Enemy/Attack Left/attackleft2.png"),new Image("res/Enemy/Attack Left/attackleft3.png"),new Image("res/Enemy/Attack Left/attackleft4.png")};
		Image[] dastardlyAttackRight = {new Image("res/Enemy/Attack Right/attackright1.png"),new Image("res/Enemy/Attack Right/attackright2.png"),new Image("res/Enemy/Attack Right/attackright3.png"),new Image("res/Enemy/Attack Right/attackright4.png")};
		
		enemyUp = new Animation(dastardlyWalkUp, time1, false);
		enemyDown = new Animation(dastardlyWalkDown, time1, false);
		enemyLeft = new Animation(dastardlyWalkLeft, time1, false);
		enemyRight = new Animation(dastardlyWalkRight, time1, false);
		enemyAttackLeft = new Animation(dastardlyAttackLeft,enemyDur,false);
		enemyAttackRight=new Animation(dastardlyAttackRight,enemyDur,false);
		foe=enemyDown;
		//foe=enemyUp;
		if(current.isEnemy())
		{
		n = new Enemy();
		}
		go=new Image("res/GameOverFianl.png");
		
		music= new Atmo();
		music.playMain();
		
	}
	
	/**
	 * This method draws several values on screen and manipulates them.
	 * This method also keeps track of button presses and the character's X and Y values. 
	 * @param GameContainer
	 * @param StateBasedGame
	 * @param Graphics
	 * 
	 */
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException//render draws graphics
	{
		
		int xpos=Mouse.getX();
		int ypos=Mouse.getY();
		String mouse = "mouse pos: " + xpos +", " + ypos;// constantly updates user to mouse position
		
		Image setting = new Image("res/magic background.png");
		setting.draw(0,60);
		current = grid.currentRoom();
		current.getImage().draw(125,90);
		//g.drawString(mouse, 0,0);
		demon.draw(shiftX,shiftY);
		
		
		Input in = gc.getInput();
		if(in.isKeyDown(Input.KEY_S)&& mainMan.getMagic()>0)
		{
			magicBlast.draw(blastPosRight,shiftY);
		}
		if(in.isKeyDown(Input.KEY_A)&& mainMan.getMagic()>0)
		{
			otherMagicBlast.draw(blastPosLeft,shiftY);
		}
		
		
		//g.drawString("demon X: " +shiftX +"\ndemon Y: " + shiftY, 450, 20);
		
		
		if(quit==true)
		{
			g.drawString("Resume (R)",250,100);
			g.drawString("Main Menu (M)",250,150);
			g.drawString("Quit game (Q)",250,200);
			if(quit==false)
			{
				g.clear();
			}	
		}
		if(shopping==true)
		{
			g.drawString("(Q)Quit(Q)",550,100);
			g.drawString("(M)Add Magic ($30)",550,125);
			g.drawString("(H)Add Health ($50)",550,150);
			g.drawString("(P)Add XP ($20)",550,175);
			g.drawString("(D)Increase Damage ($300/25XP)",550,200);
			g.drawString("(U)Increase Magic Damage ($900/25XP)",550,225);
			g.drawString("(C)Continue Shopping(C)",550,250);
			if(shopping==false)
			{
				g.clear();
			}
			
		}

		try
		{
		
		Sound snd = new Sound("res/Sounds/Door Sound.wav");
		if(shiftX>=433 && shiftX<=470 && shiftY<=146)
		{
			current.setIsCharacter(false);
			current = grid.shiftUpOne(current);
			current = grid.currentRoom();
			current.getImage().draw(125,90);
			shiftX=452;
			shiftY=416;
			snd.play();
			n=new Enemy();
			enemyY=270;
			enemyX=448;
			if(current.getShopValue()==false)
			{
				current.setIsEnemy(true);
			}
			
		}
		if(shiftX>=433 && shiftX<=470 && shiftY>=419)
		{
			current.setIsCharacter(false);
			current = grid.shiftDownOne(current);
			current = grid.currentRoom();
			current.getImage().draw(125,90);
			shiftX=452;
			shiftY=150;
			snd.play();
			n=new Enemy();
			enemyY=270;
			enemyX=448;
			if(current.getShopValue()==false)
			{
				current.setIsEnemy(true);
			}
		}
		if(shiftX>=708 && shiftY>=261 && shiftY<=300)
		{
			current.setIsCharacter(false);
			current = grid.shiftRightOne(current);
			current = grid.currentRoom();
			current.getImage().draw(125,90);
			shiftX=217;
			shiftY=285;
			snd.play();
			n=new Enemy();
			enemyY=270;
			enemyX=448;
			if(current.getShopValue()==false)
			{
				current.setIsEnemy(true);
			}
		}
		if(shiftX<=199 && shiftY>=261 && shiftY<=300 )
		{
			current.setIsCharacter(false);
			current = grid.shiftLeftOne(current);
			current = grid.currentRoom();
			current.getImage().draw(125,90);
			shiftX=700;
			shiftY=285;
			snd.play();
			n=new Enemy();
			enemyY=270;
			enemyX=448;
			//System.out.println(n.getHealth());
			if(current.getShopValue()==false)
			{
				current.setIsEnemy(true);
			}
		}
		}catch(IndexOutOfBoundsException e)
		{
			System.out.print("you've gone too far");
		}
		catch(NullPointerException e2)
		{
			System.out.print("theres nothing there");
		}
	
		
		Input input =gc.getInput();
		
		if(input.isMouseButtonDown(0))
		{
			music= new Atmo();
			//music.stopMain();
			music.playOther();
		}
		
		
		
	
		
		if(current.getShopValue())
		{
			Image shopTable = new Image("res/DUNGEONS/table.png");
			shopTable.draw(450,300);
			if(shiftX<500 && shiftX>440 && shiftY>270 && shiftY<330)
			{
				shopping=true;
			}
			
			if(shopping)
			{
				if(in.isKeyDown(Input.KEY_Q))
				{
					shopping = false;
				}
				if(in.isKeyDown(Input.KEY_M)&& count<=0)
				{
					if(mainMan.getCash()>=30 )//&& count<=2)
					{
					mainMan.addMagic(10);
					mainMan.spendCash(30);
					count++;
					}
				}
				if(in.isKeyDown(Input.KEY_H)&& count<=0)
				{
					if(mainMan.getCash()>=50)
					{
						mainMan.addHealth(20);
						mainMan.spendCash(50);
						count++;
					}
				}
				if(in.isKeyDown(Input.KEY_P)&& count<=0)
				{
					if(mainMan.getCash()>=20)
					{
						mainMan.addXP(20);
						mainMan.spendCash(20);
						count++;
					}
				}
				if(in.isKeyDown(Input.KEY_D)&& count<=0)
				{
					if(mainMan.getCash()>=300 && mainMan.getXP()>=25)
					{
						mainMan.damageBuff(5);
						mainMan.spendCash(300);
						count++;
					}
				}
				if(in.isKeyDown(Input.KEY_U)&& count<=0)
				{
					if(mainMan.getCash()>=900 && mainMan.getXP()>=25)
					{
						mainMan.magicBuff(15);
						mainMan.spendCash(900);
						count++;
					}
				}
				if(in.isKeyDown(Input.KEY_C))
				{
					count=0;
				}
			}
			
		}
		
		
		Image bar = new Image("res/Green Button.png");
		bar.draw(720,580);
		g.drawString("$: " + mainMan.getCash() , 742, 605);
		
		Image orbs = new Image("res/Smaller stat orbs.png");
		orbs.draw(320,550);
		g.drawString("" + mainMan.getHP() , 420, 585);
		g.drawString("" + mainMan.getMagic() , 505, 585);
		Image xp = new Image("res/Smaller XP Bar.png");
		xp.draw(0,550);
		g.drawString("XP: " + mainMan.getXP() , 100, 588);
		Image txtBox = new Image("res/TextBox.png");
		txtBox.draw(170,4);
		g.drawString("Pompous adventurers have invaded your home. \nDefend your keep!", 240, 30);
		gc.setShowFPS(false);
		
		current = grid.currentRoom();
		if(current.isEnemy())
		{
			//System.out.print(current);
			foe.draw(enemyX,enemyY);
			//current = grid.currentRoom();
				
			//enemyX -= n.getDelta() * .09f;
			//foe.update(100000000);
		}
		
		if(end)
		{
			g.clear();
			go.draw(0,0);
			
		}
		
		
		//g.drawString("shiftX: " + shiftX + "\nshiftY: " + shiftY,100,100);
		//g.drawString("enemyX: " + enemyX + "\nenemyY: " + enemyY,100,200);
		//g.drawString("blast pos left: " + blastPosLeft,100,300);
	}
	
	/**
	 * This method updates all images, and animations on screen and monitors all button presses in the game window.
	 * @param GameContainer
	 * @param StateBasedGame
	 * @param int delta
	 */
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException//updates imagery
	{
		current = grid.currentRoom();
		if(current.isEnemy())
		{
			if(enemyY>=134&&n.getHealth()>0)
			{
				if(enemyY>=shiftY)
				{
					foe=enemyUp;
					enemyY -= velocityX * delta;
					//enemyY -= delta * .1f;
					foe.update(delta);
				}
				if(enemyY<=shiftY&&n.getHealth()>=1)//<<<<<<<<<<<<<---------------------------------------------------------weird walking
				{
					foe=enemyDown;
					enemyY += delta * 0.1f;
					foe.update(delta);
				}
				if(enemyX<=shiftX&&n.getHealth()>=1)//<<<<<<<<<<<<<---------------------------------------------------------weird walking
				{
					foe=enemyRight;
					enemyX +=  delta * 0.1f;
					foe.update(delta);
				}
				if(enemyX>=shiftX &&n.getHealth()>=1)
				{
					foe=enemyLeft;
					enemyX -= velocityX * delta;
					foe.update(delta);
				}//MUST FIX SPEED
				if(enemyY<=shiftY+46 && enemyY>=shiftY-10&&current.isEnemy()&&(shiftX+20>=enemyX-30&&enemyX>=shiftX) || enemyX==shiftX)
				{
					foe=enemyAttackLeft;
					foe.update(delta);
					//if(foe.getCurrentFrame().equals(takLeft)&& n.getHealth()>=1)
					{
						mainMan.takeDamage(n.dealDamage());
					}
					
				}
				if(enemyY<=shiftY+46 && enemyY>=shiftY-10&&current.isEnemy()&&(shiftX>=enemyX&&enemyX+20>=shiftX-30) || enemyX==shiftX)
				{
					foe=enemyAttackRight;
					foe.update(delta);
					//if(foe.getCurrentFrame().equals(takRight) && n.getHealth()>=1)
					{
						mainMan.takeDamage(n.dealDamage());
					}
				}
			}	
				if(n.getHealth()<=0)
				{
					//mainMan.deathToll();
					foe = deathAnimetion;
					deathAnimetion.update(delta);
					if(foe.getCurrentFrame().equals(finalDoom))
					{
					enemyX=1000;
					enemyY=1000;
					current.setIsEnemy(false);
					mainMan.addCash(n.getDrop());
					//System.out.print("WAAAAAAAY DEAD");
					mainMan.addXP(1);
					}
				}
			
		}
		
		
		
		
		int count=0;
		/*
		 * The following code segment lists the movments and attacks of the main character
		 */
		Input in = gc.getInput();
		if(in.isKeyDown(Input.KEY_UP)&& mainMan.getHP()>0)//this code registers key input to do things on the screen, hory shiit
		{
			demon = movingUp;
			if(shiftY>=135)
			{
			shiftY -=delta * .13f;//increases Y position of deamon
			movingUp.update(delta);
			}
			count=0;
		}
		if(in.isKeyDown(Input.KEY_DOWN)&& mainMan.getHP()>0)
		{
			demon =movingDown;
			if(shiftY<=420)
			{
			shiftY += delta * .13f;
			movingDown.update(delta);
			}
			count=0;
		}
		if(in.isKeyDown(Input.KEY_LEFT)&& mainMan.getHP()>0)
		{
			demon = movingLeft;
			if(shiftX>198)
			{
			shiftX -= delta *.13f;
			movingLeft.update(delta);
			}
			count=0;
		}
		if(in.isKeyDown(Input.KEY_RIGHT)&& mainMan.getHP()>0)
		{
			demon = movingRight;
			if(shiftX<710)
			{
			shiftX += delta *.13f;
			movingRight.update(delta);
			}
			count=0;
		}
		if(in.isKeyDown(Input.KEY_Z)&& mainMan.getHP()>0)
		{
			demon = attackingLeft;
			attackingLeft.update(delta);
			
			if(shiftY-46<=enemyY&& shiftY+10>=enemyY&&current.isEnemy()&&shiftX>=enemyX &&shiftX-30<=enemyX&&count<=1)
			{
				n.takeDamage(mainMan.dealDamage());
				count++;
			}
			
		}
		if(in.isKeyDown(Input.KEY_X)&& mainMan.getHP()>0)
		{
			demon =attackingRight;
			attackingRight.update(delta);
			
			if(shiftY-46<=enemyY&& shiftY+10>=enemyY&&current.isEnemy()&&shiftX+50>=enemyX &&shiftX<=enemyX&&count<=1)
			{
				n.takeDamage(mainMan.dealDamage());
				count++;
			}
			
		}
		if(((in.isKeyDown(Input.KEY_S)&& !in.isKeyDown(Input.KEY_A)) && mainMan.getMagic()>0))
		{
			demon =attackingRight;
			blastPosRight += delta *.9;
			magicBlast.update(delta);
			//mainMan.reduceMagic(5);
			if(blastPosRight>=710)
			{
				magicBlast.draw(blastPosRight,shiftY);
				blastPosRight=shiftX+15;
				mainMan.reduceMagic(5);
			}
			if(shiftY-46<=enemyY&& shiftY+10>=enemyY&&current.isEnemy()&&blastPosRight+50>=enemyX &&count<=1)//&&blastPosLeft==enemyX+40)
			{
				n.takeDamage(mainMan.dealBlastDMG());
				count++;
			}
		}
		boolean temp = false;
		if((in.isKeyDown(Input.KEY_A) && !in.isKeyDown(Input.KEY_S)) && mainMan.getMagic()>0 && mainMan.getHP()>0)
		{
			
			demon =attackingLeft;
			blastPosLeft -= delta *.9;
			otherMagicBlast.update(delta);
			//mainMan.reduceMagic(5);
			otherMagicBlast.draw(blastPosLeft,shiftY);
			if(blastPosLeft<=197)
			{
				blastPosLeft=shiftX-35;
				
				mainMan.reduceMagic(5);
			}
			//float temp =shiftY+45;
			//float temp2 = shiftX+45;
			if(shiftY-46<=enemyY&& shiftY+10>=enemyY&&current.isEnemy()&&count<=1 &&blastPosLeft+50>=enemyX)//&&blastPosLeft==enemyX)
			{
				n.takeDamage(mainMan.dealBlastDMG());
				//System.out.println("this happened");
				count++;
			}
		}
		
		
		
		if(mainMan.getHP()<=0)
		{
			//mainMan.deathToll();
			demon = deathAnimetion;
			deathAnimetion.update(delta);
			if(deathAnimetion.getCurrentFrame().equals(finalDoom))
			{
				shiftX=1000;
				shiftY=1000;
				end=true;
				
				
			}
			
		}
		
		
		
		if(in.isKeyDown(Input.KEY_ESCAPE))
		{
			quit=true;
		}
		
		if(quit)
		{
			if(in.isKeyDown(Input.KEY_R))
			{
				quit = false;
			}
			if(in.isKeyDown(Input.KEY_M))
			{
				sbg.enterState(0);
			}
			if(in.isKeyDown(Input.KEY_Q))
			{
				System.exit(0);
			}
		}
		
		
	}
	
	
	/**
	 * This method returns the ID of the current state
	 * this method takes no parameters
	 * @return 1
	 */
	public int getID()
	{
		return 1;
	}
	
}
