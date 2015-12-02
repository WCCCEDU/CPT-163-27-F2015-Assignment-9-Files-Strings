/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg9;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paul Scarrone
 */

// This test passes now and gives an example of how your file should work
// Once you are done with reading and calculating dice you will need to update
// this test to pass again
public class DiceReaderTest {
  public static void test_reader(){
	DiceFileReader diceReader = new DiceFileReader("dice.txt");
	diceReader.read();
        
        List<String> lines = new ArrayList<>();
        lines = diceReader.getLines();
        for(int x=0; x<lines.size(); x++){
            String[] parts = lines.get(x).split(":");
            int sides = Integer.parseInt(parts[0]);
            String type = parts[1];
            
            switch(type){
                case "loaded": int loadedNum = Integer.parseInt(parts[2]);
                               LoadedDie loaded = new LoadedDie(sides, loadedNum);
                               loaded.roll();
                               System.out.println(loaded.getValue());
                               break;
                    
                case "fudge": FudgeDie fudge = new FudgeDie(sides);
                              fudge.roll();
                              System.out.println(fudge.getValue());
                              break;
                    
                case "numbered": NumberedDie numbered = new NumberedDie(sides);
                                 numbered.roll();
                                 System.out.println(numbered.getValue());
            }
        }
	System.out.println(diceReader.getLines().toString().equals("[]"));
  }
}
