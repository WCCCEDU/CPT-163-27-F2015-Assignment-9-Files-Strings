/**
 * A new version of the Dice Tower assignment, this program uses a dice interface
 * and implements two types of die objects from the interface.
 */
package assignment.pkg9;

import static assignment.pkg9.DiceReaderTest.test_reader;
import java.util.ArrayList;

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
      test_output(tower, i);
      i++;
      dieList.removeAll(dieList);
    } // end foreach line loop
  } // end of main method
  
  public static void test_output(DiceTower tower, int line){
    System.out.print("Group " + line + ": \n\t");
    for(Die rolledDie : tower.diceList) {
      String type = rolledDie.getClass().toString();
      System.out.print(rolledDie.getValue() + " ");
      }
      System.out.println("  ");
  }
    
  // tests the dice tower class
 /* public static int test_diceTowerWithTwoD6(){
    int trayValue = tower.getTrayValue();
    if(trayValue >= 2 && trayValue <= 12){
      return -1; // means the die value is inside the bounds of 2 d6
    }else{
      return trayValue;
    }
  } */  //end of dice tower method
}   //end of class