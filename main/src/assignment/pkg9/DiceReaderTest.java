/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg9;

import java.util.ArrayList;
import java.util.List;
import dice.DiceTower;
import dice.Fudge;
import dice.Loaded;

/**
 *
 * @author Paul Scarrone
 */
// This test passes now and gives an example of how your file should work
// Once you are done with reading and calculating dice you will need to update
// this test to pass again
public class DiceReaderTest {

  public static void test_reader() {
    DiceFileReader diceReader = new DiceFileReader("./dice.txt");
    diceReader.read();

    List<String> lines = new ArrayList<>();
    lines = diceReader.getLines();

    //int trayValue = 0;
    
    // break the file down by line
    for (int i = 0; i < lines.size(); i++) {
      int trayValue = 0;
      
      System.out.println("Tray #" + (i + 1) + ":");
      String[] fileLine = lines.get(i).split(" ");

      // seperate the file's line into die
      for (int ii = 0; ii < fileLine.length; ii++) {
        String[] dieConfig = fileLine[ii].split(":");

        int numberOfSides = Integer.parseInt(dieConfig[0]);
        String dieType = dieConfig[1];
        
        // if "loaded" - load the die
        int loadedSide = 0;
        if (dieType.equals("loaded")){
          loadedSide = Integer.parseInt(dieConfig[2]);
        }

        switch (dieType) { 
          case "numbered":
            dice.NumberedDie numberedDie = new dice.NumberedDie(numberOfSides);
            numberedDie.roll();
            int numberedDieValue = numberedDie.getValue();
            trayValue += numberedDieValue;
            System.out.println("Numbered die roll: " + numberedDieValue);
            break;
          case "loaded":
            dice.Loaded loaded = new dice.Loaded();
            trayValue += loadedSide;
            System.out.println("Loaded die roll: " + loadedSide);
            break;
          case "fudge":
            dice.Fudge fudge = new dice.Fudge(numberOfSides);
            fudge.roll();
            int fudgeDieValue = fudge.getValue();
            trayValue += fudgeDieValue;
            System.out.println("Fudge die roll: " + fudgeDieValue);
            break;

        }
      }
        
      System.out.println("Total this tray: " + trayValue + "\n");
      
    }
  }
}
