/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
  
  public void read() throws IOException{
    this.lines = new ArrayList();
    FileReader fileReader = null;
    BufferedReader bufferedReader = null;
    String line = null;
    
    try {
        fileReader = new FileReader("dice.txt");
        bufferedReader = new BufferedReader(fileReader);
    } catch (FileNotFoundException ex) {
        Logger.getLogger(DiceFileReader.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    while((line = bufferedReader.readLine()) != null){
        if(!line.startsWith("#### ")){
            String currentLine = line;
            this.lines.add(currentLine);
        }
    }
	// Put you read logic and populate lines
  }
}
