package assignment.pkg9;

import java.util.ArrayList;
import java.util.List;

/**
 * Dice Tower.
 * A Dice Tower is a tool used by serious gamers use to roll many dice at once.
 * It looks like this:
 * https://www.miniaturescenery.com/Images/PortableDiceTowerLarge.jpg
 * An instance of a dice tower is defined by the number panels it
 * contains to help provide a more regular distribution of die values.
 * The die bounce from panel to panel until they
 * exit the dice tower at the bottom tray.
 * A dice tower will accept a collection of dice and reports their results when
 * they reach the tray at the bottom
 * @author Paul Scarrone
 */
public class DiceTower {
  private final int PANEL_COUNT = 3; //number of panels in the dice tower
  private int trayValue;  //combined value of rolled dice
  private List<NumberedDie> dice;

  public DiceTower() {
	this.dice = new ArrayList();
        this.trayValue = 0;
  }
  
  public DiceTower(List dice) {
	this.dice = dice;
        this.trayValue = 0;
  }
  
  public int getTrayValue() {
    return this.trayValue;
  }
  
  //rolls each dice three times using the
  //roll method from the Die class
  public void DropDice(){
    for (int currentDie = 0; currentDie < dice.size(); currentDie++) {      
      for (int p = 0; p < PANEL_COUNT; p++) {
        this.dice.get(currentDie).roll();
      }
      trayValue += this.dice.get(currentDie).getResult();
    }
  }
}
