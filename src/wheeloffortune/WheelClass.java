package wheeloffortune;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WheelClass extends JFrame
{
    // Variables to keep track of the user information
    public int userWinnings = 0;
    public String phrases[] = {"THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG", "SOMEWHERE OVER THE RAINBOW", "PETER PAN","BATMAN"};
    
    // An arraylist to keep track of the guesses that the user already submitted
    public ArrayList userGuessLetters = new ArrayList();
 
    // Random option that chooses a puzzle from the array of strings
    Random r = new Random();
    int randPhrase = r.nextInt(3);
    
    // Shows the phrase 
    public String initPhraseConcealed = phrases[randPhrase].replaceAll("[ABCDEFGHIJKLMNOPQRSTUVWXYZ]", "_ ");
    public String endPhraseConcealed = phrases[randPhrase].replaceAll("[ABCDEFGHIJKLMNOPQRSTUVWXYZ]", "_");
    public int length = phrases[randPhrase].length();
    public char userGuessPhrase[] = initPhraseConcealed.toCharArray();
    
    // This just keeps track of the amount that the user spun
    public int wedge = 0;
    
    
    // Function for when user spins the wheel
    // Finds the amount of money the user spun then calls the user guess function so that the user  can guess the letter
    void spinWheel()
    {
        // Random choses a number between 0 and 23;
        Random rand = new Random();
        int randWedge = rand.nextInt(23);
        
        int wedges[] = {300,300,300,300,300,350,400,400,450,500,500,500,550,600,600,600,700,700,800,800,900,5000};
        
     
        // If random number is one or zero, results in the string outputs and setsthe user winnings to zero
        if(randWedge == 0)
        {
            JOptionPane.showMessageDialog(null,"You landed on: Lose a turn ");
            this.userWinnings +=0;
            this.wedge = 0;
        }
        
        else if(randWedge==1)
        {
           JOptionPane.showMessageDialog(null,"You landed on: Bankrupt"); 
           this.userWinnings = 0;
           this.wedge = 0;
        }
        
        // Sets the wedge variable to the number given for future reference
        else
        {
         JOptionPane.showMessageDialog(null,"You landed on: " + wedges[randWedge]);
         this.wedge = wedges[randWedge];
        }
        
        // Calls the user guess function
        userGuess();    
    }
  
    // Function for user to buy vowels
void buyVowel()
{
    Scanner input = new Scanner(System.in);
    String vowel;
    char vowelChar;
    char phraseArray[] = phrases[randPhrase].toCharArray();
   
    //Checks to see if the user has enough money
    if(this.userWinnings < 250)
    {
        JOptionPane.showMessageDialog(null, "Error. You don't have enough money to buy vowels.");
        menu();
    }
    
    //  Subtracts the amount of money from the user winnings and compares it to the string to see if its in the phrase
    else
    {
        this.userWinnings -=250;
        JOptionPane.showMessageDialog(null,"Enter a vowel: ");
        vowel = input.nextLine();
        vowelChar = vowel.charAt(0);
        
for(int i = 0; i < phraseArray.length; i++)
     {
         
         if(phraseArray[i] == vowelChar)
         {
             this.userGuessPhrase[i] = vowelChar;
         }
         else if(phraseArray[i] == this.userGuessPhrase[i])
         {
             this.userGuessPhrase[i] = phraseArray[i];
         }
         else if(phraseArray[i] == ' ')
         {
             this.userGuessPhrase[i] = ' ';
         }
         else
             this.userGuessPhrase[i] = '_';
         
     }
     // Calls the menu function
        menu();
        
  }
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
        System.out.println("Enter choice: ");
    }
    
    else
    {         
        System.out.println("======================");
        System.out.println("=  Wheel Of Fortune  =");
        System.out.println("======================");
        System.out.println(phrases[randPhrase]);
        System.out.println("1. Spin the wheel");
        System.out.println("2. Buy a vowel");
        System.out.println("3. Solve the puzzle");
        System.out.println("4. Quit");
        System.out.println("Enter choice: ");
    }
}


    public void userGuess()
    {
      Scanner key = new Scanner(System.in);
      String userLetter;
      JOptionPane.showMessageDialog(null,"Enter a letter: ");
      
      userLetter = key.nextLine();
      char u = userLetter.charAt(0);
      char phraseArray[] = phrases[randPhrase].toCharArray();
           
      // Validation for if the user entered a letter
      // Checks to make sure user does not enter a vowel
      // Prompts user to re enter a letter
      // The number values 65 and 122 represents the decimal value in the ASCII Table for the letters A to z
      // The numbers 65, 69, 73, 79, 85 represent the decimal values for the vowels in the ASCII table
      while(userLetter.length() > 1 || ((int)u < 65 || (int)u > 122 || (int)u == 65 || (int) u == 69 || (int) u == 73 || (int) u == 79 || (int) u == 85))
        {
            JOptionPane.showMessageDialog(null,"Error. Enter a valid letter.");
            JOptionPane.showMessageDialog(null,"Enter a letter: ");
            userLetter = key.nextLine();
            u = userLetter.charAt(0);
        }
      
      while(this.userGuessLetters.contains(u))
      {
            JOptionPane.showMessageDialog(null,"Error. Already entered that letter.");
            JOptionPane.showMessageDialog(null,"Enter a different letter: ");
            userLetter = key.nextLine();
            u = userLetter.charAt(0);
      }
      this.userGuessLetters.add(u);
      
     for(int i = 0; i < phraseArray.length; i++)
     {
         
         if(phraseArray[i] == u)
         {
             this.userGuessPhrase[i] = u;
             this.userWinnings += this.wedge;
         }
         else if(phraseArray[i] == this.userGuessPhrase[i])
         {
             this.userGuessPhrase[i] = phraseArray[i];
         }
         else if(phraseArray[i] == ' ')
         {
             this.userGuessPhrase[i] = ' ';
         }
         else
             this.userGuessPhrase[i] = '_';
         
     }
        menu();
      }
    
    

// Test input
  static void testInput()
  {
            String userLetter;
            Scanner key = new Scanner(System.in);
            
            JOptionPane.showMessageDialog(null,"Enter a letter: ");
            userLetter = key.nextLine();
            char u = userLetter.charAt(0);
            
            while(userLetter.length() > 1 || ((int)u < 65 || (int)u > 122))
            {
                JOptionPane.showMessageDialog(null,"Error. Enter a valid letter.");
                JOptionPane.showMessageDialog(null,"Enter a letter: ");
                userLetter = key.nextLine();
                u = userLetter.charAt(0);
            }
            
            JOptionPane.showMessageDialog(null,"You entered: " + userLetter);
  }
  
 // Displays the main menu
void menu()
{
        System.out.println("======================");
        System.out.println("=  Wheel Of Fortune  =");
        System.out.println("======================");
        System.out.println(this.userGuessPhrase);
        System.out.println("$" + this.userWinnings);
        System.out.println("1. Spin the wheel");
        System.out.println("2. Buy a vowel");
        System.out.println("3. Solve the puzzle");
        System.out.println("4. Quit");
        System.out.println("Enter choice: ");
}


//Function for when users enter Solve Puzzle Mode
// Allows user to enter a letter until they guess all letters correctly
// If they guess one letter wrong, game over!
void solvePuzzle()
{
      Scanner key = new Scanner(System.in);
      String userLetter;
      boolean run = true;
      
while(run)
{
     JOptionPane.showMessageDialog(null,"Enter a letter: ");

      // User Input letter
      userLetter = key.nextLine();
      
      // changes the user input into a char
      char u = userLetter.charAt(0);
      
      // Creates a char array from the phrase of the puzzle
      char phraseArray[] = phrases[randPhrase].toCharArray();
 
// Checks to see if the letter the user guess is in the phrase
if(phrases[randPhrase].contains(userLetter))
    {  
        // for loop that goes through each letter in the char array and sees if the user
        // input or guess is in the char arrar (phraseArray)
     for(int i = 0; i < phraseArray.length; i++)
     {       
         // if the user guess is in the array, adds the letter to the board displaying where
         // the user guessed correctly and adds money to the users winnings
         
        if(phraseArray[i] == u)
        {
             this.userGuessPhrase[i] = u;
             this.userWinnings += this.wedge;
             
            if(phraseArray[i] == this.userGuessPhrase[i])
            {
                this.userGuessPhrase[i] = phraseArray[i];
            }
             else if(phraseArray[i] == ' ')
            {
                this.userGuessPhrase[i] = ' ';
            }
            else
                this.userGuessPhrase[i] = '_';  
        }
        
        // If the user has every letter correct
        if (this.userGuessPhrase.toString().equalsIgnoreCase(this.phrases[randPhrase]))
        {
            JOptionPane.showMessageDialog(null,"You win!");
            break;
        }
     }
    }
// If user guessed the wrong letter then they lose
else
{
    JOptionPane.showMessageDialog(null,"You lose!");
    break;
}
}
}
}
