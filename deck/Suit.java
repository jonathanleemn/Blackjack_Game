package deck;

public enum Suit
{
	HEARTS("Hearts"),
	DIAMONDS("Diamonds"), 
	CLUBS("Clubs"), 
	SPADES("Spades");

	protected final String suitName;

	Suit(String n)
	{
		suitName = n;
	}

	public String getSuitName()
	{
		return suitName;
	}

}
