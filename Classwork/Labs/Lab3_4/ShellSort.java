package Lab3_4;

public class ShellSort {
	public static void main(String[] args) {
		int[] list = {161, 151, 82, 173, 3, 126, 81, 91, 106, 168};//81,161,168,173
		gapInsertionSort(list,3,0); //gapInsertionSort Test
		for(int x : list)
		{
			System.out.println(x);
		}
		System.out.println();
		shellSort(list,list.length/2); 			//shellSort Test
		for(int x : list)
		{
			System.out.println(x);
		}
		
		int[] time0 = {74, 103, 179, 197, 141, 42, 28, 200, 24, 10};	//Time Test
		
		long avg = 0;
		
		for(int i = 0; i < 1000; i++)
		{
			long startime  = System.nanoTime();
			shellSort(time0,time0.length/2);
			long endtime = System.nanoTime();
			long finalTime = endtime - startime;
			avg += finalTime;
		}
		System.out.print("it took " + avg/1000+" for shellSort.\n");
	}
	public static int[] gapSequence = {1, 4, 10, 23, 57, 132, 301, 701,1750};
	public static int[] bestCase = {	1, 2, 3, 4, 6, 8, 9, 12, 16, 18, 24, 27, 32, 36, 48, 54, 64, 72, 81, 96, 108, 128, 144, 162, 192, 
			216, 243, 256, 288, 324, 384, 432, 486, 512, 576, 648, 729, 768, 864, 972, 1024, 1152, 1296, 1458, 15,
			36, 1728, 1944, 2048, 2187, 2304, 2592, 2916, 3072, 3456, 3888};
	public static void shellSort(int[] list,int sequence)
	{
		
		int gap = sequence;
		if(gap <= 1)
		{
			insertionSort(list);
		}
		else
		{
			for (int i = 0; i < gap; i++) {
				gapInsertionSort(list, gap, i);
			}
			shellSort(list,(int) (sequence/2.2));
			
		}
	}
	public static void insertionSort(int [] list1)
	{
		if(list1.length == 0)
		{
			return;
		}
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
	public static void gapInsertionSort(int [] list1,int gap,int start)
	{
		int fhp = start;
		while(true)
		{
			if(fhp >= list1.length-gap)
			{
				break;
			}
			if(list1[fhp] <= list1[fhp+gap])
			{
				fhp = fhp+gap;
				continue;
			}
			if(list1[fhp] > list1[fhp+gap])
			{
					swapIntArray(list1,fhp,fhp+gap);
					int num = fhp;
					for(int i = fhp-gap; i > -1; i = i - gap)
					{
						if(list1[i] <= list1[num])
						{
							break;
						}
						else
						{
							swapIntArray(list1,i,num);
							num = num -gap ;
						}
					}
					fhp = fhp + gap;
					continue;
			}	
		}
	}
	public static void swapIntArray(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
