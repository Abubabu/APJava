
public class NewMeme {
    public static void main(String[] args)
    {
    	String[] test = {"potato","potato1","potato2"};
    	String[] test1 = new String[1];
    	test1[0] = changeTomato(test);
    	System.out.println(test[2]);
    	System.out.println(test1[0]);
    }
	public static String changeTomato(String[] string)
	{
		string[2] = "tomato";
		return string[2];
	}
}
