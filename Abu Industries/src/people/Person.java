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
	
	public Person(String name,String type,Item item,int xcoord,int ycoord,int floor)
	{
		this.name = name;
		this.type = type;
		this.item[0] = item;
		this.xcoord = xcoord;
		this.ycoord = ycoord;
		this.floor = floor;
	}
	//@overload
	public Person(String name,String type,Item[] item, int xcoord, int ycoord, int floor)
	{
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
	public int chooseMove()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Type which direction you would like to go in.");                            //Chatbot's greeting/opening message
        String statement = input.nextLine();
        if(statement.equals("N"))
        {
        	return 1;
        }
        if(statement.equals("S"))
        {
        	return -1;
        }
        if(statement.equals("E"))
        {
        	return 2;
        }
        if(statement.equals("W"))
        {
        	return -2;
        }
        return 27;
	}
	public abstract void print();
}
