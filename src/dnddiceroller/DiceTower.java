package dnddiceroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
  private final int PANEL_COUNT = 3;
  private int tray;
  private List<Die> dice;

  public DiceTower() {
	this.dice = new ArrayList();
        this.tray = 0;
  }
  
  public DiceTower(List dice) {
	this.dice = dice;
        this.tray = 0;
  }
  
  public void dropDice(){    
      for(int sides = 0; sides < this.PANEL_COUNT; sides++){
        for(Die droppedDie: this.dice){
              droppedDie.roll();
          }
      }
  }
  
  /**
   * Returns the value of all dice in the tray
   * @return Tray Value
   */
  public int trayValue(){
      this.tray = 0;    
      for(Die die: dice){
          this.tray += die.value();
      }    
      return this.tray;
  }
          
}
