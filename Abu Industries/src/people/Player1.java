package people;


import java.util.Scanner;

import board.Board;
import items.Item;
import rooms.Room;
import game.Utilities;

public class Player1 extends Person{
	public Player1(String name, String type, Item[] item, int xcoord, int ycoord,int floor) {
			super(name,type,item,xcoord,ycoord,floor);
	}
	public int chooseMove(Board abu)
	{
		int x = getLocation()[0];
		int y = getLocation()[1];
		Room room = abu.getGamemap()[getFloor()][x][y];
		boolean[] door = abu.getGamemap()[getFloor()][x][y].getDoors();
		Scanner input = new Scanner(System.in);
		System.out.println("What do you want to do.");                      
        String statement = input.nextLine();
        if(Utilities.isNorth(statement)&& (x!=0) && door[3])
        {
        	return -2;
        }
        if(Utilities.isSouth(statement)&& (x!=2)&& door[1])
        {
        	return 2;
        }
        if(Utilities.isEast(statement)&& (y!=2) && door[0])
        {
        	return 1;
        }
        if(Utilities.isWest(statement)&& (y!=0) && door[2])
        {
        	return -1;
        }
        if(statement.equals("Take")&& (room.getItems().length) > 0)
        {
        	return 3;
        }
        if(statement.equals("Talk")&& (room.getNpc().length) > 1)
        {
        	return -3;
        }
        return 27;
	}
	
}
