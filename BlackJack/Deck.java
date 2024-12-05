import java.util.ArrayList;

public class Deck //class header
{
	//instance variables
	private ArrayList<Card> cards;

	//constructor
	public Deck()
	{
		cards = new ArrayList<Card>();
		for (int i = 0; i < 52; i ++)
		{
			int num = i % 13 + 1;
			String suit = "Diamonds";
			if (i / 13 == 1)
				suit = "Hearts";
			else if (i / 13 == 2)
				suit = "Clubs";
			else if (i / 13 == 3)
				suit = "Spades";
			cards.add(new Card(num,suit));
		}
	}

	//methods

	//toString
	public String toString()
	{
		return cards.toString();
	}

	//mutator methods
	public void shuffle()
	{
		for (int i = 0; i < 1000; i ++)
		{
			int x = (int)(Math.random()*cards.size());
			cards.add(cards.remove(x));
		}
	}

	public Card deal()
	{
		return cards.remove(0);
	}

}
