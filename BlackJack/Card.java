public class Card //class header
{
	//instance variables - fields - describe the class
	private String suit;
	private int num;
	private String color;

	//constructor - sets the instance variables
	public Card(int n, String s)
	{
		num = n;
		suit = s;
		if(s.equals("Clubs") || s.equals("Spades"))
			color = "Black";
		else
			color = "Red";
	}

	//methods

	//toString - for printing the object
	public String toString()
	{
		switch(num)
		{
			case 1 : return "Ace of " + suit;
			case 11 : return "Jack of " + suit;
			case 12 : return "Queen of " + suit;
			case 13 : return "King of " + suit;
			default : return num + " of " + suit;
		}
	}

	//accessor methods - "getters"
	public int getNum()
	{
		return num;
	}

	public String getSuit()
	{
		return suit;
	}

	public String getColor()
	{
		return color;
	}

	//mutator methods - "setters" - none for Card class
}
