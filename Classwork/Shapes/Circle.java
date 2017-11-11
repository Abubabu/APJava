
public class Circle implements Shape{
	private int radius;
    private static double pi = 3.14159265;

    public Circle(int radius){
       this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return pi*(radius*radius);
    }

    @Override
    public double calculatePerimeter()
    {
        return pi*(2*radius);
    }

    @Override
    public String toString()
    {
        return "Circle radius: " + radius + " Area: " + this.calculateArea() + " Perimeter: " + this.calculatePerimeter();
    }
}
