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
	}*/
		int[] time1 = {1,3,1,6,1,3,6,0,1,2};
		long startime  = System.nanoTime();
		countingSort(time1);
		long endtime = System.nanoTime(); // 88534.76
		long finalTime = endtime - startime;
		
		System.out.print(finalTime);
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
			int initialcount = count;
			while(count < array.length) {
						for(int z = hashedArray[numcount - 1]; z < hashedArray[numcount];z++) {
							array[count] = numcount;
							count++;
							z++;
							if(count >= array.length)
								break;
						}
						numcount++;
				}
				
		}
}
