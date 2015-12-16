/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment9;

import assignment9.Die;
import java.util.Random;

/**
 *
 * @author mkavic
 */
public class Fudge implements Die 
{
private int sides = 0;
int value =0;
int fudgeValue;



public Fudge(int sides)
{
    this.sides = 3;
}
@Override
public void roll()
{
  Random die = new Random();
       fudgeValue = die.nextInt(this.sides) + 1;  
}
@Override

public int value()
{
    if(fudgeValue % 3 == 0)
        value = 1;
    else if (fudgeValue % 3 == 1)
        value = -1;
    else 
       value = 0;
    return value; 
}






}
