/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnddiceroller;

/**
 *
 * @author Tehold
 */
public interface Die {
    /**
     * Returns value of a Die
     * @return integer Value of Die
     */
    public int value();
    /**
     *  Returns name of Die
     * @return type of Die
     */
    public String name();
    /**
     * Roll method to simulate rolling a Die 
     * And setting value to a random integer
     */
    public void roll();
            
}
