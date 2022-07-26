import java.util.Scanner;
import java.util.Random;

public class Casino_Final
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
  public static void main (String[] args)
  {
    System.out.println("The Casual+Casino Card Sim. V1.2.1 Created by AK Studios, in collaboration between AR Productions and KC Design LLC.");
    System.out.println("It's Friday night. You've just gotten your bachelor's degree, and you just got your acceptance letter into Grad School at the University of Chicago. It's time for you to take a break and party, even though your friends are still working on trying to get grades up last minute and throw in some extrracurriculars. You decide that, now that you're 21, you wanna go and discover America's most infamous pasttime. You arrive at the Casino at exactly 5 o'clock, and walk into the entrance.");
    System.out.println("You make your way to an empty blackjack table to start. You ask the dealer for some chips, and he asks you how much money you need converted.");
    Scanner scan = new Scanner(System.in);
    // Make sure wallet amount is a variable
    while (!scan.hasNextDouble()) {
      System.out.println("Please enter your money amount as a positive rational number in the form of $X.XX, omitting the dollar sign and all alphabets.");
      scan.next();
    }
    int cardNum;
    int lastNum = 0;
    // Initialize them variables
    double wallet = scan.nextDouble();
    if (wallet > 1000000000)
    { System.out.println("We all know you don't have over a billion dollars, but you know what? Fine."); }
    long start;
    String rouletteColor =  "Error";
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
    
    boolean canPlay = true;
    int deckLength = 0;
    int turnCount = 2;
    int slap = 6;
    String winnerNameSlapJack = "";
    card tempCard;
    player human1 = new player();
    human1.setPlayability(true);
    player house = new player();
    house.setPlayability(true);
    discardPile discard = new discardPile();
    deck decky = new deck();
    
    decky.shuffle();
    
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
    double walletOriginal = wallet;
    Random rand = new Random();
    int timesWatched = 40;
    double winnings = 0.00;
    double totalWinnings = 0.00;
    double wager = 0.00;
    double winMultiplier = 1.00;
    double debt = 0.00;
    double loanMoney = 0.00;
    int num1, num2, num3 = 0;
    int slotOrNot = 0;
    int inCasino = 10;
    int elapsedTime = 0;
    boolean hasHotelRoom = false;
    String[] horses = {"keno", "Sheriff", "Deputy", "Lucky", "Pecos", "Colt", "Horseshoe", "Barley", "Bronco", "Blazer", "Wilbur", "Buck", "Franklin", "Kentucky", "Trigger", "Blacksmith", "Buckeye", "Bolt", "Washington", "Connecticut", "Ironclad", "King", "Jockey", "Clydesdale", "Wrangler", "Jupiter", "Tennessee", "Texas", "Diesel", "Tank", "Colorado", "Ridgeline", "Quarterback", "Shoelace", "Colonel", "Lincoln", "Steeltoe", "Officer", "Rushmore", "Marigold", "Sapphire", "Pearl", "Hayley", "Ellie", "Peanut", "River", "Marmalade", "Nutmeg", "Piper", "Gypsy", "Butterscotch", "Clover", "Sadie", "Sassy", "Bailey", "Skydancer", "Daisy", "Strawberry", "Kennedy", "Morgan", "Nightmare", "Magnolia", "Mustang", "Sally", "Hollyhock", "Aster", "Molly", "Willow", "Meadow", "Ladybird", "Carolina", "Wisteria", "Cherish", "Rosette", "Midsummer", "Amethyst", "Eleanor", "Juliet", "Jasmine", "Velvet", "Big Mama", "Temperance"};
    // Place variables. Games are in the range 100-199. 
    final int lobby = 100;
    final int slots = 110;
    final int blackJack = 120;
    final int slapjack = 130;
    final int baccarat = 140; 
    final int keno = 150;
    final int superSlots = 160;
    final int war = 170;
    final int roulette = 180;
    final int horseRacing = 190;
    // Place variables. Services and Utilities are in the range 200-299.
    final int ATM = 200;
    final int restaurant = 210;
    final int rules = 220;
    final int bar21Plus = 230;
    final int hotelCheckIn = 240;
    final int hotelRoom = 250;
    final int cashCounterWorkStation = 260;
    final int pool = 270;
    final int gym = 280;
    final int giftShop = 290;
    boolean drunk = false;
    // Leaving the Casino is in the 300-350 range.
    final int outsideCasino = 300;
    final int uber = 310;
    final int bus = 320;
    final int callFriend = 330;
    final int plane = 340;
    final int jail = 350;
    
    double houseProfits = 0.00;
    int slotRolls = 0;
    final int slotsCost = 10;
    int place = 100;
    if ((wallet-slotsCost) < 0)
    {
      place = ATM;
      System.out.println("You currently do not have enough money to play anything. The minimum cost is $10. You approach the nearest ATM.");
    }
    else
    { //********************************************************************** CHANGE WHEN NEW GAMES ARE ADDED **********************************************************************
      System.out.println("Type in a place's corresponding number in order to go there! \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
      place = scan.nextInt();
      while ((place %10 != 0))
      {
        System.out.println("Oops! Try again. \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
        place = scan.nextInt();
      }
      //********************************************************************** CHANGE WHEN NEW GAMES ARE ADDED **********************************************************************
    }
    if (place == outsideCasino)
    {
      inCasino = outsideCasino;
    }
    while (inCasino == 10)
    {
      if (place == lobby)
      {
        System.out.println("You stand at the outskirts of the Casino. You make out an occassional cheer over the excited babble of the other gamblers. You admire the prowess of the casino, the way it has maintained a position of infamy for decades. You watch first-hand as people (usually) willingly give up their money. You realize how casinos the modern Gold Rush, except this time, the rich men behind the curtains control everything, leaving behind just enough success stories to keep people coming back while also fattening their pockets. You eventually decide, however, that it's time to get back to the big boy videogame you wanted to take part in. You turn around, but then you're floored by the spectacular sight of Vegas' skyline stretching out for miles. In the distance, reaching above the scattered houses at the edge of the valley, you can make out the Sierra Nevada's mountain peaks embrace the sky. Eventually, you remember that there's money to be made downstairs.");
        System.out.print("Type in a place's corresponding number in order to go there! \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
        place = scan.nextInt();
        while ((place % 10 != 0))
        {
          System.out.println("Oops. Try again. \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
          place = scan.nextInt();
        }
      }
      while (place == slots)
      { //********************************************************************** SLOT MACHINE CODE **********************************************************************
        if ((wallet - slotsCost) < 0)
        {
          System.out.println("Whoops! You don't have enough money to play slots. You are now walking to an ATM.");
          place = ATM;
        }
        else
        {
          System.out.println("You are currently at a slot machine, and it costs $10 to play. You currently have $" + wallet + "0 and have $" + debt +"0 debt. Do you want to play? Type 1 if yes and 0 if no.");
          slotOrNot = scan.nextInt();
          while (slotOrNot == 1)
          {
            wallet-= slotsCost;
            houseProfits += slotsCost;
            System.out.println("You currently have $" + wallet + " in your wallet.");
            System.out.println("This slot machine has a special wager feature. The bigger the wager, the higher your winnings multiplier! Enter wager now! (Every dollar adds 10% to your multiplier.)");
            wager = scan.nextDouble();
            while ((wallet-wager) < 0)
            {
              System.out.println("Whoops! You don't have enough money to wager this much. Try again.");
              wager = scan.nextDouble();
            }
            winMultiplier = ((wager/10)+1);
            wallet-= wager;
            houseProfits += wager;
            System.out.println("Pulling lever and spinning slot machine . . .");
            System.out.println("Watching numbers roll . . .");
            num1 = rand.nextInt(10);
            num2 = rand.nextInt(10);
            num3 = rand.nextInt(10);
            System.out.println("The slot machine rolled a " + num1 + num2 + num3 + ".");
            if (num1 == num2 || num2 == num3 || num1 == num3)
            {
              if (num1 == 9 && num2 == 9 && num3 == 9)
              {
                winnings = (1000000*winMultiplier);
                System.out.println("JACKPOT!!! YOU HAVE WON $1,000,000 (BEFORE the wager has been added)");
                System.out.println("YOU HAVE WON $" + winnings*winMultiplier + " !!!");
              }
              else
              {
                if (((num1 == num2) && (num2 == num3)) && (num1 != 9))
                {
                  winnings = (((1000)*winMultiplier));
                  System.out.println("Triple numbers! You won $" + winnings);
                }
                if (num1 == num2)
                {
                  winnings = (((100)/4)*winMultiplier);
                  System.out.println("Two of a kind! You won $" + winnings);
                }
                if (num2 == num3)
                {
                  winnings = (((100)/4)*winMultiplier);
                  System.out.println("Two of a kind! You won $" + winnings);
                }
                if (num1 == num3)
                {
                  winnings = (((100)/4)*winMultiplier);
                  System.out.println("Double sandwich! You won $" + winnings);
                }
              }
            }
            else
            {
              if (num1 > 5)
              {
                winnings = ((double) ((double)(num1*100 + num2*10 + num3)/100)*winMultiplier);
                System.out.println("You won $" + winnings);
              }
              else
              {
                winnings = (4.99*winMultiplier);
                System.out.println("You won $" + winnings);
              }
            }
            wallet += winnings;
            houseProfits -= winnings;
            totalWinnings += winnings;
            slotRolls++;
            System.out.println("To play slots again, type in 1. To go to an ATM or leave the Casino, type in 0.");
            winnings = 0;
            slotOrNot = scan.nextInt();
          }
          if (slotOrNot == 0)
          { //********************************************************************** CHANGE WHEN NEW GAMES ARE ADDED **********************************************************************
            System.out.println("You don't want to play slots? Ok then. Would you like to visit any of the following? \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
            place = scan.nextInt();
            while ((place % 10 != 0))
            {
              System.out.println("Oops! Try again. \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
              place = scan.nextInt();
            }
          } //********************************************************************** CHANGE WHEN NEW GAMES ARE ADDED **********************************************************************
        }
      }
      while (place == blackJack)
      {
        System.out.println("You are currently at a blackjack table. Type 1 to start a game or 2 to leave.");
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
            System.out.println("Oops. Try again. Type in 1 to start or 2 to leave.");
            initResponse =(int) scan.nextInt();
          }
        }
        
        if (initResponse == 2)
        {
          System.out.println("You walk away from the black jack table.");
          System.out.println("Type in a place's corresponding number to go there! \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
          place = scan.nextInt();
          while ((place % 10 != 0))
          {
            System.out.println("Oops! Try again. \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
            place = scan.nextInt();
          }
        }
        while (!gameover) // ALLOW THE PLAYER TO PLAY MULTIPLE ROUNDS 
        {
          if(initResponse == 1 && firstround == true) // FIRST ROUND OF BLACKJACK 
          {
            System.out.println("How much do you want to wager? You currently have $" + wallet);
            wager = scan.nextDouble();
            while (((wallet-wager) < 0) || (wager < 20))
            {
              System.out.println("Whoops! You're either betting more than you have or less than $20. Try again.");
              wager = scan.nextDouble();
            }
            playerPack.deckOFcards.clear();  
            playerPack.populatedeck();  
            dealerPack.deckOFcards.clear();   
            dealerPack.populatedeck(); 
            playercardcount = 0;
            dealercardcount = 0; 
            playercardranktotal_regular = 0;
            playercardranktotal_alternate = 0;
            dealercardranktotal_regular = 0;
            dealercardranktotal_alternate = 0;
            
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
              System.out.println("DEALER has exactly 21 and has won!  " + "\n" + dealerSelectedCards);
              System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
              dealerscoreTally = dealerscoreTally + blackjackpoints; //2 POINTS for BlackJack and 1 POINT for regular win 
              dealerblackjackcount = dealerblackjackcount + 1; 
              System.out.println("DEALER Black Jack Cards = " + dealerSelectedCards);
              winnerFound=true;
              wallet -= wager*1;
              houseProfits += wager*1;
              totalWinnings -= wager*1;
            }
            else if (playercardranktotal_regular==21 || playercardranktotal_alternate==21)
            {
              System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
              System.out.println("You (PLAYER) have exactly 21 and have won!  " + "\n" + playerSelectedCards);
              System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
              playerscoreTally = playerscoreTally + blackjackpoints ; //2 POINTS for BlackJack and 1 POINT for regular win 
              playerblackjackcount = playerblackjackcount + 1; 
              winnerFound = true;
              wallet += wager*2;
              houseProfits -= wager*2;
              totalWinnings += wager*2;
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
          }
          
          if (secondResponse == 2) 
          {
            gameover = true;  //EXIT THE GAME 
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("A final tally of how many wins and losses occurred during your game of black jack.: "); 
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            printScoreFinal(dealerscoreTally,playerscoreTally,dealerblackjackcount, playerblackjackcount); // DISPLAY SCORES 
            System.out.println("You walk away from the black jack table.");
            System.out.println("Type in a place's corresponding number to go there! \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
            place = scan.nextInt();
            while ((place % 10 != 0))
            {
              System.out.println("Oops! Try again. \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
              place = scan.nextInt();
            }
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
                  System.out.println("A final tally of your score: "); 
                  System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                  //printScore(dealerscoreTally,playerscoreTally); // DISPLAY SCORES 
                  printScoreFinal(dealerscoreTally,playerscoreTally,dealerblackjackcount, playerblackjackcount); // DISPLAY SCORES 
                  System.out.println("You walk away from the black jack table.");
                  System.out.println("Type in a place's corresponding number to go there! \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
                  place = scan.nextInt();
                  while ((place % 10 != 0))
                  {
                    System.out.println("Oops! Try again. \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
                    place = scan.nextInt();
                  }
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
                wallet -= wager*1;
                houseProfits += wager*1;
                totalWinnings -= wager*1;
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
                  System.out.println("A final tally of your current black jack session: "); 
                  System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                  //printScore(dealerscoreTally,playerscoreTally); // DISPLAY SCORES 
                  printScoreFinal(dealerscoreTally,playerscoreTally,dealerblackjackcount, playerblackjackcount); // DISPLAY SCORES
                  System.out.println("You walk away from the black jack table.");
                  System.out.println("Type in a place's corresponding number to go there! \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
                  place = scan.nextInt();
                  while ((place % 10 != 0))
                  {
                    System.out.println("Oops! Try again. \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
                    place = scan.nextInt();
                  }
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
                  System.out.println("A final tallly of your score: "); 
                  System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                  //printScore(dealerscoreTally,playerscoreTally); // DISPLAY SCORES 
                  printScoreFinal(dealerscoreTally,playerscoreTally,dealerblackjackcount, playerblackjackcount); // DISPLAY SCORES 
                  System.out.println("You walk away from the black jack table.");
                  System.out.println("Type in a place's corresponding number to go there! \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
                  place = scan.nextInt();
                  while ((place % 10 != 0))
                  {
                    System.out.println("Oops! Try again. \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
                    place = scan.nextInt();
                  }
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
                  wallet += wager*1;
                  houseProfits -= wager*1;
                  totalWinnings += wager*1;
                }
                else
                {
                  System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                  System.out.println("DEALER has won!  " + "\n" + dealerSelectedCards);
                  System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                  wallet -= wager*1;
                  houseProfits += wager*1;
                  totalWinnings -= wager*1;
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
                wallet += wager*1;
                houseProfits -= wager*1;
                totalWinnings += wager*1;
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
                  System.out.println("A final tally of your scores: "); 
                  System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                  printScoreFinal(dealerscoreTally,playerscoreTally,dealerblackjackcount,playerblackjackcount); // DISPLAY SCORES 
                  System.out.println("You walk away from the black jack table.");
                  System.out.println("Type in a place's corresponding number to go there! \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
                  place = scan.nextInt();
                  while ((place % 10 != 0))
                  {
                    System.out.println("Oops! Try again. \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
                    place = scan.nextInt();
                  }
                } //EXIT THE GAME 
                if (initResponse == 1) {firstround = true; } // IN THE NEXT ITERATION OF WHILE LOOP, IT WILL BE FIRST ROUND
              }
            }// END OF WHILE STATEMENT FOR ***STAND*** PROCESS 
          }
        }
      }
      
      if (place == baccarat)
      {
        System.out.println("You visit a baccarat table.");
        System.out.println("Oops. This table is not currently available. In a rage, you go to customer service, but all that they tell you is that there is a dealer shortage.");
        System.out.print("Type in a place's corresponding number in order to go there! \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
        place = scan.nextInt();
        while ((place % 10 != 0))
        {
          System.out.println("Oops. Try again. \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
          place = scan.nextInt();
        }
      }
      
      if (place == superSlots)
      {
        System.out.println("You visit a SUPER SLOT machine.");
        System.out.println("Oops. This table is not currently available. In a rage, you go to customer service, but all that they tell you is that there is a dealer shortage.");
        System.out.print("Type in a place's corresponding number in order to go there! \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
        place = scan.nextInt();
        while ((place % 10 != 0))
        {
          System.out.println("Oops. Try again. \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
          place = scan.nextInt();
        }
      }
      
      if (place == keno)
      {
        System.out.println("You visit a keno table.");
        System.out.println("Oops. This table is not currently available. In a rage, you go to customer service, but all that they tell you is that there is a dealer shortage.");
        System.out.print("Type in a place's corresponding number in order to go there! \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
        place = scan.nextInt();
        while ((place % 10 != 0))
        {
          System.out.println("Oops. Try again. \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
          place = scan.nextInt();
        }
      }
      
      if (place == war)
      {
        System.out.println("You visit a war table.");
        System.out.println("Oops. This table is not currently available. In a rage, you go to customer service, but all that they tell you is that there is a dealer shortage.");
        System.out.print("Type in a place's corresponding number in order to go there! \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
        place = scan.nextInt();
        while ((place % 10 != 0))
        {
          System.out.println("Oops. Try again. \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
          place = scan.nextInt();
        }
      }
      
      while(place == slapjack)
      {
        cardNum = 0;
        System.out.println("You visit a Casino-style slapjack counter. These are special 1v1 dining tables set up for the variant.");
        System.out.println("You are currently at a blackjack table. Type 1 to start a game or 2 to leave.");
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
            System.out.println("Oops. Try again. Type in 1 to start or 2 to leave.");
            initResponse =(int) scan.nextInt();
          }
        }
        
        if (initResponse == 2)
        {
          System.out.println("You walk away from the slapjack table.");
          System.out.println("Type in a place's corresponding number to go there! \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
          place = scan.nextInt();
          while ((place % 10 != 0))
          {
            System.out.println("Oops! Try again. \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
            place = scan.nextInt();
          }
        }
        while (initResponse == 1)
        {
          deck decky2 = new deck();
          decky2.shuffle();
          decky2.dealAllCards(house);
          System.out.println("You are now ready to bet. How much is the question.");
          wager = scan.nextDouble();
          while ((wallet-wager) < 0)
          {
            System.out.println("Whoops! You don't have enough money to wager this much. Try again.");
            wager = scan.nextDouble();
          }
          System.out.println("You are now ready. You tell this to the dealer as well, and he starts dealing cards.");
          boolean currentlyPlaying = true;
          while (currentlyPlaying)
          {
            System.out.println("Top Card: " + house.playCard(52-cardNum));
            System.out.println("To slap, press 1. Else press 0. ");
            start = System.currentTimeMillis();
            int whatNow = scan.nextInt();
            if((whatNow == 1) && (house.getCard(52-cardNum) == 11))
            {
              System.out.println("You slapped the Jack! You win!");
              wallet += wager*1;
              houseProfits -= wager*1;
              totalWinnings += wager*1;
              currentlyPlaying = false;
            }
            if((whatNow == 1) && (house.getCard(52-cardNum) != 11))
            {
              System.out.println("That wasn't a Jack! You lose");
              wallet -= wager*1;
                  houseProfits += wager*1;
                  totalWinnings -= wager*1;
                  currentlyPlaying = false;
            }
            if((whatNow != 1) && (house.getCard(52-cardNum) == 11))
            {
              System.out.println("You you didn't slap the Jack! You lose!");
              wallet -= wager*1;
                  houseProfits += wager*1;
                  totalWinnings -= wager*1;
                  currentlyPlaying = false;
            }
            if((whatNow != 1) && (house.getCard(52-cardNum) != 11))
            {cardNum++;}
          }
          System.out.println("Wanna play again? If yes, type in 1. Else, type in 2.");
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
              System.out.println("Oops. Try again. Type in 1 to start or 2 to leave.");
              initResponse =(int) scan.nextInt();
            }
          }
          if (initResponse == 2)
          {
            System.out.println("You walk away from the slapjack table.");
            System.out.println("Type in a place's corresponding number to go there! \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
            place = scan.nextInt();
            while ((place % 10 != 0))
            {
              System.out.println("Oops! Try again. \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
              place = scan.nextInt();
            }
          }
        }
      }
      
      
      
      
      
      
      
      if (place == roulette)
      {
        System.out.println("You decide to go visit the roulette table next.");
        if (wallet < 20)
        {
          System.out.println("Oops. You don't have enough money to play. You are now walking to an ATM so that you can get more than $20.");
          place = ATM;
        }
        else
        {
          System.out.println("Do you know what all the types of bets in roulette mean? If so, type in 1. Otherwise, type in 0.");
          int knowsRules = scan.nextInt();
          while (knowsRules!= 1 && knowsRules!=0)
          {
            System.out.println("Try again. Do you know the bets (1) or not (0)?");
            knowsRules = scan.nextInt();
          }
          if (knowsRules == 0)
          {
            System.out.print("You decide to go ask for a rule book so that you can make informed decisions when you play.");
            place = rules;
          }
          else
          {
            boolean wannaRoulette = true;
            while (wannaRoulette)
            {
              System.out.println("First, of course, you decide how much you want to wager.");
              wager = scan.nextDouble();
              while ((wallet-wager) < 0)
              {
                System.out.println("Whoops! You don't have enough money to wager this much. Try again.");
                wager = scan.nextDouble();
              }
              System.out.println("Ok. Now you have to decide how you are going to play this. You have 16 betting options for European Roulette. What do you choose?");
              System.out.println("1. Evens \n 2. Odds \n 3. High \n 4. Low \n 5. Red \n 6. Black \n 7. 1st Dozen \n 8. 2nd Dozen \n 9. 3rd Dozen \n 10. 1st Column \n 11. 2nd Column \n 12. 3rd Column \n 13. Six Line \n 14. Street \n 15. Split \n 16. Straight-Up");
              int betType = scan.nextInt();
              while ((betType < 1) || (betType > 16))
              {
                System.out.println("Oops. Try again. Input the number corresponding to the bet you want.");
                betType = scan.nextInt();
              }
              int rouletteNum = (int)(Math.random()*37);
              switch (rouletteNum) {
                case 0:
                  rouletteColor = "Green";
                  break;
                case 1:
                  rouletteColor = "Red";
                  break;
                case 2:
                  rouletteColor = "Black";
                  break;
                case 3:
                  rouletteColor = "Red";
                  break;
                case 4:
                  rouletteColor = "Black";
                  break;
                case 5:
                  rouletteColor = "Red";
                  break;
                case 6:
                  rouletteColor = "Black";
                  break;
                case 7:
                  rouletteColor = "Red";
                  break;
                case 8:
                  rouletteColor = "Black";
                  break;
                case 9:
                  rouletteColor = "Red";
                  break;
                case 10:
                  rouletteColor = "Black";
                  break;
                case 11:
                  rouletteColor = "Black";
                  break;
                case 12:
                  rouletteColor = "Red";
                  break;
                case 13:
                  rouletteColor = "Black";
                  break;
                case 14:
                  rouletteColor = "Red";
                  break;
                case 15:
                  rouletteColor = "Black";
                  break;
                case 16:
                  rouletteColor = "Red";
                  break;
                case 17:
                  rouletteColor = "Black";
                  break;
                case 18:
                  rouletteColor = "Red";
                  break;
                case 19:
                  rouletteColor = "Red";
                  break;
                case 20:
                  rouletteColor = "Black";
                  break;
                case 21:
                  rouletteColor = "Red";
                  break;
                case 22:
                  rouletteColor = "Black";
                  break;
                case 23:
                  rouletteColor = "Red";
                  break;
                case 24:
                  rouletteColor = "Black";
                  break;
                case 25:
                  rouletteColor = "Red";
                  break;
                case 26:
                  rouletteColor = "Black";
                  break;
                case 27:
                  rouletteColor = "Red";
                  break;
                case 28:
                  rouletteColor = "Black";
                  break;
                case 29:
                  rouletteColor = "Black";
                  break;
                case 30:
                  rouletteColor = "Red";
                  break;
                case 31:
                  rouletteColor = "Black";
                  break;
                case 32:
                  rouletteColor = "Red";
                  break;
                case 33:
                  rouletteColor = "Black";
                  break;
                case 34:
                  rouletteColor = "Red";
                  break;
                case 35:
                  rouletteColor = "Black";
                  break;
                case 36:
                  rouletteColor = "Red";
                  break;
              }
              switch (betType) {
                case 1:
                  if ((rouletteNum%2 == 0)  && (rouletteNum > 0))
                {
                  System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                  System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                  System.out.println("Congrats! You bet right!");
                  System.out.println("You've won $" + wager);
                  wallet += wager*1;
                  houseProfits -= wager*1;
                  totalWinnings += wager*1;
                  break;
                }
                  else
                  {
                    System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                    System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                    System.out.println("Oof. You bet on the wrong set of numbers.");
                    wallet -= wager*1;
                    houseProfits += wager*1;
                    totalWinnings -= wager*1;
                    break;
                  }
                case 2:
                  if (rouletteNum%2 == 1)
                {
                  System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                  System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                  System.out.println("Congrats! You bet right!");
                  System.out.println("You've won $" + wager);
                  wallet += wager*1;
                  houseProfits -= wager*1;
                  totalWinnings += wager*1;
                  break;
                }
                  else
                  {
                    System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                    System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                    System.out.println("Oof. You bet on the wrong set of numbers.");
                    wallet -= wager*1;
                    houseProfits += wager*1;
                    totalWinnings -= wager*1;
                    break;
                  }
                case 3:
                  if (rouletteNum >= 19)
                {
                  System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                  System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                  System.out.println("Congrats! You bet right!");
                  System.out.println("You've won $" + wager);
                  wallet += wager*1;
                  houseProfits -= wager*1;
                  totalWinnings += wager*1;
                  break;
                }
                  else
                  {
                    System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                    System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                    System.out.println("Oof. You bet on the wrong set of numbers.");
                    wallet -= wager*1;
                    houseProfits += wager*1;
                    totalWinnings -= wager*1;
                    break;
                  }
                case 4:
                  if ((rouletteNum < 19) && (rouletteNum > 0))
                {
                  System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                  System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                  System.out.println("Congrats! You bet right!");
                  System.out.println("You've won $" + wager);
                  wallet += wager*1;
                  houseProfits -= wager*1;
                  totalWinnings += wager*1;
                  break;
                }
                  else
                  {
                    System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                    System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                    System.out.println("Oof. You bet on the wrong set of numbers.");
                    wallet -= wager*1;
                    houseProfits += wager*1;
                    totalWinnings -= wager*1;
                    break;
                  }
                case 5:
                  if (rouletteColor.equals("Red"))
                {
                  System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                  System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                  System.out.println("Congrats! You bet right!");
                  System.out.println("You've won $" + wager);
                  wallet += wager*1;
                  houseProfits -= wager*1;
                  totalWinnings += wager*1;
                  break;
                }
                  else
                  {
                    System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                    System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                    System.out.println("Oof. You bet on the wrong set of numbers.");
                    wallet -= wager*1;
                    houseProfits += wager*1;
                    totalWinnings -= wager*1;
                    break;
                  }
                case 6:
                  if (rouletteColor.equals("Black"))
                {
                  System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                  System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                  System.out.println("Congrats! You bet right!");
                  System.out.println("You've won $" + wager);
                  wallet += wager*1;
                  houseProfits -= wager*1;
                  totalWinnings += wager*1;
                  break;
                }
                  else
                  {
                    System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                    System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                    System.out.println("Oof. You bet on the wrong set of numbers.");
                    wallet -= wager*1;
                    houseProfits += wager*1;
                    totalWinnings -= wager*1;
                    break;
                  }
                case 7:
                  if ((rouletteNum < 13) && (rouletteNum > 0))
                {
                  System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                  System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                  System.out.println("Congrats! You bet right!");
                  System.out.println("You've won $" + 2*wager);
                  wallet += wager*2;
                  houseProfits -= wager*2;
                  totalWinnings += wager*2;
                  break;
                }
                  else
                  {
                    System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                    System.out.println("Oof. You bet on the wrong set of numbers.");
                    wallet -= wager*1;
                    houseProfits += wager*1;
                    totalWinnings -= wager*1;
                    break;
                  }
                case 8:
                  if ((rouletteNum < 25) && (rouletteNum > 12))
                {
                  System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                  System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                  System.out.println("Congrats! You bet right!");
                  System.out.println("You've won $" + 2*wager);
                  wallet += wager*2;
                  houseProfits -= wager*2;
                  totalWinnings += wager*2;
                  break;
                }
                  else
                  {
                    System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                    System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                    System.out.println("Oof. You bet on the wrong set of numbers.");
                    wallet -= wager*1;
                    houseProfits += wager*1;
                    totalWinnings -= wager*1;
                    break;
                  }
                case 9:
                  if (rouletteNum > 24) 
                {
                  System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                  System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                  System.out.println("Congrats! You bet right!");
                  System.out.println("You've won $" + 2*wager);
                  wallet += wager*2;
                  houseProfits -= wager*2;
                  totalWinnings += wager*2;
                  break;
                }
                  else
                  {
                    System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                    System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                    System.out.println("Oof. You bet on the wrong set of numbers.");
                    wallet -= wager*1;
                    houseProfits += wager*1;
                    totalWinnings -= wager*1;
                    break;
                  }
                case 10:
                  if (rouletteNum % 3 == 1)
                {
                  System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                  System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                  System.out.println("Congrats! You bet right!");
                  System.out.println("You've won $" + 2*wager);
                  wallet += wager*2;
                  houseProfits -= wager*2;
                  totalWinnings += wager*2;
                  break;
                }
                  else
                  {
                    System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                    System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                    System.out.println("Oof. You bet on the wrong set of numbers.");
                    wallet -= wager*1;
                    houseProfits += wager*1;
                    totalWinnings -= wager*1;
                    break;
                  }
                case 11:
                  if (rouletteNum % 3 == 2)
                {
                  System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                  System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                  System.out.println("Congrats! You bet right!");
                  System.out.println("You've won $" + 2*wager);
                  wallet += wager*2;
                  houseProfits -= wager*2;
                  totalWinnings += wager*2;
                  break;
                }
                  else
                  {
                    System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                    System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                    System.out.println("Oof. You bet on the wrong set of numbers.");
                    wallet -= wager*1;
                    houseProfits += wager*1;
                    totalWinnings -= wager*1;
                    break;
                  }
                case 12:
                  if ((rouletteNum % 3 == 0) && (rouletteNum > 0))
                {
                  System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                  System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                  System.out.println("Congrats! You bet right!");
                  System.out.println("You've won $" + 2*wager);
                  wallet += wager*2;
                  houseProfits -= wager*2;
                  totalWinnings += wager*2;
                  break;
                }
                  else
                  {
                    System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                    System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                    System.out.println("Oof. You bet on the wrong set of numbers.");
                    wallet -= wager*1;
                    houseProfits += wager*1;
                    totalWinnings -= wager*1;
                    break;
                  }
                case 13:
                  System.out.println("What is the last number in your 6-line? (i.e. if your six-line is the first possible, you input 6. If its the next possible, you input 9, and so on.)");
                  lastNum = scan.nextInt();
                  while ((lastNum%3!=0) && (!(lastNum>5)) && (!(lastNum < 37)))
                  {
                    System.out.println("A six-line ends in a positive multiple of 3 that is <= 36. You would know this if you read the rules. Try again.");
                    lastNum = scan.nextInt();
                  }
                  if ((rouletteNum <= lastNum) && (rouletteNum > lastNum-6))
                  {
                    System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                    System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                    System.out.println("Congrats! You bet right!");
                    System.out.println("You've won $" + 5*wager);
                    wallet += wager*5;
                    houseProfits -= wager*5;
                    totalWinnings += wager*5;
                    break;
                  }
                  else
                  {
                    System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                    System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                    System.out.println("Oof. You bet on the wrong set of numbers.");
                    wallet -= wager*1;
                    houseProfits += wager*1;
                    totalWinnings -= wager*1;
                    break;
                  }
                case 14:
                  System.out.println("What is the last number in your street? (i.e. if your street is the first possible, you input 3. If its the next possible, you input 6, and so on.)");
                  lastNum = scan.nextInt();
                  while ((lastNum%3!=0) && (!(lastNum>2)) && (!(lastNum < 37)))
                  {
                    System.out.println("A street ends in a positive multiple of 3 that is <= 36. You would know this if you read the rules. Try again.");
                    lastNum = scan.nextInt();
                  }
                  if ((rouletteNum <= lastNum) && (rouletteNum > lastNum-3))
                  {
                    System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                    System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                    System.out.println("Congrats! You bet right!");
                    System.out.println("You've won $" + 11*wager);
                    wallet += wager*11;
                    houseProfits -= wager*11;
                    totalWinnings += wager*11;
                    break;
                  }
                  else
                  {
                    System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                    System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                    System.out.println("Oof. You bet on the wrong set of numbers.");
                    wallet -= wager*1;
                    houseProfits += wager*1;
                    totalWinnings -= wager*1;
                    break;
                  }
                case 15:
                  System.out.println("What is the last number in your split? (i.e. if your split is the first possible, you input 2 (winning numbers 1 and 2). If its the next possible, you input 3 (winning numbers 2 and 3), and so on.)");
                  lastNum = scan.nextInt();
                  while ((!(lastNum>1)) && (!(lastNum < 37)))
                  {
                    System.out.println("Try again. The last number must be positive, greater than 1, and less than 37.");
                    lastNum = scan.nextInt();
                  }
                  if ((rouletteNum <= lastNum) && (rouletteNum > lastNum-2))
                  {
                    System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                    System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                    System.out.println("Congrats! You bet right!");
                    System.out.println("You've won $" + 17*wager);
                    wallet += wager*17;
                    houseProfits -= wager*17;
                    totalWinnings += wager*17;
                    break;
                  }
                  else
                  {
                    System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                    System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                    System.out.println("Oof. You bet on the wrong set of numbers.");
                    wallet -= wager*1;
                    houseProfits += wager*1;
                    totalWinnings -= wager*1;
                    break;
                  }
                case 16:
                  System.out.println("What is the last number in your straight-up?");
                  lastNum = scan.nextInt();
                  while ((!(lastNum>-1)) && (!(lastNum < 37)))
                  {
                    System.out.println("Try again. The last number must be positive and less than 37.");
                    lastNum = scan.nextInt();
                  }
                  if ((rouletteNum == lastNum))
                  {
                    System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                    System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                    System.out.println("Congrats! You bet right, and HIT THE JACKPOT!!!");
                    System.out.println("YOU'VE WON $" + 35*wager);
                    wallet += wager*35;
                    houseProfits -= wager*35;
                    totalWinnings += wager*35;
                    break;
                  }
                  else
                  {
                    System.out.println("The rest of the players at the table say that they're ready. The dealer sends the little aluminum ball hopping and skipping as the wheel spins. Gradually, it slows down as the anticipation builds up.");
                    System.out.println("It landed on the " + rouletteColor + " " + rouletteNum);
                    System.out.println("Oof. You bet on the wrong number.");
                    wallet -= wager*1;
                    houseProfits += wager*1;
                    totalWinnings -= wager*1;
                    break;
                  }
              }
            }
            System.out.println("You up for another round? Type in \"Y\" for yes and \"N\" for no.");
            char keepGoing = scan.next().charAt(0);
            while (keepGoing != 'Y' && keepGoing != 'N')
            {
              System.out.println("Oops. Try again. Type in a capital Y for yes or a capital N for no.");
              keepGoing = scan.next().charAt(0);
            }
            if (keepGoing == 'N')
            {
              wannaRoulette = false;
            }
            if (wallet < 20)
            {
              System.out.println("Oops. You don't have enough money to play. You are now walking to an ATM so that you can get more than $20.");
              place = ATM;
              wannaRoulette = false;
            }
          }
        }
      }
      if (place == horseRacing)
      {
        System.out.println("You discover the Casino's racetrack, and find out that there are races being held 24/7. You decide to bet a bit on the next few races.");
        boolean isRacing = true;
        if (wallet < 20)
        {
          System.out.println("Oops. The minimum bet is $20, and don't have enough in your wallet at the moment. You head towards the ATM.");
          place = ATM;
          isRacing = false;
        }
        while (isRacing)
        {
          System.out.println("You currently have $" + wallet + " in your wallet.");
          System.out.println("How much do you want to bet?");
          wager = scan.nextDouble();
          while (((wallet-wager) < 0) &&  (wager < 20))
          {
            System.out.println("Whoops! You're either betting more money than you have, or less than $20. Try again.");
            wager = scan.nextDouble();
          }
          int horse1 = ((int)(Math.random()*13));
          int horse2 = ((int)(Math.random()*14)+13);
          int horse3 = ((int)(Math.random()*13)+27);
          int horse4 = ((int)(Math.random()*14)+40);
          int horse5 = ((int)(Math.random()*14)+54);
          int horse6 = ((int)(Math.random()*13)+68);
          String[] horsesRacing = {horses[horse1], horses[horse2], horses[horse3], horses[horse4], horses[horse5], horses[horse6]};
          System.out.println("In lane 1: " + horses[horse1]);
          System.out.println("In lane 2: " + horses[horse2]);
          System.out.println("In lane 3: " + horses[horse3]);
          System.out.println("In lane 4: " + horses[horse4]);
          System.out.println("In lane 5: " + horses[horse5]);
          System.out.println("In lane 6: " + horses[horse6]);
          System.out.println("Input the lane # of the horse you are betting on.");
          int horseX = scan.nextInt();
          while ((horseX < 1) || (horseX > 6))
          {
            System.out.println("Oops. Try again.");
            horseX = scan.nextInt();
          }
          System.out.println("They race! And boy is this a close race. Even when they cross the finish line, you have no idea who has won.");
          System.out.println("You watch the replay footage with the rest of the crowd at the track as you anxiously await to see whether or not you won your bet.");
          int first = (int)(Math.random()*6); // if this is 1
          int second = (first+4)%6; // this is 6
          int third = (second+2)%6; // this is 3
          int fourth = (third+1)%6; // this is 5
          int fifth = (fourth+4)%6; // this is 4
          int sixth = (fifth+3)%6; // this is 2
          System.out.println("In 1st: " + horsesRacing[first]);
          System.out.println("In 2nd: " + horsesRacing[second]);
          System.out.println("In 3rd: " + horsesRacing[third]);
          System.out.println("In 4th: " + horsesRacing[fourth]);
          System.out.println("In 5th: " + horsesRacing[fifth]);
          System.out.println("In 6th: " + horsesRacing[sixth]);
          if (horseX-1 == first)
          {
            System.out.println("YOUR HORSE WON!");
            System.out.println("YOU JUST WON $" + wager*5);
            wallet += wager*5;
            houseProfits -= wager*5;
            totalWinnings += wager*5;
          }
          if (horseX-1 == second)
          {
            System.out.println("Your horse came second, and you are furious that " + horsesRacing[first] + " beat your by a hair. However, you're still a winner!");
            System.out.println("You just won $" + wager*2);
            wallet += wager*2;
            houseProfits -= wager*2;
            totalWinnings += wager*2;
          }
          if (horseX-1 == third)
          {
            System.out.println("Your horse came third. You're still kinda happy you doubled your money, though.");
            System.out.println("You just won $" + wager*1);
            wallet += wager*1;
            houseProfits -= wager*1;
            totalWinnings += wager*1;
          }
          if (horseX-1 == fourth)
          {
            System.out.println("Your horse came fourth. I mean, you did come close though.");
            wallet -= wager*1;
            houseProfits += wager*1;
            totalWinnings -= wager*1;
          }
          if (horseX-1 == fifth)
          {
            System.out.println("Your horse came fifth. You kinda saw this coming, but you still had to hope a little.");
            wallet -= wager*1;
            houseProfits += wager*1;
            totalWinnings -= wager*1;
          }
          if (horseX-1 == sixth)
          {
            System.out.println("Your horse came sixth. That's big rip. But there's always next time.");
            wallet -= wager*1;
            houseProfits += wager*1;
            totalWinnings -= wager*1;
          }
          System.out.println("Do you want to race again? If so, type in \"true\". Otherwise, type in \"false\".");
          isRacing = scan.nextBoolean();
        }
        System.out.println("Type in a place's corresponding number in order to go there! \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
        place = scan.nextInt();
        while ((place % 10 != 0))
        {
          System.out.println("Oops! Try again. \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
          place = scan.nextInt();
        }
      }
      //********************************************************************** GAMES ABOVE HERE. EVERYTHING ELSE BELOW **********************************************************************
      if (place == ATM)
      {//********************************************************************** ATM CODE **********************************************************************
        System.out.println("You are now at an ATM. How much money do you want to withdraw?");
        loanMoney = scan.nextInt();
        debt += loanMoney;
        wallet += loanMoney;
        //********************************************************************** CHANGE WHEN NEW GAMES ARE ADDED **********************************************************************
        System.out.println("You now have $" + wallet + "0 in your wallet and $" + debt + "0 debt.");
        System.out.println("Type in a place's corresponding number in order to go there! \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
        place = scan.nextInt();
        while ((place % 10 != 0))
        {
          System.out.println("Whoops! Try again! \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
          place = scan.nextInt();
        }
        //********************************************************************** CHANGE WHEN NEW GAMES ARE ADDED **********************************************************************
      }
      if (place == restaurant)
      {
        System.out.println("You head to the restautant. No champagne or alcohol to entice you. Smart move, knowing that money is at stake. You hang out at a table until a server finds you. He gives you a menu, and later comes back and asks what you would like.");
        System.out.println("1. Burger \t \t $5");
        System.out.println("2. 10x Nuggets \t $5");
        System.out.println("3. Mac & Cheese \t $5");
        System.out.println("4. Chicken Salad \t $10");
        System.out.println("5. Small Pizza \t $10");
        System.out.println("6. Burrito \t $5");
        System.out.println("7. Sub \t \t $5");
        System.out.println("8. Coke \t \t $2");
        System.out.println("9. Water \t \t $2");
        System.out.println("10. Lemonade \t $2");
        System.out.println("Enter the item you want's corresponding number!");
        int food = scan.nextInt();
        while ((food < 0) || (food >10))
        {
          System.out.println("Oops. We couldn't figure out what you wanted. Scroll up to see the menu and try again.");
        }
        switch (food) {
          case 1:
            System.out.println("You ordered a Burger.");
            wallet -= 5;
            houseProfits += 5;
            totalWinnings -= 5;
            System.out.println("You take a giant bite out of it. The sauce/ranch they threw in is the main thing you taste, but it works well, and you can't honestly say you've had a better meal before.");
            break;
          case 2:
            System.out.println("You ordered chicken nuggets.");
            wallet -= 5;
            houseProfits += 5;
            totalWinnings -= 5;
            System.out.println("You have loved chicken nuggets since you were a mere child, but never before had you had chicken nuggets as cripsy, crunchy, and soft as the ones they just gave you. You're left in awe, savoring each bite until the flavor has long since faded into memory.");
            break;
          case 3:
            System.out.println("You ordered Mac and Cheese.");
            wallet -= 5;
            houseProfits += 5;
            totalWinnings -= 5;
            System.out.println("You take a giant bite out of it. The sauce/ranch they threw in is the main thing you taste, but it works well, and you can't honestly say you've had a better meal before.");
            break;
          case 4:
            System.out.println("You ordered a Chicken Salad.");
            wallet -= 10;
            houseProfits += 10;
            totalWinnings -= 10;
            System.out.println("You take a giant bite out of it. The sauce/ranch they threw in is the main thing you taste, but it works well, and you can't honestly say you've had a better meal before.");
            break;
          case 5:
            System.out.println("You ordered a Small Pizza.");
            wallet -= 10;
            houseProfits += 10;
            totalWinnings -= 10;
            System.out.println("You take a giant bite out of it. The sauce/ranch they threw in is the main thing you taste, but it works well, and you can't honestly say you've had a better meal before.");
            break;
          case 6:
            System.out.println("You ordered a Burrito.");
            wallet -= 5;
            houseProfits += 5;
            totalWinnings -= 5;
            System.out.println("You take a giant bite out of it. The sauce/ranch they threw in is the main thing you taste, but it works well, and you can't honestly say you've had a better meal before.");
            break;
          case 7:
            System.out.println("You ordered a Sub.");
            wallet -= 5;
            houseProfits += 5;
            totalWinnings -= 5;
            System.out.println("You take a giant bite out of it. The sauce/ranch they threw in is the main thing you taste, but it works well, and you can't honestly say you've had a better meal before.");
            break;
          case 8:
            System.out.println("You ordered a Coke.");
            wallet -= 2;
            houseProfits += 2;
            totalWinnings -= 2;
            System.out.println("You take a nice, long sip. Ice cubes tinkle within your glass cup. The cold drink makes you feel more alert, and prepared for whatever hands you're about to be dealt in life.");
            break;
          case 9:
            System.out.println("You ordered a Water.");
            wallet -= 2;
            houseProfits += 2;
            totalWinnings -= 2;
            System.out.println("You take a nice, long sip. Ice cubes tinkle within your glass cup. The cold drink makes you feel more alert, and prepared for whatever hands you're about to be dealt in life.");
            break;
          case 10:
            System.out.println("You ordered a Lemonade.");
            wallet -= 2;
            houseProfits += 2;
            totalWinnings -= 2;
            System.out.println("You take a nice, long sip. Ice cubes tinkle within your glass cup. The cold drink makes you feel more alert, and prepared for whatever hands you're about to be dealt in life.");
            break;
        }
        System.out.println("Once you finish eating/drinking, you feel like you are ready to go take a look around the Casino again. Type in a place's corresponding number in order to go there! \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
        place = scan.nextInt();
        while ((place % 10 != 0))
        {
          System.out.println("Whoops! Try again! \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
          place = scan.nextInt();
        }
      }
      
      if (place == rules)
      {
        System.out.println("Being new to the whole Casino scene, you aren't entirely sure how these games are played. You go up to the Customer Relations desk and ask for a rulebook. After a few minutes, they produce a laminated rulebook discussing the rules of every game offered at the Casino");
        System.out.println("SLOTS");
        System.out.println();
        System.out.println("This is a simple 3 wheel slot machine with a betting feature. How it works is like this: You put in a wager, and you spin the lever. If all three numbers are 9s, you win a million dollar jackpot, multiplied by your wager. If any other 3 numbers are 9s, you win 1000x your wager. If any two numbers you roll match, your bet is multiplied by 25. If the first number is greater than 5, you win the rolled number's percent of 1000 multiplied by your wager. Otherwise, you win half of your wager.");
        System.out.println();
        System.out.println("BLACKJACK");
        System.out.println();
        System.out.println("You and the dealer are each dealt 2 cards, and each have one card face-up. The goal is to get as close to 21 as possible. All cards count for their face value. The ace counts as either a 1 or an 11. The goal of the game is to get closer to 21 than the dealer without going over. Bets are all doubled for wins and lost completely for losses and ties. If you win with exactly 21, you earn a total of 5x your original bet");
        System.out.println();
        System.out.println("BACCARAT");
        System.out.println();
        System.out.println("You and all the other players receive two collective cards, which are placed face-down at the center of the table. The dealer also has two cards placed face-down. Your goal is to bet on whoever has the cards closest to 9 (or if there will be a tie): The players, or the dealer. All cards count for their face value with aces low except 10s and the faces, which are worth 0. If either the cards add up to more than 10, we drop the 1 (so if the two cards drawn are 9 and 9, the sum is 8). If either side's cards add up to less than 5, they are obligated to draw a third card. Wagers are paid out double or nothing, and ties are paid out 8x or nothing.");
        System.out.println();
        System.out.println("SLAPJACK");
        System.out.println();
        System.out.println("In this variant of slapjack, the dealer goes through the deck, rapidly placing cards face-up, in a pile, on the table. The goal is to slap the card pile when the first jack is played. Bets are piad triple or nothing.");
        System.out.println();
        System.out.println("keno");
        System.out.println();
        System.out.println("In this variant of war, each player is dealt a single card, face-up. 2s are highest, followed by aces, kings, queens, etc. The dealer then deals him/herself cards, face-up, until the sum of the cards is no longer under 8. Then, the player with the highest card value wins all the wagered money, and his/her personal bet is doubled.");
        System.out.println();
        System.out.println("SUPERSLOTS");
        System.out.println();
        System.out.println("A similar version of the original slot machine, except this one has 5 numbers. The rules are the same as with the 3-slot, but the grand prize is $10,000,000, and you are much more likely to win something. The cost to play is also much higher ($1000).");
        System.out.println();
        System.out.println("WAR");
        System.out.println();
        System.out.println("You and the dealer are each dealt one card, face-up. The player with the card that has the highest face value wins (Aces low). Bets are either doubled or lost completely.");
        System.out.println();
        System.out.println("ROULETTE");
        System.out.println();
        System.out.println("A wheel with 37 numbers, 0-36, each either red or black, is spun. A little white ball is placed on the spinning wheel, and the goal is to bet on the numbers the ball lands on. There are 16 different bets. High/Low, Red/Black, and Odd/Even each pay double or nothing. Betting on a dozen (1-12, 13-24, and 25-36) each pay 4x or nothing. Column bets (1,4,7,10, etc. OR 2, 5, 8, 11, etc. OR 3, 6, 9, 12, etc.) each pay 4x as well. Siz-line bets (any set of 6 consecutive numbers ending in a multiple of 3) pay 5x. Streets (sets of 3 consecutive numbers ending in a multiple of 3) pay 11x. Splits (any two consecutive numbers) pay 17x, and Straight-Up (any single number) pays 35x.");
        System.out.println();
        System.out.println("HORSE RACING");
        System.out.println();
        System.out.println("A randomized horse race between 6 horses. Each one will generally have a 16.7% chance of winning. Payout is 5x for getting 1st, 2x for getting second, and 1x for getting third.");
        System.out.println();
        System.out.println("Satisfied, you return the book and head to the ATM so that you can arm your wallet against these games in an attempt to win big.");
        place = ATM;
      }
      if (place == bar21Plus)
      {
        System.out.println("You walk over to the bar. You whisper something to the waiter, showing him your driver's license. He motions you to follow and leads you through a giant kitchen. He walks up to the wall-length mirror at the back, and taps random parts of it with his fingers. When he finishes, a panel of the mirror slides back, leading you into the secret 21+ bar within the Casino. Some casual baccarat games are taking place out back. You take a seat at a stool near the bar counter. The waiter retreats as the mirror panel rejoins the wall behind you.");
        System.out.println("\"What'd ya like? I got every single type of champagne, beer, alcohol, and soda you could ever drink.\" - The Bartender");
        String drink = scan.next();
        wallet -= 100;
        houseProfits += 100;
        totalWinnings -= 100;
        System.out.println("\" A glass 'er " + drink + " comin' right up.\" He passes you a filled glass cup, complete with a slice of lemon hanging on the lip. \"That'll be $100.\"");
        System.out.println("You didn't quite check the price of the " + drink + " at this joint. Your wallet feels shallower than ever as you take a sip.");
        drunk = true;
        System.out.println("You eventually finish your drink. You wobble off back through the kitchen. The world seems stange and distorted, but you still manage to get out without seeming too high.");
        System.out.print("Type in a place's corresponding number in order to go there! \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
        place = scan.nextInt();
        while (place % 10 != 0)
        {
          System.out.println("Oops. Try again. \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
          place = scan.nextInt();
        }
      } 
      if (place == hotelCheckIn)
      {
        System.out.println("You decide that it's about time that you get a room from the Casino. You walk up to the receptionist.");
        System.out.println("\"Hi there. Would you like a room? They are only $1000 a night, and have all sorts of included features, such as the pool, gym, room service, etc. You're also more likely to win big when you get a room with us.\" - The Receptionist");
        String temp2 = scan.next();
        while (!(temp2.toLowerCase().equals("yes")) && !(temp2.toLowerCase().equals("no")))
        {
          System.out.println("\"I'm sorry sir. I didn't quite get you. Was that a yes or a no?");
          temp2 = scan.next();
        }
        if (temp2.toLowerCase().equals("yes"))
        { wallet -= 1000;
          houseProfits += 1000;
          totalWinnings -= 1000;
          System.out.println("\"Great! We have a room on the 30th floor for you, with a beautiful view of Vegas.\" She says, handing you a fancy black and gold room card. \"This will let you access all the perks I mentioned. Enjoy!\" She says. You thank her and go up to your room.");
          place = hotelRoom;
        }
        if (temp2.toLowerCase().equals("no"))
        {
          System.out.println("\"Oh. ok.\". You almost feel bad for rejecting the receptionist's offer as you walk away. You drift through the Casino, and eventually end up at the ATM");
          place = ATM;
        }
      }
      while (place == hotelRoom)
      {
        if (!hasHotelRoom)
        {
          System.out.println("Wait a sec. You don't have a room yet. You go to the check-in counter to get one.");
          place = hotelCheckIn;
          break;
        }
        System.out.println("You enter your hotel room. 20 stories above the Vegas skyline, with a full glass wall, you decide that the room was definitely worth it. What do you want to do?");
        System.out.println("10 = Sleep \n 20 = Watch TV \n 30 = Watch Netflix \n 40 = Order room service \n 50 = Leave");
        int placeInRoom = scan.nextInt();
        if (placeInRoom == 10)
        {
          System.out.println("You are exhausted. You head straight towards your bed, and embrace your blanket like an old friend. The motion-sensitive lights in the room agree with your plans and turn off.");
          start = System.currentTimeMillis();
          while(start >= System.currentTimeMillis() - 5000);
          System.out.println(" .  .  .  The Next Morning  .  .  .  ");
          System.out.println("You wake up with a renewed sense of purpose the next morning.");
        }
        if (placeInRoom == 20)
        {
          timesWatched++;
          System.out.println("You turn on the TV. Some sports games are hapenning, but nothing too intersting. You flip through some more channels. Fox News criticizes the Democratic party some more, while CNN and the others do the opposite. Sprint has made another ridiculous commercial to make Verizon look bad. Eventually, you settle on watching The Godfather. You watch that for the next two hours. Even though you have watched this movie " + timesWatched + " times, it never gets old.");
        }
        if (placeInRoom == 30)
        {
          System.out.println("You decide to binge watch episodes of The Office on Netflix. You get through 10 episodes before you start to feel kinda bored again.");
        }
        if (placeInRoom == 40)
        {
          wallet -= 80;
          houseProfits += 80;
          totalWinnings -= 80;
          System.out.println("You feel somewhat hungry, but are too lazy to go down to the bar. You order room service, and request them to deliver some buffalo chicken wings with a side of celery sticks, ranch, and edamame seeds. You also order a nice bottle of Bud Light to go with. You watch some Game of Thrones while you eat.");
        }
        if (placeInRoom == 50)
        {
          System.out.println("You get tired of the room. You decide to leave.");
          System.out.println("Type in a place's corresponding number in order to go there! \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
          place = scan.nextInt();
          while ((place %10 != 0))
          {
            System.out.println("Oops! Try again. \n lobby = 100 \n slots = 110 \n blackJack = 120 \n slapjack = 130 \n baccarat = 140 \n keno = 150 \n superSlots = 160 \n war = 170 \n roulette = 180 \n horseRacing = 190 \n ATM = 200 \n restaurant = 210 \n rules = 220 \n bar21Plus = 230 \n hotelCheckIn = 240 \n hotelRoom = 250 \n cashCounterWorkStation = 260 \n pool = 270 \n gym = 280 \n giftShop = 290 \n outsideCasino = 300");
            place = scan.nextInt();
          }
        }
      }
      
      if (place == cashCounterWorkStation)
      {
        boolean working = true;
        System.out.println("You rapidly realize that this casino really needs some help. You apply to be one of the dealers, and they show you to an empty table. Since you're new, you're job solely consists of performing basic math and giving customers the chips they need. They remind you that there are security cameras watching, and then leave you to do math. They say you will average about $15 an hour. You keep your eye on the clock.");
        while (working == true)
        {
          System.out.println("You decide to keep working. The next customer approaches.");
          int chipsNeeded = (int)(Math.random()*10000);
          System.out.println("He needs $" + chipsNeeded + " in chips.");
          System.out.println("How many $1000 chips do you give him?");
          int nums1 = scan.nextInt();
          System.out.println("How many $100 chips do you give him?");
          int nums2 = scan.nextInt();
          System.out.println("How many $10 chips do you give him?");
          int nums3 = scan.nextInt();
          System.out.println("How many $1 chips do you give him?");
          int nums4 = scan.nextInt();
          if (nums1*1000+nums2*100+nums3*10+nums4 != chipsNeeded)
          {
            System.out.println("You can't do basic math, and have been fired. You put on a long face as you hand over your uniform and forfeit the money youve earned thus far.");
            System.out.println("You head to the ATM to get more money so that you can cheer yourself up while gambling.");
            working = false;
            place = ATM;
          }
          else
          {
            elapsedTime += 5;
            System.out.println("The customer walks back satisfied.");
          }
          System.out.println("Do you want to keep working (yes/no)? So far, you have worked for " + elapsedTime + " minutes and earned $"+ 0.25*elapsedTime);
          String temp = scan.next();
          if (temp.toLowerCase().equals("no"))
          {
            System.out.println("You tell the other staff you're taking a break now that there isn't a massive line of customers trying to get chips at other tables. You head out to the ATM to see how much money you have now.");
            working = false;
            place = ATM;
            wallet += 0.25*elapsedTime;
            houseProfits -= 0.25*elapsedTime;
            totalWinnings += 0.25*elapsedTime;
          }
        }
      }
      
      if (place == pool)
      {
        if (!hasHotelRoom)
        {
          System.out.println("You see that pool, and you long to get in. Unfortunately, the pool and other hotel amenities are only for people that have a hotel room. A buff bouncer stands at the pool entrance, watching people swipe their room cards to get into the pool. You make your way to the hotel check-in so that you can get in on the action");
          place = hotelCheckIn;
        }
        else
        {
          System.out.println("Being a room owner, you are allowed to get into the pool. You swipe your room card to get inside the pool room, and smile as poolside staff give you complementary swim wear. You jump inside the pool, eager to get away from the suffocating Vegas heat.");
          System.out.println("You finally have a chance to relax. While you don't show it in the casino, the whole prospect of gambling still terrifies you. Being a college student who is already thousands in debt doesn't help. But in the pool, you can finally relax. There is no betting about swimming races, but rather just people chilling in floaties, making casual conversation. Some goups seem to know each other in advance, and gather together, exchanging gossip like baccarat chips.");
          System.out.println("And the best part: the occassional silence as people leave, with you being the only one in the pool for stretches of half hours at a time. You embrace the opportunity to regain some mental clarity, without the incessant chatter of the casino destroying your focus.");
          System.out.println("Refreshed and relaxed, you get out of the pool. Staff nearby notice you coming out and give you a fresh, fuzzy white towel to drape over yourself as you go back to your room.");
          place = hotelRoom;
        }
      }
      if (place == gym)
      {
        if (!hasHotelRoom)
        {
          System.out.println("You see that gym, and you are dying to work on your muscles. Unfortunately, the gym and other hotel amenities are only for people that have a hotel room. A buff bouncer stands at the entrance, watching people swipe their room cards to get in. You make your way to the hotel check-in so that you can join them.");
          place = hotelCheckIn;
        }
        else
        {
          System.out.println("Being a room owner, you easily make your way to the gym. Only when you are inside do you truly realize how much equipment they have in there. Rowing machines, Dumbbells, Bikes, Treadmills, you name it! You have no idea where to start or what to do. After a few minutes of surveying the equipment, you decide to start by figuring out how long you're about to dedicate to exercise.");
          System.out.println("How long (in minutes) do you decide to spend?");
          int time = scan.nextInt();
          if (time > 480)
          {
            System.out.println("You decide you would spend over 8 hours working on you muscles, but by the 5th, you're exhausted. Your legs are killing you, and you have only stopped because the treadmill's constant speed outlasted your stamina. You hobble back to your room, too tired to do virtually anything else.");
            place = hotelRoom;
          }
          if ((time > 240) && (time <= 480))
          {
            System.out.println("You decide on a hardcore 4-8 hour workout. You make it through 15 minutes on every machine, and then go through your favorites for the rest of the time. You're absolutely drained by the end of it, but you feel powerful and muscular, and flex your biceps on the wall-wide mirror with a smile as you leave to go to your room.");
            place = hotelRoom;
          }
          if ((time > 60) && (time <= 240))
          {
            System.out.println("You decide on a moderate 2-4 hour workout. You don't push yourself too hard, but are far from the fakers walking on the treadmills mearby. You don't quite get to every machine, but rather focused on specific regions of the body with your work outs, oneat a time for half hour blocks. In the final half hour, you convince the rest of the gym to do some yoga, taking some mats out of storage and stretching as you cool down from your workout session. Finally, feeling powerful yet nowhere near exhausted, you leave the gym and head back to your room.");
            place = hotelRoom;
          }
          if ((time > 15) && (time <= 60))
          {
            System.out.println("You decide on a light under-an-hour workout. You push yourself to the limits, with hardcore 10 minute workouts followed by a dose of less intense workouts for 5. By the end, while you don't feel like you've worked out much, your machines tell you that you've lost a couple hundred calories, and you leave the gm satisfied. You head back to your room.");
            place = hotelRoom;
          }
          if (time <= 15)
          {
            System.out.println("Suddenly, you snap back to reality, remember that you hate these workout machines and the way that they have mocked you throughout your life. You storm out of the gym.");
            place = hotelRoom;
          }
        }
      }
      //************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*******************************
      if (place == giftShop)
      {
        System.out.println("You head over to the CCC gift shop. You find lots of merchandise, and are unsure of what to buy (if anything). What you do know is that there is a giant line. You decide to only buy one thing.");
        System.out.println("Pick from the following menu. Enter the number of the thing you want to buy.");
      }
      //**************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************************FINISH CODING THIS*****************
      if (place == outsideCasino)
      {
        inCasino = 50;
      }
    }
    if (inCasino == 50)
    {
      System.out.println("You have decided to leave the Casino. Today, you have received $" + totalWinnings + " in total. You have $" + wallet + "0 in your wallet and $" + debt + "0 debt.");
      if (slotRolls > 9)
      {
        if (wallet-debt < walletOriginal)
        {
          System.out.println("You have lost $" + ((walletOriginal-wallet)+debt) + " But it was the fun you had while playing slots that really matters. And don't forget to come back soon!");
        }
        if (wallet-debt == walletOriginal)
        {
          System.out.println("Wow! You broke even! But if you had fun, you most definitely made a profit. And don't forget to come back soon!");
        }
        if (wallet-debt > walletOriginal)
        {
          System.out.println("You have made a profit of $" + ((wallet-walletOriginal)-debt) + ". Well done! Come back soon!");
        }
      }
      else
      {
        if ((houseProfits > 0) && (houseProfits < 1000))
        {
          System.out.println("The House made a profit of $" + houseProfits + ". Thank you!");
        }
        if ((houseProfits > 1000))
        {
          System.out.println("The House made a profit of $" + houseProfits + " and you lost $" + ((walletOriginal-wallet)+debt) + "!. Wow! That's a lot of money. Thanks a lot, and don't forget to refill your pockets!");
        }
        if ((houseProfits < 0) || (houseProfits == 0))
        {
          System.out.println("Dang! You made a profit of $" + ((wallet-walletOriginal)-debt) + " and made us lose $" + (houseProfits*-1) + "! Don't worry, we WILL get you next time!");
        }
      }
    }
    System.out.println("Finally, before you leave, you have to decide how you will get home. Pick from one of the following, and input its corresponding number:");
    System.out.println("310: Get an Uber.");
    System.out.println("320: Get an bus.");
    System.out.println("330: Get a ride from a friend.");
    System.out.println("340: Get a taxi to the airport so that you can fly back home.");
    place = scan.nextInt();
    if ((place != uber) && (place != bus) && (place != callFriend) && (place != plane) && drunk)
    {
      System.out.println("You stumble out of the casino. Unsure of where to go, you decide to walk around Vegas. Since you're still drunk, you still behave erratically. You yell at a dog for walking too close, and ask half the people on the street for their numbers. Eventually, you end up jaywalking directly in front of a Vegas Police Cruiser. You mumble incoherently as the officer slaps on shiny handcuffs and reads you your Miranda rights. He drives you back to the county jail."); 
      System.out.println("You end up in jail following your day at the Casino. And all because you refused to obey a simple command asking you how you wanted to go home.");
    }
    if ((place != uber) && (place != bus) && (place != callFriend) && (place != plane) && !drunk)
    {
      System.out.println("You walk around Vegas some more after leaving the Casino. You feel satisfied, almost enlightened by your time. You spend some time at a Starbucks charging you phone, and only then do you finally decide that it is time to go back home, to your apartment in Chicago.");
    }
    if (place == uber)
    {
      System.out.println("You manage to get an Uber ride. The driver pulled up in an SUV that seemed almost brand new. He was nice, too, and was even willing to save you a hundred dollars (having seen you walk out of the casino) at the end of the day-long drive from Las Vegas to Chicago.");
    }
    if (place == bus)
    {
      System.out.println("You find a Greyhound Bus right outside. Lucky for you, the bus was part of a nation-wide tour. They had just come over to finish off their visit to the Southern US. You jump in, and visit all sorts of sights as they go east, stopping at Baton Rouge and then heading straight up along the Mississippi River. In about a week's time, they make it up to Lake Michigan, at which point you sneak off, onto another Greyhound bus to take you straight back to Chicago.");
    }
    if (place == callFriend)
    {
      System.out.println("You call your friend. He seems annoyed that he has drive all the way out to Vegas from Silicon Valley, but he knows you'd do the same for him, having been inseparable friends since the 8th grade. He lets you stay with him until you all go back to Chicago together when his internship at Google is over.");
    }
    if (place == plane)
    {
      System.out.println("You get a taxi after about a half hour. He takes you to the McCarran airport, and you feel taken advantage of when he asks you for a full $60 fare, but you really don't have a choice. The TSA staff seem extra annoying, and you just wanna go home. Once you make it onto your plane, however, they tell you that they have overbooked seating in economy and decided to let you travel business class at no additional charge. You enjoy the luxuries of increased leg room and cushioned leather seating on your flight back to Chicago.");
    }
    System.out.println();
    System.out.println("Thanks for playing!");
    System.out.println();
    System.out.println("\t \t       Credits:");
    System.out.println();
    System.out.println("Executive Producer \t \t \t Krishna Cheemalapati");
    System.out.println("Executive Producer \t \t \t Advait Renduchintala");
    System.out.println("Lead Designer \t \t \t Advait Renduchintala");
    System.out.println("Lead StoryWriter \t \t \t Krishna Cheemalapati");
    System.out.println("Executive Programmer \t \t Krishna Cheemalapati");
    System.out.println("Executive Programmer \t \t Advait Renduchintala");
    System.out.println("Lead Research \t \t \t Kharn Nigam, Apaar Baweja, Revanth Chandramohan, Emmett Pierce, Jeanine Labrosse");
    System.out.println("Chief Beta-Testers \t \t \t Dhananjai Senthil Kumar, Falcon Yule, Krishna Cheemalapati, Advait Renduchintala");
    System.out.println("Director of Programming \t \t Jeanine Labrosse");
    System.out.println("Chief Motivator \t \t \t Justin Hasler");
    scan.close();
  }
}