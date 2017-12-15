package Lab4_1;

public class DeckTester {

	public static void main(String[] args)
	{
		String[] rank = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		String[] suit = {"Ace","Club","Spade","Heart"};
		int[] pointValue = {2,3,4,5,6,7,8,9,10,11,12,13,1};
		Deck deck = new Deck(rank,suit,pointValue);
		
		deck.shuffle();
		
		for(int i = 0; i < deck.size(); i++)
		{
			System.out.println(deck.getCard(i).toString());
		}
		System.out.println(deck.size());
	}

}
