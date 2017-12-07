package SortCompetition;

import java.util.Arrays;

public class TimSort {
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
					time1[k] = (int) (Math.random()*10000); 
				}
				long startime  = System.nanoTime();
				TimSorts(time1);
				long endtime = System.nanoTime(); 
				long finalTime = endtime - startime;
				avg1 += finalTime;
			}
			j++;
		}
		System.out.println(avg1/100);
/*		int[] yes = {61, 170, 191, 49, 66, 97, 107, 140, 14, 27, 185, 55, 194, 16, 143, 19, 182, 112, 73, 188, 8, 128, 102, 122, 4};
		int[] no = TimSortsOP(yes);
		for(int i = 0; i < no.length; i++)
		{
			System.out.println(no[i]);
		}	*/
		int[] median = {9 ,5 ,1 ,3 ,0 ,22,7 ,44};
		int[] nums =   {44,33,11,22,55,66,77,88};
	//	insertionSort(median,nums);
		for(int i = 0; i < nums.length; i++)
		{
			//System.out.print(median[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < nums.length; i++)
		{
			//System.out.print(nums[i] + " ");
		}	
		
		int values[][] = new int[1000][1000];
	    for (int i = 0; i < values.length; i++) {
	        for (int p = 0; p < values[i].length; p++) {
	            values[i][p] = ((int) (Math.random() * 10000));
	        }
	    }
		challengeFour(values);
		
	}
	//Overloaded
	public static int challengeFour(int[][] nums) //Tim Sort
	{
		int[] associatedArray = new int[nums.length];
		for(int i = 0; i < nums.length; i++)
		{
			TimSortsOP(nums[i]);
			associatedArray[i] = medianFixed(nums[i]);
		}
		insertionSort(associatedArray,nums);
		for(int i = 0; i < 10; i++)
		{
			System.out.print(associatedArray[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < 10; i++)
		{
			System.out.print(medianFixed(nums[i]) + " ");
		}
		System.out.println(medianFixed(nums[500]));
		System.out.println(medianFixed(nums[501]));
		System.out.println(median(   medianFixed(	nums[	((int)nums.length/2)] ), medianFixed( nums[ ((int)nums.length/2)+1] )));
		return median(   medianFixed(	nums[	((int)nums.length/2)] ), medianFixed( nums[ ((int)nums.length/2)+1] )); 
	}
	private static int medianFixed(int[] nums)
	{
			return (nums[((int)nums.length/2)] + nums[((int)nums.length/2)+1])/2;
	}
	private static int median(int num1, int num2)
	{
			return (num1+num2)/2;
	}
	private static void insertionSort(int [] list1,int[][] nums)
	{
		if(list1.length == 0)
		{
			return;
		}
		int fhp = 1;
		if(list1[0] > list1[1])
		{
			swapIntArray(list1,0,1);
			swapArrayArray(nums,0,1);
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
					swapArrayArray(nums,fhp,fhp+1);
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
							swapArrayArray(nums,i,num);
							num = num -1 ;
						}
					}
					fhp = fhp + 1;
					continue;
			}	
		}
	}
	
	public static void insertionSortString(String [] list1)
	{
		int fhp = 1;
		if(list1[0].compareTo(list1[1]) > 0)
		{
			swapStringArray(list1,0,1);
		}
		while(true)
		{
			if(fhp >= list1.length-1)
			{
				break;
			}
			if(list1[fhp].compareTo(list1[fhp+1]) > 0)
			{
				fhp = fhp+1;
				continue;
			}
			if(list1[fhp].compareTo(list1[fhp+1]) < 0)
			{
					swapStringArray(list1,fhp,fhp+1);
					int num = fhp;
					for(int i = fhp-1; i > -1; i--)
					{
						if(list1[i].compareTo(list1[num]) > 0)
						{
							break;
						}
						else
						{
							swapStringArray(list1,i,num);
							num = num -1 ;
						}
					}
					fhp = fhp + 1;
					continue;
			}	
		}
	}
	public static void swapStringArray(String[] array, int i, int j) {
		String temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static int[] TimSortsOP(int[] nums)
	{
		if(nums.length < 8)
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
	public static String[] TimSorts(String[] nums)
	{
		if(nums.length < 8)
		{
			insertionSortString(nums);
			return nums;
		}
		else
		{
			int half = (nums.length/2 );
			String[] oneHalf = Arrays.copyOfRange(nums, 0, half);
			String[] otherHalf = Arrays.copyOfRange(nums, half, nums.length);
			return mergeIntOptimized( TimSorts( oneHalf ), TimSorts( otherHalf));		
		}
	}
	private static int[] mergeInt(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length+nums2.length];
		int onePosition = 0;
		int twoPosition = 0;
		while(true)
		{
			if(onePosition >= nums1.length) //when all of list1 is in the results array
			{
				for(int i = twoPosition; i < nums2.length; i++)
				{
					result[nums1.length+i] = nums2[i];
				}
				break;
			}
			if(twoPosition >= nums2.length) //when all of list2 is in the results array
			{
				for(int i = onePosition; i < nums1.length; i++)
				{
					result[nums2.length+i] = nums1[i];
				}
				break;
			}
			if(  nums1[onePosition] == nums2[twoPosition]) // doesn't matter which one you push into array
			{
				result[onePosition+twoPosition] = nums2[twoPosition];
				twoPosition++;
				continue;
			}
			if(  nums1[onePosition] < nums2[twoPosition] ) // if list1 is lower
			{
				result[onePosition+twoPosition] = nums1[onePosition];
				onePosition++;
				continue;
			}
			if(  nums2[twoPosition] < nums1[onePosition] ) // if list2 is lower
			{
				result[onePosition+twoPosition] = nums2[twoPosition];
				twoPosition++;
				continue;
			}
		}
		return result;
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
	private static void swapIntArray(int[] array, int i, int j) {

		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	private static void swapArrayArray(int[][] array, int i, int j) {

		int[] temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
