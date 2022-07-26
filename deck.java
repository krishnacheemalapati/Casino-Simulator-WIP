import java.util.Collections; // Found this online, give an easy way to shuffle the deck
import java.util.ArrayList;
public class deck 
{
  public ArrayList<card> deckOfCards = new ArrayList<card>();
  private int cardsUsed;
  public deck() 
  {
    for ( int suit = 1; suit <= 4; suit++ ) 
    {
      for ( int num = 1; num <= 13; num++ ) 
      {
        card c = new card(num, suit);
        deckOfCards.add(c);
      }
    }
  }
  public void shuffle() 
  {
    Collections.shuffle(deckOfCards);
  }
  public int cardsLeft() 
  {
    return deckOfCards.size() - cardsUsed;
  }
  public card dealCard() 
  {
    return (card)deckOfCards.get(cardsUsed);
  }
  public void dealAllCards(player pp1, player pp2, player pp3)
  {
    cardsUsed = 0;
    while (cardsUsed < 52)
    {
      if (cardsUsed%3 == 0)
      {
        pp1.drawCard(this.dealCard());
      }
      if (cardsUsed%3 == 1)
      {
        pp2.drawCard(this.dealCard());
      }
      if (cardsUsed%3 == 2)
      {
        pp3.drawCard(this.dealCard());
      }
      cardsUsed++;
    }
  }
  public void dealAllCards(player pp1, player pp2)
  {
    cardsUsed = 0;
    while (cardsUsed < 52)
    {
      if (cardsUsed%2 == 0)
      {
        pp1.drawCard(this.dealCard());
      }
      if (cardsUsed%2 == 1)
      {
        pp2.drawCard(this.dealCard());
      }
      cardsUsed++;
    }
  }
  public void dealAllCards(player pp1)
  {
    cardsUsed = 0;
    while (cardsUsed < 52)
    {
      if (cardsUsed%2 == 0)
      {
        pp1.drawCard(this.dealCard());
      }
      if (cardsUsed%2 == 1)
      {
        pp1.drawCard(this.dealCard());
      }
      cardsUsed++;
    }
  }
}