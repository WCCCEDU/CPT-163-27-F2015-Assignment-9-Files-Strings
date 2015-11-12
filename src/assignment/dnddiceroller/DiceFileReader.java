/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.dnddiceroller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
  
  

    public DiceFileReader(String filePath, List<String> lines) {
        this.filePath = filePath;
        this.lines = lines;
    }
    public List<String> getLines(){
	return this.lines;
    }
  
    public void read(){
        this.lines = new ArrayList<String>();
        
        try {
            while(input.hasNextLine()) {
                String temp = input.nextLine();
                if(temp.charAt(0) != '#'){
                   lines.add(temp); 
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }
    } 
                
                
  }
            
                
        
            
      
        

