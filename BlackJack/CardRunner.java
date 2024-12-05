import java.util.ArrayList;
import java.util.Scanner;
public class CardRunner
{
	public CardRunner()
	{
		Deck deck = new Deck();
		System.out.println(deck);
		deck.shuffle();

		ArrayList<Card> p1 = new ArrayList<Card>();
		ArrayList<Card> p2 = new ArrayList<Card>();

		for (int i = 0; i < 2; i ++)
		{
			p1.add(deck.deal());
			p2.add(deck.deal());
    }

		System.out.println("Player Hand: " + p1);

		System.out.println("Dealer Card: " + p2.get(0));

    	int playerValue = getHandSum(p1);
    	int dealerValue = getHandSum(p2);

    System.out.println("Player Hand Value: " + playerValue);
	System.out.println("Would you like to hit or stand? Please enter in all lowercase.");
    //System.out.println("Dealer Hand Value: " + dealerValue);

    if(playerValue == 21)
    {
      System.out.println("Player wins!");
      return;
    }

    if(dealerValue == 21)
    {
      System.out.println("Dealer wins!");
      return;
    }

    Scanner reader = new Scanner(System.in);
    String response;

    // Player
    do {
	  response = reader.nextLine();

      if(response.equals("hit"))
      {
        p1.add(deck.deal());
        playerValue = getHandSum(p1);
		System.out.println("Player's New Hand: " + p1);
		System.out.println("Player Hand Value: " + playerValue);

        if(playerValue > 21)
        {
          System.out.println("Bust! You lose!");
          return;
        }
        else if(playerValue == 21)
        {
          System.out.println("Player wins!");
          return;
        }
      }
      else if(response.equals("stand"))
      {
        System.out.println("You are standing at " + playerValue);
        break;
      }
	  } while(response.equals("hit"));

    if(playerValue > 21)
    {
      return;
    }

    // Dealer
    System.out.println("Dealer's Turn");
    //p2.add(deck.deal());
    //dealerValue = getHandSum(p2);
    System.out.println("Dealer's Hand: " + p2);
    System.out.println("Dealer Hand Value: " + dealerValue);

    /*do {
      //response = reader.nextLine();

      if(response.equals("Hit"))
      {
        p2.add(deck.deal());
        dealerValue = getHandSum(p2);
		    System.out.println("Dealer's New Hand: " + p2);
        System.out.println("Dealer Hand Value: " + dealerValue);
      }
	  } while(response.equals("Hit") && dealerValue < 17);*/

	  while(dealerValue < 17)
	  {
	    p2.add(deck.deal());
		dealerValue = getHandSum(p2);
		System.out.println("Dealer's New Hand: " + p2);
        System.out.println("Dealer Hand Value: " + dealerValue);
		}

    if(dealerValue > 21)
    {
      System.out.println("Bust! Dealer lose!");
      System.out.println("Player wins!");
      return;
    }

    if (playerValue > dealerValue)
    {
      System.out.println("Player wins!");
    }
    else if (dealerValue > playerValue)
    {
      System.out.println("Dealer wins!");
    }
    else
    {
	 System.out.println("It is a tie!");
	}
  }

  public int getHandSum(ArrayList<Card> p)
	{
    int handSum = 0;
	  int numAces = 0;

    for(int i=0; i<p.size(); i++)
    {
      if(p.get(i).getNum() == 1)
      {
        numAces++;
        handSum+=11;
      }
      else if(p.get(i).getNum() > 10)
      {
        handSum += 10;
      }
      else
      {
        handSum += p.get(i).getNum();
      }
    }

   while (handSum > 21 && numAces > 0)
   {
      handSum -= 10;
      numAces--;
   }
		return handSum;
	}

	/*public static void main(String[] args)
	 {
	 	CardRunner cr = new CardRunner();
	 }*/
}