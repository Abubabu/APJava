package people;

import items.Item;

public class Boss extends Person {

	public Boss(String name, String type, Item[] item, int xcoord, int ycoord, int floor) {
		super(name, type, item, xcoord, ycoord,floor);
		// TODO Auto-generated constructor stub
	}
	 public void print()
	    {
		 	System.out.println("hello Boss");
	    }
}