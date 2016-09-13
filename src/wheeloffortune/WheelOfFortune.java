/*
* CMPSC 261, Section 1
* Fall 2016
* Instructor: Phil O'Connell
* Student: Sydnee Woodhouse
* ID: svw5194
*/
package wheeloffortune;

import java.util.Scanner;

public class WheelOfFortune 
{
  public static void main(String[] args) 
  {
      Scanner keyboard = new Scanner(System.in);
      Scanner key = new Scanner(System.in);
    // Present the user with a simple text menu of those choices
    // spin the wheel, buy a vowel, solve the puzzle, or quit the game
    // Print back to the screen what choice was made
    // The choice to quit is the only one having functionality right now
    // Choosing that will exit the program
      
      System.out.println("Wheel Of Fortune");
      System.out.println("1. Spin the wheel");
      System.out.println("2. Buy a vowel");
      System.out.println("3. Solve the puzzle");
      System.out.println("4. Quit the game");
      System.out.println("5. Test");
      
      int userChoice;
     
      while(true)
      {
          userChoice = keyboard.nextInt();
          
          if (userChoice == 4)
          {
             break;
          }
            switch(userChoice)
            {
              case 1: System.out.println("You chose to spin the wheel.");
                      break;
              case 2: System.out.println("You chose to buy a vowel.");
                      break;
              case 3: System.out.println(" You chose to solve the puzzle.");
                      break;
              case 5: testInput();
                        break;
            }
            
            String userLetter;
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
