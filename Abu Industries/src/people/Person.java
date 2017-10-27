package people;

import items.Item;

public abstract class Person {
	private String name;
	private String type;
	private double coords;
	private int floor;
	private Item[] item;
	
	public Person(String name,String type,Item item,double coords,int floor)
	{
		this.name = name;
		this.type = type;
		this.item[0] = item;
		this.coords = coords;
		this.floor = floor;
	}
	public Person(String name,String type,Item[] item, double coords, int floor)
	{
		this.name = name;
		this.type = type;
		this.item = item;
		this.coords = coords;
		this.floor = floor;
	}
	public Item getItemsCiv()
	{
		return item[0];
	}
	public Item[] getItemsAll()
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
	public double getLocation()
	{
		return coords;
	}
	public double getFloor()
	{
		return floor;
	}
	public void setLocation(int floor, double coords)
	{
		this.coords = coords;
		this.floor = floor;
	}
}
