package assignment.dnddiceroller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
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
      Die temp;
      try {
      File diceOutput = new File("Dice Output.txt");
      PrintWriter output = new PrintWriter(diceOutput);
         
      
       DiceFile.read();
        DiceList = DiceFile.getLines();

        for(int i = 0; i < DiceList.size(); i++) {

            List<Die> dice = new ArrayList<Die>();

            output.print("Line " + (i+1) + ": ");
            for (StringTokenizer stringTokenizer = new StringTokenizer(DiceList.get(i)
                 ," "); stringTokenizer.hasMoreTokens();) {
                int die;
                String type;
                int loaded;

                String token = stringTokenizer.nextToken();

                output.print(token);

                StringTokenizer dieTokens = new StringTokenizer(token,":");

                die = Integer.parseInt(dieTokens.nextToken());
                type = dieTokens.nextToken();
                
                if (type.equals("loaded"))
                {
                    loaded = Integer.parseInt(dieTokens.nextToken());
                    temp = new LoadedDice(die,loaded);
                }
                else if (type.equals("fudge"))
                {
                    temp = new FudgeDice(die);
                }
                else if (type.equals("numbered"))
                {
                    temp = new NumberedDie(die);
                }
                else
                {
                    throw new Exception("Invalid die type found on line " + (i+1));
                }
                   
                dice.add(temp);
                
                if(stringTokenizer.hasMoreElements())
                {
                    output.print(", ");
                }
                else
                    output.println();
                
            }
            //Create dice tower using dice
            //roll dice in dice tower
            //output results
            DiceTower tower = new DiceTower(dice);
            tower.dropDice();
            output.println("Line " + (i+1) + " total: " + tower.trayValue());
            
            
        }
        
        output.close();
        
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}