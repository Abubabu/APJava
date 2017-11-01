package people;


import items.Item;

public class Player1 extends Person{
	public Player1(String name, String type, Item[] item, int xcoord, int ycoord,int floor) {
			super(name,type,item,xcoord,ycoord,floor);
	}
	public void print()
	{
		 System.out.println("hello player1");
	}
	

}
