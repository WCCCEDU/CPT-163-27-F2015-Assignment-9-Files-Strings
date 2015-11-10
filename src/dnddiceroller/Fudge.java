/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnddiceroller;

import java.util.Random;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author Zachary
 */
public class Fudge implements Die {
    private int sideOfDie;
    private int valueOfDie;
    
    public int getvaleOfDie(){
        return valueOfDie;
        
    }
    
    public Fudge (int sideOfDie){
        this.sideOfDie=sideOfDie;
    }
    
    public int roll(){
        Random rand1=new Random();
        return this.valueOfDie=rand1.nextInt(this.sideOfDie)-1;
    }

    @Override
    public int rollDice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
