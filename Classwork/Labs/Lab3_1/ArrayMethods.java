package Lab3_1;

public class ArrayMethods {
  
	public static void main(String[] args)
	{
		int[] yes = {0,1,2,3,3,4,1,3,4,4,1};
		
		for(int i = 0; i <  removeDuplicates(yes).length-1; i++)
		{
			System.out.println( removeDuplicates(yes)[i]); //Test removeDuplicate function
		}
		
		int[] test = {1,2,4};
		int[] test1 = {1,2,4};
		int[][] answer = productArray(test,test1);
		for(int i = 0; i < test.length; i++)
		{
			for(int j = 0; j < test1.length; j++)
			{
				System.out.print(answer[i][j]);	//Test productArray function
			}
			System.out.println();
		}
		int[][] result = pascalTriangle(8);
		for (int[] x : result)
		{
		   for (int y : x)
		   {
		        System.out.print(y + " "); //Test pascalTriangle function
		   }
		   System.out.println();
		}
		printPascalTriangle(result);	//Test printPascalTriangle function
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
	public static int[][] productArray(int[] row,int[] col)
	{
		int[][] result = new int[row.length][col.length];
		for(int i = 0; i < row.length; i++)//Row
		{
			int[] loop = new int[row.length];
			for(int j = 0; j < row.length; j++)//col
			{
				loop[j] = row[i]*col[j];
			}
			result[i] = loop;
		}
		return result;
	}
	public static int[][] pascalTriangle(int num)
	{
		if(num == 1)
		{
			int[][] one= {{1}};
			return one;
		}
		int[][] pascal = new int[num][];
		int[] lastRow = {1};
		for(int i = 0; i < num; i++)
		{
			
			int[] loop = new int[i+1];
			loop[0] = 1;
			loop[loop.length-1] = 1;
			for(int j = 1; j< loop.length-1; j++)
			{
				loop[j] = lastRow[j] + lastRow[j-1];
			}
			pascal[i] = loop;
			lastRow = loop;
		}
		return pascal;
	}
	public static void printPascalTriangle(int[][] pTriangle)
	{
		int lastRowVal = (pTriangle[pTriangle.length-1].length);
		for(int i = 0; i < pTriangle.length-1;i++)
		{
			int index = lastRowVal - pTriangle[i].length;
			for(int k = 0; k < index; k++)
			{
				System.out.print(" ");
			}
			for(int j = 0; j <= pTriangle[i].length-1; j++)
			{
				if(j == pTriangle[i].length-1 )
				{
					System.out.print(pTriangle[i][j]);
				}
				else
				{
				System.out.print(pTriangle[i][j]+ " ");
				}
			}
			for(int k = 0; k < index; k++)
			{
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	public static int[] copyArray(int[] intArray) //Helper function
	{
		int[] copy = new int[intArray.length];
		for(int i = 0; i< intArray.length; i++)
		{
			copy[i] = intArray[i];
		}
		return copy;
	}
}

