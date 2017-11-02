package people;

import items.Item;

public class Civilian extends Person{

	public Civilian(String name, String type, Item[] item) {
		super(name, type, item);
		// TODO Auto-generated constructor stub
	}
	public static void print(int floor)
    {
		String[] text = {
		"Why are you talking to me?\n",
		"Shoooo! I'm very busy!\n",
		"What's up dude\n",
		""
		};
		if(floor == 0)
		{
			text[3] = "I saw a man with a big Sword down the hall, be careful!";
		}
		if(floor == 1)
		{
			text[3] = "I saw a man with a big Axe down the hall, be careful!";
		}
		if(floor == 2)
		{
			text[3] = "I saw a man with a big Spear down the hall, be careful!";
		}
		System.out.println(text[(int)(Math.random()*3.3)]);
    }
	
}
