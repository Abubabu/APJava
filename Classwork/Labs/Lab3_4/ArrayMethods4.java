package Lab3_4;

import java.util.Arrays;

public class ArrayMethods4 {
	public static void main(String[] args)
	{
		int[] Numeros = {3,1,61,1,61,16,4,1,2,44,466};
		partition(Numeros,0,Numeros.length-1 );
		for(int x: Numeros)
		{
			System.out.println(x);
		}
		System.out.println("\n");
		quickSort(Numeros,0,Numeros.length-1 );
		for(int x: Numeros)
		{
			System.out.println(x);
		}
		
	}
	public static void partition(int[] list1, int front, int back)
	{
			int count = 0;
			int pivot = (back + front) / 2;
			while(count <= back) {
				if(list1[count] > list1[pivot] && count < pivot - 1) {
					swapIntArray(list1,pivot,pivot - 1);
					swapIntArray(list1,count,pivot);
					pivot = pivot - 1;
				}
				else if(list1[count] > list1[pivot] && count == pivot - 1) {
					swapIntArray(list1,count,pivot);
					pivot = pivot - 1;
					count++;
				}
				else if(list1[count] < list1[pivot] && count > pivot + 1) {
					swapIntArray(list1,pivot,pivot + 1);
					swapIntArray(list1,count,pivot);
					pivot = pivot + 1;
				}
				else if(list1[count] < list1[pivot] && count == pivot + 1) {
					swapIntArray(list1,count,pivot);
					pivot = pivot + 1;
					count++;
				}
				else
					count++;
			}
	}
	public static void swapIntArray(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void quickSort(int[] list1, int front, int back)
	{
		if(front < back)
		{
			int half = (back+front)/2 ;
			int[] oneHalf = Arrays.copyOfRange(list1, 0, half);
			int[] otherHalf = Arrays.copyOfRange(list1, half, list1.length-1);
			partition(oneHalf,0,half);
			quickSort( oneHalf,0,half);
			
			partition(otherHalf,half,list1.length-1);
			quickSort(otherHalf,half,list1.length-1);
		}
	}
	public static void customSort()//depends on the sort)
	{
				
	}
}
