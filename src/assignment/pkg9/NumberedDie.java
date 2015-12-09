package assignment.pkg9;

import java.util.Random;

/**
 * A Die is a many sided object that when rolled provides a random value from
 * 1 through the number of sides on the object. Some dice are 6 sided and have
 * the numbers 1-6 on them. Some dice are 20 sided with the numbers 1-20 on them.
 * Others are called fudge dice and have the values of -1 0 or +1
 * @author Paul Scarrone
 */
public class NumberedDie implements Die {
    
  //requried fields
  private int dieSize; //number of sides the dice has (d6, d8, d20, etc.)
  private int result; //result rolled

  /**
   *Die Constructor
   * 
   * @param dieSize
   */
  public NumberedDie(int dieSize){
    this.dieSize = dieSize;
    this.result = 0;
  }
  
  //acquries the possible die results
  public int getDieSize(){
    return this.dieSize;
  }
  
  //returns the die's result
  @Override
  public int getResult(){
    return this.result;
  }
  
  //roll method used to roll a single die
    @Override
  public void roll() {
    Random randomRoll = new Random();
    this.result = randomRoll.nextInt(this.dieSize) + 1;
  }
  
}
