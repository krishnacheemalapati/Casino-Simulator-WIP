import java.util.Scanner;

public class Midterm
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
    while (((human1.isPlaying() != false) && (human2.isPlaying() != false)) || ((human1.isPlaying() != false) && (house.isPlaying() != false)) || ((house.isPlaying() != false) && (human2.isPlaying() != false)))
    {
      start = System.currentTimeMillis();
      while(start >= System.currentTimeMillis() - 900){};
      // Dealer / Computer
      if ((turnCount%3 == 2) && (house.getNumCards() > 0))
      {
        System.out.println("It is now the dealer's turn.");
        while (canPlay == true)
        {
          if (discard.getNumCards() <= 2)
          {
            canPlay = false;
          }
          else
          {
            System.out.println("Do you want to slap the pile? Player one: type 0. Player two: type 1. Otherwise, type 6.");
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
                System.out.println("The dealer slaps and gets the discard pile!");
                while (discard.getNumCards() > 0)
                {
                  tempCard = discard.giveCard(0);
                  house.drawCard(tempCard);
                }
              }
              start = System.currentTimeMillis();
              while(start >= System.currentTimeMillis() - 900){};
            }
            if (slap==1)
            {
              System.out.println("Player 2 slaps!");
              if ((discard.getCard(0) == 11))
              {
                System.out.println("Player 2 slaps and gets the discard pile!");
                while (discard.getNumCards() > 0)
                {
                  tempCard = discard.giveCard(0);
                  human2.drawCard(tempCard);
                }
              }
              else
              {
                System.out.println("Whoops. The deck cannot be legally slapped at this time. Please try again later.");
              }
              start = System.currentTimeMillis();
              while(start >= System.currentTimeMillis() - 900){};
            }
            if (slap==0)
            {
              System.out.println("Player 1 slaps!");
              if ((discard.getCard(0) == 11))
              {
                System.out.println("Player 1 slaps and gets the discard pile!");
                while (discard.getNumCards() > 0)
                {
                  tempCard = discard.giveCard(0);
                  human1.drawCard(tempCard);
                }
              }
              else
              {
                System.out.println("Whoops. The deck cannot be legally slapped at this time. Please try again later.");
              }
              start = System.currentTimeMillis();
              while(start >= System.currentTimeMillis() - 900){};
            }
            canPlay = false;
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
        System.out.println("You have " + human1.getNumCards() + " cards. Your friend has " + human2.getNumCards() + " and the dealer has " + house.getNumCards() + ".");
        turnCount++;
        canPlay = true;
      }
      else
      {
        house.setPlayability(false);
        turnCount++;
        canPlay = true;
      }
      
      // Player 1 ****************************************************************************************************************
      
      if ((turnCount%3 == 0) && (human1.getNumCards() > 0))
      {
        System.out.println("It is now your turn.");
        while (canPlay == true)
        {
          if (discard.getNumCards() <= 2)
          {
            break;
          }
          else
          {
            System.out.println("Do you want to slap the pile? Player one: type 0. Player two: type 1. Otherwise, type 6.");
            slap = scan.nextInt();
            start = System.currentTimeMillis();
            while(slap==6){
              if (start >= System.currentTimeMillis() - 900)
              {
                break;
              }
            } //Computer has a 900 millisecond reaction time because mine is over 500 
            if (slap==6)
            {
              System.out.println("You did not choose to slap.");
              if ((discard.getCard(0) == 11))
              {
                System.out.println("The dealer slaps and gets the discard pile!");
                while (discard.getNumCards() > 0)
                {
                  tempCard = discard.giveCard(0);
                  house.drawCard(tempCard);
                }
              }
              start = System.currentTimeMillis();
              while(start >= System.currentTimeMillis() - 900){};
            }
            if (slap==1)
            {
              System.out.println("Player 2 slaps!");
              if ((discard.getCard(0) == 11))
              {
                System.out.println("Player 2 slaps and gets the discard pile!");
                while (discard.getNumCards() > 0)
                {
                  tempCard = discard.giveCard(0);
                  human2.drawCard(tempCard);
                }
              }
              else
              {
                System.out.println("Whoops. The deck cannot be legally slapped at this time. Please try again later.");
              }
              start = System.currentTimeMillis();
              while(start >= System.currentTimeMillis() - 900){};
            }
            if (slap==0)
            {
              System.out.println("Player 1 slaps!");
              if ((discard.getCard(0) == 11))
              {
                System.out.println("Player 1 slaps and gets the discard pile!");
                while (discard.getNumCards() > 0)
                {
                  tempCard = discard.giveCard(0);
                  human1.drawCard(tempCard);
                }
              }
              else
              {
                System.out.println("Whoops. The deck cannot be legally slapped at this time. Please try again later.");
              }
              start = System.currentTimeMillis();
              while(start >= System.currentTimeMillis() - 900){};
            }
            break;
          }
        }
        tempCard = human1.playCard(0);
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
        System.out.println("You have " + human1.getNumCards() + " cards. Your friend has " + human2.getNumCards() + " and the dealer has " + house.getNumCards() + ".");
        canPlay = true;
        turnCount++;
      }
      else
      {
        human1.setPlayability(false);
        turnCount++;
        canPlay = true;
      }
      
      // Player 2 ****************************************************************************************************************
      
      if ((turnCount%3 == 1) && (human2.getNumCards() > 0))
      {
        System.out.println("It is now your friend's turn.");
        while (canPlay == true)
        {
          if (discard.getNumCards() <= 2)
          {
            canPlay = false;
          }
          else
          {
            System.out.println("Do you want to slap the pile? Player one: type 0. Player two: type 1. Otherwise, type 6.");
            slap = scan.nextInt();
            start = System.currentTimeMillis();
            while(slap==6){
              if (start >= System.currentTimeMillis() - 900)
              {
                break;
              }
            } //Computer has a 900 millisecond reaction time because mine is over 500 
            if (slap==6)
            {
              System.out.println("You did not choose to slap.");
              if ((discard.getCard(0) == 11))
              {
                System.out.println("The dealer slaps and gets the discard pile!");
                while (discard.getNumCards() > 0)
                {
                  tempCard = discard.giveCard(0);
                  house.drawCard(tempCard);
                }
              }
              start = System.currentTimeMillis();
              while(start >= System.currentTimeMillis() - 900){};
            }
            if (slap==1)
            {
              System.out.println("Player 2 slaps!");
              if ((discard.getCard(0) == 11))
              {
                System.out.println("Player 2 slaps and gets the discard pile!");
                while (discard.getNumCards() > 0)
                {
                  tempCard = discard.giveCard(0);
                  human2.drawCard(tempCard);
                }
              }
              else
              {
                System.out.println("Whoops. The deck cannot be legally slapped at this time. Please try again later.");
              }
              start = System.currentTimeMillis();
              while(start >= System.currentTimeMillis() - 900){};
            }
            if (slap==0)
            {
              System.out.println("Player 1 slaps!");
              if ((discard.getCard(0) == 11))
              {
                System.out.println("Player 1 slaps and gets the discard pile!");
                while (discard.getNumCards() > 0)
                {
                  tempCard = discard.giveCard(0);
                  human1.drawCard(tempCard);
                }
              }
              else
              {
                System.out.println("Whoops. The deck cannot be legally slapped at this time. Please try again later.");
              }
              start = System.currentTimeMillis();
              while(start >= System.currentTimeMillis() - 900){};
            }
            canPlay = false;
          }
        }
        tempCard = human2.playCard(0);
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
        System.out.println("You have " + human1.getNumCards() + " cards. Your friend has " + human2.getNumCards() + " and the dealer has " + house.getNumCards() + ".");
        turnCount++;
        canPlay = true;
      }
      else
      {
        human2.setPlayability(false);
        turnCount++;
        canPlay = true;
      }
    }
    
    if (human1.isPlaying() != false)
    {
      human1.won();
      winnerNameSlapJack = "YOU";
    }
    if (human2.isPlaying() != false)
    {
      winnerNameSlapJack = "YOUR FRIEND";
      human2.won();
    }
    if (house.isPlaying() != false)
    {
      house.won();
      winnerNameSlapJack = "THE DEALER";
    }
    
    
    
    /* ****************************************************************************************************************
     * 
     * End of tradtional SlapJack
     * Game #2: The exact same thing, modified so that ALL face cards count, Two duplicates in a row count, and a duplicate sandwich (cards like x y x in the order from the top) count
     * ****************************************************************************************************************
     */
    canPlay = true;
    deckLength = 0;
    turnCount = 2;
    slap = 6;
    card tempCard2;
    human1.clear();
    human1.setPlayability(true);
    human2.clear();
    human2.setPlayability(true);
    house.clear();
    house.setPlayability(true);
    discard.clear();
    deck deckyV2 = new deck();
    
    deckyV2.shuffle();
    deckyV2.dealAllCards(human1, human2, house);
    
    System.out.println("Congratulations to " + winnerNameSlapJack + " for winning Slapjack!");
    System.out.println("You and your friend decide to switch it up and play a more challenging version of SlapJack.");
    System.out.println("The two of you visit a nearby SlapFace table.");
    
    while (((human1.isPlaying() != false) && (human2.isPlaying() != false)) || ((human1.isPlaying() != false) && (house.isPlaying() != false)) || ((house.isPlaying() != false) && (human2.isPlaying() != false)))
    {
      start = System.currentTimeMillis();
      while(start >= System.currentTimeMillis() - 900){};
      // Dealer / Computer
      if ((turnCount%3 == 2) && (house.getNumCards() > 0))
      {
        System.out.println("It is now the dealer's turn.");
        while (canPlay == true)
        {
          if (discard.getNumCards() <= 2)
          {
            canPlay = false;
          }
          else
          {
            System.out.println("Do you want to slap the pile? Player one: type 0. Player two: type 1. Otherwise, type 6.");
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
              if ((discard.getCard(0) == discard.getCard(1)) || (discard.getCard(0) == discard.getCard(2)) || (discard.getCard(0) >= 11))
              {
                System.out.println("The dealer slaps and gets the discard pile!");
                while (discard.getNumCards() > 0)
                {
                  tempCard = discard.giveCard(0);
                  house.drawCard(tempCard);
                }
              }
              start = System.currentTimeMillis();
              while(start >= System.currentTimeMillis() - 900){};
            }
            if (slap==1)
            {
              System.out.println("Player 2 slaps!");
              if ((discard.getCard(0) == discard.getCard(1)) || (discard.getCard(0) == discard.getCard(2)) || (discard.getCard(0) >= 11))
              {
                System.out.println("Player 2 slaps and gets the discard pile!");
                while (discard.getNumCards() > 0)
                {
                  tempCard = discard.giveCard(0);
                  human2.drawCard(tempCard);
                }
              }
              else
              {
                System.out.println("Whoops. The deck cannot be legally slapped at this time. Please try again later.");
              }
              start = System.currentTimeMillis();
              while(start >= System.currentTimeMillis() - 900){};
            }
            if (slap==0)
            {
              System.out.println("Player 1 slaps!");
              if ((discard.getCard(0) == discard.getCard(1)) || (discard.getCard(0) == discard.getCard(2)) || (discard.getCard(0) >= 11))
              {
                System.out.println("Player 1 slaps and gets the discard pile!");
                while (discard.getNumCards() > 0)
                {
                  tempCard = discard.giveCard(0);
                  human1.drawCard(tempCard);
                }
              }
              else
              {
                System.out.println("Whoops. The deck cannot be legally slapped at this time. Please try again later.");
              }
              start = System.currentTimeMillis();
              while(start >= System.currentTimeMillis() - 900){};
            }
            canPlay = false;
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
        System.out.println("You have " + human1.getNumCards() + " cards. Your friend has " + human2.getNumCards() + " and the dealer has " + house.getNumCards() + ".");
        turnCount++;
        canPlay = true;
      }
      else
      {
        house.setPlayability(false);
        turnCount++;
        canPlay = true;
      }
      
      // Player 1 ****************************************************************************************************************
      
      if ((turnCount%3 == 0) && (human1.getNumCards() > 0))
      {
        System.out.println("It is now your turn.");
        while (canPlay == true)
        {
          if (discard.getNumCards() <= 2)
          {
            break;
          }
          else
          {
            System.out.println("Do you want to slap the pile? Player one: type 0. Player two: type 1. Otherwise, type 6.");
            slap = scan.nextInt();
            start = System.currentTimeMillis();
            while(slap==6){
              if (start >= System.currentTimeMillis() - 900)
              {
                break;
              }
            } //Computer has a 900 millisecond reaction time because mine is over 500 
            if (slap==6)
            {
              System.out.println("You did not choose to slap.");
              if ((discard.getCard(0) == discard.getCard(1)) || (discard.getCard(0) == discard.getCard(2)) || (discard.getCard(0) >= 11))
              {
                System.out.println("The dealer slaps and gets the discard pile!");
                while (discard.getNumCards() > 0)
                {
                  tempCard = discard.giveCard(0);
                  house.drawCard(tempCard);
                }
              }
              start = System.currentTimeMillis();
              while(start >= System.currentTimeMillis() - 900){};
            }
            if (slap==1)
            {
              System.out.println("Player 2 slaps!");
              if ((discard.getCard(0) == discard.getCard(1)) || (discard.getCard(0) == discard.getCard(2)) || (discard.getCard(0) >= 11))
              {
                System.out.println("Player 2 slaps and gets the discard pile!");
                while (discard.getNumCards() > 0)
                {
                  tempCard = discard.giveCard(0);
                  human2.drawCard(tempCard);
                }
              }
              else
              {
                System.out.println("Whoops. The deck cannot be legally slapped at this time. Please try again later.");
              }
              start = System.currentTimeMillis();
              while(start >= System.currentTimeMillis() - 900){};
            }
            if (slap==0)
            {
              System.out.println("Player 1 slaps!");
              if ((discard.getCard(0) == discard.getCard(1)) || (discard.getCard(0) == discard.getCard(2)) || (discard.getCard(0) >= 11))
              {
                System.out.println("Player 1 slaps and gets the discard pile!");
                while (discard.getNumCards() > 0)
                {
                  tempCard = discard.giveCard(0);
                  human1.drawCard(tempCard);
                }
              }
              else
              {
                System.out.println("Whoops. The deck cannot be legally slapped at this time. Please try again later.");
              }
              start = System.currentTimeMillis();
              while(start >= System.currentTimeMillis() - 900){};
            }
            break;
          }
        }
        tempCard = human1.playCard(0);
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
        System.out.println("You have " + human1.getNumCards() + " cards. Your friend has " + human2.getNumCards() + " and the dealer has " + house.getNumCards() + ".");
        canPlay = true;
        turnCount++;
      }
      else
      {
        human1.setPlayability(false);
        turnCount++;
        canPlay = true;
      }
      
      // Player 2 ****************************************************************************************************************
      
      if ((turnCount%3 == 1) && (human2.getNumCards() > 0))
      {
        System.out.println("It is now your friend's turn.");
        while (canPlay == true)
        {
          if (discard.getNumCards() <= 2)
          {
            canPlay = false;
          }
          else
          {
            System.out.println("Do you want to slap the pile? Player one: type 0. Player two: type 1. Otherwise, type 6.");
            slap = scan.nextInt();
            start = System.currentTimeMillis();
            while(slap==6){
              if (start >= System.currentTimeMillis() - 900)
              {
                break;
              }
            } //Computer has a 900 millisecond reaction time because mine is over 500 
            if (slap==6)
            {
              System.out.println("You did not choose to slap.");
              if ((discard.getCard(0) == discard.getCard(1)) || (discard.getCard(0) == discard.getCard(2)) || (discard.getCard(0) >= 11))
              {
                System.out.println("The dealer slaps and gets the discard pile!");
                while (discard.getNumCards() > 0)
                {
                  tempCard = discard.giveCard(0);
                  house.drawCard(tempCard);
                }
              }
              start = System.currentTimeMillis();
              while(start >= System.currentTimeMillis() - 900){};
            }
            if (slap==1)
            {
              System.out.println("Player 2 slaps!");
              if ((discard.getCard(0) == discard.getCard(1)) || (discard.getCard(0) == discard.getCard(2)) || (discard.getCard(0) >= 11))
              {
                System.out.println("Player 2 slaps and gets the discard pile!");
                while (discard.getNumCards() > 0)
                {
                  tempCard = discard.giveCard(0);
                  human2.drawCard(tempCard);
                }
              }
              else
              {
                System.out.println("Whoops. The deck cannot be legally slapped at this time. Please try again later.");
              }
              start = System.currentTimeMillis();
              while(start >= System.currentTimeMillis() - 900){};
            }
            if (slap==0)
            {
              System.out.println("Player 1 slaps!");
              if ((discard.getCard(0) == discard.getCard(1)) || (discard.getCard(0) == discard.getCard(2)) || (discard.getCard(0) >= 11))
              {
                System.out.println("Player 1 slaps and gets the discard pile!");
                while (discard.getNumCards() > 0)
                {
                  tempCard = discard.giveCard(0);
                  human1.drawCard(tempCard);
                }
              }
              else
              {
                System.out.println("Whoops. The deck cannot be legally slapped at this time. Please try again later.");
              }
              start = System.currentTimeMillis();
              while(start >= System.currentTimeMillis() - 900){};
            }
            canPlay = false;
          }
        }
        tempCard = human2.playCard(0);
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
        System.out.println("You have " + human1.getNumCards() + " cards. Your friend has " + human2.getNumCards() + " and the dealer has " + house.getNumCards() + ".");
        turnCount++;
        canPlay = true;
      }
      else
      {
        human2.setPlayability(false);
        turnCount++;
        canPlay = true;
      }
    }
    
    if (human1.isPlaying() != false)
    {
      human1.won();
      winnerNameSlapFace = "YOU";
    }
    if (human2.isPlaying() != false)
    {
      human2.won();
      winnerNameSlapFace = "YOUR FRIEND";
    }
    if (house.isPlaying() != false)
    {
      house.won();
      winnerNameSlapFace = "THE DEALER";
    }
    
    System.out.println("Congratulations to " + winnerNameSlapFace + " for winning Slapface!");
    System.out.println("Your friend feels adventurous and goes off to a poker table. You, on the other hand, don't like having an empty wallet, and go for a bets-free game of war.");
    System.out.println("You visit a nearby War table.");
    
    //******************************************************************************************************************************************************************************************************************************************
    // WAR
    //******************************************************************************************************************************************************************************************************************************************
    
    canPlay = true;
    deckLength = 0;
    turnCount = 0;
    deckLength = 0;
    human1.clear();
    human1.setPlayability(true);
    house.clear();
    house.setPlayability(true);
    discard.clear();
    card tempCard3 = new card();
    
    deck deckyV3 = new deck();
    deckyV3.shuffle();
    deckyV3.dealAllCards(human1, house);
    String winnerNameWar;
    
    while ((human1.isPlaying() != false) && (house.isPlaying() != false))
    {
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