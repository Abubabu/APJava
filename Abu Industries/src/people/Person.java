package people;

import java.util.Scanner;

import items.Item;
import rooms.Room;

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
	//Overloaded
	public Person(String name, String type, Item[] item, int xcoord, int ycoord,int floor) 
	{
		this.name = name;
		this.type = type;
		this.item = item;
		this.xcoord = xcoord;
		this.ycoord = ycoord;
		this.floor = floor;
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
	public int swapWeapon(Room room) {
		Item[] items = room.getItems();
		Scanner input = new Scanner(System.in);
		String statement = input.nextLine();
		if(statement.equals("Yes")||statement.equals("yes"))
		{
			if(items.length == 1)
			{
				Item[] item = {new Item(items[0].getType(),items[0].getStrength())};
				this.item = item;
				System.out.println("You have taken the weapon\n");
				try {
					Thread.sleep(1200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return 0;
			}
			System.out.println("Type the number of the weapon you want to swap to");
			statement = input.nextLine();
			int index = Integer.parseInt(statement);
			while(index < 1 || index > items.length)
			{
				System.out.println("type in a valid number");
				statement = input.nextLine();
			}
			Item[] item = {new Item(items[index-1].getType(),items[index-1].getStrength())};
			this.item = item;
			System.out.println("You have taken the weapon\n");
			try {
				Thread.sleep(1200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return index;
		}
		return 27;
	}	
}
