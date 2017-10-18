
public class Pentagon implements Shape {
	private int side;
	public Pentagon(int side)
	{
		this.side = side;
	}
	
	@Override
    public double calculateArea() {
        return .25*(Math.sqrt(5*(5+(2*Math.sqrt(5))))*(side*side));
    }

    @Override
    public double calculatePerimeter()
    {
        return 5*side;
    }

    @Override
    public String toString()
    {
        return "Pentagon side: " + side + " Area: " + this.calculateArea() + " Perimeter: " + this.calculatePerimeter();
    }
}
