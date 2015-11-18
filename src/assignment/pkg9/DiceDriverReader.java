package assignment.pkg9;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 * read text file, run each line through DiceTower and output results in new text file.
 * @author Katrina
 */
public class DiceDriverReader {
   public static void main(String[]args) throws IOException {
       DiceFileReader reader = new DiceFileReader ("./dice.txt");
       FileWriter fwriter = new FileWriter("diceResults.txt");
        try
           (PrintWriter outputFile = new PrintWriter(fwriter)) {
            reader.read();
            
           ArrayList<Die> die = new ArrayList(); 
           String[] lines = null; // holds individual lines in text file.
           String[] eachDieSpace; //holds value of die after splitting spaces below.
           String[] eachDieColon; // holds value of die after spliting colons below.  
                          
    // tokenize: split file line into seperate pieces of information.
    for(String line: lines) {
       eachDieSpace = line.split(" ");

    for(String moreLine: eachDieSpace) {
       eachDieColon = line.split(":");  
      
        Integer sides;
        Integer loadedSide;
        switch (eachDieColon[1]) {
          case "numbered":
            sides = Integer.parseInt(eachDieColon[0]);
            die.add(new NumberedDie(sides));
            break;
          case "fudge":
            sides = Integer.parseInt(eachDieColon[0]);
            die.add(new FudgeDie(sides));
            break;
           case "loaded":
            sides = Integer.parseInt(eachDieColon[0]);
            loadedSide = Integer.parseInt(eachDieColon[2]);
            die.add(new LoadedDie(sides, loadedSide));
            break;
        } 
    }
    }
    }
   }
}

      

     