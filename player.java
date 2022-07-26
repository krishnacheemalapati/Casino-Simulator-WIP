import java.util.ArrayList;

public class player 
{
  private int winCount = 0;
  private boolean isPlaying;
  private int cardCount;
  private card play;
  private card nothing = new card(0, 0);
  private card temp;
  private ArrayList<card> Player = new ArrayList <card>();
  public player(){}
  public void clear()
  {
    Player.clear();
    cardCount = 0;
  }
  public void drawCard(card cardNew)
  {
    Player.add(cardNew);
    cardCount++;
  }
  public card playCard(card playedCard)
  {
    if (cardCount < 1)
    { return nothing;}
    else
    {
      Player.remove(playedCard);
      cardCount--;
      return playedCard;
    }
  }
  public card playCard(int position)
  {
    if (cardCount < 1)
    { return nothing;}
    else
    {
      play = Player.get(position);
      Player.remove(position);
      cardCount--;
      return play;
    }
  }
  public card playCard()
  {
    if (cardCount < 1)
    {return nothing;}
    else
    {
      play = Player.get(0);
      Player.remove(0);
      cardCount--;
      return play;
    }
  }
  public int getNumCards()
  {
    return Player.size();
  }
  public int getCard(int position)
  {
    temp = (card)Player.get(position);
    return temp.getNum();
  }
  public void setPlayability(boolean playable)
  {
    this.isPlaying = playable;
  }
  public boolean isPlaying()
  {
    return this.isPlaying;
  }
  public void won()
  {
    this.winCount++;
  }
  public int getWins()
  {
    return this.winCount;
  }
}