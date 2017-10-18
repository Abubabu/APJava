
public class Square extends Rectangle{
	int side;
	public Square(int side)
    {
        super(side,side);
        this.side = side;
    }

    @Override
    public String toString()
    {
    	return "Square side: " + side + " Area: " + this.calculateArea() + " Perimeter: " + this.calculatePerimeter(); 
    }
}
