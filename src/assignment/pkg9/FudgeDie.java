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

 
 public class FudgeDie implements Die {
   private final int sides; //of die
   private final int value; // of roll
   private final String type = "fudge";
 
   public FudgeDie(Integer sides) {
     this.sides = sides;
     this.value = 0;
   }
 
   @Override
   public int getValue() {
     return value;
   }
     
  public String getType() {
    return type;
  }

  public int getSides() {
    return sides;
  }
  
   @Override
   public void roll() {
    
}
 }
