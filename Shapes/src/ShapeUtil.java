import java.util.Random;
public class ShapeUtil {
	public static double sumPerimiter(Shape[] shapeArr) {
		double sum = 0;
		for(int i = 0; i < shapeArr.length;i++ )
		{
			sum +=  shapeArr[i].calculatePerimiter();
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
		int x = rand.nextInt(100);
		switch(x)
		{
		case(0):
			return Circle(rand.nextInt(100)+1);
		case(1):
			return Rectangle(rand.nextInt(100)+1);
		default: 
			return Square(10);
		}
		
	}
}
