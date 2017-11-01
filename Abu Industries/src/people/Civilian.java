package people;

import items.Item;

public class Civilian extends Person{

	public Civilian(String name, String type, Item[] item) {
		super(name, type, item);
		// TODO Auto-generated constructor stub
	}
	public void print()
    {
		System.out.println("hello Civilian");
    }
}
