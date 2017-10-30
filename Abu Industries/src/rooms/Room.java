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
        if (getNpc().length != 0)	//prints out pointer to player1
        {
  //          System.out.print(getNpc()[0].print());
        	System.out.print("[Player1]");
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
}
