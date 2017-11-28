package Lab3_4;

public class ShellSort {
	public static void main(String[] args) {
		int[] list = {56,27,13,9,9,0};
		gapInsertionSort(list,3,0); //gapInsertionSort Test
		for(int x : list)
		{
			System.out.println(x);
		}
	}
	public static void shellSort(int[] list)
	{
		int gap = list.length/2;
		if(gap == 1)
		{
			insertionSort(list);
		}
		else
		{
			//shellSort()
			insertionSort(list);
		}
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
