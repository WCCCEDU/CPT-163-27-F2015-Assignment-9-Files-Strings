package dnddiceroller;

import java.util.ArrayList;
import java.util.List;

/**
 * Dice Tower.
 * A Dice Tower is a tool used by serious gamers to roll many dice at once.
 *
 * An instance of a dice tower is defined by 
 *      the number of panels it contains to help provide a regular
 *      distribution of die values.
 * 
 * The die bounce from panel to panel until they exit the dice tower
 * at the bottom of they tray.
 * 
 * A dice tower will accept a collection of dice and report their results
 * when they reach the tray at the bottom
 *
 * @author Rhonda Marshall
 * Nov 9, 2015
 */
public class DiceTower {
    final int PANEL_COUNT = 3;          // number of sides on dice tower
    private int trayValue;              // total of dice in the tray
    
    /**
     * The dice array will hold Die reference variables
     * The array will be used to reference NumberedDie, Fudge,
     * and Loaded objects.
     * The NumberedDie, Fudge, and Loaded classes implement the Die interface and
     * because of the established interface inheritance I can reference these
     * by using the Die reference variable
     * 
     * Because Die is an interface variable that references an object
     * I can only use the it to call the methods in the interface
     */
    
    List<Die> dice;
   
    /**
     * DiceTower constructors
     * 
     */
    public DiceTower() {
        this.dice = new ArrayList();
        this.trayValue = 0;
    }
    
    public DiceTower(List dice) {
            this.dice = dice;
            this.trayValue = 0;
    }
    
    /**
     * getTrayValue accessors method
     * 
     * @return trayValue 
     */
    public int getTrayValue() {
        
        return this.trayValue;
        
    }  // getTrayValue method
     
    /**
     * dropDice method will roll each die, the number of panels that are
     * in the dice tower
     * 
     * accumulate the trayValue
     */    
    public void dropDice() {
        // for each of the die in the array
        for (int i = 0; i < this.dice.size(); i++) {
            // roll the dice the number of panels in the tower, PANEL_COUNT
            for (int j = 0; j < PANEL_COUNT; j++)
                this.dice.get(i).roll();
           
            /**
             * I am using the instanceof Operator to determine the class
             * of a an object in the dice array
            
     
            int value = this.dice.get(i).getValue();
            if (this.dice.get(i) instanceof NumberedDie)
                System.out.printf("Numbered Dice (is a Die) %d\n", value);
            else if (this.dice.get(i) instanceof Fudge)
                System.out.printf("Fudge Dice (is a Die) %d\n", value);
            else
                System.out.printf("Loaded Dice (is a Die) %d\n", value);
            
            */
            
            this.trayValue += this.dice.get(i).getValue();
        }    
        
    } // dropDice method
    
} // DiceTower class





