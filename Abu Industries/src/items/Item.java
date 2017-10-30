package items;

public class Item {
	private String type; 
	private String strength;
	
	
	public Item (String type, String strength)
	{
		this.type = type;
		this.strength = strength;
	}
	public String getType()
	{
		return type;
	}
	public String getStrength()
	{
		return strength;
	}

}
