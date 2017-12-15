package Lab4_1;

import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> unDealt; 
	private ArrayList<Card> Dealt;
	public Deck(String[] rank, String[] suit, int[] pointValue) {
		ArrayList<Card> undealt = new ArrayList<Card>();
		for(int i = 0; i < rank.length; i++)
		{
			String x = rank[i];
			int z = pointValue[i];
			for(String y : suit)
			{
					Card card = new Card(x,y,z);
					undealt.add(card);
			}
		}
		this.unDealt = undealt;
		this.Dealt = new ArrayList<Card>();
	}
	public Card getCard(int x)
	{
		return unDealt.get(x);
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
	
	public boolean isEmpty()
	{
		return unDealt.size() == 0;
	}
	
	public int size()
	{
		return unDealt.size();
	}
	
	public Card deal()
	{
		if(unDealt.size() == 0)
		{
			return null;
		}
		else
		{
			int target = (int)(Math.random()*unDealt.size());
			Card card =unDealt.get(target);
			unDealt.remove(target);
			Dealt.add(card);
			return card;
		}
	}
	
	public void shuffle()
	{
		if(!(this.Dealt.size() == 0))
		{
			unDealt.addAll(this.Dealt);
			this.Dealt.clear();
		}
		
		for(int i = this.unDealt.size()-1; i > 0; i--)
		{
			int rand = (int)(Math.random()*i);
			Card card = unDealt.get(i);
			unDealt.set(i, unDealt.get(rand));
			unDealt.set(rand, card);
		}
	}
	
	
}
