/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import assignment.pkg9.DiceFileReader;

/**
 *
 * @author Gary
 */
public class main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    DiceFileReader diceReader = new DiceFileReader("./dice.txt");
    diceReader.read();
    
    assignment.pkg9.DiceReaderTest.test_reader();

  }
}
