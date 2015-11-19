/*
 * Fudge dice roll method
 */
package dice;

import java.util.Random;

/**
 *
 * @author Gary
 */
public class Fudge implements Die {

  // fields/declarations
  private int numberSides;    // holds the number of sides the die has
  private int value;          // holds the value of the current roll

  /**
   * constructor
   *
   * @param numberSides
   * @param value
   */
  public Fudge(int numberSides) {
    this.numberSides = numberSides;
    this.value = 0;
  }

  public int getNumberSides() {
    return this.numberSides;
  }

  public int getValue() {
    return this.value;
  }

  /**
   * roll method determines the Fudge dice outcome
   */
  @Override
  public void roll() {
    if (numberSides == 6){
      Random randomNumbers = new Random();
      this.value = randomNumbers.nextInt(this.numberSides / 2) - 1;
    } else {
      Random randomNumbers = new Random();
      this.value = randomNumbers.nextInt(3) - 1;
    }
    
  } // end roll method
  
} // end Fudge.java

