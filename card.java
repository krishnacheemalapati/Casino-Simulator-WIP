public class card
{
  private boolean equals = false;
  private int num = 0;
  private int suit = 0;
  private String realNum = "1";
  private String realSuit = "Hearts";
  public card()
  {
    num = ((int)((Math.random()*13)+1));
    suit = ((int)((Math.random()*4)+1));
  }
  public card(int chosenNum, int chosenSuit)
  {
    num = chosenNum;
    suit = chosenSuit;
  }
  public void determineCard()
  {
    if (num == 0)
    {}
    if (num == 1)
    { realNum = "Ace of ";}
    if (num == 2)
    { realNum = "2 of ";}
    if (num == 3)
    { realNum = "3 of ";}
    if (num == 4)
    { realNum = "4 of ";}
    if (num == 5)
    { realNum = "5 of ";}
    if (num == 6)
    { realNum = "6 of ";}
    if (num == 7)
    { realNum = "7 of ";}
    if (num == 8)
    { realNum = "8 of ";}
    if (num == 9)
    { realNum = "9 of ";}
    if (num == 10)
    { realNum = "10 of ";}
    if (num == 11)
    { realNum = "Jack of ";}
    if (num == 12)
    { realNum = "Queen of ";}
    if (num == 13)
    { realNum = "King of ";}
    
    if (suit == 0)
    {}
    if (suit == 1)
    { realSuit = "Clubs";}
    if (suit == 2)
    { realSuit = "Diamonds";}
    if (suit == 3)
    { realSuit = "Hearts";}
    if (suit == 4)
    { realSuit = "Spades";}
  }
  public void checkSame(card c2)
  {
    while ((this.getNum() == c2.getNum()) && (this.getSuit() == c2.getSuit()))
    {
      c2.setNum(((int)(Math.random()*13)));
      c2.setSuit(((int)(Math.random()*4)));
    }
  }
  public boolean equals(card c2)
  {
    if ((this.getNum() == c2.getNum()) && (this.getSuit() == c2.getSuit()))
    {
      return true;
    }
    else 
    {
      return false;
    }
  }
  public int getNum()
  {
    return num;
  }
  public void setNum(int newNum)
  {
    this.num = newNum;
    this.determineCard();
  }
  public void setSuit(int newSuit)
  {
    this.suit = newSuit;
    this.determineCard();
  }
  public int getSuit()
  {
    return suit;
  }
  public String getRealNum()
  {
    return realNum;
  }
  public String getRealSuit()
  {
    return realSuit;
  }
  public String toString() 
  {
    return realNum+realSuit;
  }
}