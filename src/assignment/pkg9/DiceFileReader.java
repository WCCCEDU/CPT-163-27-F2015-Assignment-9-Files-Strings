
package assignment.pkg9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Katrina Siffrinn
 * @author Paul Scarrone
 */
public class DiceFileReader {
  private String filePath;
  private Scanner input = null;
  private List<String> lines;


  //DiceFileReader reader = new DiceFileReader("dice.txt");

  
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
	// read each line. must exclued comments that begin with # in text file.
        while (this.input.hasNext()){
            String line = this.input.nextLine();
            if (line.charAt(0) != '#'){
                this.lines.add(line);
            }
            
        }
  }
}
