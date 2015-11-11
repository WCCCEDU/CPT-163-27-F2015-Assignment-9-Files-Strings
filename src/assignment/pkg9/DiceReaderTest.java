/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg9;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paul Scarrone
 */

// This test passes now and gives an example of how your file should work
// Once you are done with reading and calculating dice you will need to update
// this test to pass again
public class DiceReaderTest {
  public static void test_reader() throws FileNotFoundException{
	DiceFileReader diceReader = new DiceFileReader("./dice.txt");
	diceReader.read();
        
        PrintWriter writer = new PrintWriter("./results.txt");
        
        List<String> basicFile = new ArrayList<>();
        basicFile = diceReader.getLines();
        for (int i = 0; i < basicFile.size(); i++){
            String[] fileLine = basicFile.get(i).split(" ");
            
            for (int x = 0; x < fileLine.length; x++){
                String[] indivDie = fileLine[x].split(":");
                
                int sides = Integer.parseInt(indivDie[0]);
                String type = indivDie[1];
                int loadedSides = 0;
                
                if (type.equals("loaded")){
                    loadedSides = Integer.parseInt(indivDie[2]);
                    Loaded loadedDie = new Loaded(sides, loadedSides);
                    loadedDie.roll();
                    writer.write(fileLine[i] + ": Loaded, " + loadedDie.getValue());
                }else if (type.equals("numbered")){
                    NumberedDie numberedDie = new NumberedDie(sides);
                    numberedDie.roll();
                    writer.write(fileLine[i] + ": Numbered, " + numberedDie.getValue());
                }else if (type.equals("fudge")){
                    Fudge fudgedDie = new Fudge(sides);
                    fudgedDie.roll();
                    writer.write(fileLine[i] + ": Fudge, " + fudgedDie.getValue());
                }
                
            }
            writer.close();
	
        }
        System.out.println(diceReader.getLines().toString().equals("[]"));
    }
}
