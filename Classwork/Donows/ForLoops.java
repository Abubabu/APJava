
public class ForLoops {
	public static void main(String[] args)
	{
		int[] arr = {1,2,3,4,5,6};
		
		System.out.println(average(arr));
		addOne(arr);
		System.out.println(average(arr));
	}

	private static double average(int[] arr) {
		double total = 0.0;
		for(int x : arr)
		{
			total += x;
		}
		return total/arr.length;
	}

	private static void addOne(int[] arr) {
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = arr[i] + 1;
		}
		
	}
}
