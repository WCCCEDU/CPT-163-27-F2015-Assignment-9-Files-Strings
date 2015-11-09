/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg9;

import java.util.Random;

/**
 *
 * @author Seth Frosch
 */
public class Loaded implements Die {
  private int side; //Number of sides on the die
  private int value; //Value of the side
  private int loadedSide; //Value of the side that you want to roll
  
  //Constructor for Loaded class accepts int value for number of sides and
  //loaded side
  public Loaded(int side, int loadedSide){
      this.side = side;
      this.loadedSide = loadedSide;
  }
  
  //Accessor to get value field
  @Override
  public int getValue(){
      return value;
  }
  
  /**
   * @param roll method assigns random int number to value field by adding 1 to 
   * get value between 1 and number of sides but continues to roll if the value
   * is not the loaded side
   */
  @Override
  public int roll(){
      Random rand = new Random();
      this.value = rand.nextInt(this.side) + 1;
      while(this.value!=this.loadedSide){
          this.value = rand.nextInt(this.side) + 1;
      }
      return this.value;
  }
}
