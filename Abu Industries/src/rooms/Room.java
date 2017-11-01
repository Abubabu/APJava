package rooms;

import people.Person;
import items.Item;

import java.util.Arrays;

public class Room {

    private boolean[] doors;
    private Person[] npc;
    private Item[] items;
    public boolean explored;
    private int x, y, k;

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
    public  Person[] getNpc() {
        return npc;
    }
    public void setNpc(Person[] npc) {
        this.npc = npc;
    }
    public void removeNpc()
    {
    	this.npc = Arrays.copyOf(this.npc,this.npc.length-1);
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
    public Item[] getItems()
    {
    	return items;
    }
    public void isExplored()
    {
    	this.explored = true;
    }
  //  public abstract void print(int k, int j, int i);
    public void print(int k, int j, int i)
    {
    	 if (isPlayer1Here())	//prints out pointer to player1
         {
   //          System.out.print(getNpc()[0].print());
         	System.out.print("[player1]");
         }
        else if (this.explored)
        {
            System.out.print("[E]");
        }
        else
        {
            System.out.print("["+ k + j + i + "R]");
        }

    }	
    public String toString()
    {
    	boolean[] doors = this.getDoors();
    	String response = "This is a Room. It has doors to the ";
    	if (doors[0])
    	{
    		response += "N";
    	}
    	
    	if(doors[1]) {
    		response += " and E";
    	}
    	
    	if (doors[2]) {
    		response += " and S";
    	}
    	
    	if (doors[3]) {
    		response += " and W";
    	}
    	response += "\n" + "there are " + this.getItems().length + " items in this room. ";
    	response += "\n" + "there are " + this.getNpc().length + " people in this room. ";
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
