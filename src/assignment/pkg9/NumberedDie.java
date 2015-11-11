
package assignment.pkg9;

import java.util.Random;

public class NumberedDie implements Die {
  private int sides;
  private int value;
  private final String type = "numbered";

  public NumberedDie(int sides) {
    this.sides = sides;
  }

  @Override
  public int getValue() {
    return value;
  }

  @Override
  public int getSides() {
    return sides;
  }

  @Override
  public String getType() {
    return type;
  }
    
  //add one to offset the starting point at zero
  @Override
  public void roll() {
    this.value = (new Random()).nextInt(this.sides) + 1; 
  }
}