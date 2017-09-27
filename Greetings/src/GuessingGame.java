
import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Math;

public class GuessingGame {
    public static void main(String[] args)
    {
        /*
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name.");
        String s = input.next();
        System.out.println("Welcome to the game " + s + ".");
        System.out.println("How old are you?");
        int a =  input.nextInt();
        System.out.print("You are " + a + " years old.");
        if(a >= 18)
        {
            System.out.print(" YOU ARE OLD ENOUGH!");
        }
        else
        {
            System.out.print(" NOT OLD ENOUGH!");
        }
            */
        GuessingGame();

    }
    public static void GuessingGame()
    {
        Scanner guess = new Scanner(System.in);
        int randomNumber = (int)(Math.random()*10 + 1);
        int userGuess = -1;
        int numberOfTurns = 0;
        while(randomNumber != userGuess)
        {
            boolean isNumber = false;
            numberOfTurns++;
            while (!isNumber)
            {

                try
                {
                    System.out.println("Guess a number.");
                    userGuess = guess.nextInt();
                    if(userGuess == randomNumber)
                    {
                        System.out.println("YOU DID IT, IT ONLY TOOK " + numberOfTurns + " TURNS!");
                        isNumber = true;
                    }
                    else
                    {
                        System.out.println("WRONG NUMBER, TRY AGAIN");

                    }
                }
                catch(InputMismatchException e)
                {
                    System.out.println("INPUT A NUMBER U ...");
                    guess.next();

                }
            }
        }
    }
}
