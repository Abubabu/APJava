package Lab3_2;

import java.util.Arrays;

public class ArrayMethods2 {
	public static void main(String[] args)
	{
		String[] one = {"Apple","Denver", "Pistol", "Tree"};
		String[] two = {"Ball", "Coconut", "Potato", "Vanesa"};
		String[] three = {"Ball", "Coconut", "Lamp","Plant","Potato"};
		String[] test1 = merge(one,two);
		String[] test2 = merge(one,three);
		String[] test3 = merge(two,three); 
		for (String x : test1)
		{
		   System.out.print(x+" ");
		}
		System.out.println();
		for (String x : test2)
		{
		   System.out.print(x+" ");
		}
		System.out.println();
		for (String x : test3)
		{
		   System.out.print(x+" ");
		}
		System.out.println("\n---------------------------------------------------------\n");
		
		String[] four = {"Vanesa","Apple","Potato","Denver", "Apple","Pistol", "Tree"};
		String[] five = {"Coconut","Ball", "Lamp","Coconut", "Potato", "Vanesa"};
		String[] six = {"Potato","Coconut","Ball", "Coconut", "Potato","Lamp","Plant","Potato"};
		String[] test4 = mergeSort(four);
		String[] test5 = mergeSort(five);
		String[] test6 = mergeSort(six);
		for (String x : test4)
		{
		   System.out.print(x+" ");
		}
		System.out.println();
		for (String x : test5)
		{
		   System.out.print(x+" ");
		}
		System.out.println();
		for (String x : test6)
		{
		   System.out.print(x+" ");
		}
		System.out.println("\n---------------------------------------------------------\n");
		
		int[] seven = {12,5,6,13,19,8,12,20,1};
		int[] eight = {5,6,13,19,8,12,20,};
		int[] nine = {22,5,6,13,19,8,12,20,1};
		int test7 = partition(seven);
		int test8 = partition(eight);
		int test9 = partition(nine);
		
		System.out.print(test7+" ");
		System.out.println();
		System.out.print(test8+" ");
		System.out.println();
		System.out.print(test9+" ");
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
			int half = ((int)list.length/2 );
			String[] oneHalf = Arrays.copyOfRange(list, 0, half);
			String[] otherHalf = Arrays.copyOfRange(list, half, list.length);
			return merge(  mergeSort( oneHalf ), mergeSort( otherHalf)  );		
		}
	}
	public static int partition(int[] list)
	{
		int pivot = list[0];
		int counter = 0;
		for(int i = 1; i < list.length; i++)
		{
			if(list[i] <= pivot)
			{
				counter++;
			}
		}
		return counter;
	}
}
