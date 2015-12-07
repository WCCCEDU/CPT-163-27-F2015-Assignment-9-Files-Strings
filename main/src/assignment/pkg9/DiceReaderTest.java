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
 * @author Gary A. Newsome
 * @author Paul Scarrone
 */
// This test passes now and gives an example of how your file should work
// Once you are done with reading and calculating dice you will need to update
// this test to pass again
public class DiceReaderTest {

  public static void test_reader() {
    DiceFileReader diceReader = new DiceFileReader("./dice.txt");
    diceReader.read();
  
    // tests the file can be opened.
    // If there was another purpose, I am not sure.
  }
}
