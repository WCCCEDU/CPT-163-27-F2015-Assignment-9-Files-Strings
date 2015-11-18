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
 * @author Katrina Siffrinn
 */
public class DiceTower {
       
  //fields
  private final int PANEL_COUNT = 3;
  private final List<Die> dice;
  private int trayValue;

 
   //constructors accept values for fields. 
    public DiceTower() {
        this.dice = new ArrayList();
        this.trayValue = 0;
   }
  
    /**
     * 
     * @param dice 
     */
    public DiceTower(List dice) {
        this.dice = dice;
        this.trayValue = 0;
  }
    
  /**
   * accessors return values to fields.
   * @return the value of trayValue.
   */
    public int getTrayValue(){
      return this.trayValue;
  }
  
  //dropDice method simulates die being dropped into a dice tower.
  public void dropDice(){
      int i = 0;
      this.dice.stream().forEach((die) -> {
          die.roll();
      });
  }
  
  
public void trayResults(){
    this.dice.stream().map((die) -> {
        this.trayValue += die.getValue();
        return die;
      }).forEach((_item) -> {
          trayResults();
      });
}
}

 


