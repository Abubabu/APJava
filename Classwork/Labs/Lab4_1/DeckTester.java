package Lab4_1;

public class DeckTester {

	public static void Main(String[] args)
	{
		String[] rank = {"A","B","C"};
		String[] suit = {"Dim","Club","Spades"};
		int[] pointValue = {1,2,3};
		Deck deck = new Deck(rank,suit,pointValue);
		
		deck.shuffle();
		
		for(int i = 0; i < deck.size(); i++)
		{
			System.out.println(deck.getCard(i).toString());
		}
	}

}
