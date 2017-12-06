package SortCompetition;

import java.util.Arrays;

public class TimSort {
	public static void main(String[] args)
	{
		int j = 0;
		double avg1 = 0;
		int[] time1 = new int[1000];
		while(j < 100)
		{
			for(int i = 0; i < 1; i++)
			{
				for(int k = 0; k < 1000; k++)
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
		int[] yes = {61, 170, 191, 49, 66, 97, 107, 140, 14, 27, 185, 55, 194, 16, 143, 19, 182, 112, 73, 188, 8, 128, 102, 122, 4};
		int[] no = TimSortsOP(yes);
		for(int i = 0; i < no.length; i++)
		{
			System.out.println(no[i]);
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
	public static int[] TimSorts(int[] nums)
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
			return mergeInt(  TimSorts( oneHalf ), TimSorts( otherHalf));		
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
	public static String[] merge(String[] list1, String[] list2)
	{
		String[] result = new String[list1.length+list2.length];
		int onePosition = 0;
		int twoPosition = 0;
		while(true)
		{
			if(onePosition >= list1.length) //when all of list1 is in the results array
			{
				for(int i = twoPosition; i < list2.length; i++)
				{
					result[list1.length+i] = list2[i];
				}
				break;
			}
			if(twoPosition >= list2.length) //when all of list2 is in the results array
			{
				for(int i = onePosition; i < list1.length; i++)
				{
					result[list2.length+i] = list1[i];
				}
				break;
			}
			if(  list1[onePosition].compareTo(list2[twoPosition]) == 0) // doesn't matter which one you push into array
			{
				result[onePosition+twoPosition] = list2[twoPosition];
				twoPosition++;
				continue;
			}
			if(  list1[onePosition].compareTo(list2[twoPosition]) < 0 ) // if list1 is lower
			{
				result[onePosition+twoPosition] = list1[onePosition];
				onePosition++;
				continue;
			}
			if(  list2[twoPosition].compareTo(list1[onePosition]) < 0 ) // if list2 is lower
			{
				result[onePosition+twoPosition] = list2[twoPosition];
				twoPosition++;
				continue;
			}
		}
		return result;
	}
	public static String[] mergeSort(String[] list)
	{
		if(list.length == 1)
		{
			return list;
		}
		else
		{
			int half = (list.length/2 );
			String[] oneHalf = Arrays.copyOfRange(list, 0, half);
			String[] otherHalf = Arrays.copyOfRange(list, half, list.length);
			return merge(  mergeSort( oneHalf ), mergeSort( otherHalf));		
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
	private static void swapIntArray(int[] array, int i, int j) {

		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
