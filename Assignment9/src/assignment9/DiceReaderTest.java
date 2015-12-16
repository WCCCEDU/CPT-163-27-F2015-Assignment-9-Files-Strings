/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment9;

import java.io.IOException;

/**
 *
 * @author mkavic
 */
public class DiceReaderTest {
   public static void test_reader() throws IOException{
	DiceFileReader diceReader = new DiceFileReader("dice.txt");
	diceReader.read();
	System.out.println(diceReader.getLines().toString().equals("[]"));
  } 
}
