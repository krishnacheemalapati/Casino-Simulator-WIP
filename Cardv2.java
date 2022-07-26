public class Cardv2
{
   Rank rank;
   Suit suit;
public Cardv2(Rank rank, Suit suit)
   {
        this.rank = rank;
        this.suit = suit;
   }

public Cardv2()
   {
        this.rank = null;
        this.suit = null;
   }
 public String toString() 
    {  return rank + " of " + suit; } 
    
 public int getCardRank()
 {
   return this.rank.getRank();
 }
 
 public boolean equals(Cardv2 c)
 {
   return (c.rank == rank) && (c.suit == suit);
 }
}
