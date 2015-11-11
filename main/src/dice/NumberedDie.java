package dice;

import java.util.Random;

/**
 * A Die is a many sided object that when rolled provides a random value from 1
 * through the number of sides on the object. Some dice are 6 sided and have the
 * numbers 1-6 on them. Some dice are 20 sided with the numbers 1-20 on them.
 * Others are called fudge dice and have the values of -1 0 or +1
 *
 * @author Paul Scarrone
 */
public class NumberedDie implements Die {

  // fields/declarations
  private int numberSides;    // holds the number of sides the die has
  private int value;   // holds the value of the current roll

  /**
   * constructor
   *
   * @param numberSides
   * @param value
   */
  public NumberedDie(int numberSides) {
    this.numberSides = numberSides;
    this.value = 0;
  }

  public int getNumberSides() {
    return this.numberSides;
  }

  @Override
  public int getValue() {
    return this.value;
  }

  /**
   * roll method uses a random number to simulate the roll of a single die
   */
  @Override
  public void roll() {
    Random randomNumbers = new Random();
    this.value = randomNumbers.nextInt(this.numberSides) + 1;
  } // end roll method

} // end NumberedDie.java
