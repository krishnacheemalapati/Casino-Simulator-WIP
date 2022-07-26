import java.util.Scanner;
import java.util.Random;

public class PP508
{
  public static void main (String[] args)
  {
    System.out.println("Welcome to Java Slots! Before we go gambling, please tell me how much money you have in your wallet.");
    Scanner scan = new Scanner(System.in);
    double wallet = scan.nextDouble();
    double walletOriginal = wallet;
    Random rand = new Random();
    double winnings = 0.00;
    double totalWinnings = 0.00;
    double wager = 0.00;
    double winMultiplier = 1.00;
    double debt = 0.00;
    double loanMoney = 0.00;
    int num1, num2, num3 = 0;
    int slotOrNot = 0;
    int inCasino = 10;
    int ATM = 20;
    int slots = 10;
    double houseProfits = 0.00;
    int slotRolls = 0;
    final int slotsCost = 10;
    
    int place = 0;
    if ((wallet-slotsCost) < 0)
    {
      place = ATM;
      System.out.println("You currently do not have enough money to play slots. The cost is $10. You approach the nearest ATM.");
    }
    else
    {
      System.out.println("To play slots, type in 10! To go to the ATM and get some money, type in 20! To leave the Casino, type in 50!");
      place = scan.nextInt();
      while ((place != 10) && (place != 20) && (place != 50))
      {
        System.out.println("Whoops! You did not follow instructions. To play slots, type in 10! To go to the ATM and get some money, type in 20! To leave the Casino, type in 50!");
        place = scan.nextInt();
      }
    }
    if (place == 50)
    {
      inCasino = 50;
    }
    while (inCasino == 10)
    {
      while (place == slots)
      {
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
                  winnings = (((1000)/40)*winMultiplier);
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
          {
            System.out.println("You don't want to play slots? Ok then. Would you like to visit an ATM (type 20) or leave the Casino (type 50)?");
            place = scan.nextInt();
            while ((place != 20) && (place != 50))
            {
              System.out.println("Whoops! You did not follow instructions. To play slots, type in 10! To go to the ATM and get some money, type in 20! To leave the Casino, type in 50!");
              place = scan.nextInt();
            }
          }
        }
      }
      if (place == ATM)
      {
        System.out.println("You are now at an ATM. How much money do you want to withdraw?");
        loanMoney = scan.nextInt();
        debt += loanMoney;
        wallet += loanMoney;
        System.out.println("You now have $" + wallet + "0 in your wallet and $" + debt + "0 debt. You now walk back to the slot machine");
        place = slots;
      }
      if (place == 50)
      {
        inCasino = 50;
      }
    }
    if (inCasino == 50)
    {
      if (slotRolls > 9)
      {
        System.out.println("You have decided to leave the Casino. Today, you have received $" + totalWinnings + " from the slot machine. You have $" + wallet + "0 in your wallet and $" + debt + "0 debt.");
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
    scan.close();
  }
}