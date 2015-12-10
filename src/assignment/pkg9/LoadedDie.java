package assignment.pkg9;
import java.util.Random;

/**
 *
 * @author Katrina
 */
public class LoadedDie implements Die{
    
    //fields
    private final  int side;
    private int value;
    private int loadedSide;
    
    /**
     * constructor
     * @param sides is the number of sides on the die
     * @param loadedSide is the weighted value
     */
    public LoadedDie(int sides, int loadedSide){
        this.side = sides;
        this.loadedSide = loadedSide;
        this.value = 0;
    }
    
    @Override
     public void roll(){
        Random rand= new Random();
        this.value = rand.nextInt(this.side) + 1;
        
     }
    /**
     * accessors
     * @return the value of the die.
     */
        @Override
    public int getValue() {
        return this.value;
    }
           
    public int getSide(){
        return this.side;
    }
     //method to randomly determine if we roll +1, -1 or return a loaded number
    public int determineRoll(){
            Random rand = new Random();
    int chance;
        chance = rand.nextInt(this.determineRoll());
    return chance;
    }

    
           
  
}

