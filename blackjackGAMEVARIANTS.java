import java.util.*;
public class blackjackGAMEVARIANTS
{
  public static void printScore(int dealerscore, int playerscore)
  {
        System.out.println("#######################################################################################");
        System.out.println("SCORE: DEALER: " + dealerscore + " Points || PLAYER: " + playerscore + " Points");
        System.out.println("#######################################################################################");
  }
  
  public static void printScoreFinal(int dealerscore, int playerscore, int dealerblackjackcount, int playerblackjackcount)
  {
        System.out.println("#######################################################################################");
        System.out.println("\t\t\t" + " SCORE " + "\t\t\t" + " NUMBER OF BLACKJACK WINS ");
        System.out.println("\t\t\t" + "-------" + "\t\t\t" + "--------------------------");
        System.out.println("DEALER: " + "\t\t" + dealerscore + " Points " + "\t\t\t" + dealerblackjackcount + " Blackjacks");
        System.out.println("PLAYER: " + "\t\t" + playerscore + " Points " + "\t\t\t" + playerblackjackcount + " Blackjacks");
        System.out.println("#######################################################################################");
  }
   
  public static void main(String [] args)
  {
    int dealerscoreTally =0, playerscoreTally =0, initResponse, secondResponse=0;
    int playercardcount = 0;
    int dealercardcount = 0; 
    int playercardranktotal_regular = 0;
    int playercardranktotal_alternate = 0;
    int playercardranktotal_final = 0; 
    int playerblackjackcount = 0; 
    int dealercardranktotal_regular = 0;
    int dealercardranktotal_alternate = 0;
    int dealerblackjackcount = 0; 
    int dealercardranktotal_Max = 0; 
    boolean validResponseObtained; 
    boolean aceAlreadyConsidered; 
    int blackjackpoints = 2;
    int regularwinpoints = 1; 
    boolean hitInProgress; 
    boolean standInProgress; 
    
    boolean gameover = false; 
    boolean firstround = true; 
    boolean winnerFound;
    DeckOfCards playerPack;
    playerPack = new DeckOfCards ();
    DeckOfCards dealerPack;
    dealerPack = new DeckOfCards ();
    DeckOfCards playerSelectedCards;
    playerSelectedCards = new DeckOfCards ();
    DeckOfCards dealerSelectedCards;
    dealerSelectedCards = new DeckOfCards ();
    
    
    
    Scanner scan = new Scanner(System.in);
    System.out.println("Welcome to Blackjack! CHOOSE YOUR OPTION - 1 TO BEGIN PLAYING (or) 2 TO LEAVE THE GAME");
    initResponse =(int) scan.nextInt();
    validResponseObtained = false;
    
    
    while (!validResponseObtained)
    {
    if (initResponse == 1 || initResponse == 2)
    {
      validResponseObtained = true;
    }
    else
    {
      System.out.println("INVALID OPTION! CHOOSE YOUR OPTION - 1 TO BEGIN PLAYING (or) 2 TO LEAVE THE GAME");
      initResponse =(int) scan.nextInt();
    }
    }
    
    if (initResponse == 2)
    {
      System.out.println("THANKS FOR CHOOSING TO PLAY BLACKJACK WITH ME.  HAVE A GREAT DAY");
      System.exit(0);
    }
      
    while (!gameover) // ALLOW THE PLAYER TO PLAY MULTIPLE ROUNDS 
    {
    if(initResponse == 1 && firstround == true) // FIRST ROUND OF BLACKJACK 
    {
      
      playercardcount = 0;
      dealercardcount = 0; 
      playercardranktotal_regular = 0;
      playercardranktotal_alternate = 0;
      dealercardranktotal_regular = 0;
      dealercardranktotal_alternate = 0;
      //above line of code giving error
      System.out.println("Let me create decks of cards for you (Player) and me (Dealer)");
            
      playerPack.deckOFcards.clear();  
      playerPack.populatedeck();  
      System.out.println("size of Player Pack = " + playerPack.deckOFcards.size());
      System.out.println("");
      System.out.println("Your (Player) cards are as follows: " + "\n" + playerPack);
      System.out.println("");
      
      
      dealerPack.deckOFcards.clear();   
      dealerPack.populatedeck();  
      System.out.println("size of Dealer Pack = " + dealerPack.deckOFcards.size()); 
      System.out.println("");
      System.out.println("My (Dealer) cards are as follows: " + "\n" + dealerPack);
      System.out.println("");
      
      if (playerPack.equals(dealerPack))
      {
      System.out.println("GREAT NEWS!!! YOUR (PLAYER PACK) AND MY (DEALER PACK) ARE SAME AND SO IT IS GOING TO BE A FAIR GAME!");
      }
      else
      {
        System.out.println("!!!!YOUR (PLAYER PACK) AND MY (DEALER PACK) ARE NOT SAME AND SO IT IS NOT GOING TO BE A FAIR GAME!");
      }
      
      
      
      //DRAW TWO CARDS FOR PLAYER.  MOVE THEM FROM PLAYER PACK TO PLAYER-SELECTED-CARDS.  SHOW THE PLAYER THE TWO CARDS AND THEIR VALUE
      playerSelectedCards.deckOFcards.clear();  
      playerSelectedCards.drawCardfromDeck(playerPack);
      playercardcount++; //CONTAINS HOW MANY CARDS HAVE BEEN DRAWN FOR THE PLAYER 
      playerSelectedCards.drawCardfromDeck(playerPack);
      playercardcount++;
      System.out.println("The two random cards that you start with are: " + playerSelectedCards);  
      
      aceAlreadyConsidered = false; // IF ACE CARD IS DRAWN, ITS VALUE CAN BE INTERPRETED AS EITHER 1 OR 11 
      for (int k=0; k < playercardcount; k++)
      {
        playercardranktotal_regular = playercardranktotal_regular + playerSelectedCards.getCardDetails(k).getCardRank();
        if (playerSelectedCards.getCardDetails(k).getCardRank() == 1)   
        {
            aceAlreadyConsidered = true; 
        }
      }
       if (aceAlreadyConsidered == true)
       {
         playercardranktotal_alternate = playercardranktotal_regular + 10;
         System.out.println("Your cards have two values = " + playercardranktotal_regular + " OR " + playercardranktotal_alternate);
       }
       else
       {
         playercardranktotal_alternate = playercardranktotal_regular;
         System.out.println("Your cards value = " + playercardranktotal_regular);
       }
      
        
      
      //DRAW TWO CARDS FOR DEALER.  MOVE THEM FROM DEALER PACK TO DEALER-SELECTED-CARDS.  SHOW THE PLAYER THE FIRST CARD ONLY 
      dealerSelectedCards.deckOFcards.clear();  
      dealerSelectedCards.drawCardfromDeck(dealerPack);
      dealercardcount++;//CONTAINS HOW MANY CARDS HAVE BEEN DRAWN FOR THE DEALER 
      System.out.println("First set of Random cards from Dealer = " + dealerSelectedCards);  //DRAW TWO CARDS FOR DEALER, BUT DISPLAY ONLY ONE CARD
      dealerSelectedCards.drawCardfromDeck(dealerPack);
      dealercardcount++;
      
      aceAlreadyConsidered = false; // IF ACE CARD IS DRAWN, ITS VALUE CAN BE INTERPRETED AS EITHER 1 OR 11 
      for (int k=0; k < dealercardcount; k++)
      {
        dealercardranktotal_regular = dealercardranktotal_regular + dealerSelectedCards.getCardDetails(k).getCardRank();
        if (dealerSelectedCards.getCardDetails(k).getCardRank() == 1)   
        {
            aceAlreadyConsidered = true; 
        }
      }
      
      if (aceAlreadyConsidered == true)
       {
         dealercardranktotal_alternate = dealercardranktotal_regular + 10;
       }
       else
       {
         dealercardranktotal_alternate = dealercardranktotal_regular;
       }
      
      
      //System.out.println("Dealer cards value = " + dealercardranktotal_regular);  
      //****************************************************
      //FIRST ROUND BLACKJACK DECISION MAKING 
      //****************************************************
      winnerFound = false; 
      if(dealercardranktotal_regular==21 || dealercardranktotal_alternate==21)
      {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("DEALER has a Black Jack and has won!  " + "\n" + dealerSelectedCards);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        dealerscoreTally = dealerscoreTally + blackjackpoints; //2 POINTS for BlackJack and 1 POINT for regular win 
        dealerblackjackcount = dealerblackjackcount + 1; 
        System.out.println("DEALER Black Jack Cards = " + dealerSelectedCards);
        winnerFound=true;
      }
      else if (playercardranktotal_regular==21 || playercardranktotal_alternate==21)
      {
       System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
       System.out.println("You (PLAYER) have a Black Jack and have won!  " + "\n" + playerSelectedCards);
       System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
       playerscoreTally = playerscoreTally + blackjackpoints ; //2 POINTS for BlackJack and 1 POINT for regular win 
       playerblackjackcount = playerblackjackcount + 1; 
       winnerFound = true;
      }
      if(winnerFound == true ) //IF DEALER OR PLAYER HAS WON, GO FOR NEXT ROUND OF PLAY OR EXIT 
      {
        printScore(dealerscoreTally,playerscoreTally); // DISPLAY SCORES 
        System.out.println("TYPE IN \"1\" to PLAY AGAIN, or type in \"2\" TO LEAVE THE GAME");
        secondResponse =scan.nextInt();
        validResponseObtained = false;
        while (!validResponseObtained)
        {
        if (secondResponse == 1) {initResponse = secondResponse; firstround = true;validResponseObtained=true;}
        else if (secondResponse == 2) {gameover = true; validResponseObtained=true;} 
        else 
        {
          System.out.println("!!!INVALID INPUT - TYPE IN \"1\" to PLAY AGAIN, or type in \"2\" TO LEAVE THE GAME");
          secondResponse =scan.nextInt();
        }
       }
       
      }
      else
      {//NO BLACKJACK WINNER FOUND IN ROUND 1 - SO, ASK IF THE PLAYER WANTS TO HIT OR STAND OR EXIT 
        //ALSO MAKE A RECOMMENDATION TO PLAYER WHETHER PLAYER SHOULD CHOOSE HIT OR STAND TO IMPROVE CHANCES OF WINNING 
       System.out.println("Type in \"3\" if you want to HIT, or type in \"4\" if you want to STAND or \"2\" TO LEAVE THE GAME");
       secondResponse =scan.nextInt();
       validResponseObtained = false;
        while (!validResponseObtained)
        {
          if (secondResponse == 3 || secondResponse == 4 || secondResponse == 2)
          {
            validResponseObtained = true; 
          }
          else
          {
            System.out.println("!!!INVALID INPUT - Type in \"3\" if you want to HIT, or type in \"4\" if you want to STAND or \"2\" TO LEAVE THE GAME");
            secondResponse =scan.nextInt();
          }
        }
      }
    }  //END OF FIRST ROUND IF STATEMENT  
    
    if (secondResponse == 2) 
    {
      gameover = true;  //EXIT THE GAME 
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println("THANK YOU FOR PLAYING.  HERE IS THE FINAL SCORE: "); 
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      printScoreFinal(dealerscoreTally,playerscoreTally,dealerblackjackcount, playerblackjackcount); // DISPLAY SCORES 
    }//END OF IF STATEMENT FOR EXITING FROM THE GAME
    
    if(secondResponse==3) //IF THE PLAYER DECIDES TO "HIT" 
      {
        firstround = false; 
        hitInProgress = true; 
        
    
        while (hitInProgress) 
        {
          //DRAW THE NEXT CARD FOR PLAYER 
          playerSelectedCards.drawCardfromDeck(playerPack);
          playercardcount++;
          System.out.println("Your cards now are: " + playerSelectedCards);
          
          aceAlreadyConsidered = false; // IF ACE CARD IS DRAWN, ITS VALUE CAN BE INTERPRETED AS EITHER 1 OR 11
          playercardranktotal_regular =  0; 
          for (int k=0; k < playercardcount; k++)
          {
            playercardranktotal_regular = playercardranktotal_regular + playerSelectedCards.getCardDetails(k).getCardRank();
            if (playerSelectedCards.getCardDetails(k).getCardRank() == 1)   
            {
              aceAlreadyConsidered = true; 
            }
          }
          if (aceAlreadyConsidered == true)
          {
            playercardranktotal_alternate = playercardranktotal_regular + 10;
            System.out.println("Your cards have two values = " + playercardranktotal_regular + " OR " + playercardranktotal_alternate);
          }
          else
          {
            playercardranktotal_alternate = playercardranktotal_regular;
            System.out.println("Your cards value = " + playercardranktotal_regular);
          }
          // IF PLAYER WINS BY GETTING TO 21 
          if (playercardranktotal_regular==21 || playercardranktotal_alternate==21)
          {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("You (PLAYER) have won!  " + "\n" + playerSelectedCards);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            playerscoreTally = playerscoreTally + regularwinpoints ; //2 POINTS for BlackJack and 1 POINT for regular win 
            printScore(dealerscoreTally,playerscoreTally); // DISPLAY SCORES 
            winnerFound = true;
            hitInProgress = false;
            System.out.println("Type in \"1\" if you want to PLAY AGAIN, or type in \"2\" TO LEAVE THE GAME");
            initResponse =scan.nextInt();
            validResponseObtained = false;
            while (!validResponseObtained)
            {
              if (initResponse == 1 || initResponse == 2)
              {
                validResponseObtained = true; 
              }
              else
              {
                System.out.println("!!!INVALID INPUT - Type in \"1\" if you want to PLAY AGAIN, or type in \"2\" TO LEAVE THE GAME");
                initResponse = scan.nextInt();
              }
            }
            
            if (initResponse == 2) 
            {
              gameover = true; 
              System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
              System.out.println("THANK YOU FOR PLAYING.  HERE IS THE FINAL SCORE: "); 
              System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
              //printScore(dealerscoreTally,playerscoreTally); // DISPLAY SCORES 
              printScoreFinal(dealerscoreTally,playerscoreTally,dealerblackjackcount, playerblackjackcount); // DISPLAY SCORES 
            } //EXIT THE GAME 
            if (initResponse == 1) {firstround = true; } // IN THE NEXT ITERATION OF WHILE LOOP, IT WILL BE FIRST ROUND
          }
          
          // IF PLAYER GETS BUSTED BY GOING BEYOND 21 
           else if (playercardranktotal_regular > 21 && playercardranktotal_alternate > 21)
          {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("You (PLAYER) are BUSTED.  DEALER has won!  " + "\n" + playerSelectedCards);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            dealerscoreTally = dealerscoreTally + regularwinpoints ; //2 POINTS for BlackJack and 1 POINT for regular win 
            printScore(dealerscoreTally,playerscoreTally); // DISPLAY SCORES 
            winnerFound = true;
            hitInProgress = false;
            System.out.println("Type in \"1\" if you want to PLAY AGAIN, or type in \"2\" TO LEAVE THE GAME");
            initResponse =scan.nextInt();
            validResponseObtained = false;
            while (!validResponseObtained)
            {
              if (initResponse == 1 || initResponse == 2)
              {
                validResponseObtained = true; 
              }
              else
              {
                System.out.println("!!!INVALID INPUT - Type in \"1\" if you want to PLAY AGAIN, or type in \"2\" TO LEAVE THE GAME");
                initResponse = scan.nextInt();
              }
            }
            
            if (initResponse == 2) 
            {
              gameover = true; 
              System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
              System.out.println("THANK YOU FOR PLAYING.  HERE IS THE FINAL SCORE: "); 
              System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
              //printScore(dealerscoreTally,playerscoreTally); // DISPLAY SCORES 
              printScoreFinal(dealerscoreTally,playerscoreTally,dealerblackjackcount, playerblackjackcount); // DISPLAY SCORES 
            } //EXIT THE GAME 
            if (initResponse == 1) {firstround = true; } // IN THE NEXT ITERATION OF WHILE LOOP, IT WILL BE FIRST ROUND
          }
          else
          {
            System.out.println("Type in \"3\" if you want to HIT, or type in \"4\" if you want to STAND or \"2\" TO LEAVE THE GAME");
            secondResponse =scan.nextInt();
            validResponseObtained = false;
            while (!validResponseObtained)
            {
              if (secondResponse == 3 || secondResponse == 4 || secondResponse == 2)
              {
                validResponseObtained = true; 
              }
              else
              {
                System.out.println("!!!INVALID INPUT - Type in \"3\" if you want to HIT, or type in \"4\" if you want to STAND or \"2\" TO LEAVE THE GAME");
                secondResponse =scan.nextInt();
              }
            }
            
            if (secondResponse == 2) 
            { 
              gameover = true; 
              hitInProgress = false;
              System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
              System.out.println("THANK YOU FOR PLAYING.  HERE IS THE FINAL SCORE: "); 
              System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
              //printScore(dealerscoreTally,playerscoreTally); // DISPLAY SCORES 
              printScoreFinal(dealerscoreTally,playerscoreTally,dealerblackjackcount, playerblackjackcount); // DISPLAY SCORES 
            } //EXIT THE GAME 
            if (secondResponse == 4) {hitInProgress = false;}
            if (secondResponse == 3 || secondResponse == 4) {firstround = false; } 
          }
        }// END OF WHILE STATEMENT FOR HIT PROCESS 
       }//END OF PLAYER HIT PROCESS IF STATEMENT 
       
       if(secondResponse==4) //IF THE PLAYER DECIDES TO "STAND"
       {
         
        firstround = false; 
        standInProgress = true; 
        if (playercardranktotal_alternate > 21) 
        {
          playercardranktotal_final = playercardranktotal_regular;
        }
        else
        {
          playercardranktotal_final = playercardranktotal_alternate;
        }
        
        winnerFound = false; 
        
        while (standInProgress) 
        {
          if (
              (dealercardranktotal_regular > 16 && dealercardranktotal_regular < 21 && 
                    (dealercardranktotal_regular >= playercardranktotal_final)
               )
              || (dealercardranktotal_alternate > 16 && dealercardranktotal_alternate < 21 && 
                    (dealercardranktotal_alternate >= playercardranktotal_final)
                  )
               )
          {
            winnerFound = true;
            System.out.println("DEALER cards are: " + dealerSelectedCards);
          }
          else
          {
            //DRAW THE NEXT CARD FOR DEALER  
            dealerSelectedCards.drawCardfromDeck(dealerPack);
            dealercardcount++;
            System.out.println("DEALER cards now are: " + dealerSelectedCards);
            
            aceAlreadyConsidered = false; // IF ACE CARD IS DRAWN, ITS VALUE CAN BE INTERPRETED AS EITHER 1 OR 11
            dealercardranktotal_regular =  0; 
            for (int k=0; k < dealercardcount; k++)
            {
              dealercardranktotal_regular = dealercardranktotal_regular + dealerSelectedCards.getCardDetails(k).getCardRank();
              if (dealerSelectedCards.getCardDetails(k).getCardRank() == 1)   
              {
                aceAlreadyConsidered = true; 
              }
            }
            if (aceAlreadyConsidered == true)
            {
              dealercardranktotal_alternate = dealercardranktotal_regular + 10;
              System.out.println("DEALER cards have two values = " + dealercardranktotal_regular + " OR " + dealercardranktotal_alternate);
            }
            else
            {
              dealercardranktotal_alternate = dealercardranktotal_regular;
              System.out.println("DEALER cards value = " + dealercardranktotal_regular);
            }
          }
          // IF DEALER WINS BY GETTING TO 21 OR (GETTING MORE THAN 16 AND GRATER THAN OR EQUAL TO PLAYER CARDS RANK TOTAL) 
          if (
              (dealercardranktotal_regular==21 || dealercardranktotal_alternate==21) 
              || (dealercardranktotal_regular > 16 && dealercardranktotal_regular < 21 && 
                    (dealercardranktotal_regular >= playercardranktotal_final))
              || (dealercardranktotal_alternate > 16 && dealercardranktotal_alternate < 21 && 
                    (dealercardranktotal_alternate >= playercardranktotal_final))
             )
            
          {
            if (dealercardranktotal_alternate > 16 && dealercardranktotal_alternate < 21)
            {
              dealercardranktotal_Max = Math.max(dealercardranktotal_regular,dealercardranktotal_alternate); 
            }
            else
            {
              dealercardranktotal_Max = dealercardranktotal_regular;
              
            } 
            if (dealercardranktotal_Max == playercardranktotal_final)
            {
              System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
              System.out.println("IT IS A TIE OR A PUSH! - SAME CARD VALUES!  " + "\n" + playerSelectedCards);
              System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
              playerscoreTally = playerscoreTally + regularwinpoints ; //2 POINTS for BlackJack and 1 POINT for regular win 
            }
            else
            {
             System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
             System.out.println("DEALER has won!  " + "\n" + dealerSelectedCards);
             System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
            dealerscoreTally = dealerscoreTally + regularwinpoints ; //2 POINTS for BlackJack and 1 POINT for regular win 
            printScore(dealerscoreTally,playerscoreTally); // DISPLAY SCORES 
            winnerFound = true;
            standInProgress = false;
          }
          else if (dealercardranktotal_regular > 21 && dealercardranktotal_alternate > 21)
          {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("You (PLAYER) have won!  " + "\n" + playerSelectedCards);
            System.out.println("DEALER has lost!  " + "\n" + dealerSelectedCards);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            playerscoreTally = playerscoreTally + regularwinpoints ; //2 POINTS for BlackJack and 1 POINT for regular win 
            printScore(dealerscoreTally,playerscoreTally); // DISPLAY SCORES 
            winnerFound = true;
            standInProgress = false;
          }
          if (winnerFound == true)
          {
            System.out.println("Type in \"1\" if you want to PLAY AGAIN, or type in \"2\" TO LEAVE THE GAME");
            initResponse =scan.nextInt();
            validResponseObtained = false;
            while (!validResponseObtained)
            {
              if (initResponse == 1 || initResponse == 2)
              {
                validResponseObtained = true; 
              }
              else
              {
                System.out.println("!!!INVALID INPUT - Type in \"1\" if you want to PLAY AGAIN, or type in \"2\" TO LEAVE THE GAME");
                initResponse = scan.nextInt();
              }
            }
            
            if (initResponse == 2) 
            {
              gameover = true; 
              System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
              System.out.println("THANK YOU FOR PLAYING.  HERE IS THE FINAL SCORE: "); 
              System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
              printScoreFinal(dealerscoreTally,playerscoreTally,dealerblackjackcount,playerblackjackcount); // DISPLAY SCORES 
            } //EXIT THE GAME 
            if (initResponse == 1) {firstround = true; } // IN THE NEXT ITERATION OF WHILE LOOP, IT WILL BE FIRST ROUND
          }
        }// END OF WHILE STATEMENT FOR ***STAND*** PROCESS 
      }//END OF PLAYER ***STAND*** PROCESS IF STATEMENT 
    }//END OF WHILE LOOP FOR GAME 
  }//END OF MAIN METHOD 
}//END OF CLASS BODY 
        
       
       
   
  
      
     
    
    //advait was here....TODAY...
  
 

    
    