/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg9;

import java.util.ArrayList;
import java.util.List;
import dice.DiceTower;

/**
 *
 * @author Paul Scarrone
 */
// This test passes now and gives an example of how your file should work
// Once you are done with reading and calculating dice you will need to update
// this test to pass again
public class DiceReaderTest {

  public static void test_reader() {
    DiceFileReader diceReader = new DiceFileReader("dice.txt");
    diceReader.read();

    List<String> lines = new ArrayList<>();
    lines = diceReader.getLines();

    int trayValue = 0;
    
    // break the file down by line
    for (int i = 0; i < lines.size(); i++) {
      System.out.println("Tray #" + (i + 1) + " = ");
      String[] fileLine = lines.get(i).split(" ");

      // seperate the file's line into die
      for (int ii = 0; ii < fileLine.length; ii++) {
        String[] dieConfig = fileLine[ii].split(":");

        int numberOfSides = Integer.parseInt(dieConfig[0]);
        String dieType = dieConfig[1];
        
        int loadedSide = 0;
        if (dieType.equals("loaded")){
          loadedSide = Integer.parseInt(dieConfig[2]);
        }

        switch (dieType) { // to be facied up once working
          case "numbered":
            dice.NumberedDie die = new dice.NumberedDie(numberOfSides);
            die.roll();
            trayValue += die.getValue();
            break;
          case "loaded":
            trayValue += loadedSide;
            break;
          case "fudge":
            trayValue += 0;
            break;

        }
      }
    }
    // System.out.println(diceReader.getLines().toString().equals("[]"));
    System.out.println(trayValue);
  }
}
