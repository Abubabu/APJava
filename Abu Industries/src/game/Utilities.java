package game;

import board.Board;
import items.Item;
import people.Civilian;
import people.Person;
import people.Player1;
import rooms.Bossroom;

public class Utilities {
	public static Player1 createPerson(String name) {
		Item[] item = {new Item("Sword",1)};
		return new Player1(name,"Player1",item,0,0,0);
	}
	public static Board movePlayer(Board abu, Person player1, int move) {
		int[] location = player1.getLocation();
		if(move>=-2 && move <= 2)
		{
			abu.getGamemap()[player1.getFloor()][location[0]][location[1]].removeNpc();//removes player1 from the room they were in
			abu.getGamemap()[player1.getFloor()][location[0]][location[1]].isExplored();//sets that room to explored
			if(move == 1)   //East
			{
				if(location[1] <= 1)		//array out of bounds check
				{
					player1.setLocation(location[0], location[1]+1);								 //sets location to target room
					abu.getGamemap()[player1.getFloor()][location[0]][location[1]+1].addNpc(player1);   //adds player1 to target room
					return abu;                                                                         //returns updated game map
				}
			}
			if(move == -1)	//South
			{
				if(location[1] >= 1)
				{
					player1.setLocation(location[0], location[1]-1);
					abu.getGamemap()[player1.getFloor()][location[0]][location[1]-1].addNpc(player1);   
					return abu;
				}
			}
			if(move == 2)	//West
			{
				if(location[0] <= 1)
				{
					player1.setLocation(location[0]+1, location[1]);
					abu.getGamemap()[player1.getFloor()][location[0]+1][location[1]].addNpc(player1);   
					return abu;
				}
			}
			if(move == -2)	//North
			{
				if(location[0] >= 1)
				{
					player1.setLocation(location[0]-1, location[1]);
					abu.getGamemap()[player1.getFloor()][location[0]-1][location[1]].addNpc(player1);   
					return abu;
				}
			}
		}
		if(move == 3)	//Take
		{
			Item.print(abu.getGamemap()[player1.getFloor()][location[0]][location[1]].getItems());
			int index = player1.swapWeapon(abu.getGamemap()[player1.getFloor()][location[0]][location[1]]);
			if(index == 27)
			{
				return abu;
			}
			abu.getGamemap()[player1.getFloor()][location[0]][location[1]].removeItemAtIndex(index);
			return abu;
		}
		if(move == -3)	//Talk
		{
			Civilian.print(player1.getFloor());
				return abu;
			
		}
		return abu;
		
	}
	public static Board movePlayerFloor(Board abu, Person player1, int move) {
		abu.getGamemap()[player1.getFloor()][player1.getLocation()[0]][player1.getLocation()[1]].removeNpc();
		abu.getGamemap()[player1.getFloor()][player1.getLocation()[0]][player1.getLocation()[1]].isExplored();
		player1.setLocation(move,0,0);
		abu.getGamemap()[move][0][0].addNpc(player1);   
		return abu;
	}
	public static Person[] getRandCivs()
	{
		int rand = (int)(Math.random()*4);
		Person[] peeps = new Person[rand];
		for(int i = 0; i < rand; i++)
		{
			peeps[i] = new Civilian("XD","Yeet",getRandItems());  //Civs have weapons but they don't do anything with it in game...
		}
		return peeps;
	}
	public static Item[] getRandItems()		
	{
		int rand = (int)(Math.random()*4);
		Item[] stuff = new Item[rand];
		for(int i = 0; i < rand; i++)
		{
			stuff[i] = new Item(getType(),getRandStrength());
		}
		return stuff;
	}
	public static int getRandStrength()
	{
		return (int)((Math.random()*100)+1);
	}
	public static String getType()
	{
		String[] types = {"Sword","Axe","Spear","Gun"};
		int num = (int)(Math.random()*97);
		if(num < 31)
		{
			return types[0];
		}
		else if(num < 62)
		{
			return types[1];
		}
		else if(num < 93)
		{
			return types[2];
		}
		else
		{
			return types[3];
		}
	}
	public static int bossTrigger(Player1 player1) { 		
		if(player1.getLocation()[0]== 2 && player1.getLocation()[1] == 1 )
		{
			return Bossroom.bossfight(player1);
		}
		return 3;
	}
	public static boolean isNorth(String x)
	{
		return(x.equals("N")||x.equals("n")||x.equals("North")||x.equals("north"));
	}
	public static boolean isSouth(String x)
	{
		return(x.equals("S")||x.equals("s")||x.equals("South")||x.equals("south"));
	}
	public static boolean isEast(String x)
	{
		return(x.equals("E")||x.equals("e")||x.equals("East")||x.equals("east"));
	}
	public static boolean isWest(String x)
	{
		return(x.equals("W")||x.equals("w")||x.equals("West")||x.equals("west"));
	}
	
}
