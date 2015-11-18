package assignment.dnddiceroller;

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

  public DiceTower() {
	this.dice = new ArrayList();
  }
  
  public DiceTower(List dice) {
	this.dice = dice;
  }

  public void dropDice() {
        for (int i = 0; i < PANEL_COUNT; i++) {
            for (int j = 0; j < dice.size(); j++) {
                Die temp = dice.get(j);
                temp.roll();
            }
        }
    }

  public int trayValue() {
      int totalValue = 0;
      for (int i = 0; i < dice.size(); i++) {
          Die temp = dice.get(i);
          totalValue = totalValue + temp.value();
          
      }
      return totalValue;
    }
}
