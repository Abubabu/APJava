package Lab4_1;

import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> unDealt; 
	private ArrayList<Card> Dealt;
	public Deck(String[] rank, String[] suit, int[] pointValue) {
		ArrayList<Card> undealt = new ArrayList<Card>();
		for(String x : rank)
		{
			for(String y : suit)
			{
				for(int z : pointValue)
				{
					Card card = new Card(x,y,z);
					undealt.add(card);
				}
			}
		}
		this.unDealt = undealt;
	}
	public ArrayList<Card> getUnDealt() {
		return unDealt;
	}
	public void setUnDealt(ArrayList<Card> unDealt) {
		this.unDealt = unDealt;
	}
	public ArrayList<Card> getDealt() {
		return Dealt;
	}
	public void setDealt(ArrayList<Card> dealt) {
		Dealt = dealt;
	}
	@Override
	public String toString() {
		return "Deck [unDealt=" + unDealt + ", Dealt=" + Dealt + "]";
	} 
	
	
}
