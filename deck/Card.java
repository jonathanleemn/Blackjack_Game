package deck;

public class Card
{
	protected Suit s;
	protected Rank r;
	int playerTotal;

	public Card(Suit s, Rank r)
	{
		this.s = s;
		this.r = r;
	}

	public void printCard()
	{
		System.out.printf("%s of %s\n", r.rank, s.suitName);
	}

	public int getPlayerTotal()
	{
		return playerTotal = r.getCardValue() + playerTotal;
	}

	@Override
	public String toString()
	{
		return r + " of " + s;
	}

	public int getValue()
	{
		return r.getCardValue();
	}
}
