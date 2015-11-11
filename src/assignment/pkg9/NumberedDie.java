
package assignment.pkg9;

import java.util.Random;

public class NumberedDie implements Die {
  private int sides;
  private int value;

    public NumberedDie(int sides) {
        this.sides = sides;
    }

  @Override
    public int getValue() {
        return value;
    }
    
    //add one to offset the starting point at zero
  @Override
    public void roll() {
        this.value = (new Random()).nextInt(this.sides) + 1; 
    }
}
