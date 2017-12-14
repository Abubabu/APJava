package Lab4_1;

public class Card{
	private String rank;  //(name of the card)
	private String suit;
	private int pointValue;
	
	Card(String rank, String suit, int pointValue)
	{
		this.rank = rank;
		this.suit = suit;
		this.pointValue = pointValue;
	}
	public String getRank() 
	{
		return rank;
	}
	public String getSuit()
	{
		return suit;
	}
	public int getpointValue()
	{
		return pointValue;
	}
	
	public boolean equals(Card otherCard) //check if this card equals another in value.
	{
		return pointValue == otherCard.pointValue;
	}
	@Override
	public String toString() {
		return "Card [rank=" + rank + ", suit=" + suit + ", pointValue=" + pointValue + "]";
	}

	

}
