/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg9;

/**
 *
 * @author Katrina
 */

 
 public class LoadedDie implements Die {
   private final int sides; // of die
   private int value; // of roll
   private int targetValue;
   private final String type = "loaded";
   
   public LoadedDie(int sides, int loaded) {
     this.sides = sides;
     this.value = 1;
     this.value = loaded;
   }
 
   @Override
   public int getValue() {
     return this.value;
   }

  public int getSides() {
    return sides;
  }

  public int getTargetValue() {
    return targetValue;
  }

  public String getType() {
    return type;
  }
   
   @Override
   public void roll() {
    
}
 }   
     