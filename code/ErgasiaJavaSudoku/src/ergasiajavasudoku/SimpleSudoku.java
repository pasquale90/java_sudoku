/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ergasiajavasudoku;

import java.io.IOException;

/**
 * @author Πασχάλης Μελισσάς ΑΕΜ:1901
 * @version 27/1/2014
 */


/**
 * Κλάση υλοποίησης απλού Sudoku που κληρονομεί από την SudokuLogic.
 *
 */
public class SimpleSudoku extends SudokuLogic{
    private DiscreteValues values[];
    
    /**
     * Kατασκεύαστής κλάσης.Καλεί τον κατασκευαστή της SudoluLogic.
     */
    public SimpleSudoku(){  
        super(9,9);
        }
  
    /**
     * Μέθοδος της SudokuLogic που υλοποιείται ξεχωριστά για κάθε παραλλαγή.Σε
     * αυτή τη μέθοδο ο χρήστης δίνοται οι συντεταγμένες ενός κελιού καθώς και οι
     * τιμή η οποία παίρνει το κελί εφ όσον αυτή βέβαια είναι επιτρεπτή. 
     * 
     * @param row συντεταγμένη της γραμμής του πίνακα.
     * @param column συντεταγμένη της στήλης του πίνακα.
     * @param val τιμή τύπου DiscreteValues που γεμίζει το κελί του πίνακα με τις 
    * παραπάνω συντεταγμένες.
     */
    @Override
    public void playHuman(int row,int column,DiscreteValues val){
        if(validMoves(row,column,val)!=false)
        getBoard().setV(row,column,val);
    }
    
    /**
     * Μέθοδος η οποία τροποποιεί την αντίστοιχη μέθοδο της SudokuLogic και δίνει
     * τα κατάλληλα ορίσματα("SimpleSudoku")και τα περνάει στην αντίστοιχη συνάρτηση ώστε να 
     * φορτώσει τα κατάλληλα αρχεία.
     * @throws NullPointerException 
     */
    public void loadSudoku()throws NullPointerException{
        Integer r=getRandom().nextInt(10);
        String s=r.toString();
        try{
        readSudokuFile("SimpleSudoku",s);  
        }catch(IOException e){
            System.out.print("File"+s+"didn t found");
        } 
    }
   
}
