package dnddiceroller;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Paul Scarrone
 * @author Rhonda Marshall
 */

// This test passes now and gives an example of how your file should work
// Once you are done with reading and calculating dice you will need to update
// this test to pass again
public class DiceReaderTest {
    
    /**
     *
     * @param numNumberedSides
     * @param numFudgeSides
     * @param numLoadedSides
     * @return
     */
    public static int test_reader(int numNumberedSides, int numFudgeSides,
                                    int numLoadedSides) {
        DiceFileReader diceReader = new DiceFileReader("dice.txt");
	diceReader.read();
       
        List<String> lines = new ArrayList();
        lines = diceReader.getLines();
        
        // For each line in the file
        for (int i = 0; i < lines.size(); i++) {
            System.out.printf("New Tray: %s  ", lines.get(i));
            
            // split the line into info about the dice
            String[] dieStr = lines.get(i).split(" ");
            
            // start a new list for each line in the file
            List<Die> dice = new ArrayList();
            
            int numNumberedDie = 0;
            int numFudgeDie = 0;
            int numLoadedDie = 0;
            
            // For each die in the line
            for (int j = 0; j < dieStr.length; j++) {
                String[] dieFields = dieStr[j].split(":");
                
                int numberOfDice = Integer.parseInt(dieFields[0]);
                String dieType = dieFields[1];
                int loadedSide = 0;
                if (dieType.equals("loaded"))
                    loadedSide = Integer.parseInt(dieFields[2]);
                
                if (dieType.equals("numbered")) {
                    numNumberedDie += numberOfDice;
                    for (int k = 0; k < numberOfDice; k++)
                        dice.add(new NumberedDie(6));
                } else if (dieType.equals("fudge")) {
                    numFudgeDie += numberOfDice;
                    for (int k = 0; k < numberOfDice; k++)
                        dice.add(new Fudge(6));
                } else {
                    numLoadedDie += numberOfDice;
                    for (int k = 0; k < numberOfDice; k++)
                        dice.add(new Loaded(6, loadedSide));
                }
            }
         
        DiceTower tower = new DiceTower(dice);
        tower.dropDice();
        int trayValue = tower.getTrayValue();

        int low = 0;
        int high = 0;
        
        /**
         * A numbered die increases the low range by number of numbered die
         * A numbered die increases the high range by the number of sides for
         * each numbered die
         */
        if (numNumberedDie != 0) {
            low += numNumberedDie;
            high += (numNumberedDie * numNumberedSides);
        }
        
        /**
         * A fudge die reduces the low range and increases the high range by 
         * one for each fudge die
         */
        
        if (numNumberedDie == 0 && numLoadedDie == 0) {
            low = numFudgeDie * -1;
            high = numFudgeDie;
            }
        else {
            low -=  numFudgeDie;
            high += numFudgeDie; 
            }
        
        /**
         * A loaded die increases the low range by number of numbered die
         * A loaded die increases the high range by the number of sides for
         * each loaded die
         */
        if (numLoadedDie != 0) {
            low += numLoadedDie;
            high += (numLoadedDie * numLoadedSides);
        }
      
        if (trayValue < low ||  trayValue > high) {
            System.out.printf("setting value to -1\n");
            trayValue = -1;
            } 
        
        System.out.printf("  trayValue is %d\n", trayValue);
    }
    
    return 0;
    } // test_reader
}

