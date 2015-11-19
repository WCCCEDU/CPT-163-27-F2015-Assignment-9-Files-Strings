/*
 * Loaded die.roll class
 * Uses a Random number to generate whether the roll will be fair or give the
 * loaded result.
 */
package dice;

import java.util.Random;

/**
 *
 * @author Gary
 */
public class Loaded implements Die {

  // fields/declarations
  private int numberSides;    // holds the number of sides the die has
  private int value;          // holds the value of the current roll
  private int loadedChance;   // variable used to determine if we use a
                              // standard roll, or return the loaded number

  /**
   * constructor
   *
   * @param numberSides
   * @param value
   */
  public Loaded() {
    this.numberSides = 6;
    this.value = 0;
    this.loadedChance = 2;
  }

  public int getNumberSides() {
    return this.numberSides;
  }

  public int getValue() {
    return this.value;
  }

  public int getLoadedChance() {
    return loadedChance;
  }

  /**
   * determineRoll method determines the path of our loaded dice
   */
  public int determineRoll() {
    // Randomlly generate a 0 or a 1 to determine if we roll
    // or return a loaded number
    Random randomNumbers = new Random();
    int chance = randomNumbers.nextInt(this.loadedChance);
    return chance;
  } // end determineRoll method

  /**
   * roll method determines the path of our loaded dice
   */
  
  @Override
  public void roll() {
    Random randomNumbers = new Random();
    this.value = randomNumbers.nextInt(this.numberSides) + 1;
  } // end roll method

} // end Loaded.java

