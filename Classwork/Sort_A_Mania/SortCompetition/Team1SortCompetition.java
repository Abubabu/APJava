package SortCompetition;

public class Team1SortCompetition extends SortCompetition {
	public static void main(String[] args)
	{
		int j = 0;
		double avg1 = 0;
		int[] time1 = new int[10000];
		while(j < 100)
		{
			for(int i = 0; i < 1; i++)
			{
				for(int k = 0; k < 10000; k++)
				{
					time1[k] = (int) (Math.random()*10000); //need to have semi-sorted array
				}
				long startime  = System.nanoTime();
				challengeThree(time1);
				long endtime = System.nanoTime();
				long finalTime = endtime - startime;
				avg1 += finalTime;
			}
			j++;
		}
		System.out.print(avg1/100);
	}
	
	public  int challengeOne(int[] nums) //Counting Sort
	{
		countingSort(nums);
		return medianFixed(nums);
	}
	public int challengeTwo(String[] strings, String query) //Counting Sort
	{
		return 0;
	}
	public int challengeThree(int[] num) //Insertion Sort
	{
		insertionSort(num);
		return medianFixed(num);
	}
	public int challengeFour(int[][] nums) //Tim Sort
	{
		int[] associatedArray = new int[nums.length];
		for(int i = 0; i < nums.length; i++)
		{
			//TimSort(nums[i]);
			associatedArray[i] = medianFixed(nums[i]);
		}
		//TimSortParalell(associatedArray,nums);
	//	return medianFixed(   nums[		medianFixed(nums.length)		]	) ///ASK LEVIN WTH THE MEDIAN ARRAY OF 1000 ARRAYS IS, CANT SELECT 500&501
		
	}
	public int challengeFive(Comparable[] arr, Comparable query) {
		// TODO Auto-generated method stub
		return 0;
	}
	private static void insertionSort(int [] list1)
	{
		if(list1.length == 0)
		{
			return;
		}
		int fhp = 1;
		if(list1[0] > list1[1])
		{
			swapIntArray(list1,0,1);
		}
		while(true)
		{
			if(fhp >= list1.length-1)
			{
				break;
			}
			if(list1[fhp] <= list1[fhp+1])
			{
				fhp = fhp+1;
				continue;
			}
			if(list1[fhp] > list1[fhp+1])
			{
					swapIntArray(list1,fhp,fhp+1);
					int num = fhp;
					for(int i = fhp-1; i > -1; i--)
					{
						if(list1[i] <= list1[num])
						{
							break;
						}
						else
						{
							swapIntArray(list1,i,num);
							num = num -1 ;
						}
					}
					fhp = fhp + 1;
					continue;
			}	
		}
	}
	public static void countingSort(int[] array) {
		int[] hashedArray = new int[array.length];
		
		for(int i = 0; i < array.length; i++) {
			hashedArray[array[i]] += 1;
		}
		
		for(int j = 1; j < hashedArray.length; j++) {
			hashedArray[j] += hashedArray[j - 1];
		}
		int count = 0;
		int numcount = 0;
		int startposition = 0;
		while(count < array.length) {
			for(int z = startposition; z < hashedArray[numcount]; z++) {
				array[count] = numcount;
				count++;
			}
			startposition = hashedArray[numcount];
			numcount++;
		}
	}
	private static void swapIntArray(int[] array, int i, int j) {

		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	private static int median(int[] nums)
	{
		if(nums.length%2 == 1)
		{
			return nums[((int)nums.length/2) + 1];
		}
		else
		{
			return (nums[((int)nums.length/2)] + nums[((int)nums.length/2)+1])/2;
		}
	}
	private static int medianFixed(int[] nums)
	{
			return (nums[((int)nums.length/2)] + nums[((int)nums.length/2)+1])/2;
	}
	@Override
	public String greeting() {
		// TODO Auto-generated method stub
		return null;
	}
}
