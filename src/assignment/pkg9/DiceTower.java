/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg9;

import java.util.List;

/**
 *
 * @author zacharyzordo
 */
public class DiceTower {
    private List<RegularDie> diceInTheTower;
    private int sumOfDice;

    public DiceTower(List<RegularDie> diceInTheTower) {
        this.diceInTheTower = diceInTheTower;
    }
    
    public void whatAreTheDiceValues(){
        int currentDieValue;
        sumOfDice = 0;
        for(RegularDie item : this.diceInTheTower){
            RegularDie currentDie = item;
            currentDie.roll();
            currentDieValue = currentDie.getDieValue();
            //System.out.println(currentDieValue + "\n");
            sumOfDice += currentDieValue;
        }
    }
    
    public int trayValue(){
        return this.sumOfDice;
    }
}
