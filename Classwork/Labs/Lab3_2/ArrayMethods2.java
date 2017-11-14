package Lab3_2;

public class ArrayMethods2 {
	public static void main(String[] args)
	{
		String[] one = {"Apple, Denver, Pistol, Tree"};
		String[] two = {"Ball", "coconut", "Potato", "Vanesa"};
		String[] three = {"Ball", "coconut", "Potato", "Lamp","Plant"};
		String[] test1 = merge(one,two);
		//String[] test2 = merge(one,three);
		//String[] test3 = merge(two,three);
		for (String x : test1)
		{
		   System.out.print(x);
		}
		System.out.println();
		//for (String x : test2)
		//{
		//   System.out.print(x);
		//}
		System.out.println();
		//for (String x : test3)
		//{
		//   System.out.print(x);
		//}
	}
	public static String[] merge(String[] list1, String[] list2)
	{
		String[] result = new String[list1.length+list2.length];
		boolean listsMerged = true;
		int onePosition = 0;
		int twoPosition = 0;
		// USE COMPARETO
		while(listsMerged)
		{
			if(onePosition+twoPosition == result.length) // not sure
			{
				break;
			}
			if(  list1[onePosition].equals(list2[twoPosition]) ) // if list2 is lower
			{
				result[onePosition+twoPosition] = list2[twoPosition];
				twoPosition++;
			}
			if(  ((int) list1[onePosition].charAt(0)) > ((int) list2[twoPosition].charAt(0)) ) // if list2 is lower
			{
				result[onePosition+twoPosition] = list2[twoPosition];
				twoPosition++;
			}
			if(  ((int) list1[onePosition].charAt(0)) < ((int) list2[twoPosition].charAt(0)) ) // if list1 is lower
			{
				result[onePosition+twoPosition] = list1[onePosition];
				onePosition++;
			}
			if(  ((int) list1[onePosition].charAt(0)) == ((int) list2[twoPosition].charAt(0)) ) // if list2 is equal to list1
			{
				int answer = checkCharecters(    list1[twoPosition].substring(1, list1.length)  ,  list2[twoPosition].substring(1, list2.length) ); // check next letters in both string for ascii values
				if(answer == 1)
				{
					result[onePosition+twoPosition] = list1[onePosition];
					onePosition++;
				}
				if(answer == 2)
				{
					result[onePosition+twoPosition] = list2[onePosition];
					twoPosition++;
				}
			}
			
		}
		return result;
	}
	
	/*private static int checkCharecters(String string, String string2) {
		if( ((int) string.charAt(0)) < ((int) string2.charAt(0))) {
			return 1;
		}
		else if( ((int) string.charAt(0)) > ((int) string2.charAt(0))) {
			return 2;
		}
		else
			return checkCharecters(string.substring(1,string.length()),string2.substring(1,string2.length()));
	}*/
	public static String[] sortMerge(String[] list) {
		return list;
	}
	public static int partition(int[] list)
	{
		return 0;
	}
}
