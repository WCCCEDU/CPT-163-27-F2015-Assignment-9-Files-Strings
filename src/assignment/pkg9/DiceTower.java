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
  private List<Die> dice;
  private int trayValue;

 
   //constructors accept values for fields. 
    public DiceTower() {
        this.dice = new ArrayList();
        this.trayValue = 0;
   }
    public DiceTower(List dice){
        this.dice = dice;
        this.trayValue = 0;
    }
    
    /**
     *
     * @return trayValue: sum of dice in tray.
     */
    public int getTrayValue(){
    return this.trayValue;
    }
    
    public void addDice(Die die){
        this.dice.add(die);
    }
        
    //dropDice method simulates die being dropped into a dice tower.
    public void dropDice(){
      for(int i = 0; i < this.PANEL_COUNT; i++){
        this.dice.stream().forEach((die) -> {
          die.roll();
      });
      }      
  
    this.dice.stream().forEach((die) -> {
        this.trayValue += die.getValue();   
        });
}
}
      



 


