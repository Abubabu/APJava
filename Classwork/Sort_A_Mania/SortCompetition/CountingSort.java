package SortCompetition;

public class CountingSort {
	public static void main(String[] args) {
		
	}
		public static void countingSort(int[] array) {
			int[] hashedArray = new int[array.length];
			
			for(int i = 0; i < array.length; i++) {
				hashedArray[i] += 1;
			}
			
			for(int j = 0; j < hashedArray.length; j++) {
				hashedArray[j] += hashedArray[j - 1];
			}
			
			for(int j = 0; j < hashedArray.length; j++) {
				hashedArray[j] += hashedArray[j - 1];
			}
			
			int count = 0;
			int hashCount = 0;
			int numcount = 0;
			while(count < array.length) {
				for(int i = 0; i < hashedArray[numcount];i++) {
					array[count] = count;
					hashCount++;
					count++;
				}
				numcount++;
			}
				
		}
}
