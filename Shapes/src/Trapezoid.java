
public class Trapezoid implements Shape {
    private int base1;
    private int base2;
    private int side1;
    private int side2;
    private int height;
    public Trapezoid(int base1,int base2,int side1,int side2,int height)
    {
        this.base1 = base1;
        this.base2 = base2;
        this.side1 = side1;
        this.side2 = side2;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return ((base1+base2)/2)*height;
    }

    @Override
    public double calculatePerimeter()
    {
        return base1+base2+side1+side2;
    }

    @Override
    public String toString()
    {
        return "Trapizoid base1: " + base1 + " Trapizoid base2: " + base2 + " Trapizoid side1: " + side1 + " Trapizoid side2: " + side2 + " Area: " + this.calculateArea() + " Perimeter: " + this.calculatePerimeter();
    }
}
