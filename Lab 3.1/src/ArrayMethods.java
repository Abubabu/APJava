import java.lang.reflect.Array;

public class ArrayMethods {

	public static void main(String[] args)
	{
		int[] yes = {0,1,2,3,3,4,1,3,4,4,1};
		
		for(int i = 0; i <  removeDuplicates(yes).length-1; i++)
		{
			System.out.println( removeDuplicates(yes)[i]);
		}
	
	}
	public static int[ ] removeDuplicates(int[ ] org)
	{
		boolean [] copy = new boolean[org.length];
		int count = 0;
		int x = 0;
		copy[0] = false;
		for(int  i = 0; i < org.length-2; i++)
		{
			for(int j = i+1; j < org.length-1; j++)
			{
				if(org[i] == org[j])
				{
					copy[j] = true;
					count++;
				}
				else {
					if(!copy[j])
					{
						copy[j] = false;
					}
					continue;
				}
				
			}
		}
		int[] finalCopy = new int[org.length-count];
	/*	for(int i = 0; i <  finalCopy.length-1; i++)
		{
			System.out.println( finalCopy[i]);
		}*/
	//	System.out.println("------------------------------------------------");
		int secondcount = 0;
		while(x < finalCopy.length)
		{
			if(!copy[x])
			{
				finalCopy[secondcount] = org[x];
				x++;
				secondcount++;
			}
			else
				x++;
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
