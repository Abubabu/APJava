package items;

public class Item implements items{
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
		String response;
		if(items.length == 1)
		{
			response = "There is only one weapon here, " + sentenceFormatter(items[0].getType()) + " with " + items[0].getStrength() + " strength.";
		}
		else
		{
			response = "There are many weapons here \n";
			for(int i = 0; i < items.length; i++)
			{
				response += (i+1) + ": " + sentenceFormatter(items[i].getType()) + " with " + items[i].getStrength() + " strength\n";
			}
		}
		response += "\n Would you like to swap your weapon? ";
		System.out.println(response);
	}
	public static String sentenceFormatter(String x)
	{
		if(x.equals("Axe"))
		{
			return "an " + x;
		}
		return "a " + x; 	
	}
}
