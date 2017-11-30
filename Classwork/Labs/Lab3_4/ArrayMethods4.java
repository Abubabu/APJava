package Lab3_4;

import java.util.Arrays;

public class ArrayMethods4 {
	public static void main(String[] args)
	{
		int[] Numeros = {3,1,61,1,61,16,4,1,2,44,466};
		int[] Numeros1 = {62, 100, 141, 138, 190, 116, 111, 175, 162, 3};
		int[] Numeros2 = {185, 45, 110, 151, 163, 86, 100, 143, 57, 21};
		partition(Numeros,0,Numeros.length);						//Partition Test
		for(int x: Numeros)
		{
			System.out.println(x);
		}
		System.out.println("\n");
		quickSort(Numeros,0,Numeros.length );				//QuickSort Test
		for(int x: Numeros)
		{
			System.out.println(x);
		}
		System.out.println("\n");
		quickSort(Numeros1,0,Numeros1.length );
		for(int x: Numeros1)
		{
			System.out.println(x);
		}
		System.out.println("\n");
		quickSort(Numeros2,0,Numeros2.length );
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
	public static int partition(int[] list1, int front, int back)
	{
			int count = 0;
			int pivot = (back + front) / 2;
			while(count < back) {
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
					else if(list1[count] == list1[pivot] && count > pivot + 1) {
						swapIntArray(list1,pivot,pivot + 1);
						swapIntArray(list1,count,pivot);
						pivot = pivot + 1;
					}
					else if(list1[count] == list1[pivot] && count < pivot - 1) {
						swapIntArray(list1,pivot,pivot - 1);
						swapIntArray(list1,count,pivot);
						pivot = pivot - 1;
					}
					else
						count++;
				}
			return pivot; 
	}
	public static void swapIntArray(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void quickSort(int[] list1, int front, int back)
	{	
		if(front != back) {
			int pivot = partition(list1,front, back);
			if(pivot - 1 >= front)
			   quickSort(list1,front, pivot--); 
			if(pivot + 1 < back)
				quickSort(list1,pivot++, back);
		}
	}
	public static void customSort()//depends on the sort)
	{
				
	}
}
