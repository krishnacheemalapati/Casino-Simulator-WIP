import java.util.*;
public class DeckOfCards
{
  public ArrayList<Cardv2> deckOFcards;
  public static final int maxNumberofCards = 52;
 
 public DeckOfCards()
 {
  this.deckOFcards = new ArrayList<Cardv2>();
 }
 public void populatedeck()
 {
   for(Suit cardsuit: Suit.values())
   {
     for(Rank cardrank: Rank.values())
     {
       Cardv2 tempcard = new Cardv2 (cardrank, cardsuit);
       this.deckOFcards.add(tempcard);
     }
   }
  }
 public Cardv2 getCardDetails(int i)
 {
   return this.deckOFcards.get(i);
 }
 public void removeCardfromDeck(int i)
 {
   this.deckOFcards.remove(i);
 }
 public void addCardtoDeck(Cardv2 addCardtoDeck)
 {
   this.deckOFcards.add(addCardtoDeck);
 } 
 public void drawCardfromDeck(DeckOfCards deckFrom)
 {
   Random random = new Random();
   
   int CardDrawIndex = random.nextInt(deckFrom.deckOFcards.size())+0;
   this.deckOFcards.add(deckFrom.getCardDetails(CardDrawIndex));
   deckFrom.removeCardfromDeck(CardDrawIndex);
 }
 public String toString()
 {
   String deckoutput = "";
   for (Cardv2 card:this.deckOFcards)
   {
     deckoutput = deckoutput + card.toString() +". ";
   }
   return deckoutput;
 }
 
  public boolean equals(DeckOfCards d)
 {
    Cardv2 tempcard1 = new Cardv2();
    Cardv2 tempcard2 = new Cardv2();
    
    for (int i = 0; i<deckOFcards.size()-1; i++)
    {
      tempcard1 = d.deckOFcards.get(i);
      tempcard2 = deckOFcards.get(i);
      if (tempcard1.equals(tempcard2) == false)
      {
        return false;
      }
    } 
    return true;
 }
}
