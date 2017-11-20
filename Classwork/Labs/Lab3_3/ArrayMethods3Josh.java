package Lab3_3;

public class ArrayMethods3Josh {
	public static void main(String[] args) {
		String[] potato = {"potato","potato","potato","apple"};
		bubbleSort(potato);
		for(int i = 0; i < potato.length;i++) {
			System.out.println(potato[i] + " ");
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
	
	public static void swapStringArray(String[] array, int i, int j) {
		String temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
