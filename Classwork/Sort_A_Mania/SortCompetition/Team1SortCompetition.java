package SortCompetition;

import java.util.Arrays;

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
				//challengeThree(time1);
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
			TimSortsOP(nums[i]);
			associatedArray[i] = medianFixed(nums[i]);
		}
		//TimSortParalell(associatedArray,nums);
		return median(   medianFixed(	nums[	((int)nums.length/2)] ), medianFixed( nums[ ((int)nums.length/2)+1] )); 
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
	private static void countingSort(int[] array) {
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
	public static int[] TimSortsOP(int[] nums)
	{
		if(nums.length < 10)
		{
			insertionSort(nums);
			return nums;
		}
		else
		{
			int half = (nums.length/2 );
			int[] oneHalf = Arrays.copyOfRange(nums, 0, half);
			int[] otherHalf = Arrays.copyOfRange(nums, half, nums.length);
			return mergeIntOptimized(  TimSortsOP( oneHalf ), TimSortsOP( otherHalf));		
		}
	}
	private static int[] mergeIntOptimized(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length+nums2.length];
		int onePosition = 0;
		int twoPosition = 0;
		while(true)
		{
			if(onePosition > nums1.length-1) //when all of list1 is in the results array
			{
				for(int i = twoPosition; i < nums2.length; i++)
				{
					result[nums1.length+i] = nums2[i];
				}
				break;
			}
			if(twoPosition > nums2.length-1) //when all of list2 is in the results array
			{
				for(int i = onePosition; i < nums1.length; i++)
				{
					result[nums2.length+i] = nums1[i];
				}
				break;
			}
			if(  nums1[onePosition] < nums2[twoPosition] ) // if list1 is lower
			{
				result[onePosition+twoPosition] = nums1[onePosition];
				onePosition++;
				continue;
			}
			else if(  nums2[twoPosition] < nums1[onePosition] ) // if list2 is lower
			{
				result[onePosition+twoPosition] = nums2[twoPosition];
				twoPosition++;
				continue;
			}
			else
			{
				result[onePosition+twoPosition] = nums2[twoPosition];
				twoPosition++;
				continue;
			}
		}
		return result;
	}
	private static void swapIntArray(int[] array, int i, int j) {

		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	private static int medianFixed(int[] nums)
	{
			return (nums[((int)nums.length/2)] + nums[((int)nums.length/2)+1])/2;
	}
	private static int median(int num1, int num2)
	{
			return (num1+num2)/2;
	}
	@Override
	public String greeting() {
		// TODO Auto-generated method stub
		return null;
	}
}
