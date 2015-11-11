/**
 * A new version of the Dice Tower assignment, this program uses a dice interface
 * and implements two types of die objects from the interface.
 */
package assignment.pkg9;

import static assignment.pkg9.DiceReaderTest.test_reader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samantha Shurie
 */
public class Assignment9Strings {

  public static void main(String[] args) {
    String[] txtLines; // HOLDS LINES OF TEXT FILE IN ARRAY
    String[] diceStrings = null; // HOLDS DIE AFTER SPLITTING BY SPACES IN ARRAY
    String[] diceFields; //   HOLDS DIE AFTER SPLITTING BY COLONS IN ARRAY
    ArrayList<Die> dieList = new ArrayList(); //  STORES FINAL DIE OBJECTS
    
    // CREATE FILE READING OBJECT AND READ FILE
    test_reader(); //I am still a little confused about what to do with this method
    DiceFileReader reader = new DiceFileReader("dice.txt");
    reader.read();
    
    // CONVERT LIST FROM READER OBJECT TO TXT-LINES ARRAY
      txtLines = reader.getLines().toArray(new String[reader.getLines().size()]);
      
    // TOKENIZE BY SPACES AND COLONS
    int i = 1;
    for(String line: txtLines) {
      diceStrings = line.split(" ");

      for(String die: diceStrings) {
        diceFields = die.split(":");  
        //  DETERMINE THE TYPE OF DIE AND CREATE NEW DIE OBJECT USING TYPE GIVEN
        Integer sides;
        Integer loadedSide;
        switch (diceFields[1]) {
          case "numbered":
            sides = Integer.parseInt(diceFields[0]);
            dieList.add(new NumberedDie(sides));
            break;
          case "fudge":
            sides = Integer.parseInt(diceFields[0]);
            dieList.add(new FudgeDie(sides));
            break;
          default:
            sides = Integer.parseInt(diceFields[0]);
            loadedSide = Integer.parseInt(diceFields[2]);
            dieList.add(new LoadedDie(sides, loadedSide));
            break;
        } //  end switch
      } //  end foreach die loop
      
      //  CREATE NEW DIE TOWER OBJECT AND ROLL DICE GROUPED BY LINE
      DiceTower tower = new DiceTower(dieList);
      tower.dropDice();
      FileWriter diceRolledFile;
   
      try {
        diceRolledFile = new FileWriter("diceRolled.txt", true);
        PrintWriter file = new PrintWriter(diceRolledFile);
        for(Die die : dieList) {
          file.print(die.getType() + ":" + die.getSides() +";" +
                die.getValue() + "\t");
        }
        file.println(" ");
        diceRolledFile.close();
      } catch (IOException ex) {
        Logger.getLogger(Assignment9Strings.class.getName()).log(Level.SEVERE, null, ex);
      } 
      i++;
      //after printing row to the file, empty list for next row
      dieList.removeAll(dieList);
    } // end foreach line loop
    
    //test file output by opening file and printing contents to console
    test_file("diceRolled.txt");
  } // end of main method
  
  public static void test_file(String filePath){
    DiceFileReader testFile = new DiceFileReader(filePath);
    testFile.read();
    for(String diceLine: testFile.getLines()) {
      System.out.println(diceLine);
    }
  }
}   //end of class