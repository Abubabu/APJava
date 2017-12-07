package SortCompetition;

public class CountingSort {
	public static void main(String[] args) {
		/*int j = 0;
		double avg1 = 0;
		int[] time1 = new int[10000];
		while(j < 100)
		{
			for(int i = 0; i < 1; i++)
			{
				for(int k = 0; k < 10000; k++)
				{
					time1[k] = (int) (Math.random()*10000); //need to have semi-sorted array
				}
				long startime  = System.nanoTime();
				countingSort(time1);
				long endtime = System.nanoTime(); // 88534.76
				long finalTime = endtime - startime;
				avg1 += finalTime;
			}
			j++;
		}
		System.out.print(avg1/100);*/
		System.out.println("AAAAAAAAAAAAAA".compareTo("akersman"));
	}
		public static void countingSort(int[] array) {
			int[] hashedArray = new int[array.length];
			
			for(int i = 0; i < array.length; i++) {
				hashedArray[array[i]] += 1;
			}
			
			for(int j = 1; j < hashedArray.length; j++) {
				hashedArray[j] += hashedArray[j - 1];
			}
			int count = 0;
			int numcount = 0;
			int startposition = 0;
			while(count < array.length) {
				for(int z = startposition; z < hashedArray[numcount]; z++) {
					array[count] = numcount;
					count++;
				}
				startposition = hashedArray[numcount];
				numcount++;
			}
		}
		
		/*public static void countingSort(String[] array) {
			int[] hashedArray = new int[array.length];
			
			for(int i = 0; i < array.length; i++) {
				hashedArray[array[i]] += 1;
			}
			
			for(int j = 1; j < hashedArray.length; j++) {
				hashedArray[j] += hashedArray[j - 1];
			}
			int count = 0;
			int numcount = 0;
			int startposition = 0;
			while(count < array.length) {
				for(int z = startposition; z < hashedArray[numcount]; z++) {
					array[count] = numcount;
					count++;
				}
				startposition = hashedArray[numcount];
				numcount++;
			}
		}*/
}
