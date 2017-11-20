package Lab3_3;

public class ArrayMethods3Josh {
	public static void main(String[] args) {
		String[] potato = {"apples","potato","potato","apple"};
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
					j = smallest;
				}
				if(j == array.length - 1)
					swapDoubleArray(array,i,j);
			}
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
