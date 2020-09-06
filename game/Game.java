package game;

import java.util.Scanner;

import deck.Deck;
import deck.Rank;
import player.Hand;

public class Game
{
	Deck myDeck = new Deck();
	public static Hand player = new Hand();
	public static Hand dealer = new Hand();
	Scanner input = new Scanner(System.in);
	int choice;
	boolean playerBust = false;

	public boolean playGame()
	{
		System.out.println("Your cards: ");
		myDeck.dealCards();
		player.printHand();
		checkPlayersAceCount();
		playersTurn();
		playerWinMessage();
		checkDealersAceCount();
		dealersTurn();
		dealerWinMessage();
		
		return false;
	}

	public void checkPlayersAceCount()
	{
		if (Deck.playerAceCount > 1)
		{
			Deck.playerAceCount--;
			myDeck.playerTotal = myDeck.playerTotal - 10 * Deck.playerAceCount;
		}
	}
	
	public void checkDealersAceCount()
	{
		if (Deck.dealerAceCount > 1)
		{
			Deck.dealerAceCount--;
			myDeck.dealerTotal = myDeck.dealerTotal - 10 * Deck.dealerAceCount;
		}
	}

	public void playerWinMessage()
	{
		if (myDeck.playerTotal > 21)
		{
			System.out.println("Player busts");
			playerBust = true;
		}
		else if (myDeck.playerTotal == 21)
			System.out.println("Blackjack!");
	}
	
	public void dealerWinMessage()
	{
		if(myDeck.dealerTotal > myDeck.playerTotal && myDeck.dealerTotal <= 21)
			System.out.println("Dealer has a higher value. Dealer wins");
		else if(myDeck.dealerTotal == myDeck.playerTotal)
			System.out.println("Push. Neither players win");
		else if(myDeck.dealerTotal > 21)
			System.out.println("Dealer busts. Player wins");
		else if(myDeck.dealerTotal < myDeck.playerTotal && playerBust == false)
			System.out.println("Player has a higher value. Player wins");
		else if(playerBust == true && myDeck.dealerTotal <= 21)
			System.out.println("Dealer wins");
	}

	public void dealersTurn()
	{
		System.out.println("\nDealer's cards: ");
		dealer.printHand();
		System.out.println("Dealer Total: " + myDeck.dealerTotal);
		while(myDeck.dealerTotal <= 16 && myDeck.dealerTotal < myDeck.playerTotal && playerBust == false)
		{
			myDeck.dealerDrawCard();
			checkDealersAceCount();
			System.out.println("\nDealer hits");
			dealer.printHand();
			System.out.println("Dealer Total: " + myDeck.dealerTotal);
		}

	}

	public void playersTurn()
	{
		System.out.println("Player Total: " + myDeck.playerTotal);
		while (myDeck.playerTotal < 21)
		{
			System.out.print("\nHit(1) or Stay(2) ");
			choice = input.nextInt();
			if (choice == 1)
			{
				myDeck.playerDrawCard();
				checkPlayersAceCount();
				System.out.println("\nYour cards: ");
				player.printHand();
				System.out.println("Player Total: " + myDeck.playerTotal);
			}
			if (choice == 2)
			{
				break;
			}
		}
	}
}
