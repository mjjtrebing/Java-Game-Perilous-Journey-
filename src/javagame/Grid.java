package javagame;
/*@author Matt Trebing, Ben Strodel
 * ITec 220
 * Project 5
 * Grid.java
 */

import java.util.Random;
import org.newdawn.slick.*;
public class Grid 
{
	private Room[][] rooms;
	private Room current;
	/**Constructor
	 * This method when called initializes a 2d array of rooms.
	 * This method also creates the "current" room, and all 4 shop rooms
	 * @throws SlickException
	 */
	public Grid() throws SlickException
	{
		Image farNorthDoor = new Image("res/DUNGEONS/3 paths/DUNGEON SEW.png");
		Image farSouthDoor = new Image("res/DUNGEONS/3 paths/DUNGEON NEW.png");
		Image farEastDoor = new Image("res/DUNGEONS/3 paths/DUNGEON NSW.png");
		Image farWestDoor = new Image("res/DUNGEONS/3 paths/DUNGEON NSE.png");
		
		Image NECorner = new Image("res/DUNGEONS/2 paths/DUNGEON SW.png");
		Image NWCorner = new Image("res/DUNGEONS/2 paths/DUNGEON SE.png");
		Image SECorner = new Image("res/DUNGEONS/2 paths/DUNGEON NW.png");
		Image SWCorner = new Image("res/DUNGEONS/2 paths/DUNGEON NE.png");
		Random rando = new Random();
		int num1 =rando.nextInt(7)+1;
		int num2 =rando.nextInt(7)+1;
		int num3 =rando.nextInt(7)+1;
		int num4 =rando.nextInt(7)+1;
		rooms = new Room[10][10];
		int count = 0;
		for(int x = 0; x<rooms.length;x++)
		{
			for(int y=0;y<rooms[x].length;y++)
			{
				rooms[x][y]= new Room();
			}
		}
		for(int x = 0; x<rooms.length;x++)
		{
			for(int y=0;y<rooms[x].length;y++)
			{
				rooms[x][y].setID(count);
				count++;
				rooms[9][y].setImage(farNorthDoor);
				rooms[0][y].setImage(farSouthDoor);
				rooms[x][0].setImage(farEastDoor);
				rooms[x][9].setImage(farWestDoor);
				rooms[9][0].setImage(NECorner);
				rooms[9][9].setImage(NWCorner);
				rooms[0][9].setImage(SWCorner);
				rooms[0][0].setImage(SECorner);
				rooms[num1][num2].setShop(true);
				rooms[num1][num2].setIsEnemy(false);
				rooms[num3][num4].setShop(true);
				rooms[num3][num4].setIsEnemy(false);
				rooms[0][0].setShop(true);
				rooms[0][0].setIsEnemy(false);
				rooms[9][9].setShop(true);
				rooms[0][0].setIsEnemy(false);
			}
		}
		
		rooms[0][4].setIsEnemy(false);
		current = rooms[0][4];
		rooms[0][4].setStart(true);
		current.setIsCharacter(true);
	}
	
	/**
	 * This method simply returns the 2d array of rooms.
	 * This method takes no parameters.
	 * @return rooms
	 */
	public Room[][] roomReturn()
	{
		return rooms;
	}
	/**
	 * this method is meant to be used to update the 2d array of rooms
	 * This method returns nothing
	 * @param places
	 */
	public void roomUpload(Room[][] places)
	{
		rooms=places;
	}

	
	
	/**
	 * This method locates the target(current) room in the 2d array of rooms and returns the room in the array above the current array.
	 * the request room's character value is set to true.
	 * @param target
	 * @return request
	 * @throws SlickException
	 */
	public Room shiftUpOne(Room target) throws SlickException
	{
		
		//System.out.print("target: " +target.getID());
		Room request = new Room();
		for(int x=0;x<rooms.length;x++)
		{
			for(int y=0; y<rooms[x].length;y++)
			{
				if(target.getID()==rooms[x][y].getID() )
				{
					request = rooms[x][y];
					//System.out.println("room " + rooms[x][y].getID());
					request =rooms[x+1][y];
					rooms[x+1][y].setIsCharacter(true);
				}
			}
		}
		//System.out.print("req: " +request.getID());
		current=request;
		return request;
	}
	
	/**
	 * Like the last method this method locates the room below the target room and returns it.
	 * the request room's character value is set to true.
	 * @param target
	 * @return request
	 * @throws SlickException
	 */
	public Room shiftDownOne(Room target) throws SlickException
	{
		//System.out.print("target: " +target.getID());
		Room request = new Room();
		for(int x=0;x<rooms.length;x++)
		{
			for(int y=0; y<rooms[x].length;y++)
			{
				if(target.getID()==rooms[x][y].getID())
				{
				//	System.out.println("room " + rooms[y][x].getID());
					request =rooms[x-1][y];
					rooms[x-1][y].setIsCharacter(true);
				}
			}
		}
		//System.out.print("req: " +request.getID());
		current=request;
		return request;
	}
	
	/**
	 * Like the last method this method locates the room to the right of the target room and returns it.
	 * the request room's character value is set to true.
	 * @param target
	 * @return request
	 * @throws SlickException
	 */
	public Room shiftRightOne(Room target) throws SlickException
	{
		//System.out.print("target: " +target.getID());
		Room request = new Room();
		for(int x=0;x<rooms.length;x++)
		{
			for(int y=0; y<rooms[x].length;y++)
			{
				if(target.getID()==rooms[x][y].getID())
				{
					//System.out.println("room " + rooms[y][x].getID());
					request =rooms[x][y-1];
					rooms[x][y-1].setIsCharacter(true);
				}
			}
		}
		//System.out.print("req: " +request.getID());
		current=request;
		return request;
	}
	
	/**
	 * Like the last method this method locates the room to the left of the target room and returns it.
	 * the request room's character value is set to true.
	 * @param target
	 * @return request
	 * @throws SlickException
	 */
	public Room shiftLeftOne(Room target) throws SlickException
	{
		//System.out.print("target: " +target.getID());
		Room request = new Room();
		for(int x=0;x<rooms.length;x++)
		{
			for(int y=0; y<rooms[x].length;y++)
			{
				if(target.getID()==rooms[x][y].getID())
				{
					//System.out.println("room " + rooms[y][x].getID());
					request =rooms[x][y+1];
					rooms[x][y+1].setIsCharacter(true);
				}
			}
		}
		//System.out.print("req: " +request.getID());
		current=request;
		return request;
	}
	
	/**
	 * this method search through the 2d array of rooms to find the room with the character value set to true
	 * @return
	 * @throws SlickException
	 */
	public Room currentRoom() throws SlickException
	{
		Room current = new Room();
		for(int x=0;x<rooms.length;x++)
		{
			for(int y=0; y<rooms[x].length;y++)
			{
				if(rooms[x][y].getIsCharacter())
				{
					current = rooms[x][y];
					//System.out.print(current.getID());
				}
			}
		}
		return current;
		
	}
}
