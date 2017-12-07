package SortCompetition;

public class TimSortForComparable {
	public static void main(String[] args)
	{
		String[] test = {"i","z","x","a","b","l"};
		System.out.print("yes");
		insertionSortString(test);
		System.out.print("yes");
		for(int i = 0; i < test.length; i++)
		{
			System.out.println(test[i]);
		}
	}
	public static void insertionSortString(Comparable [] list1)
	{
		int fhp = 1;
		if(list1[0].compareTo(list1[1]) > 0)
		{
			swapComparableArray(list1,0,1);
		}
		while(true)
		{
			if(fhp >= list1.length-1)
			{
				break;
			}
			if(list1[fhp].compareTo(list1[fhp+1]) < 0)
			{
				fhp = fhp+1;
				continue;
			}
			if(list1[fhp].compareTo(list1[fhp+1]) > 0)
			{
					swapComparableArray(list1,fhp,fhp+1);
					int num = fhp;
					for(int i = fhp-1; i > -1; i--)
					{
						if(list1[i].compareTo(list1[num]) < 0)
						{
							break;
						}
						else
						{
							swapComparableArray(list1,i,num);
							num = num -1 ;
						}
					}
					fhp = fhp + 1;
					continue;
			}	
		}
	}
	public static void swapStringArray(String[] array, int i, int j) {
		String temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static void swapComparableArray(Comparable[] array, int i, int j) {
		Comparable temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
