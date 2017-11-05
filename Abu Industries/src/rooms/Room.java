package rooms;

import people.Boss;
import people.Person;
import items.Item;

import java.util.Arrays;

public class Room {
    private boolean[] doors;
    private Person[] npc;
    private Item[] items;
    public boolean explored;
    private int x, y, k;
    private Boss[] boss;

    public Room(boolean[] doors, Person[] npc, Item[] items, int x, int y, int k)
    {
    	this.x = x;
    	this.y = y;
    	this.k = k;
        this.doors = doors;
        this.npc = npc;
        this.items = items;
        this.explored = false;
    }
    //Overloaded
    public Room(boolean[] doors, Boss[] boss,Person[] npc, Item[] items, int x, int y, int k)
    {
    	this.x = x;
    	this.y = y;
    	this.k = k;
        this.doors = doors;
        this.boss = boss;
        this.npc = npc;
        this.items = items;
        this.explored = false;
    }
    public  Person[] getNpc() {
        return npc;
    }
    public void setNpc(Person[] npc) {
        this.npc = npc;
    }
    public void removeNpc()
    {
    	this.npc = Arrays.copyOf(this.npc,this.npc.length-1); //player1 is always the last person in the array
    }
    public void addNpc(Person p)
    {
        this.npc = Arrays.copyOf(this.npc,this.npc.length+1);
        this.npc[this.npc.length-1] = p;
    }
    public boolean[] getDoors()
    {
    	return doors;
    }
    public int getX()
    {
    	return x;
    }
    public int getY()
    {
    	return y;
    }
    public int[] getLocation()
	{
		int[] buf = {x,y};
		return buf;
	}
    public Item[] getItems()
    {
    	return items;
    }
    public void removeItemAtIndex(int x)
	{
		if(x == 0)
		{	
			System.out.println("1");
			Item[] items = new Item[0];
			System.out.println(items.length);
			this.items = items;
		}
		else
		{
			Item[] items = new Item[this.items.length-1];
			int alt = 0;
			for(int i = 0; i < this.items.length-1; i++)
			{
				if(i == (x-1))
				{
					continue;
				}
				items[alt] = this.items[i];
				alt++;
			}
			this.items = items;
		}
	}
    public void isExplored()
    {
    	this.explored = true;
    }
    public void print(int k, int j, int i)
    {
    	 if (isPlayer1Here())	
         {
         	System.out.print("[YOU]");
         }
        else if (this.explored)
        {
            System.out.print("[E]");
        }
        else
        {
        	System.out.print("[ROOM]");
        }

    }	
    public String toString()
    {
    	boolean[] doors = this.getDoors();
    	String response = "This is a Room. It has doors to the";
    	if (doors[0])
    	{
    		response += " E";
    	}
    	
    	if(doors[1]) {
    		response += " S";
    	}
    	
    	if (doors[2]) {
    		response += " W";
    	}
    	
    	if (doors[3]) {
    		response += " N";
    	}
    	response += "\n" + "there are " + this.getItems().length + " items in this room. ";
    	response += "\n" + "there are " + (this.getNpc().length-1) + " other people in this room. ";
    	return response + "\n";
    }
    public boolean isPlayer1Here()
	{
    	Person[] peeps = getNpc();
		for(int i = 0; i<peeps.length; i++)
		{
			if((peeps[i].getType()).equals("Player1"))
			{
				return true;
			}
		}
		return false;
	}
}
