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
public class FudgeDice implements Die{
    private int die;
    private int value;
    private Random FudgeRand = new Random();
    public FudgeDice(int die){
        this.die = die;
    }
        
    
    @Override
    public void roll() {
       this.value = FudgeRand.nextInt(3)-1;
    }

    @Override
    public int value() {
        return this.value;
    }
    
}
