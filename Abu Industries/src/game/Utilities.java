package game;

import board.Board;
import items.Item;
import people.Person;
import people.Player1;

public class Utilities {
	private static Item[] item;
	public static Person createPerson() {
		return new Player1("Sadman","Player",item,0,0,0);
	}
	public static Board movePlayer(Board abu, Person player1, int move) {
		int[] location = player1.getLocation();
		if(move == 1)
		{
			if(location[1] <= 1)
			{
				player1.setLocation(location[0], location[1]+1);
	//			abu[0][location[0]][location[1]+1].addNpc(player1);   NANI!!!!??
				return abu;
			}
		}
		if(move == -1)
		{
			if(location[1] >= 1)
			{
				player1.setLocation(location[0], location[1]-1);
				return abu;
			}
		}
		if(move == 2)
		{
			if(location[0] <= 1)
			{
				player1.setLocation(location[0]+1, location[1]);
				return abu;
			}
		}
		if(move == -2)
		{
			if(location[1] >= 1)
			{
				player1.setLocation(location[0], location[1]);
				return abu;
			}
		}
		return abu;
		
	}

}
