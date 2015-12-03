/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import assignment.pkg9.DiceFileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gary
 */
public class main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // test the file to open exists
    assignment.pkg9.DiceReaderTest.test_reader();

    // read the file by line
    DiceFileReader diceReader = new DiceFileReader("./dice.txt");
    diceReader.read();

    // create and open an outputfile
    FileWriter rolledDice = null;
    PrintWriter outputFile = null;
    try {
      rolledDice = new FileWriter("RolledDice.txt", true);
      outputFile = new PrintWriter(rolledDice);
    } catch (IOException ex) {
      Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
    }
    // create an array list and store the lines from the file in the list
    List<String> lines = new ArrayList<>();
    lines = diceReader.getLines();

    // tokenize the file first by 'space' then by ':'
    for (int i = 0; i < lines.size(); i++) {
      int trayValue = 0;

      System.out.println("Tray #" + (i + 1) + ":");
      outputFile.println("Tray #" + (i + 1) + ":");
      String[] fileLine = lines.get(i).split(" ");

      // seperate the file's line into die
      for (int ii = 0; ii < fileLine.length; ii++) {
        String[] dieConfig = fileLine[ii].split(":");

        int numberOfSides = Integer.parseInt(dieConfig[0]);
        String dieType = dieConfig[1];

        // if "loaded" - load the die
        int loadedSide = 0;
        if (dieType.equals("loaded")) {
          loadedSide = Integer.parseInt(dieConfig[2]);
        }

        switch (dieType) {
          case "numbered":
            dice.NumberedDie numberedDie = new dice.NumberedDie(numberOfSides);
            numberedDie.roll();
            int numberedDieValue = numberedDie.getValue();
            trayValue += numberedDieValue;
            System.out.println("Numbered die roll: " + numberedDieValue);
            outputFile.println("Numbered die roll: " + numberedDieValue);
            break;
          case "loaded":
            dice.Loaded loaded = new dice.Loaded();
            trayValue += loadedSide;
            System.out.println("Loaded die roll: " + loadedSide);
            outputFile.println("Loaded die roll: " + loadedSide);
            break;
          case "fudge":
            dice.Fudge fudge = new dice.Fudge(numberOfSides);
            fudge.roll();
            int fudgeDieValue = fudge.getValue();
            trayValue += fudgeDieValue;
            System.out.println("Fudge die roll: " + fudgeDieValue);
            outputFile.println("Fudge die roll: " + fudgeDieValue);
            break;

        }
      }

      System.out.println("Total this tray: " + trayValue + "\n");
      outputFile.println("Total this tray: " + trayValue + "\n");

    }
    try {
      rolledDice.close();
    } catch (IOException ex) {
      Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
    }

  }
}
