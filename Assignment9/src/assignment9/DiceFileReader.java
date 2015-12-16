/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.System.in;
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
  // constructor always run filePath
  public DiceFileReader(String filePath) {
	this.filePath = filePath;

//Creates new File object 	
	File inputFile = new File(filePath);
//Try catch for execptions	
	try {
	  this.input = new Scanner(inputFile);
	} catch (FileNotFoundException ex) {
	  Logger.getLogger(DiceFileReader.class.getName()).log(Level.SEVERE, null, ex);
	}
  }
  //Return Arraylist
  public List<String> getLines(){
	return this.lines;
  }
  
  public void read() throws IOException{
	this.lines = new ArrayList();
	// Put you read logic and populate lines
      Scanner file = null;
	try {
	  file = new Scanner(new File(filePath));
	} catch (FileNotFoundException ex) {
	  Logger.getLogger(DiceFileReader.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	while(file.hasNext()){
	  String line = file.nextLine();
	  if(line.contains("#"))
            this.toString();//nonsense to get ride of the first lines
          else{
             this.lines.add(line);     
                  }
          
	  
    
	}
	  
  }
  }
  