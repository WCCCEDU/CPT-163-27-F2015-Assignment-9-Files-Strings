package dnddiceroller;

import assignment.pkg9.DiceFileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Paul Scarrone
 */
public class DnDDiceRoller {

  /**
   * Try out your dies and dice tower
   * @param args the command line arguments
   */
  public static void main(String[] args) throws FileNotFoundException {
	for(int i = 0; i< 1000; i++){
	  int d6 = test_oneD6();
	  if(d6 != -1){
		System.out.println("Die Test Failed with Value: " + d6);
	  }
	  int tower = test_diceTowerWithTwoD6();
	  if(tower != -1){
	System.out.println("Tower Test Failed with Value: " + tower);
	  }
          DiceFileReader diceReader = diceReader = new DiceFileReader("./dice.txt");
	}
        File temp = new File ("dice.txt");
        Scanner file = new Scanner (temp);
        
       while(file.hasNext()){
           String s = file.nextLine().trim();
           System.out.println(s);
       }


        
        
  }
  
  public static int test_oneD6(){
	NumberedDie die = new NumberedDie(6);
	die.roll();//method
	int dieValue = die.getvalueOfDie(); 
	if(dieValue >= 1 && dieValue <= 6){
	  return -1; // Means the die value is outside its bounds for a d6
	}else{
	  return dieValue;
	}
        

  }
  
  public static int test_diceTowerWithTwoD6(){
	List<NumberedDie> dice = new ArrayList();//declaring an array list
	dice.add(new NumberedDie(6));
	dice.add(new NumberedDie(6));
	DiceTower tower = new DiceTower(dice);//new dicetower value to dice
	tower.dropDice();//drop dice method access class
	int trayValue = tower.getTrayValue();//getting the valye of tray
	if(trayValue >= 2 && trayValue <= 12){
	  return -1; // means the die value is outside the bounds of 2 d6
	}else{
	  return trayValue; //return the value of trayvalue if if statement is false. else
	}
  }
  
}
