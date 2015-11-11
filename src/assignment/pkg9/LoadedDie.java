
package assignment.pkg9;
import java.util.Random;

public class LoadedDie implements Die {
  private final int sides;
  private int value;
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

  @Override
  public int getSides() {
    return sides;
  }

  public int getTargetValue() {
    return targetValue;
  }

  @Override
  public String getType() {
    return type;
  }
  
  @Override
  public void roll() {
    //roll onces, then if the value is not already the desired value, give  up
    //to 3 more tries to reach it, weighing that outcome more heavily
    this.value = (new Random()).nextInt(this.sides) + 1;
    for(int i = 0; i < 3; i++) {
      if(this.value != this.targetValue) {
        this.value = (new Random()).nextInt(this.sides) + 1;
      }
    }
  } //end roll method
} //end class
