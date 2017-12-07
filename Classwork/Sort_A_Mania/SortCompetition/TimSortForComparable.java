package SortCompetition;

import java.util.Arrays;

public class TimSortForComparable {
	public static void main(String[] args)
	{
		String[] test = {"i","z","x","a","b","l"};
		System.out.print("yes");
		insertionSortCom(test);
		System.out.print("yes");
		for(int i = 0; i < test.length; i++)
		{
			System.out.println(test[i]);
		}
	}
	public static void insertionSortCom(Comparable [] list1)
	{
		int fhp = 1;
		if(list1[0].compareTo(list1[1]) > 0)
		{
			swapComparableArray(list1,0,1);
		}
		while(true)
		{
			if(fhp >= list1.length-1)
			{
				break;
			}
			if(list1[fhp].compareTo(list1[fhp+1]) < 0)
			{
				fhp = fhp+1;
				continue;
			}
			if(list1[fhp].compareTo(list1[fhp+1]) > 0)
			{
					swapComparableArray(list1,fhp,fhp+1);
					int num = fhp;
					for(int i = fhp-1; i > -1; i--)
					{
						if(list1[i].compareTo(list1[num]) < 0)
						{
							break;
						}
						else
						{
							swapComparableArray(list1,i,num);
							num = num -1 ;
						}
					}
					fhp = fhp + 1;
					continue;
			}	
		}
	}
	public static Comparable[] TimSortsOP(Comparable[] nums)
	{
		if(nums.length < 8)
		{
			insertionSortCom(nums);
			return nums;
		}
		else
		{
			int half = (nums.length/2 );
			Comparable[] oneHalf = Arrays.copyOfRange(nums, 0, half);
			Comparable[] otherHalf = Arrays.copyOfRange(nums, half, nums.length);
			return mergeComOptimized(  TimSortsOP( oneHalf ), TimSortsOP( otherHalf));		
		}
	}
	private static Comparable[] mergeComOptimized(Comparable[] nums1, Comparable[] nums2) {
		Comparable[] result = new Comparable[nums1.length+nums2.length];
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
			if(  nums1[onePosition].compareTo(nums2[twoPosition]) < 0) // if list1 is lower
			{
				result[onePosition+twoPosition] = nums1[onePosition];
				onePosition++;
				continue;
			}
			else if(  nums1[onePosition].compareTo(nums2[twoPosition]) > 0) // if list2 is lower
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
	public static void swapStringArray(String[] array, int i, int j) {
		String temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static void swapComparableArray(Comparable[] array, int i, int j) {
		Comparable temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
