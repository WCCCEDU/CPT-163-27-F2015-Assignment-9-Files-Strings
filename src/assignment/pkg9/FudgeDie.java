/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg9;

import java.util.Random;

/**
 *
 * @author Jacob
 */
public class FudgeDie implements Die {
  
  //required fields
  private int dieSize;
  private int result;
  private int fudgeModifier;
  
  public FudgeDie(int dieSize){
    this.dieSize = dieSize;
    this.result = 0;
  }

  public int fudgeFix(){
    while((dieSize % 3) != 0){
      dieSize++;
    }
    return dieSize;
  }

  public int findFudgeModifier(){
    int fudgeFinder = this.dieSize / 3;
    int i = 0;
    if(i <= this.result && this.result <= fudgeFinder){
      fudgeModifier = -1;
    }else if(fudgeFinder <= this.result && this. result <=(2 * fudgeFinder)){
      fudgeModifier = 0;
    }else{
      fudgeModifier = 1;
    }
    this.result = fudgeModifier;
    return this.result;
  }
  
  @Override
  public void roll() {
    Random fudgeRoll = new Random();
    this.result = fudgeRoll.nextInt(this.dieSize) + 1;
  }
  
  public int getDieSize(){
    return dieSize;
  }

  @Override
  public int getResult() {
    return result;
  }
  
}
