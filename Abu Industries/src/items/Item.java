package items;

public class Item {
	private String type; 
	private int strength;
	
	
	public Item (String type, int strength)
	{
		this.type = type;
		this.strength = strength;
	}
	public String getType()
	{
		return type;
	}
	public int getStrength()
	{
		return strength;
	}
	public static void print(Item[] items)
	{
		String response = "In this room, there is ";
		for(Item a : items)
		{
			response += "a " + a.getType()+ " with " + a.getStrength() + " strength, \n";
		}
		response += "\n Would you like to swap your weapon? ";
		System.out.println(response);
	}
	//Sword x Axe    Axe x Spear   Spear X Sword  The gun beats all 
}
