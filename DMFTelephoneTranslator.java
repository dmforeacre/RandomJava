/**
   Name:    Daniel Foreacre
   Class:   CPS 121 Fahringer
   Date:    3/20/19
   Assignment 9.1
   
   This program prompts the user to enter a 10 digit telephone number
   and will translate any letters to the correct number and display
   it back to user.
*/

import javax.swing.*;              // For message dialogs
import java.awt.Font;              // For Font class

public class DMFTelephoneTranslator
{
   public static void main(String[] args)
   {
      // Change message box font to monospaced so dashes are more visible
      UIManager.put("OptionPane.messageFont", new Font("Monospaced", Font.PLAIN, 14)); 
     
      String number,      // String for user's entered telephone number 
             newNumber;   // String for translated telephone number
      
      // Call method to get a valid telephone number
      number = getTeleNumber();
      
      // Call method to translate telephone number
      newNumber = translateNumber(number);
      
      // Call method to display results
      displayResults(number, newNumber);
      
      System.exit(0);
   }
   
   /**
      This method prompts the user to input a 10 digit telephone
      number and returns a string if it is valid, otherwise repeats
      until a valid number is entered.
      @return String containing a valid 10 digit telephone number
   */
   public static String getTeleNumber()
   {
      String input;     // Holds user's input
      
      input = JOptionPane.showInputDialog("DMForeacre's Telephone Translator\n\n\n" +
            "This program will translate any phone number with letters " +
            "in it to the correct digits to dial.\n\n" +
            "Please input a number to translate.\n" +
            "Number MUST be in the format ###-###-#### including dashes!\n\n");
            
      while(!isValid(input))
      {
         input = JOptionPane.showInputDialog("Number is not in the correct format!\n\n" +
               "###-###-####\n\n" +
               "Please enter again.\n\n");
      }
      
      return input;
   }
   
   /**
      This method takes a string argument and returns true if it is
      in the correct 10 digit format and false otherwise.
      @param entry String holding the user's entry
      @return true if entry is in the valid format, false otherwise
   */
   public static boolean isValid(String entry)
   {
      boolean valid = true;     // Flag for valid entry
      int i = 0;                // Counter for character test
      
      // Not valid if entry isn't 12 characters long
      if (entry.length() != 12)
         valid = false;
      else
      {
         // Not valid if first 3 characters are not letters or digits
         while (i < 3)
         {
            if (!Character.isLetterOrDigit(entry.charAt(i)))
               valid = false;
            i++;
         }
      
         // Not valid if 4th character is not a dash
         if (entry.charAt(i) != '-')
            valid = false;
         i++;
      
         // Not valid if 5th through 7th characters are not letters or digits
         while (i < 7)
         {
            if (!Character.isLetterOrDigit(entry.charAt(i)))
               valid = false;
            i++;
         }
      
         // Not valid if 8th character is not a dash
         if (entry.charAt(i) != '-')
            valid = false;
         i++;

         // Not valid if last 4 characters are not letters or digits
         while (i < 12)
         {
            if (!Character.isLetterOrDigit(entry.charAt(i)))
               valid = false;
            i++;
         }   
      }
      
      return valid;      
   }
   
   /**
      This method takes a string argument and translates it to a telephone number
      containing only digits and returns the translated number.
      @param number String holding the entered telephone number
      @return String holding the translated number
   */
   public static String translateNumber(String number)
   {
      String newNumber = "";         // String to hold translated number, initialized to be empty
      
      // Loop through all 12 characters
      for (int i = 0; i < 12; i++)
      {
         // If character is a dash, add dash to translated string
         if (number.charAt(i) == '-')
            newNumber += '-';
         // If character is a digit, add it to translated string
         else if (Character.isDigit(number.charAt(i)))
            newNumber += number.charAt(i);
         // If character is a letter, translate it to specified digit
         // and add it to translated string
         else if (Character.isLetter(number.charAt(i)))
         {
            switch (Character.toUpperCase(number.charAt(i)))
            {
               case 'A':
               case 'B':
               case 'C':
                  newNumber += '2';
                  break;
               case 'D':
               case 'E':
               case 'F':
                  newNumber += '3';
                  break;
               case 'G':
               case 'H':
               case 'I':
                  newNumber += '4';
                  break;
               case 'J':
               case 'K':
               case 'L':
                  newNumber += '5';
                  break;
               case 'M':
               case 'N':
               case 'O':
                  newNumber += '6';
                  break;
               case 'P':
               case 'Q':
               case 'R':
               case 'S':
                  newNumber += '7';
                  break;
               case 'T':
               case 'U':
               case 'V':
                  newNumber += '8';
                  break;
               case 'W':
               case 'X':
               case 'Y':
               case 'Z':
                  newNumber += '9';
                  break;
            }
         }
      }
      
      return newNumber;
   }
   
   /**
      This method displays the entered and translated telephone
      numbers to the user.
      @param number    The telephone number entered by the user
      @param newNumber The translated telephone number
   */
   public static void displayResults(String number, String newNumber)
   {
      JOptionPane.showMessageDialog(null, "The telephone number you entered was:\n" +
            number + "\n\nThe translated number to dial is:\n" + newNumber);
   }   
}