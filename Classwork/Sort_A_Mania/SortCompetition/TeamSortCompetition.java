package SortCompetition;

public class TeamSortCompetition {
	public static void main(String[] args)
	{
		
	}
	
	public static int challengeOne(int[] nums)
	{
		shellSort(nums,nums.length/2);
		return median(nums);
	}
	public static int challengeTwo(String[] strings)
	{
		return 0;
	}
	private static void shellSort(int[] list,int sequence)
	{
		
		int gap = sequence;
		if(gap <= 1)
		{
			insertionSort(list);
		}
		else
		{
			for (int i = 0; i < gap; i++) {
				gapInsertionSort(list, gap, i);
			}
			shellSort(list,(int) (sequence/2.2));
			
		}
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
	private static void gapInsertionSort(int [] list1,int gap,int start)
	{
		int fhp = start;
		while(true)
		{
			if(fhp >= list1.length-gap)
			{
				break;
			}
			if(list1[fhp] <= list1[fhp+gap])
			{
				fhp = fhp+gap;
				continue;
			}
			if(list1[fhp] > list1[fhp+gap])
			{
					swapIntArray(list1,fhp,fhp+gap);
					int num = fhp;
					for(int i = fhp-gap; i > -1; i = i - gap)
					{
						if(list1[i] <= list1[num])
						{
							break;
						}
						else
						{
							swapIntArray(list1,i,num);
							num = num -gap ;
						}
					}
					fhp = fhp + gap;
					continue;
			}	
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
}
