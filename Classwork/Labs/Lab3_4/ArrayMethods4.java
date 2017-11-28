package Lab3_4;

import java.util.Arrays;

public class ArrayMethods4 {
	public static void main(String[] args)
	{
		int[] Numeros = {3,1,61,1,61,16,4,1,2,44,466};
		int[] Numeros1 = {62, 100, 141, 138, 190, 116, 111, 175, 162, 3};
		int[] Numeros2 = {185, 45, 110, 151, 163, 86, 100, 143, 57, 21};
		partition(Numeros,0,Numeros.length-1 );						//Partition Test
		for(int x: Numeros)
		{
			System.out.println(x);
		}
		System.out.println("\n");
		quickSort(Numeros,0,Numeros.length-1 );				//QuickSort Test
		for(int x: Numeros)
		{
			System.out.println(x);
		}
		System.out.println("\n");
		quickSort(Numeros1,0,Numeros1.length-1 );
		for(int x: Numeros1)
		{
			System.out.println(x);
		}
		System.out.println("\n");
		quickSort(Numeros2,0,Numeros2.length-1 );
		for(int x: Numeros2)
		{
			System.out.println(x);
		}
		
		/*int[] time0 = {74, 103, 179, 197, 141, 42, 28, 200, 24, 10};	//Time Test
		
		long avg = 0;
		
		for(int i = 0; i < 1000; i++)
		{
			long startime  = System.nanoTime();
			quickSort(time0,0,time0.length-1);
			long endtime = System.nanoTime();
			long finalTime = endtime - startime;
			avg += finalTime;
		}*/
		/*System.out.print("it took " + avg/1000+" for QuickSort.\n");*/
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
		/*if(front < back)
		{
			int half = (back+front)/2 ;
			if(half != list1.length - 1 && half !=0){
				int[] oneHalf = Arrays.copyOfRange(list1, 0, half); 
				int[] otherHalf = Arrays.copyOfRange(list1, half, list1.length);
				partition(oneHalf,0,half);
				quickSort( oneHalf,0,half);
				
				partition(otherHalf,half,list1.length-1);
				quickSort(otherHalf,half,list1.length-1);
			}
			else if(half == 0) {
				int[] otherHalf = Arrays.copyOfRange(list1, half, list1.length);
				partition(otherHalf,half,list1.length-1);
				quickSort(otherHalf,half,list1.length-1);
			}
			else {
				int[] oneHalf = Arrays.copyOfRange(list1, 0, half);
				partition(oneHalf,0,half);
				quickSort( oneHalf,0,half);
			}	
		}*/
		
		if(front != back) {
			partition(list1,front, back);
				quickSort(list1,front, ((front + back) / 2) - 1); 
				quickSort(list1,((front + back ) / 2) + 1, back);
		}
	}
	public static void customSort()//depends on the sort)
	{
				
	}
}
