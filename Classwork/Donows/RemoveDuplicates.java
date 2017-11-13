
public class RemoveDuplicates {

	public static void main(String[] args)
	{
		int[] test1 = {1,4,4,5,2,4,2,5};
		int[] test2 = {34,2,7,7,7};
		int[] test3 = {};
		
		long startTime = System.nanoTime(); // Record the startTime
		System.out.println(countUnique(test1)); //4
		long endTime = System.nanoTime(); //Record Endtime
		long totalTime = endTime-startTime;
		System.out.println("Time taken  in naoseconds: " + totalTime);
		
		System.out.println(countUnique(test2));//3
		System.out.println(countUnique(test3));//0
	}

	public static int countUnique(int[] numbers) {
		int count = 0;
		
		for(int i = 0; i < numbers.length; i++)
		{
			//Assume the number is unique at first
			boolean unique = true;
			
			//check all the subsequent  numbers
			for(int j = i+1; j < numbers.length; j++)
			{
				if(numbers[i] == numbers[j])
				{
					unique = false;//If we found an equivalent number, unique is false
					break;
				}
			}
			//If unique stayed true, we add 1 to the unique count
			if(unique)
			{
				count++;
			}
		}
		return count;
	}
}
