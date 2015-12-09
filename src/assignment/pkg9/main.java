/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg9;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

/**
 *
 * @author Jacob
 */
public class main {
  public static void main(String args[]) throws IOException{
   DiceFileReader reader = new DiceFileReader("dice.txt");
   FileWriter writeFile = new FileWriter("diceresults.txt");
   PrintWriter outputFile = new PrintWriter(writeFile);
   
   reader.read();
   List<String> lines = new ArrayList<>();
   lines = reader.getLines();
   
   for(int i = 0; i < lines.size(); i++){
     System.out.println("\nDice Set #" + (i + 1) + ": " + lines.get(i));
     outputFile.println("\nDice Set #" + (i + 1) + ": " + lines.get(i));
     List<Die> dice = new ArrayList();  
     String[] individualDice = lines.get(i).split(" ");
     
     for(int d = 0; d < individualDice.length; d++){
       String[] singleDie = individualDice[d].split(":");
       
       int dieSides = Integer.parseInt(singleDie[0]);
       String dieType = singleDie[1];
       
       //load Die if necessary
       int loadedSide = 0;
       if(dieType.equals("loaded")){
         loadedSide = Integer.parseInt(singleDie[2]);
       }
       
       switch (dieType){
         case "numbered":
           NumberedDie numberedDie = new NumberedDie(dieSides);
           numberedDie.roll();
           int numberedDieResult = numberedDie.getResult();
           System.out.println("Numbered Die Result: " + numberedDieResult);
           outputFile.println("Numbered Die Result: " + numberedDieResult);
           break;
         case "loaded":
           LoadedDie loadedDie = new LoadedDie(dieSides, loadedSide);
           loadedDie.loadedProbability();
           int loadedDieResult = loadedDie.getResult();
           System.out.println("Loaded Die Result: " + loadedDieResult);
           outputFile.println("Loaded Die Result: " + loadedDieResult);
           break;
         case "fudge":
           FudgeDie fudgeDie = new FudgeDie(dieSides);
           fudgeDie.roll();
           int fudgeDieResult = fudgeDie.getResult();
           System.out.println("Fudge Die Result: " + fudgeDieResult);
           outputFile.println("Fudge Die Result: " + fudgeDieResult);
           break;
       }
     } 
   }
   outputFile.close();
  }
}
