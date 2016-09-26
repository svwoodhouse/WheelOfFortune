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
      WheelClass wheel = new WheelClass();
      
    // Present the user with a simple text menu of those choices
    // spin the wheel, buy a vowel, solve the puzzle, or quit the game
    // Print back to the screen what choice was made
    // The choice to quit is the only one having functionality right now
    // Choosing that will exit the program
     
    // Initial User 
      int userChoice;
      int count = 0;
        System.out.println("======================");
        System.out.println("=  Wheel Of Fortune  =");
        System.out.println("======================");
        System.out.println(wheel.phraseConcealed);
        System.out.println("1. Spin the wheel");
        System.out.println("2. Buy a vowel");
        System.out.println("3. Solve the puzzle");
        System.out.println("4. Quit");
        System.out.println("8. Toggle puzzle reveal");
        System.out.println("9. Test letter input");
        System.out.println("Enter choice: ");
          
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
                      wheel.spinWheel();
                      wheel.userGuess();
                      break;
              case 2: System.out.println("You chose to buy a vowel.");
                      wheel.userGuess();
                      break;
              case 3: System.out.println(" You chose to solve the puzzle.");
                      wheel.userGuess();
                      break;
              case 8: count+=1;
                      wheel.toggleOption(count);
                      break;
              case 9: wheel.testInput();
                      break;
            }
      }
              
  }


  
}
