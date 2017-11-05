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
        	System.out.print("[HALL]"); 
        }

    }	
    public String toString()
    {
    	boolean[] doors = this.getDoors();
    	String response = "This is a hallway. It has doors to the";
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
    	
    	return response + "\n";
    }

	
}
