package dnddiceroller;

import assignment.pkg9.DiceFileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 *
 * @author Paul Scarrone
 */
public class DnDDiceRoller {

  /**
   * Try out your dies and dice tower
   * @param args the command line arguments
   */
  public static void main(String[] args) {
        //ArrayList that will hold our dice
        ArrayList<Die> dieList = new ArrayList();
        
        // Send file to DiceFileReader and have it process the file
        // Then assign that information to the lines ArrayList;
        DiceFileReader fileReader = new DiceFileReader("dice.txt");
        fileReader.read();
        ArrayList<String> lines = fileReader.getLines();
        
        // Access each line one at a time
        for (String singleLine : lines)
        {
         // Split line at spaces
         String[] spaceTokens = singleLine.split(" ");
         // Access each die information one at a time
         for (String dieTokens: spaceTokens)
         {
             // Split line at colons
             String[] colonTokens = dieTokens.split(":");
             // Declare variables that will be used to create different Dies
             Integer sides;
             Integer loadedSide;
             // Switch statement based on type of die that creates a Die in the
             // ArrayList
             switch (colonTokens[1]) {
                 case "numbered":
                     sides = Integer.parseInt(colonTokens[0]);
                     dieList.add(new NumberedDie(sides));
                     break;
                 case "fudge":
                     sides = Integer.parseInt(colonTokens[0]);
                     dieList.add(new FudgedDie(sides));
                     break;
                 default:
                     sides = Integer.parseInt(colonTokens[0]);
                     loadedSide = Integer.parseInt(colonTokens[2]);
                     dieList.add(new LoadedDie(sides, loadedSide));
                     break;            
             } // End Switch that Assigns Die ArrayList
         } // End For that breaks each token at colons
         
         // Create Dice tower and give it the Array List and have it drop dice
         DiceTower diceTower = new DiceTower(dieList);
         diceTower.dropDice();
         
         // Create a FileWriter object to save output        
        try{
            FileWriter rolledDice = new FileWriter("Output.txt", true);
            PrintWriter outputFile = new PrintWriter(rolledDice);
            // Step Through each Die in Array and Output info to file
            for(Die die: dieList){
                outputFile.println(die.name() + ":" + die.value());
            }
            // Close file and empty ArrayList for line of dice
            outputFile.println("----------END OF SET------------");
            rolledDice.close();
            dieList.removeAll(dieList);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        } // End For that reads each line       
  } 
}
