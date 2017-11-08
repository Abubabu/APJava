import java.lang.reflect.Array;

public class ArrayMethods {

	public static void main(String[] args)
	{
	
	
	}
	public static int[ ] removeDuplicates(int[ ] org)
	{
		boolean [] copy = new boolean[org.length];
		int count = 0;
		int x = 0;
		for(int  i = 0; i < org.length-1; i++)
		{
			for(int j = i+1; j < org.length; j++)
			{
				if(org[i] == org[j])
				{
					copy[j] = true;
					count++;
				}
				else {
					copy[j] = false;
				}
			}
		}
		int[] finalCopy = new int[org.length-count];
		while(x < (org.length-count))
		{
			if(!copy[x])
			{
				finalCopy[x] = org[x];
				x++;
			}
		}
		return finalCopy;
	}
	
	
	
	
	public static int[] copyArray(int[] intArray)
	{
		int[] copy = new int[intArray.length];
		for(int i = 0; i< intArray.length; i++)
		{
			copy[i] = intArray[i];
		}
		return copy;
	}
}
