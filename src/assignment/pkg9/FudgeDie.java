/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg9;

import java.util.Random;

/**
 *
 * @author Adam
 */
public class FudgeDie implements Die{
    private int sides;
    private int value;
    
    public FudgeDie(int sides){
        this.sides = sides;
    }
    
    @Override
    public int getValue(){
        return value;
    }

    @Override
    public void roll() {
        this.value = new Random().nextInt(this.sides)-1;
    }
}
