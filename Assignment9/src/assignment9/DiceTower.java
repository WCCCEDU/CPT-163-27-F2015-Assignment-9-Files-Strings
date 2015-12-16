/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment9;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mkavic
 */
public class DiceTower {
  final private int PANNELS = 5;
    final private List<NumberedDie> dice;
    final private int trayValue;
      
    int[] rolls = new int[PANNELS];
    
     public DiceTower() {
        this.dice = new ArrayList(); // 
        this.trayValue = 0;
    }

    public DiceTower(List dice) {
        this.dice = dice; // 
        this.trayValue = 0;
    }
     
   public void dropDice()
   {
       for (int index = 0; index < PANNELS; index ++ )
       {
        NumberedDie die = new NumberedDie(6);
	die.roll(); 
        rolls[index] = die.value();
       }
       
       
   }
   
   public int trayValue( )
   {
       int sum = 0;
       for (int i =0; i<rolls.length; i++)
       {
           sum += i;
       }
       return sum;
   }   
}
    

  

