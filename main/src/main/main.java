/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import assignment.pkg9.DiceFileReader;
import dice.DiceTower;
import dice.Die;
import dice.NumberedDie;
import java.util.List;

/**
 *
 * @author Gary
 */
public class main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    DiceFileReader reader = new DiceFileReader("./dice.txt");
	reader.read();
	for(String line : reader.getLines()){
	  DiceTower dt = new DiceTower();
	  for(String dieDef : line.split(" ")){
		String[] die = dieDef.split(":");
		dt.addDice(new NumberedDie(Integer.parseInt(die[0])));
	  }
	  dt.dropDice();
	  System.out.println(dt.getTrayValue());
	}
	/*dt.addDice(new NumberedDie(6));
	dt.addDice(new NumberedDie(8));
	dt.addDice(new NumberedDie(10));
	dt.addDice(new NumberedDie(2));
	dt.addDice(new NumberedDie(20));*/
  }
}
