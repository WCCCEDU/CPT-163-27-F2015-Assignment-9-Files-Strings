/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment9;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author mkavic
 */
public class Assignment9 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
  
        DiceFileReader reader = new DiceFileReader("C:\\Users\\MKavic\\Documents\\NetBeansProjects\\Assignment9\\src\\assignment9\\dice.txt");
        
            reader.read();
            
            FileWriter diceOutput = null;
            PrintWriter outputFile = null;
            
            List <String> lines = new ArrayList();
            lines = reader.getLines();
        
            for (int i = 0; i< lines.size(); i++)
            {
            int trayValue = 0;
            System.out.println("Tray: " + (i+1) + ":");
            outputFile.println("Tray: " + (i+1) + ":");
            
            String[] fileline = lines.get(i).split(" ");
            
            
            for (String fileline1 : fileline) {
                String[] token = fileline1.split(":");
                int numberOfSides = Integer.parseInt(token[0]);
                String type = token[1];
                
            
                int loadedSide = 0;
                if (type.equals("loaded"))
                {
                    loadedSide = Integer.parseInt(token[0]);
                    
                }     if (type.equals("loaded"))
                {
                    Loaded loadedDie = new Loaded(numberOfSides, loadedSide);
                    trayValue += loadedSide;
                    System.out.println("Loaded: " + loadedSide);
                    outputFile.println("Loaded: " + loadedSide);
                    
                }
                
                else if (type.equals("numbered"))
                {
                    NumberedDie numberedDie = new NumberedDie(numberOfSides);
                    numberedDie.roll();
                    int numberedDieValue = numberedDie.value();
                    trayValue += numberedDieValue;
                    System.out.println("Numbered die roll: " + numberedDieValue);
                    outputFile.println("Numbered die roll: " + numberedDieValue);
                }
                else if (type.equals("fudge"))
                {
                    Fudge fudge = new Fudge(numberOfSides);
                    fudge.roll();
                    int fudgeDieValue = fudge.value();
                    trayValue += fudgeDieValue;
                    System.out.println("Fudge die roll: " + fudgeDieValue);
                    outputFile.println("Fudge die roll: " + fudgeDieValue);
                    
                }
                System.out.println("Tray: " + trayValue);
                outputFile.println("Tray: " + trayValue);
            }
        
                
  
                } 
                        
                }
            }
        
 
   
     
