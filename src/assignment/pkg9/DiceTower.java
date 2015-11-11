package assignment.pkg9;

import java.util.ArrayList;
import java.util.List;

/**
 *@author Paul Scarrone
 * @author Samantha Shurie
 */
public class DiceTower {
  final int PANEL_COUNT = 3;
  List<Die> diceList;
  int trayValue;

  public DiceTower() {
    this.diceList = new ArrayList();
    trayValue = 0;
  }

  public DiceTower(List diceList) {
    this.diceList = diceList;
    trayValue = 0;
  }

  public int getTrayValue() {
    return trayValue;
  }

  public void dropDice() {
    int i = 0;
    for (Die die : diceList){
      for(int n = 0; n < PANEL_COUNT; n++) {
          diceList.get(i).roll();
      }
      trayValue += diceList.get(i).getValue();
      i++;
    }   
  } 
}
