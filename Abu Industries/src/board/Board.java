package board;

import rooms.Room;

public class Board {


    private Room[][][] abuIndustries;
    private int floor;



    public Board(Room[][][] abuIndustries)
    {
        this.abuIndustries = abuIndustries;
    }
    //@Overloaded
    public Board(Room[][] abuIndustries,int floor)
    {	this.abuIndustries = new Room[0][3][3];
        this.abuIndustries[0] = abuIndustries;
        this.floor = floor;
    }

    public void printMap()
    {
    	 for(int k = 0; k<abuIndustries.length; k++)		//Calls the print function on every room in the board
         {
    		 System.out.println("Floor " + (k+1)+ ":");
         	Room[][] floor = abuIndustries[k];
         	for (int j = 0; j<floor.length; j++)
             {
             	Room[] row = floor[j];
                 for (int i = 0; i<row.length;i++)
                 {
                    row[i].print(k,j,i);
                 }
                 System.out.println();

             }
         	System.out.println("--------------------------------------------------------");
         }
    }
    public Room[][][] getGamemap() {
        return abuIndustries;
    }
    public void setGamemap(Room[][][] abuIndustries) {
        this.abuIndustries = abuIndustries;
    }
}
