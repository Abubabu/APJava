package Lab3_3;

import java.util.Arrays;

public class ArrayMethods3 {
	public static void main(String[] args) {
		String[] potato = {"apples","potato","potato","apple"}; //Bubble Sort Tests
		String[] potato1 = {"banana","block","red","apple"};
		String[] potato2 = {"reddit","zole","apple","apple"};
		String[] potato3 = {"panana","fale","recall","pole"};
		bubbleSort(potato);
		for(int i = 0; i < potato.length;i++) {
			System.out.print(potato[i] + " ");
		}
		System.out.println();
		bubbleSort(potato1);
		for(int i = 0; i < potato1.length;i++) {
			System.out.print(potato1[i] + " ");
		}
		System.out.println();
		bubbleSort(potato2);
		for(int i = 0; i < potato2.length;i++) {
			System.out.print(potato2[i] + " ");
		}
		System.out.println();
		bubbleSort(potato3);
		for(int i = 0; i < potato3.length;i++) {
			System.out.print(potato3[i] + " ");
		}
		System.out.println("\n");
		
		double[] potato4 = {2.5,1.2};					//Selection sort Tests
		double[] potato5 = {3.5,1.1,2.7,2.7,5.7};
		double[] potato6 = {3.0,2.0,1.0,1.0,5.0};
		double[] potato7 = {3.0,2.0,1.0,1.0};
		selectionSort(potato4);
		for(int i = 0; i < potato4.length;i++) {
			System.out.print(potato4[i] + " ");
		}
		System.out.println();
		selectionSort(potato5);
		for(int i = 0; i < potato5.length;i++) {
			System.out.print(potato5[i] + " ");
		}
		System.out.println();
		selectionSort(potato6);
		for(int i = 0; i < potato6.length;i++) {
			System.out.print(potato6[i] + " ");
		}
		System.out.println();
		selectionSort(potato7);
		for(int i = 0; i < potato7.length;i++) {
			System.out.print(potato7[i] + " ");
		}
		System.out.println("\n");
		int[] potato8 = {1,3,56,2,9,27};			//Insertion Sort Tests
		int[] potato9 = {2,1,56,9,9,27,0};
		int[] potato10 = {56,27,13,9,9,0};
		int[] potato11 = {0,0,0,0,0,0,0,0};
		insertionSort(potato8);
		for(int x : potato8)
		{
			System.out.println(x);
		}
		System.out.println();
		insertionSort(potato9);
		for(int x : potato9)
		{
			System.out.println(x);
		}
		System.out.println();
		insertionSort(potato10);
		for(int x : potato10)
		{
			System.out.println(x);
		}
		System.out.println();
		insertionSort(potato11);
		for(int x : potato11)
		{
			System.out.println(x);
		}
		System.out.println("\n");
		
		String[] time = {"zebra","trap","pool","main","deter","clay","aids"};     //Time Test
		double[] time1 = {100.0,98.0,77.0,55.0,55.1,33.0,1.1};
		int[] time2 = {27,22,18,15,11,7,1};
		
		long avg = 0;
		long avg1 = 0;
		long avg2 = 0;
		
		for(int i = 0; i < 1000; i++)
		{
			long startime  = System.nanoTime();
			bubbleSort(time);
			long endtime = System.nanoTime();
			long finalTime = endtime - startime;
			avg += finalTime;
		}
		System.out.print("it took " + avg/1000+" for Bubble Sort.\n");
		for(int i = 0; i < 1000; i++)
		{
			long startime  = System.nanoTime();
			selectionSort(time1);
			long endtime = System.nanoTime();
			long finalTime = endtime - startime;
			avg1 += finalTime;
		}
		System.out.print("it took " + avg1/1000+" for Selection Sort.\n");
		for(int i = 0; i < 1000; i++)
		{
			long startime  = System.nanoTime();
			insertionSort(time2);
			long endtime = System.nanoTime();
			long finalTime = endtime - startime;
			avg2 += finalTime;
		}
		System.out.print("it took " + avg2/1000+" for Insertion Sort.\n");
	}
	
	public static void insertionSort(int [] list1)
	{
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

	public static void swapIntArray(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void bubbleSort(String[] array) {
		boolean isSorted = false;
		int i = 0;
		boolean noSwaps = true;
		while(!isSorted) {
			if(i == 0) {
				 noSwaps = true;
			}
			if(array[i].compareTo(array[i + 1]) > 0) {
				noSwaps = false;
				swapStringArray(array,i,i+1);
			}
			
			if(i == array.length - 2) {
				if(noSwaps == true)
					isSorted = true;
				else
					i = 0;
			}
			else 
				i++;
		}
	}
	
	public static void selectionSort(double[] array) {
		for(int i = 0; i < array.length - 1; i++) {
			int smallest = i;
			for(int j = i + 1; j < array.length; j++) {
				if(array[j] < array[smallest]) {
					smallest = j;
				}
			}
			swapDoubleArray(array,i,smallest);
		}
	}
	
	public static void swapStringArray(String[] array, int i, int j) {
		String temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void swapDoubleArray(double[] array, int i, int j) {
		double temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
