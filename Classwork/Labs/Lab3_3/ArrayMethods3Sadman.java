package Lab3_3;

public class ArrayMethods3Sadman {
	public static void main(String[] args) {
		int[] list1 = {1,3,56,2,9,27};
		int[] list2 = {2,1,56,9,9,27,0};
		insertionSort(list1);
		for(int x : list1)
		{
			System.out.println(x);
		}
		System.out.println();
		insertionSort(list2);
		for(int x : list2)
		{
			System.out.println(x);
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
					for(int i = fhp-1; i > -1; i++)
					{
						if(list1[i] <= list1[num])
						{
							break;
						}
						else
						{
							swapIntArray(list1,i,num);
							i = i -1;
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
}
