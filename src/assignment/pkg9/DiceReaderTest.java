package assignment.pkg9;

/**
 *
 * @author Paul Scarrone
 */

// This test passes now and gives an example of how your file should work
// Once you are done with reading and calculating dice you will need to update
// this test to pass again
public class DiceReaderTest {
  public static void test_reader(){
	DiceFileReader diceReader = new DiceFileReader("dice.txt");
	diceReader.read();
	System.out.println(diceReader.getLines().toString().equals("[]"));
  }
}
