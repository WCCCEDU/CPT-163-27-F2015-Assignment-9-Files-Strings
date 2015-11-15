package dnddiceroller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Paul Scarrone
 * @author Rhonda Marshall
 */

public class DnDDiceRoller {
    
    public static void main(String[] args) throws IOException {
        
        System.out.println("Start Test");
        
        DiceFileReader diceReader = new DiceFileReader("dice.txt");
        FileWriter fwriter = new FileWriter("results.txt");
        try (PrintWriter outputFile = new PrintWriter(fwriter)) {
            diceReader.read();
            
            List<String> lines = new ArrayList();
            lines = diceReader.getLines();
            
            // For each line in the file
            for (int i = 0; i < lines.size(); i++) {
                System.out.printf("New Tray: %s  \n", lines.get(i));
                outputFile.println("New Tray: " + lines.get(i));
                
                // split the line into info about the dice
                String[] dieStr = lines.get(i).split(" ");
                
                // start a new list for each line in the file
                List<Die> dice = new ArrayList();
                
                int low = 0, high = 0;
                
                // For each die in the line
                for (int j = 0; j < dieStr.length; j++) {
                    String[] dieFields = dieStr[j].split(":");
                    
                    int numberOfSides = Integer.parseInt(dieFields[0]);
                    
                    switch(dieFields[1].toLowerCase()) {
                        case "numbered":
                            high += numberOfSides;
                            dice.add(new NumberedDie(numberOfSides));
                            break;
                            
                        case "fudge":
                            low -= (int)(numberOfSides/3);
                            high += (int)(numberOfSides/3);
                            dice.add(new Fudge(numberOfSides));
                            break;
                            
                        case "loaded":
                            high += numberOfSides;
                            int loadedSide = Integer.parseInt(dieFields[2]);
                            dice.add(new Loaded(numberOfSides, loadedSide));
                            break;
                            
                        default:
                            break;
                    } // switch
                    
                }
                
                DiceTower tower = new DiceTower(dice);
                tower.dropDice();
                for (int j = 0; j < dice.size(); j++){
                    System.out.printf("value is %d\n", dice.get(j).getValue());
                    outputFile.println("value is " + dice.get(j).getValue() + "\n");
                    
                }
                int trayValue = tower.getTrayValue();
                
                if (trayValue < low ||  trayValue > high) {
                    System.out.printf("setting value to -1\n");
                    trayValue = -1;
                }
                
                System.out.printf("Tray Value is %d\n", trayValue);
                outputFile.println("Tray Value is " + trayValue);
                outputFile.println();
            }
         
            outputFile.close();
            
        } catch (Exception e) {
                System.out.printf("Error opening file\n");
                System.out.printf("%s\n", e.getMessage());
            }
        
        System.out.println("Stop Test");
        
    System.exit(0);
    } // main
    
}  // DnDDiceRoller class

