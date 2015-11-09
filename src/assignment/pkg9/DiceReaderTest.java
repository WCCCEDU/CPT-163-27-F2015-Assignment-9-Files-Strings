/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg9;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paul Scarrone
 */

// This test passes now and gives an example of how your file should work
// Once you are done with reading and calculating dice you will need to update
// this test to pass again
public class DiceReaderTest {
  public static void test_reader(PrintWriter outputFile){
        List<Die> dice = new ArrayList();
	DiceFileReader diceReader = new DiceFileReader("dice.txt");
	diceReader.read();
        String[] fileDice = diceReader.getLines().toString().split(" ");
        for(String dieValue : fileDice){
            int firstColon = dieValue.indexOf(":");
            int secondColon = dieValue.lastIndexOf(":");
            int firstBracket = dieValue.indexOf("[");
            int lastBracket = dieValue.lastIndexOf("]");
            int lastComma = dieValue.lastIndexOf(",");
            String sideValue = "";
            String loadedValue = "";
            if(firstColon != secondColon){
                if (firstBracket > -1){
                    if(firstColon > -1){
                    sideValue = dieValue.substring(firstBracket + 1, firstColon);
                    }
                }else{
                    sideValue = dieValue.substring(0, firstColon);
                }
                if(lastBracket > -1 || lastComma > -1){
                    loadedValue = dieValue.substring(secondColon + 1, dieValue.length() -1);
                }else{
                    loadedValue = dieValue.substring(secondColon + 1, dieValue.length());
                }
                dice.add(new Loaded (Integer.parseInt(sideValue), Integer.parseInt(loadedValue)));
            }else{
                if(dieValue.endsWith("fudge") || dieValue.endsWith("fudge,")){
                    if (firstBracket > -1){
                    if(firstColon > -1){
                    sideValue = dieValue.substring(firstBracket + 1, firstColon);
                    }
                }else{
                    sideValue = dieValue.substring(0, firstColon);
                }
                    dice.add(new Fudge(Integer.parseInt(sideValue)));
                }else{
                    if (firstBracket > -1){
                    if(firstColon > -1){
                    sideValue = dieValue.substring(firstBracket + 1, firstColon);
                    }
                }else{
                    sideValue = dieValue.substring(0, firstColon);
                }
                    dice.add(new NumberedDie(Integer.parseInt(sideValue)));
                }
            }
            DiceTower tower = new DiceTower(dice);
            tower.dropDice();
            outputFile.println(tower.getTrayValue());
        }
  }
}
