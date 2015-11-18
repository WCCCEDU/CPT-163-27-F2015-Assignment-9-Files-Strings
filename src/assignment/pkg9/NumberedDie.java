package assignment.pkg9;


import java.util.Random;

/**
 *
 * @author Katrina Siffrinn
 */

   
public class NumberedDie implements Die{
    
  //fields
    private int sides;   //of die
    private int value;   // of roll
    
    /**
     * constructor
     * @param sides
     *
     */
public NumberedDie (int sides){
    this.sides = sides;
    this.value = 0;
   }

public int getSides() {
    return this.sides;
}
    /**
     *
     * @return sum of dice sides.
     */
 
    @Override
    public int getValue(){
    return this.value;
}
    /**
     * simulates rolling one die
     */

    @Override
       public void roll(){
           Random rand = new Random();
           this.value = 1 + rand.nextInt(this.sides);
       }     
   
}
    


    

