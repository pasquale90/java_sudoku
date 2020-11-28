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
 * Κλάση υλοποίησης παραλλαγής Duidoku που κληρονομεί από την SudokuLogic.
 * 
 */
public class Duidoku extends SudokuLogic {
    private Computer computer;
    
    
  /**
   * Κατασκευαστής κλάσης.
   * Καλεί κατασκυαστή της SudokuLogic.
   * Δημιουργεί ένα αντικείμενο ComputerInstance που αντιπροσωπεύει τη λειτουργικότητα 
   * του υπολογιστή. 
   */
    public Duidoku(){
        super(4,4);
       computer=new ComputerInstance();
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
    public void playHuman(int row,int col,DiscreteValues val){
        if(validMoves(row,col,val)!=false)
        getBoard().setV(row,col,val);
        if (getFinished()==false) {
            computer.play(getBoard());
        }
    }
    
    
    /**
     * Μέθοδος η οποία τροποποιεί την αντίστοιχη της λογικής.Ελέγχει στην ουσία,
     * σε περιπτωση που δεν είναι γεμάτος ο πίνακας, αν υπάρχουν άλλες επιτρεπτές
     * κινήσεις.
     * @return true δεν υπάρχουν επιπλέον επιτρεπτές κινήσεις, και false αν εξακολου-
     * θούν να υπάρχουν.
     */
    
    
    @Override
    public boolean getFinished(){
       boolean isAlreadySolved=super.getFinished();
       int helpTable[]=new int[4];
       int help_count[][]=new int[4][4];
       if(isAlreadySolved==false){
           for(int row=0;row<4;row++){
               for (int col=0;col<4;col++){ 
                   if(getBoard().getCell(row, col)==null){  
                    helpTable=super.getNextPossNumber(row,col);
                   }
                   for(int itr=0;itr<4;itr++){
                       if(helpTable[itr]!=0)
                           return false;
                   }
               }    
           }
       }
       return true;
    }

   
}
