package people;

import java.util.Scanner;

import items.Item;

public abstract class Person {
	private String name;
	private String type;
	private int xcoord;
	private int ycoord;
	private int floor;
	private Item[] item;
	
	public Person(String name,String type,Item[] item)
	{
		this.name = name;
		this.type = type;
		this.item = item;
	}
	public Person(String name, String type, Item[] item, int xcoord, int ycoord,int floor) {
		this.name = name;
		this.type = type;
		this.item = item;
		this.xcoord = xcoord;
		this.ycoord = ycoord;
		this.floor = floor;
}
	public Item getItem()
	{
		return item[0];
	}
	public Item[] getItems()
	{
		return item;
	}
	public String getName()
	{
		return name;
	}
	public String getType()
	{
		return type;
	}
	public int[] getLocation()
	{
		int[] buf = {xcoord,ycoord};
		return buf;
	}
	public int getFloor()
	{
		return floor;
	}
	public void setLocation(int floor, int xcoord, int ycoord)
	{
		this.xcoord = xcoord;
		this.ycoord = ycoord;
		this.floor = floor;
	}
	public void setLocation(int xcoord, int ycoord)
	{
		this.xcoord = xcoord;
		this.ycoord = ycoord;
	}
	public void swapWeapon() {
		Scanner input = new Scanner(System.in);
		String statement = input.nextLine();
		if(statement.equals("Yes"))
		{
			System.out.println("Type in the type of the weapon you want to swap to");
			statement = input.nextLine();
			while(!isFound(statement))
			{
				System.out.println("please type in a proper weapon type");
				statement = input.nextLine();
			}
			String type = statement;
			System.out.println("Now type in the strength of that weapon");
			statement = input.nextLine();
			int strength = Integer.parseInt(statement);
			Item[] item = {new Item(type,strength)};
			this.item = item;
			System.out.println("Your weapon has been swapped");
			
		}
		
	}
	private boolean isFound(String statement) {
		String[] types = {"Sword","Axe","Spear","Gun"};
		for(String a : types)
		{
			if(a.equals(statement))
			{
				return true;
			}
		}
		return false;
	}
	
}
