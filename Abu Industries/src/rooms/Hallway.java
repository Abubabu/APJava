package rooms;

import people.Person;
import items.Item;


public class Hallway extends Room {

    public Hallway(boolean[] doors, Person[] people, Item[] items, int x, int y,int k)
    {
        super(doors, people, items, x, y,k);
    }

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
            System.out.print("["+ k + j + i + "H]");
        }

    }	
 /*   public void print()
    {
        if (getNpc().length != 0)
        {
  //          System.out.print(getNpc()[0].print());
        	System.out.print(getNpc()[0]);
        }
        else if (this.explored)
        {
            System.out.print("[E]");
        }
        else
        {
            System.out.print("[ ]");
        }

    }	*/
    
    public String toString()
    {
    	boolean[] doors = this.getDoors();
    	String response = "This is a hallway. It has doors to the ";
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
    	
    	return response + "\n";
    }

	
}
