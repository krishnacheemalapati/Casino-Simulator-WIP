import java.util.ArrayList;

public class discardPile 
{
  private boolean isPlaying;
  private card play;
  private card temp;
  private ArrayList<card> DiscardPile = new ArrayList <card>();
  public discardPile(){}
  public void clear()
  {
    DiscardPile.clear();
  }
  public void receiveCard(card cardNew)
  {
    DiscardPile.add(0, cardNew);
  }
  public card giveCard(int position)
  {
      play = DiscardPile.get(0);
      DiscardPile.remove(0);
      return play;
  }
  public int getNumCards()
  {
    return DiscardPile.size();
  }
  public int getCard(int position)
  {
    temp = (card)DiscardPile.get(position);
    return temp.getNum();
  }
}