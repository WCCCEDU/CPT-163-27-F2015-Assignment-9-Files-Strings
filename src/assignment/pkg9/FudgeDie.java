package assignment.pkg9;
import java.util.Random;
/**
 *
 * @author Katrina
 */

public class FudgeDie implements Die{
    
    // fields
  private final int sides;    
  private int value;      
   
    //constructor
    public FudgeDie(int sides){
      this.sides = sides;
      this.value = 0;
  }
           
    /**
     * accessors
     * @return
     */
      @Override
  public int getValue() {
    return this.value;
  }
   
    //roll method 
  @Override
  public void roll() {
    Random rand = new Random();
    this.value = rand.nextInt(3) - 1;
  } 

} 
 

