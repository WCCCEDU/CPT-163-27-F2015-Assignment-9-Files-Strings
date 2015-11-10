package dnddiceroller;

import java.io.*;
import java.util.Scanner;

/**
 * A Die is a many sided object that when rolled provides a random value from
 * 1 through the number of sides on the object. Some dice are 6 sided and have
 * the numbers 1-6 on them. Some dice are 20 sided with the numbers 1-20 on them.
 * Others are called fudge dice and have the values of -1 0 or +1
 * @author Paul Scarrone
 */
public interface Die {

     public int rollDice(); //variable for rolling
     public int getValue(); //to get value from
    }
