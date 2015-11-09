/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnddiceroller;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class LoadedDie implements Die {

    private int sides;//Number of sides on a die
    private int value;//value of Die
    private int loadedSide;//weighted value
    
    public LoadedDie(int sides, int loadedSide){
        this.sides = sides;
        this.loadedSide = loadedSide;
        this.value = 0;
    }
    
    @Override
    public void roll() {
        int[] sidesArray = new int[sides];
        int[] valueProbs = new int[sides];
        
        //populate arrays for sides and probabilities
        for(int i = 0;i<sidesArray.length;i++){
            sidesArray[i]=i+1;
            if((i+1)==loadedSide){
                valueProbs[i]=5;
            }else{
                valueProbs[i]=2;
            }
        }
        
        //create list to pick from
        ArrayList<Integer> valueList = new ArrayList<Integer>();
        for(int i = 0; i<sidesArray.length;i++){
            for(int x = 0; x<valueProbs[i];x++){
                valueList.add(sidesArray[i]);
            }
        }
        
        //randomly select from list
        int rand = new Random().nextInt(valueList.size());
        this.value = valueList.get(0);
    }

    @Override
    public int getValue() {
        return this.value;
    }
    
}
