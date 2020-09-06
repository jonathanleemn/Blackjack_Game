package player;

import java.util.ArrayList;
import java.util.stream.IntStream;

import deck.Card;
import deck.Rank;

public class Hand
{
	//will hold the cards for a player
	public ArrayList<Card> hand = new ArrayList<>();

	@Override
	public String toString()
	{
		return "Hand [hand=" + hand + "]";
	}
	
	public void printHand()
	{
		for (Card c : hand)
		{
			c.printCard();
		}
		
	}
	

}
