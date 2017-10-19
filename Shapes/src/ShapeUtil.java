import java.util.Random;


public class ShapeUtil {
	public static double sumPerimeter(Shape[] shapeArr) {
		double sum = 0;
		for(int i = 0; i < shapeArr.length;i++ )
		{
			sum +=  shapeArr[i].calculatePerimeter();
		}
		return sum;
	}
	public static double sumArea(Shape[] shapeArr) {
		double sum = 0;
		for(int i = 0; i < shapeArr.length;i++ )
		{
			sum +=  shapeArr[i].calculateArea();
		}
		return sum;
	}
	public static Shape getRandomShape()
	{
		Random rand = new Random();
		int x = rand.nextInt(5);
		switch (x) 
        {
            case 0:
                return new Circle(rand.nextInt(100));
            case 1:
                return new Rectangle(rand.nextInt(50), rand.nextInt(50));
            case 2:
                return new Square(rand.nextInt(50));
            case 3:
            	return new Pentagon(rand.nextInt(50));
            case 4:
            	return new Trapezoid(rand.nextInt(50),rand.nextInt(50),rand.nextInt(50),rand.nextInt(50),rand.nextInt(50));
            default:
            	return new Circle(rand.nextInt(100));
        }
		
	}
}
