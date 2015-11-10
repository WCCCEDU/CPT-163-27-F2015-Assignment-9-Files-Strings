/*
 * CPT 163_27 Java Programming 1
 * Westmoreland County Community College
 * Assignment 8 Die Interface
 */
package dice;

/**
 * A Die is a many sided object that when rolled provides a random value from
 * 1 through the number of sides on the object. Some dice are 6 sided and have
 * the numbers 1-6 on them. Some dice are 20 sided with the numbers 1-20 on them.
 * Others are called fudge dice and have the values of -1 0 or +1
 * @author Paul Scarrone
 * @author garyanewsome
 */
public interface Die {
  public void roll();
  public int getValue();
}
