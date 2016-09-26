package wheeloffortune;

import java.util.Arrays;
import java.util.Scanner;

public class WheelClass
{
    // Variables
    public String phrase = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
    public String phraseConcealed = phrase.replaceAll("[ABCDEFGHIJKLMNOPQRSTUVWXYZ]", "_ ");
    public char userGuessPhrase[] =phrase.toCharArray();
    
    void spinWheel()
    {
        double r = Math.random() *10;
        double weight = 24;
        
        String[] wedges = {"300", "350", "400","450","500","550","600","700","800","900","5000","Lose a Turn", "Bankrupt"};
        double[] probabilities = {5,1,2,1,3,1,3,1,2,2,1,1,1};
        
        System.out.println("You landed on: ");
      
    }
    
    // Toggle option class. If integer number is even, displays the string that includes the user guesses.
    // If odd, displays the entire string
void toggleOption(int i)
{
    if(i % 2 == 0)
    {
        System.out.println("======================");
        System.out.println("=  Wheel Of Fortune  =");
        System.out.println("======================");
        System.out.println(this.userGuessPhrase);
        System.out.println("1. Spin the wheel");
        System.out.println("2. Buy a vowel");
        System.out.println("3. Solve the puzzle");
        System.out.println("4. Quit");
        System.out.println("8. Toggle puzzle reveal");
        System.out.println("9. Test letter input");
        System.out.println("Enter choice: ");
    }
    
    else
    {         
        System.out.println("======================");
        System.out.println("=  Wheel Of Fortune  =");
        System.out.println("======================");
        System.out.println(phrase);
        System.out.println("1. Spin the wheel");
        System.out.println("2. Buy a vowel");
        System.out.println("3. Solve the puzzle");
        System.out.println("4. Quit");
        System.out.println("8. Toggle puzzle reveal");
        System.out.println("9. Test letter input");
        System.out.println("Enter choice: ");
    }
}


    public void userGuess()
    {
      Scanner key = new Scanner(System.in);
      String userLetter;
      System.out.println("Enter a letter: ");
      
      userLetter = key.next();
      char u = userLetter.charAt(0);
      char phraseArray[] = phrase.toCharArray();
      System.out.println(phraseArray);
           
      // Validation for if the user entered a letter
      while(userLetter.length() > 1 || ((int)u < 65 || (int)u > 122))
        {
            System.out.println("Error. Enter a valid letter.");
            System.out.println("Enter a letter: ");
            userLetter = key.nextLine();
            u = userLetter.charAt(0);
        }
      
     for(int i = 0; i < phraseArray.length; i++)
     {
         if(phraseArray[i] == u)
         {
             this.userGuessPhrase[i] = u;
         }
         else if(phraseArray[i] == ' ')
         {
             this.userGuessPhrase[i] = ' ';
         }
         else
             this.userGuessPhrase[i] = '_';
     }
        System.out.println("======================");
        System.out.println("=  Wheel Of Fortune  =");
        System.out.println("======================");
        System.out.println(this.userGuessPhrase);
        System.out.println("1. Spin the wheel");
        System.out.println("2. Buy a vowel");
        System.out.println("3. Solve the puzzle");
        System.out.println("4. Quit");
        System.out.println("8. Toggle puzzle reveal");
        System.out.println("9. Test letter input");
        System.out.println("Enter choice: ");
      }
    
    

// Test input
  static void testInput()
  {
            String userLetter;
            Scanner key = new Scanner(System.in);
            
            System.out.println("Enter a letter: ");
            userLetter = key.nextLine();
            char u = userLetter.charAt(0);
            
            while(userLetter.length() > 1 || ((int)u < 65 || (int)u > 122))
            {
                System.out.println("Error. Enter a valid letter.");
                System.out.println("Enter a letter: ");
                userLetter = key.nextLine();
                u = userLetter.charAt(0);
            }
            
            System.out.println("You entered: " + userLetter);
  }
}