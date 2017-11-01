package game;

import board.Board;
import items.Item;
import people.Civilian;
import people.Person;
import people.Player1;

public class Utilities {
	private static Item[] item;
	public static Person createPerson() {
		return new Player1("Sadman","Player1",item,0,0,0);
	}
	public static Board movePlayer(Board abu, Person player1, int move) {
		int[] location = player1.getLocation();
		abu.getGamemap()[player1.getFloor()][player1.getLocation()[0]][player1.getLocation()[1]].removeNpc();
		abu.getGamemap()[player1.getFloor()][player1.getLocation()[0]][player1.getLocation()[1]].isExplored();
	if(move == 1)   //North
		{
			if(location[1] <= 1)
			{
				player1.setLocation(location[0], location[1]+1);
				abu.getGamemap()[0][location[0]][location[1]+1].addNpc(player1);   
				return abu;
			}
		}
		if(move == -1)	//South
		{
			if(location[1] >= 1)
			{
				player1.setLocation(location[0], location[1]-1);
				abu.getGamemap()[0][location[0]][location[1]-1].addNpc(player1);   
				return abu;
			}
		}
		if(move == 2)	//East
		{
			if(location[0] <= 1)
			{
				player1.setLocation(location[0]+1, location[1]);
				abu.getGamemap()[0][location[0]+1][location[1]].addNpc(player1);   
				return abu;
			}
		}
		if(move == -2)	//West
		{
			if(location[0] >= 1)
			{
				player1.setLocation(location[0]-1, location[1]);
				abu.getGamemap()[0][location[0]-1][location[1]].addNpc(player1);   
				return abu;
			}
		}
		return abu;
		
	}
	public static Person[] getRandCivs()
	{
		int rand = (int)(Math.random()*4);
		Person[] peeps = new Person[rand];
		for(int i = 0; i < rand; i++)
		{
			peeps[i] = new Civilian("XD","Yeet",getRandItems());  //GETS RAND ITEMS FOR THE PERSON
		}
		return peeps;
	}
	public static Item[] getRandItems()		//USED TO GET RAND ITEMS FOUND IN THE ROOM
	{
		int rand = (int)(Math.random()*3);
		Item[] stuff = new Item[rand];
		for(int i = 0; i < rand; i++)
		{
			stuff[i] = new Item(getType(),getRandStrength());
		}
		return stuff;
	}
	public static int getRandStrength()
	{
		return (int)(Math.random()*100+1);
	}
	public static String getType()
	{
		String[] types = {"Sword","Axe","Spear","Gun"};
		int num = (int)(Math.random()*101);
		if(num > 33)
		{
			return types[0];
		}
		else if(num > 66)
		{
			return types[1];
		}
		else if(num > 99)
		{
			return types[2];
		}
		else
		{
			return types[3];
		}
	}
	
}
