package rooms;

import items.Item;
import people.Boss;
import people.Person;
import people.Player1;

public class Bossroom extends Room {

    public Bossroom(boolean[] doors, Boss[] people,Person[] npc, Item[] items, int x, int y,int k)
    {
        super(doors, people,npc, items, x, y,k);
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
    	   System.out.print("[BOSS]");
        }
    }	
    public static int bossfight(Player1 player1) 
    {
    	int floor = player1.getFloor();
        String[] text = {
        "I AM THE ROCK!!!!",
        "LEEEEEEEEROYYYY JENKIIIIINS",
        "I've been waiting...."
        };
        if(floor == 0)
        {
        	System.out.println(text[0]);
        	System.out.println("The Rock attacks you with his 65 strength Sword!");
        	if(damageCheck(player1,65,"Sword"))
        	{
        		System.out.println("The Rock has killed you, better luck next time!");
        		return 0;
        	}
        	System.out.println("You have defeated The Rock! Time to find our next target.\n");
        	try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	return 1;
        }
        if(floor == 1)
        {
        	System.out.println(text[1]);
        	System.out.println("LEEEEEEEEROYYYY attacks you with his 75 strength Spear!");
        	if(damageCheck(player1,75,"Spear"))
        	{
        		System.out.println("LEEEEEEEEROYYYY has killed you, better luck next time!");
        		return 0;
        	}
        	System.out.println("You have defeated LEEEEEEEEROYYYY! Time to find our final target.\n");
        	try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	return 2;
        }
        if(floor == 2)
        {
        	System.out.println(text[2]);
        	System.out.println("Steve Jobs attacks you with his 85 strength Axe!");
        	if(damageCheck(player1,85,"Axe"))
        	{
        		System.out.println("Steve Jobs has killed you, better luck next time!");
        		return 0;
        	}
        	System.out.println("You have defeated Steve Jobs!\nCongrats, you have taken over Abu Industries!");
        	System.out.println("Thanks For Playing");
        	return 0;
        }
        return 0;
    }	
	private static boolean damageCheck(Player1 player1,int strength, String type) {
		int playerStrength = player1.getItems()[0].getStrength();
		String playerType = player1.getItems()[0].getType();
		if(playerType.equals("Sword") && type.equals("Axe"))
		{
			playerStrength += 10;
		}
		if(playerType.equals("Axe") && type.equals("Spear"))
		{
			playerStrength += 10;
		}
		if(playerType.equals("Spear") && type.equals("Sword"))
		{
			playerStrength += 10;
		}
		if(playerType.equals("Axe") && type.equals("Sword"))
		{
			playerStrength = playerStrength - 10;
		}
		if(playerType.equals("Spear") && type.equals("Axe"))
		{
			playerStrength = playerStrength - 10;
		}
		if(playerType.equals("Sword") && type.equals("Spear"))
		{
			playerStrength = playerStrength - 10;
		}
		if(playerType.equals("Gun"))		//Sword > Axe    Axe > Spear   Spear > Sword   Gun beats all 
		{
			return false;
		}
		
		if(playerStrength > strength) //checks who is stronger after strength adjustments
		{
			return false;
		}
		else
		{
			return true;
		}	
	}
}
