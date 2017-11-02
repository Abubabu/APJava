package game;
import rooms.Room;
import items.Item;
import people.Boss;
import people.Civilian;
import people.Person;
import people.Player1;
import rooms.*;


import java.util.Scanner;

import board.Board;


public class GameRunner {

    public static void main (String[] args)
    {
        Room[][][] map = new Room[3][3][3];
        for(int k = 0; k<map.length; k++) // k is floor
        {
        	Room[][] floor = map[k];
        	for (int j = 0; j<floor.length; j++) // j is x
            {
            	Room[] row = floor[j];
                for (int i = 0; i<row.length;i++) //i is y
                {
                    boolean[] doors = {false,false,false,false}; //N,E,S,W
                    Person[] people = Utilities.getRandCivs();                
                    Item[] items = Utilities.getRandItems();
                    if(i == 1 && j ==2)
                    {
                    	Person[] noone = {};
                    	Boss[] boss = new Boss[1];
                    	if(k == 1)
                    	{
                    		Item[] opSword = {new Item("Sword",65)};
                    		boss[0] = new Boss("The Rock","Boss",opSword);
                    	}
                    	if(k == 2)
                    	{
                    		Item[] opAxe = {new Item("Spear",75)};
                    		boss[0] = new Boss("LEEEEEEEEROYYYY JENKIIIIINS","Boss",opAxe);
                    	}
                    	if(k == 3)
                    	{
                    		Item[] opSpear = {new Item("Axe",85)};
                    		boss[0] = new Boss("Steve Jobs","Boss",opSpear);
                    	}
                    	Item[] noitems = {};
                    	doors[3] = true;
                    	row[i] = new Bossroom(doors, boss, noone, noitems, i, j,k);  // (if fight with boss is won, you move up a floor)
                    }
                    else if(i == 1)
                    {
                    	Person[] noone = {};
                    	Item[] noitems = {};
                    	doors[0] = true;
                    	doors[1] = true;
                    	doors[2] = true;
                    	if(j == 1)
                    	{
                    		doors[3] = true;
                    	}
                    	row[i] = new Hallway(doors, noone, noitems, i, j,k);
                    }
                    else
                    {
                    	if(j==2)  //adds west doors to 2-2- and 2-0
                    	{
                    		doors[3] = true;
                    	}
                    	if(j == 1)   //adds east doors to 1-2 and 1-0
                    	{
                    		doors[1] = true;
                    	}
                    	if(i==0 && j<=1) 	// adds north doors to 0-0 and 1-0
                    	{
                    		doors[0] = true;
                    	}
                    	if(i==2 && j<=1)	//adds south doors to 0-2 and 1-2
                    	{
                    		doors[2]= true;
                    	}
                    	row[i] = new Room(doors, people, items, i, j,k);
                    }
                    
                }

            }
        	
        }
        

        Board Abu = new Board(map);


        boolean gameOn = true;
        Scanner in = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = in.nextLine();
        Player1 player1 = Utilities.createPerson(name);
        System.out.println("Welcome to the Abu Industries, " + player1.getName());
        map[0][0][0].addNpc(player1);
        System.out.println();
        Abu.printMap();
        System.out.println("Keywords for the console: N(move north), S(move south), E(move east), W(move west), Take(take items), Talk(talk to npc).\nThe map is turned 90 degrees clockwise, North is actually east, East is south, South is west, and West is north");
        while(gameOn)
        {
            int move = player1.chooseMove(Abu);
            if(move==27)
            {
            	System.out.println("please input a valid move. ");
            	continue;
            }
            Abu = Utilities.movePlayer(Abu, player1,move);  //updates game map 
            int trigger = Utilities.bossTrigger(player1);
            if(trigger == 0)
            {
            	break;
            }
            if(trigger==1 || trigger ==2 )
            {
            	Abu = Utilities.movePlayerFloor(Abu, player1, trigger);
            }
            Abu.printMap();
            System.out.print(Abu.getGamemap()[player1.getFloor()][player1.getLocation()[0]][player1.getLocation()[1]].toString());
        }
		in.close();
    }


}