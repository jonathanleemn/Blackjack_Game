package deck;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import player.Hand;
import deck.Rank;
import game.Game;

public class Deck
{

	public ArrayList<Card> cards = new ArrayList<Card>();
	private static final SecureRandom randomNumbers = new SecureRandom();
	private static final int NUMBER_OF_CARDS = 52;
	private int currentCard;
	public int playerTotal, dealerTotal;
	public static int playerAceCount = 0;
	public static int dealerAceCount = 0;
	Rank rank;
	Card card;

	// when creating a deck, cards are added to it and then shuffled
	public Deck()
	{
		newDeck();
		shuffle();
	}

	// populates deck with cards
	public void newDeck()
	{
		for (Suit s : Suit.values())
		{
			for (Rank r : Rank.values())
			{
				cards.add(new Card(s, r));
			}
		}
	}

	public void shuffle()
	{
		// next call to method dealCard should start at deck[0] again
		currentCard = 0;

		// for each Card, pick another random Card (0-51) and swap them
		for (int first = 0; first < cards.size(); first++)
		{
			// select a random number between 0 and 51
			int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

			// swap current Card with randomly selected Card
			Collections.swap(cards, first, second);
		}
	}

	public Card playerDrawCard()
	{
		// removes the first card from the deck
		playerTotal += cards.get(0).getValue();
		Game.player.hand.add(cards.get(0));
		countPlayersAces();
		return cards.remove(0);

	}

	public Card dealerDrawCard()
	{
		// removes the first card from the deck
		dealerTotal += cards.get(0).getValue();
		Game.dealer.hand.add(cards.get(0));
		countDealersAces();
		return cards.remove(0);
	}

	public void dealCards()// Hand player, Hand dealer
	{
		// draws one card and puts it into the player's hands
		Game.player.hand.add(cards.get(0));
		playerTotal = cards.get(0).getValue();
		countPlayersAces();
		cards.remove(0);

		// draws one card and puts it into the dealer's hands
		Game.dealer.hand.add(cards.get(0));
		dealerTotal = cards.get(0).getValue();
		countDealersAces();
		cards.remove(0);

		Game.player.hand.add(cards.get(0));
		playerTotal += cards.get(0).getValue();
		countPlayersAces();
		cards.remove(0);

		Game.dealer.hand.add(cards.get(0));
		dealerTotal += cards.get(0).getValue();
		countDealersAces();
		cards.remove(0);
	}

	public void printDeck()
	{
		for (Card c : cards)
		{
			c.printCard();
		}
	}

	public void countPlayersAces()
	{
		if (cards.get(0).getValue() == Rank.ACE.value)
			playerAceCount++;
	}
	
	public void countDealersAces()
	{
		if (cards.get(0).getValue() == Rank.ACE.value)
			dealerAceCount++;
	}
}
