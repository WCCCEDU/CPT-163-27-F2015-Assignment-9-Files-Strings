/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg9;

/**
 *
 * @author Katrina
 */
public class DriverFileReader {
    
    public static void main(String[] args) {
    DiceFileReader reader = new DiceFileReader("dice.txt");
      reader.read();
	for(String line : reader.getLines()){
	  DiceTower dt = new DiceTower();
	    for(String dieType : line.split(" ")){
	      String[] die = dieType.split(":");
	      dt.addDice(new NumberedDie(Integer.parseInt(die[0])));
	  }
	  dt.dropDice();
	  System.out.println(dt.getTrayValue());
	}
}
}
