package people;


import java.util.Scanner;

import board.Board;
import items.Item;
import rooms.Room;

public class Player1 extends Person{
	public Player1(String name, String type, Item[] item, int xcoord, int ycoord,int floor) {
			super(name,type,item,xcoord,ycoord,floor);
	}
	public void print()
	{
		 System.out.println("hello player1");
	}
	public int chooseMove(Board abu)
	{
		int x = getLocation()[0];
		int y = getLocation()[1];
		Room room = abu.getGamemap()[getFloor()][getLocation()[0]][getLocation()[1]];
		boolean[] rooms = abu.getGamemap()[getFloor()][getLocation()[0]][getLocation()[1]].getDoors();
		Scanner input = new Scanner(System.in);
		System.out.println("Type what you would like to do.");                            //Chatbot's greeting/opening message
        String statement = input.nextLine();
        if(statement.equals("N")&& (y!=2) && rooms[0])
        {
        	return 1;
        }
        if(statement.equals("S")&& (y!=0)&& rooms[2])
        {
        	return -1;
        }
        if(statement.equals("E")&& (x!=2) && rooms[1])
        {
        	return 2;
        }
        if(statement.equals("W")&& (x!=0) && rooms[3])
        {
        	return -2;
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
