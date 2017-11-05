package people;

import items.Item;

public class Civilian extends Person{

	public Civilian(String name, String type, Item[] item) {
		super(name, type, item);
	}
	public static void print(int floor)
    {
		String[] text = {      			
		"Why are you talking to me?\n",
		"Shoooo! I'm very busy!\n",
		"What's up dude\n",
		""							//placeholder for hint
		};
		if(floor == 0)   //Hints for the player
		{
			text[3] = "I saw a man with a 65 strength Sword down the hall, be careful!";
		}
		if(floor == 1)
		{
			text[3] = "I saw a man with a 75 strength Spear down the hall, be careful!";
		}
		if(floor == 2)
		{
			text[3] = "I saw a man with an 85 strength Axe down the hall, be careful!";
		}
		System.out.println(text[(int)(Math.random()*3.3)]);		//set text randomly chosen to civilian
    }
	
}
