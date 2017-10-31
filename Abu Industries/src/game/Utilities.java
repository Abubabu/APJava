package game;

import board.Board;
import items.Item;
import people.Civilian;
import people.Person;
import people.Player1;

public class Utilities {
	private static Item[] item;
	public static Person createPerson() {
		return new Player1("Sadman","Player",item,0,0,0);
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
			if(location[1] >= 1)
			{
				player1.setLocation(location[0]-1, location[1]);
				abu.getGamemap()[0][location[0]-1][location[1]].addNpc(player1);   
				return abu;
			}
		}
		return abu;
		
	}
	public static Person[] getRandNpc(int k ,int j, int i) {
		int num = (int)Math.random()*4;
		Person[] npc = new Person[num];
		for(int z = 0; z < num; z++)
		{
			npc[z] = new Civilian("John doe","Civilian",getRandItem(k,j,i)[0],i,j,k);
		}
		return null;
	}
	public static Item[] getRandItem(int k ,int j, int i) {
		int num = (int)Math.random()*2;
		Item[] npc = new Item[num];
		for(int z = 0; z < num; z++)
		{
			npc[z] = new Item("weapon", "strong");
		}
		return null;
	}

}
