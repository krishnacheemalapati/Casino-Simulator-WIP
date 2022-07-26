import java.util.Scanner;

public class MidteST
{
  public static void main (String[] args)
  {
    boolean canPlay = true;
    int deckLength = 0;
    int turnCount = 2;
    int slap = 6;
    String winnerNameSlapJack = "";
    String winnerNameSlapFace = "";
    card tempCard, tempCard2, tempCard3;
    player human1 = new player();
    human1.setPlayability(true);
    player human2 = new player();
    human2.setPlayability(true);
    player house = new player();
    house.setPlayability(true);
    discardPile discard = new discardPile();
    deck decky = new deck();
    Scanner scan = new Scanner (System.in);
    
    decky.shuffle();
    decky.dealAllCards(house, human2, human1);
    System.out.println("Welcome to Krishna's Cards and Casino!");
    System.out.println("Today, you have chosen to play a game of Slapjack with a friend and the house. Later, you will play a modified version of Slapjack, followed by a game of War.");
    
    
    
    canPlay = true;
    deckLength = 0;
    turnCount = 0;
    deckLength = 0;
    human1.clear();
    human1.setPlayability(true);
    house.clear();
    house.setPlayability(true);
    discard.clear();
    
    deck deckyV3 = new deck();
    deckyV3.shuffle();
    deckyV3.dealAllCards(human1, house);
    String winnerNameWar;
    
    while ((human1.isPlaying() != false) && (house.isPlaying() != false))
    {
      long start = System.currentTimeMillis();
      while(start >= System.currentTimeMillis() - 100){};
      
      newRound2p2: while ((human1.isPlaying() != false) || (house.isPlaying() != false))
      {
        System.out.println("You have " + human1.getNumCards() + " cards. The dealer has " + house.getNumCards() + ".");
        start = System.currentTimeMillis();
        while(start >= System.currentTimeMillis() - 100){};
        
        if (house.getNumCards() <= 0)
        {
          house.setPlayability(false);
        }
        else
        {
          tempCard = house.playCard(0);
          discard.receiveCard(tempCard);
        }
        if (human1.getNumCards() <= 0)
        {
          human1.setPlayability(false);
        }
        else
        {
          tempCard3 = human1.playCard(0);
          discard.receiveCard(tempCard3);
        }
        
        System.out.print("Current top cards: ");
        for (int x = 0; x <= discard.getNumCards()-1; x++) 
          System.out.print(" " + discard.getCard(x) + " ");
        System.out.println("");
        
        start = System.currentTimeMillis();
        while(start >= System.currentTimeMillis() - 100){};
        if (discard.getCard(0) > discard.getCard(1))
        {
          System.out.println("YOU win the round!");
          while (discard.getNumCards() > 0)
          {
            tempCard = discard.giveCard(0);
            human1.drawCard(tempCard);
          }
          start = System.currentTimeMillis();
          while(start >= System.currentTimeMillis() - 100){};
          break newRound2p2;
        }
        
        if (discard.getCard(1) > discard.getCard(0))
        {
          System.out.println("THE DEALER wins the round!");
          while (discard.getNumCards() > 0)
          {
            tempCard = discard.giveCard(0);
            house.drawCard(tempCard);
          }
          start = System.currentTimeMillis();
          while(start >= System.currentTimeMillis() - 100){};
          break newRound2p2;
        }
        if (discard.getCard(0) == discard.getCard(1))
        {
          System.out.println("WAR has been declared between THE DEALER and YOU!");
          while ((house.getNumCards() * human2.getNumCards()) > 0)
          {
            tempCard2 = house.playCard(0);
            discard.receiveCard(tempCard2);
            
            tempCard3 = human1.playCard(0);
            discard.receiveCard(tempCard3);
            
            tempCard2 = house.playCard(0);
            discard.receiveCard(tempCard2);
            
            tempCard3 = human1.playCard(0);
            discard.receiveCard(tempCard3);
            
            tempCard2 = house.playCard(0);
            discard.receiveCard(tempCard2);
            
            tempCard3 = human1.playCard(0);
            discard.receiveCard(tempCard3);
            
            System.out.print("Current top cards: ");
            for (int x = 0; x <= discard.getNumCards()-1; x++) 
              System.out.print(" " + discard.getCard(x) + " ");
            System.out.println("");
            
            start = System.currentTimeMillis();
            while(start >= System.currentTimeMillis() - 100){};
            
            if (discard.getCard(0) == discard.getCard(1))
            {
              System.out.println("WAR has been declared between THE DEALER and YOU AGAIN!!");
              
              tempCard2 = house.playCard(0);
              discard.receiveCard(tempCard2);
              
              tempCard3 = human1.playCard(0);
              discard.receiveCard(tempCard3);
              
              tempCard2 = house.playCard(0);
              discard.receiveCard(tempCard2);
              
              tempCard3 = human1.playCard(0);
              discard.receiveCard(tempCard3);
              
              tempCard2 = house.playCard(0);
              discard.receiveCard(tempCard2);
              
              tempCard3 = human1.playCard(0);
              discard.receiveCard(tempCard3);
              
              System.out.print("Current top cards: ");
              for (int x = 0; x <= discard.getNumCards()-1; x++) 
                System.out.print(" " + discard.getCard(x) + " ");
              System.out.println("");
              
              start = System.currentTimeMillis();
              while(start >= System.currentTimeMillis() - 100){};
              
              if (discard.getCard(0) == discard.getCard(1))
              {
                System.out.println("The dealer takes the cards.");
                while (discard.getNumCards() > 0)
                {
                  tempCard = discard.giveCard(0);
                  house.drawCard(tempCard);
                }
                start = System.currentTimeMillis();
                while(start >= System.currentTimeMillis() - 100){};
                break newRound2p2;
              }
            }
            else
            {
              if (discard.getCard(1) > discard.getCard(0))
              {
                System.out.println("THE DEALER wins the wars!");
                while (discard.getNumCards() > 0)
                {
                  tempCard = discard.giveCard(0);
                  house.drawCard(tempCard);
                }
                start = System.currentTimeMillis();
                while(start >= System.currentTimeMillis() - 100){};
                break newRound2p2;
              }
              else
              {
                System.out.println("YOU won the wars!");
                while (discard.getNumCards() > 0)
                {
                  tempCard = discard.giveCard(0);
                  human1.drawCard(tempCard);
                }
                start = System.currentTimeMillis();
                while(start >= System.currentTimeMillis() - 100){};
                break newRound2p2;
              }
            }
          }
          if (house.getNumCards() == 0)
          {
            System.out.println("OH NO! THE DEALER RAN OUT OF CARDS!");
            house.setPlayability(false);
            while (discard.getNumCards() > 0)
            {
              tempCard = discard.giveCard(0);
              house.drawCard(tempCard);
            }
            start = System.currentTimeMillis();
            while(start >= System.currentTimeMillis() - 100){};
            break newRound2p2;
          }
          if (human1.getNumCards() == 0)
          {
            System.out.println("OH NO! YOU RAN OUT OF CARDS!");
            human1.setPlayability(false);
            while (discard.getNumCards() > 0)
            {
              tempCard = discard.giveCard(0);
              house.drawCard(tempCard);
            }
            start = System.currentTimeMillis();
            while(start >= System.currentTimeMillis() - 100){};
            break newRound2p2;
          }
        }
      }
    }
    if (human1.isPlaying() != false)
    {
      human1.won();
      winnerNameWar = "YOU";
    }
    if (house.isPlaying() != false)
    {
      house.won();
      winnerNameWar = "THE DEALER";
    }
    else
    {
      winnerNameWar = "Error";
    }
    
    System.out.println("Congratulations to " + winnerNameWar + " for winning War!");
    System.out.println("After a rather eventful night at the Casino, you and your friend finally decide that it is time to leave. You split a pizza (and the bill), have a few drinks, and soon part ways, making plans to come back to the Casino once again next weekend.");
    System.out.println("Final Stats: You had " + human1.getWins() + " wins. Your friend had " + human2.getWins() + " wins and the dealer had " + house.getWins() + " wins.");
    System.out.println("Have a great evening! We hope you had fun at the Casino!");
// Note that getting a drink can consist of getting a soda / juice / water
  }
}