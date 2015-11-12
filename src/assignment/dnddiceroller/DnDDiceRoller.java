package assignment.dnddiceroller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Paul Scarrone
 */
public class DnDDiceRoller {

  /**
   * Try out your dies and dice tower
   * @param args the command line arguments
   */
  public static void main(String[] args) {
      String File = "dice.txt";
      List<String> DiceList;
      DiceFileReader DiceFile = new DiceFileReader(File);
      
      DiceFile.read();
      DiceList = DiceFile.getLines();
      for(int i = 0; i < DiceList.size(); i++) {
          
          List<Die> dice = new ArrayList<Die>();
          
          //System.out.println("Line " + (i+1) + ": ");
          for (StringTokenizer stringTokenizer = new StringTokenizer(DiceList.get(i)," "); stringTokenizer.hasMoreTokens();) {
              int sides;
              String type;
              int loaded;
              Die temp;
              
              String token = stringTokenizer.nextToken();
              
              //System.out.println(token);
              
              StringTokenizer dieTokens = new StringTokenizer(token,":");
              
              sides = Integer.parseInt(dieTokens.nextToken());
              type = dieTokens.nextToken();
              
              if(type.equals("loaded"))
              {
                  loaded = Integer.parseInt(dieTokens.nextToken());
                  System.out.println(sides + " " + loaded);
                  
              }
              else if(type.equals("fudge"))
              {
                  System.out.println(sides + "fudge");
              }
              if(type.equals("numbered"))
              {
                  System.out.println(sides + "numbered");
              }
                  
                  
              
              //Use type to determine what type of die to make
              //Throw die into dice
          }
          
         //Create dice tower using dice
          //roll dice in dice tower
          //output results
          
      }
      
      
  }
}
  
