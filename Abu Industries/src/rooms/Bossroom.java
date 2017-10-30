package rooms;

import items.Item;
import people.Person;

public class Bossroom extends Room {

    public Bossroom(boolean[] doors, Person[] people, Item[] items, int x, int y,int k)
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
            System.out.print("["+ k + j + i + "B]");
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
    
   

}
