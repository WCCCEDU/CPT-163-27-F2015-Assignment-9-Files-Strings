package assignment.pkg9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.*;

/**
 *
 * @author Paul Scarrone
 * @author Sharon R. Tinkey
 *  
 */
public class DnDDiceRoller {

  /**
   * Try out your dies and dice tower
   * @param args the command line arguments
   */
    public static void main(String[] args) throws IOException {     
        // open file
	DiceFileReader reader = new DiceFileReader("dice.txt");
        FileWriter fwriter = new FileWriter("diceout.txt");
        PrintWriter outputFile = new PrintWriter(fwriter);

        // read file lines into array
        reader.read();
        
        // get array with file lines 
        List<String> diceLines = new ArrayList();
        diceLines = reader.getLines();
          
        // parse each line in diceLines to separate the dice
        // and parse again to create each die object. 
        // Put each die object into arrayList.
        
        // parse the line into individual dice
        for (int i = 0; i < diceLines.size(); i++){
            outputFile.println("\n\nDICE SET #" + (i + 1) + ": " + diceLines.get(i));
            List<Die> dice = new ArrayList();       // create arraylist for dice
            String[] eachDie = diceLines.get(i).split(" ");
            
            // parse each individual die into number of sides, type, 
            // and loaded number if applicable 
            for (int x = 0; x < eachDie.length; x++){
                String[] oneDie = eachDie[x].split(":");
                int dieSides = Integer.parseInt(oneDie[0]);     // get # of sides

                // determine type of die
                // create die object and put into arraylist
                switch (oneDie[1].toLowerCase()){
                    // create numbered die, add to arraylist
                    case "numbered":
                        dice.add(new NumberedDie(dieSides));
                        outputFile.println("     Create NUMBERED die with " 
                                           + dieSides + " sides. ");
                        break;
                    // create fudge die, add to arraylist if legal   
                    case "fudge":
                        FudgeDie fdie = new FudgeDie(dieSides);
                        if (fdie.getErrMsg().equals("")){
                            dice.add(fdie); 
                            outputFile.println("     Create FUDGE with " 
                                                + dieSides + " sides. ");  
                            break;
                        } else {
                            outputFile.println(fdie.getErrMsg() + " Die not rolled.");
                            break;
                        }
                    // create loaded die, add to arraylist    
                    case "loaded":
                        int dieLoadedNum = Integer.parseInt(oneDie[2]);
                        dice.add(new LoadedDie(dieSides, dieLoadedNum));
                        outputFile.println("     Create LOADED with " + dieSides + 
                                " sides. Loaded number:" + dieLoadedNum);
                        break;
                    default:
                        outputFile.println("ERROR: Die type " + 
                                            oneDie[1].toLowerCase() +
                                            " not allowed. Skipping.....");
                        break;
                }//switch         
            }//for x
            
            // create dicetower object, put the dice object in it
            // roll and total the dice
            DiceTower tower = new DiceTower(dice);            
            tower.dropDice();                               // roll the dice
            int trayValue = tower.trayValue();              // total all dice
            outputFile.println("Tray value for dice set #" + (i + 1) + 
                               ": " + trayValue);       
        }//for i
         outputFile.println("\n\nThat's all folks!");
         outputFile.close();
         System.out.println("\n\nThat's all folks!");
    }//main        
          
  
 /*****************************************************************************/
    
  /**
   * test_oneD6    roll one die and test that value is correct for a 6-sided
   *               regular die
   * @param        none
   * @return       the result of testing:  -1 -> die value is correct
   */
    public static int test_oneD6(){      
	NumberedDie die = new NumberedDie(6);               // create a die object
	die.roll();                         // roll the die
	int dieValue = die.getDieValue();      // get value of the die
	if(dieValue >= 1 && dieValue <= 6){
          //outputFile.print("Die   Test value: " + dieValue + "  ");
	  return -1;        // Means the die value is correct for a d6
	}else{
	  return dieValue;
	}
    }//test_oneD6
    
    public static int test_onefudgeDieD6(){
        FudgeDie die = new FudgeDie(6);        // create a die object
	die.roll();                            // roll the die
	int dieValue = die.getDieValue();      // get value of the die
        String errMsg = die.getErrMsg();       // get error msg if exists
        if(errMsg != ""){
            System.out.println(errMsg);
            dieValue = -2;
        }
	if(dieValue >= -1 && dieValue <= 1){
          // outputFile.print("Fudge Test value: " + dieValue + "  ");
	  return -1;        // Means the die value is correct for a d6
	}else{
	  return dieValue;
	}
    }//test_fudgeDice
  
    public static int test_oneLoadedDieD6(){
        LoadedDie die = new LoadedDie(6);      // create a die object
        die.setLoadedDie();                    // set the "loaded" value
	die.roll();                            // roll the die
	int dieValue = die.getDieValue();      // get value of the die
	if(dieValue >= 1 && dieValue <= 6){
          //outputFile.print("Loaded Test value: " + dieValue + "  ");
	  return -1;        // Means the die value is correct for a d6
	}else{
	  return dieValue;
	}
    }//test_loadedDice
    
    /**
    * test_diceTowerWithTwoD6    roll 2 dice and test that total value of dice
    *                            is correct for two 6-sided regular dice
    * @param                     none
    * @return                    the result of testing: -1 means die value is correct
    */
    public static int test_diceTowerWithTwoD6(){
        // create a die object arraylist
	List<NumberedDie> dice = new ArrayList();
        // create die objects and add to the dice arraylist
	dice.add(new NumberedDie(6));           
	dice.add(new NumberedDie(6));  
        // create dicetower object and put the dice object in it
	DiceTower tower = new DiceTower(dice);            
        tower.dropDice();                       // roll the dice
	int trayValue = tower.trayValue();      // add the value of all dice
	if(trayValue >= 2 && trayValue <= 12){
          //outputFile.print("Tower Test value: " + trayValue + "  ");  
	  return -1;       // means the die value is correct for two d6 dice
	}else{
	  return trayValue;
	}
    }//test_diceTowerWithTwoD6
    
    /**
    * test_diceTowerWithRandomDice
    *                           Roll 6 random dice through the dice tower
    *                           Random dice can be regular or loaded and may or
    *                           may not use a fudge die.
    * @param                    none
    * @return                   the result of testing: -1 means die value is correct
    */
    public static int test_diceTowerWithRandomDice(){
        // create die object arraylist
	List<Die> dice = new ArrayList();
        Random randomNumber = new Random();
        // create die objects and add to the dice arraylist
        for (int i = 1; i <=6; i++){            
            int result = randomNumber.nextInt(2);
            if (result == 0){
                dice.add(new NumberedDie(6));        // create regular die
            } else {
                dice.add(new LoadedDie(6));     // create loaded die
            }          
        }
        // create dicetower object and put the dice object in it
	DiceTower tower = new DiceTower(dice);            
        tower.dropDice();                       // roll the dice
	int trayValue = tower.trayValue();      // add the value of all dice
        System.out.println("trayValue before fudge = " + trayValue);
        
        int result = randomNumber.nextInt(2);   // Use fudge die? 0 = no 1 = yes
        if (result == 1){                          // create fudge die
            FudgeDie die = new FudgeDie(6);        // create a die object
            die.roll();                            // roll the die
            int dieValue = die.getDieValue();      // get value of the die
            System.out.println("Fudge die value = " + dieValue);
            trayValue += dieValue;                 // adjust total by fudge die            
        }
        
        // total with range? 6 dice * #6 on dice + maybe 1 fudge
	if(trayValue >= 2 && trayValue <= 37){
          System.out.println("Tower2 Test value: " + trayValue);  
	  return -1;       // means the die value is correct for 6 d6 dice
	}else{
	  return trayValue;
	}
    }//test_diceTowerWithRandomDice
    
} //class
