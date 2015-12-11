/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg9;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zacharyzordo
 */
public class Ordo_DiceTower {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        boolean numberedPass = true;
        boolean fudgePass = true;
        boolean loadedPass = true;
        boolean towerPass = true;
        List<String> dieList = null;
        
        String diceFilePath = "dice.txt";
        
        DiceFileReader reader = new DiceFileReader(diceFilePath);
        try {
            reader.read();
        } catch (IOException ex) {
            Logger.getLogger(Ordo_DiceTower.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<String> stringList = reader.getLines();
        for(String list : stringList){
            int numbered = -1;
            int loaded = -1;
            int fudged = -99;
            
            for(String die : list.split(" ")){
                int dieSides = Integer.parseInt(die.split(":")[0]);
                switch (die.split(":")[1]) {
                    case "loaded":
                        // Process a loaded die.
                        int loadedValue = Integer.parseInt(die.split(":")[2]);
                        loaded = test_loadedDie(dieSides, loadedValue);
                        break;
                    case "fudge":
                        // Process a fudge die (number of sides should never matter on a fudge die)
                        // as they always have equal numbers of -1, 0, and +1.
                        fudged = test_fudgeDie();
                        break;
                    default:
                        numbered = test_numberedDie(dieSides);
                        break;
                }
                if(numbered != -1){
                    System.out.println("Die Test Failed with Value: " + numbered);
                    numberedPass = false;
                }
                if(fudged != -99){
                    System.out.println("Fudge Die Test Failed with Value: " + fudged);
                    fudgePass = false;
                }
                if(loaded != -1){
                    System.out.println("Loaded Die Test Failed with Value: " + loaded);
                    loadedPass = false;
                }
            }
            int tower = test_diceTowerWithTwoD6();
            if(tower != -1){
                System.out.println("Tower Test Failed with Value: " + tower);
                towerPass = false;
            }   
        }
        if(numberedPass){
            System.out.println("Numbered Die Test Passed");
        }
        if(fudgePass){
            System.out.println("Fudge Die Test Passed");
        }
        if(loadedPass){
            System.out.println("Loaded Die Test Passed");
        }
        if(towerPass){
            System.out.println("Tower Test Passed");
        }
    }
  
    public static int test_numberedDie(int dieSides){
	RegularDie die = new RegularDie(dieSides);
	die.roll();
	int dieValue = die.getDieValue();
        System.out.println(dieValue + " rolled on a " + dieSides + " sided numbered die.");
	if(dieValue >= 1 && dieValue <= dieSides){
            return -1; // Means the die value is inside its bounds for the number of sides provided.
	}else{
            return dieValue;
	}
    }
    
    public static int test_fudgeDie(){
        Fudge die = new Fudge();
        die.roll();
        int dieValue = die.getDieValue();
        System.out.println(dieValue + " rolled on a Fudge die.");
        if(dieValue >= -1 && dieValue <= 1){
            return -99; // Means the die value is inside its bounds for a Fudge die.
        }else{
            return dieValue;
        }
    }
    
    public static int test_loadedDie(int dieSides, int loadedValue){
        Loaded die = new Loaded(dieSides, loadedValue);
	die.roll();
	int dieValue = die.getDieValue();
        System.out.println(dieValue + " rolled on a " + dieSides + " sided die loaded on the " + loadedValue + " side.");
	if(dieValue >= 1 && dieValue <= 6){
            return -1; // Means the die value is inside its bounds for a d6
	}else{
            return dieValue;
	}
    }
  
    public static int test_diceTowerWithTwoD6(){
	List<RegularDie> dice = new ArrayList();
	dice.add(new RegularDie(6));
	dice.add(new RegularDie(6));
	DiceTower tower = new DiceTower(dice);
	tower.whatAreTheDiceValues();
	int trayValue = tower.trayValue();
	if(trayValue >= 2 && trayValue <= 12){
            return -1; // means the die value is outside the bounds of 2 d6
	}else{
            return trayValue;
	}
    }
}