import java.util.Scanner;

public class afjl
{
  public static void main (String[] args)
  {
    boolean canPlay = true;
    int deckLength = 0;
    int turnCount = 2;
    int slap = 6;
    String winnerNameSlapJack = "";
    String winnerNameSlapFace = "";
    card tempCard;
    player human1 = new player();
    human1.setPlayability(true);
    player house = new player();
    house.setPlayability(true);
    discardPile discard = new discardPile();
    deck decky = new deck();
    Scanner scan = new Scanner (System.in);
    
    decky.shuffle();
    decky.dealAllCards(house, human1);
    System.out.println("Welcome to Krishna's Cards and Casino!");
    System.out.println("Today, you have chosen to play a game of Slapjack with a friend and the house. Later, you will play a modified version of Slapjack, followed by a game of War.");
    long start = System.currentTimeMillis();
    while(start >= System.currentTimeMillis() - 2000); // Found this on Stack Overflow
    
    System.out.println("You have walked over to the traditional Slapjack table.");
    System.out.println("The dealer shuffles and then deals as evenly as possible amongst the three of you.");
    /****************************************************************************************************************************************************************
      * Traditional SlapJack Code
      * No mods at all
      * Two humans, one computer
      * Computer never makes mistakes when slapping, making it smart.
      * Scoring is given every turn via card count.
      * 
      * HACKS: Type in any integer value except 6 when it is your turn to prevent the dealer from noticing that (s)he can slap the discard pile and take all the cards!
      *        (THE ABOVE HACK WORKS FOR SLAPFACE [the second game] TOO!)
      ****************************************************************************************************************************************************************/
    while ((human1.isPlaying() != false) && ((house.isPlaying())))
    {
      start = System.currentTimeMillis();
      while(start >= System.currentTimeMillis() - 900){};
      // Dealer / Computer
        while (canPlay == true)
        {
          if (discard.getNumCards() <= 0)
          {
            canPlay = false;
          }
          else
          {
            decky.dealCard().toString()
            System.out.println("Do you want to slap the pile? If so, type 0. Otherwise, type 6.");
            slap = scan.nextInt();
            start = System.currentTimeMillis();
            while(slap==6){
              if (start >= System.currentTimeMillis() - 900)
              {
                break;
              }
            }
            if (slap==6)
            {
              System.out.println("You did not choose to slap.");
              if ((discard.getCard(0) == 11))
              {
                System.out.println("Oh No! That was a Jack! You have lost.");
                while (discard.getNumCards() > 0)
                {
                  tempCard = discard.giveCard(0);
                  house.drawCard(tempCard);
                }
                human1.setPlayability(true);
              }
              start = System.currentTimeMillis();
              while(start >= System.currentTimeMillis() - 900){};
            }
            if (slap==0)
            {
              System.out.println("You slap!");
              if ((discard.getCard(0) == 11))
              {
                System.out.println("You win!");
                while (discard.getNumCards() > 0)
                {
                  tempCard = discard.giveCard(0);
                  human1.drawCard(tempCard);
                }
              }
              else
              {
                System.out.println("Oh No! You slapped when it was not a Jack! You lost.");
              }
              start = System.currentTimeMillis();
              while(start >= System.currentTimeMillis() - 900){};
            }
            human1.setPlayability(true);
          }
        }
        tempCard = house.playCard(0);
        discard.receiveCard(tempCard);
        if (discard.getNumCards() >= 3)
        {
          System.out.print("Current top cards: ");
          for (int x = 0; x <= discard.getNumCards()-1; x++) 
            System.out.print(" " + discard.getCard(x) + " ");
          System.out.println("");
        }
        if (discard.getNumCards() == 2)
        {
          System.out.println("Current top cards: " + discard.getCard(0) + " " + discard.getCard(1));
        }
        if (discard.getNumCards() == 1)
        {
          System.out.println("Current top cards: " + discard.getCard(0));
        }
        turnCount++;
        canPlay = true;
      }
    
    if (human1.isPlaying() != false)
    {
      human1.won();
      winnerNameSlapJack = "YOU";
    }
    if (house.isPlaying() != false)
    {
      house.won();
      winnerNameSlapJack = "THE DEALER";
    }
    System.out.println(winnerNameSlapJack);
  }
}
    
    
    