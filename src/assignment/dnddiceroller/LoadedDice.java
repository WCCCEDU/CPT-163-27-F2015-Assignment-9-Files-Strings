/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.dnddiceroller;

import java.util.Random;

/**
 *
 * @author Inspiron
 */
public class LoadedDice implements Die{
    private final int WEIGHT = 2;
    private int die;
    private int value;
    private int loadedValue;
    private Random randValue = new Random();
    public LoadedDice(int die){
        this.die = die;
        this.loadedValue = die;
    }
    
    public LoadedDice(int die, int loadedValue){
        this.die = die;
        this.loadedValue = loadedValue;
    }
    
    @Override
    public void roll() {
        int tempValue = 0;
        for (int i = 0; i < WEIGHT && this.value != loadedValue; i++) {
            tempValue = randValue.nextInt(die)+1;
            if (tempValue == loadedValue){
                this.value = tempValue;
            }
            
        }
        
        if (this.value != loadedValue){
            this.value = tempValue;
        }
        
        
        
    }

    @Override
    public int value() {
      return this.value;
    }
    
}
