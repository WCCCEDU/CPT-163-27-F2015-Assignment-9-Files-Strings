package assignment.dnddiceroller;

import java.util.Random;

/**
 * A NumberedDie is a many sided object that when rolled provides a random value from
 1 through the number of sides on the object. Some dice are 6 sided and have
 * the numbers 1-6 on them. Some dice are 20 sided with the numbers 1-20 on them.
 * Others are called fudge dice and have the values of -1 0 or +1
 * @author Paul Scarrone
 */
public class NumberedDie implements Die{
    private int die;
    private int value;
    private Random dieSide = new Random();
   
    public NumberedDie(int die) {
       this.die = die;
       
}

    @Override
    public void roll() {
        value = dieSide.nextInt(die) + 1;// dieSide is equal to 0 thri (die -1).
        //System.out.println(value);
    }

    @Override
    public int value(){
        return this.value;
    }
}