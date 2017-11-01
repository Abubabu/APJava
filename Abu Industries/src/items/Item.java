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
	//Sword x Axe    Axe x Spear   Spear X Sword  The gun beast all 
}
