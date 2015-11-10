package dnddiceroller;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;

/**
 * Dice Tower.
 * A Dice Tower is a tool used by serious gamers use to roll many dice at once.
 * It looks like this https://www.miniaturescenery.com/Images/PortableDiceTowerLarge.jpg
 * An instance of a dice tower is defined by the number panels it contains to help
 * provide a more regular distribution of die values. The die bounce from panel to
 * panel until they exit the dice tower at the bottom tray.
 * A dice tower will accept a collection of dice and reports their results when
 * they reach the tray at the bottom
 * @author Paul Scarrone
 */
public class DiceTower {
  final int PANEL_COUNT = 3;
  private int trayValue;
  private List<Die> dice;

    public DiceTower(int trayValue, List<Die> dice) {
        this.trayValue = trayValue;
        this.dice = dice;
    }
  

  

  
  //for loop in this
  public void dropDice(){
      for(int i=0; i<this.dice.size();i++){
          this.dice.get(i).rollDice();
      }
          
  }
  
  //consturctor for variables out of array list function
  public DiceTower(List dice) {
	this.dice=dice;
        
  }
  
  
  //this will retunr the value of trayValue
  public int getTrayValue(){
      return trayValue;
  }
  
  
  }
  
  
