package Lab3_3;

public class ArrayMethods3Sadman {
	public static void main(String[] args) {
		int[] list1 = {1,3,56,2,9,27};
		pushIntArray(list1,4);
		for(int x : list1)
		{
			System.out.println(x);
		}
	}
	
	public static void insertionSort(int [] list1)
	{
		
	}
	public static void swapIntArray(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	/*Insertion takes each element from the array, and adds it to the front of the
	array in the correct order. We need to keep track of where we are inserting
	elements as we sort.
	public static void insertionSort(int [] list1)
	Returns: void
	Side-effect: list1 is sorted in ascending order*/
}
