package dnddiceroller;


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
  final int PANEL_COUNT = 3; //number of panels in dice tower
  List<Die> dice;            //list of diced to be dropped into tower
  private int trayValue;     //total value of all dice dropped

  public DiceTower() {
	this.dice = new ArrayList();
        this.trayValue = 0;
  }
  
  public DiceTower(List dice) {
	this.dice = dice;
        this.trayValue = 0;
  }
  
  public void dropDice(){
      
      //iterates through list of dice
      for(int i = 0; i < this.dice.size(); i++){
          //effectively rolls said dice once for every panel
          //thereby further randomizing result
          for(int x = 0; x < this.PANEL_COUNT; x++){
            this.dice.get(i).roll();
          }
          this.trayValue += this.dice.get(i).getValue();
      }
  }
  
  public int trayValue(){return this.trayValue;}
}