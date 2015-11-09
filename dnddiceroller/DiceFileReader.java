/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnddiceroller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Paul Scarrone
 */
public class DiceFileReader {
  private String filePath;
  private Scanner input = null;
  private List<String> lines;

  /*
    Use this with
	DiceFileReader reader = new DiceFileReader("dice.txt")
  */
  
  public DiceFileReader(String filePath) {
	this.filePath = filePath;
	
	File inputFile = new File(filePath);
	
	try {
	  this.input = new Scanner(inputFile);
	} catch (FileNotFoundException ex) {
	  Logger.getLogger(DiceFileReader.class.getName()).log(Level.SEVERE, null, ex);
	}
  }
  
  public List<String> getLines(){
	return this.lines;
  }
  
  public void read(){
	this.lines = new ArrayList();
	try {
	  this.input = new Scanner(new File("src/dnddiceroller/DiceFiles/DiceTestFile.txt"));
	} catch (FileNotFoundException ex) {
	  //Logger.getLogger(StingManipulationAndReadingFiles.class.getName()).log(Level.SEVERE, null, ex);
	  //this caused an error no matter what I tried ^^^^
        }
	
	while(input.hasNext()){
	  String line = input.nextLine();
          ArrayList<Die> HandFull = new ArrayList();
          //read file into handfulls of dice
	  String[] dice = line.split(" ");
	  for(int i = 0; i<dice.length;i++){
              //split each line into seperate dice 
              String[] thisHandFull = dice[i].split(" ");
              
              for(int x = 0; x<thisHandFull.length;x++){
                  //add a die to the list depending on what type of 
                  //die it is
                  String[] thisDie = thisHandFull[x].split(":");
                  if(thisDie.length == 3){
                      int sides = Integer.parseInt(thisDie[0]);
                      int lSide = Integer.parseInt(thisDie[2]);
                      LoadedDie loaded = new LoadedDie(sides,lSide);
                      HandFull.add(loaded);
                  }else if(thisDie[1].equals("numbered")){
                     int sides = Integer.parseInt(thisDie[0]);
                     NumberDie numbered = new NumberDie(sides);
                     HandFull.add(numbered);
                  }else{
                     int sides = Integer.parseInt(thisDie[0]);
                     FudgeDie fudge = new FudgeDie(sides);
                     HandFull.add(fudge);       
                  }                  
              }
        }
          //roll handfull of dice
          DiceTower tower = new DiceTower(HandFull);
              tower.dropDice();
              //return value
              System.out.println("Tray Value:" + tower.trayValue());
  }
        input.close();
}
}