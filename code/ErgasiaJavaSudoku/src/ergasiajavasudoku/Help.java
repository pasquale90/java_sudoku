/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ergasiajavasudoku;

/**
 * @author Πασχάλης Μελισσάς ΑΕΜ:1901
 * @version 27/1/2014
 */


/**
 * Κλάση Ελέγχου και βοηθείας προς τον χρήστη.
 */
public interface Help {
    
    abstract int[] getNextPossNumber(int row,int col);  
    
    abstract boolean validMoves(int row,int col,DiscreteValues val);
}
