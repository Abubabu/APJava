
public class Rectangle implements Shape{
	private double height;
	private double width;
	public double calculateArea() {
       return height*width;
    }

    @Override
    public double calculatePerimeter() {
        return (height*2)+(width*2);
    }

    @Override
    public String toString()
    {
        return "Rectangle Width: " + width + " Height: " + height + " Area: " + this.calculateArea() + " Perimeter: " + this.calculatePerimeter();
    }
	 public Rectangle(int height, int width) {
	        this.height = height;
	        this.width = width;
	    }
}
