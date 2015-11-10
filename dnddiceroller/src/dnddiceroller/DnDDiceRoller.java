package dnddiceroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Rhonda Marshall
 * Nov 1, 2015
 */
public class DnDDiceRoller {
    /**
     * Try out your dies and dice tower
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        final int NUM_NUMBERED_SIDES = 6;
        final int NUM_FUDGE_SIDES = 6;
        final int NUM_LOADED_SIDES = 6;
        
        System.out.printf("Begin Test\n");
        int error = DiceReaderTest.test_reader(NUM_NUMBERED_SIDES, NUM_FUDGE_SIDES, NUM_LOADED_SIDES);
        if (error == -1)
            System.out.println("Mixed Dice Test Failed");
        
        System.out.printf("End Test\n");
        
    } // main method
}
