package assignment.pkg9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Dice Tower. A Dice Tower is a tool used by serious gamers use to roll many
 * dice at once. It looks like this
 * https://www.miniaturescenery.com/Images/PortableDiceTowerLarge.jpg An
 * instance of a dice tower is defined by the number panels it contains to help
 * provide a more regular distribution of die values. The die bounce from panel
 * to panel until they exit the dice tower at the bottom tray. A dice tower will
 * accept a collection of dice and reports their results when they reach the
 * tray at the bottom
 *
 * @author Paul Scarrone
 * @author Adam King
 */
public class DiceTower {

    final int PANEL_COUNT = 3;
    List<NumberedDie> dice;
    int trayValue = 0;

    public DiceTower() {
        this.dice = new ArrayList();
    }

    public DiceTower(List dice) {
        this.dice = dice;
    }

    public int getTrayValue() {
        return trayValue;
    }

    public void dropDice() {
        int dieNum = 0;
        for (NumberedDie die : dice) {
            for (int panel = 0; panel < PANEL_COUNT; panel++) {
                this.dice.get(dieNum).diceValue = new Random().nextInt(6) + 1;
            }
            trayValue += this.dice.get(dieNum).diceValue;
            dieNum++;
        }
    }
}
