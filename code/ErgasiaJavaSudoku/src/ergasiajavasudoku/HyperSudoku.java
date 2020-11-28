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
 * Κλάση υλοποίησης παραλλαγής HyperSudoku που κληρονομεί από την SudokuLogic.
 */
public class HyperSudoku extends SudokuLogic{
  
    /**
     * Kατασκεύαστής κλάσης.Καλεί τον κατασκευαστή της SudoluLogic.
     */
    public HyperSudoku(){
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
     * Μέθοδος η οποία τροποποιεί την αντίστοιχη μέθοδο της SudokuLogic και 
     * προσθέτει έναν επιπλέον έλεγχο για τους έξτρα περιορισμούς της παραλλαγής
     * αυτής.Αρχικά φορτώνει σε ένα πίνακα τις επιτρεπτές τιμές του απλού Sudoku
     * και έπειτα ελέγχει ξεχωριστα τα έξτρα πλαίσια και τις αποθηκεύει σε ένα ξε-
     * χωριστό πίνακα.Τέλος συγκρίνει αν οι τιμές στους δύο πίνακες συμπίπτουν.Σε
     * περίπτωση που συμπίπτουν τότε τις προσθέτει σε ένα καινούργιο πίνακα και τον 
     * επιστρέφει στην έξοδο.
     * αριθμοί 
     * @param row συντεταγμένη της γραμμής του πίνακα.
     * @param column συντεταγμένη της στήλης του πίνακα.
     * @return table πίνακας τύπου int που είτε περιέχει τις τιμές που επιτρέπονται 
     * να προστεθούν στην θέση που ορίζουν τα ορίσματα της συνάρτησης είται την τιμή
     * 0 γι' αυτές που δεν επιτρέπονται.
     */
    @Override
    public int[] getNextPossNumber(int row,int col){
            int loadNextPoss[]=new int[9];
            int table[]=new int[9];
            int limit_row;
            int limit_column;
            loadNextPoss=super.getNextPossNumber(row,col);
            int count[]=new int[9];
            
            if(row>0 && row<=3)
                limit_row=1;
            else if (row>=5 && row<=7)
                limit_row=5;
            else return loadNextPoss;
            
             if(col>0 && col<=3)
                limit_column=1;
            else if (col>=5 && col<=7)
                limit_column=5;
            else return loadNextPoss;
            
                for(int i=limit_row;i<limit_row+3;i++){
                    for(int j=limit_column;j<limit_column+3;j++){
                    if(getBoard().getCell(i,j)!=null)
                    count[getBoard().getCell(i,j).ordinal()]++;
                    }
                }
                
           int counter=0;
           for(int m=0;m<9;m++){
               if(count[m]==0 && loadNextPoss[m]==m+1){
                   table[m]=m+1;
               counter++;}
                
            
            }return table;
    }
    /**
     * Μέθοδος η οποία τροποποιεί την ανίστοιχη της λογικής.Τσεκάρει αρχικά αν
     * είναι λυμμένο σύμγωνα με την απλή λογική και άν όχι , ελέχει τα επιπλέον 
     * τετράγωνα της δομής του.
     * @return true αν είναι γεμάτο και λυμμένο σύμφωνα με όλους τους περιορισμους,
     * και false διαφορετικά.
     */
    @Override
    public boolean Solved(){
        boolean TheRestPuzzleSolved=super.Solved();
         if(TheRestPuzzleSolved!=false){
            int count[]=new int[9];
        for(int helpRow=0;helpRow<2;helpRow++){ 
            for(int helpCol=0;helpCol<2;helpCol++){
                for(int row=(helpRow*4)+1;row<(helpRow*4)+1+3;row++ ){
                    for(int col=(helpCol*4)+1;col<(helpCol*4)+1+3;col++ ){
                    count[getBoard().getCell(row, col).ordinal()]++;
                    }
                }
            }
        }
        for(int itr=0;itr<9;itr++){
            if(count[itr]>1)
                return false;
            else return true;
            }
     }      
      return false;
     }
   /**
     * Μέθοδος η οποία τροποποιεί την αντίστοιχη μέθοδο της SudokuLogic και δίνει
     * τα κατάλληλα ορίσματα("HyperSudoku")και τα περνάει στην αντίστοιχη συνάρτηση ώστε να 
     * φορτώσει τα κατάλληλα αρχεία.
     * @throws NullPointerException 
     */
    
    public void loadSudoku(){
        Integer r=getRandom().nextInt(10);
        String s=r.toString();
        try{
        readSudokuFile("HyperSudoku",s);  
        }catch(IOException e){
            System.out.print("File"+s+"didn t found");
        } 
    }

}