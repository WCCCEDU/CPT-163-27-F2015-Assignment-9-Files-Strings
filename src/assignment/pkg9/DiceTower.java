package assignment.pkg9;

import java.util.ArrayList;
import java.util.List;

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
        List<Die> dice;
        int trayValue;

  public DiceTower() {
	this.dice = new ArrayList();
        trayValue = 0;
  }
  
  public DiceTower(List dice) {
	this.dice = dice;
        trayValue = 0;
  }

  public int getTrayValue() {
        return trayValue;
  }
  
  
  /**
   * Utilizes the roll() method per the number of panels in the dice tower.
   */
  public void dropDice() {
        int i = 0;
        for (Die die : dice){
            for(int x = 0; x < PANEL_COUNT; x++){
                dice.get(i).roll();
            }
            trayValue += dice.get(i).getValue();
            i++;
        }
  }
  
  
}

