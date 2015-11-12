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
          for (StringTokenizer stringTokenizer = new StringTokenizer(DiceList.get(i)
               ," "); stringTokenizer.hasMoreTokens();) {
              int die;
              String type;
              int loaded;
            
              
              String token = stringTokenizer.nextToken();
              
              //System.out.println(token);
              
              StringTokenizer dieTokens = new StringTokenizer(token,":");
              
              die = Integer.parseInt(dieTokens.nextToken());
              type = dieTokens.nextToken();
              
              if(type.equals("loaded"))
              {
                  loaded = Integer.parseInt(dieTokens.nextToken());
                  LoadedDice loadedValue = new LoadedDice(die,loaded);
                 
              }
              else if(type.equals("fudge"))
              {
                  FudgeDice fudgeValue =  new FudgeDice(die);
              }
              if(type.equals("numbered"))
              {
                  NumberedDie numberedValue = new NumberedDie(die);
                  
              }
          }
      
          DiceTower diceTower = new DiceTower(dice);
          
         //Create dice tower using dice
          //roll dice in dice tower
          //output results
      }
    
  }
}