/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ergasiajavasudoku;

import java.util.ArrayList;
import java.util.Random;
/**
 * @author Πασχάλης Μελισσάς ΑΕΜ:1901
 * @version 27/1/2014
 */
 
/**
 * @ Κλάση Board που υλοποιεί το πίνακα πάνω στον οποίο θα σχεδιαστεί η εφαρμογή.
 * @param cells τύπου DiscreteValues.Πρόκειται για τα κελιά-κουτάκια του πίνακα.
 * @param rows τύπου int.Πρόκειται για τον αριθμό γραμμών του αντίστοιχου πίνακα.
 * @param columns τύπου int.Πρόκειται για τον αριθμό στηλών του αντίστοιχου πίνακα.
 * @param random τύπου Random.Xρησημοποιείται βοηθητικά για την υλοποίηση συναρτήσεων 
 *              οι οποίες απαιτούν τυχαίες μεταβλητές.
 * @param 
 */
public class Board {
    private DiscreteValues[][] cells;
    private int rows;
    private int columns;
    private Random random;
    
    
    
    /**
     * Κατασκευαστής κλάσης Board.Παίρνει σαν ορίσματα το πλήθος των γραμμών και 
     * των στηλών που επιθυμούμε να έχει.Με αυτόν τον τρόπο επιτυγχάνεται η σύμπτυξη
     * κώδικα και παράλληλα η υλοποίηση του board  και για τις τρεις παραλλαγές Su-
     * doku που ζητούνται.
     * @param rows αρχικοποίηση γραμμών αντίστοιχου του πίνακα. 
     * @param columns αρχικοποίηση στηλών του αντίστοιχου πίνακα. 
     */
    public Board(int rows,int columns){
        random = new Random();
        this.rows=rows;
        this.columns=columns;
        cells=new DiscreteValues[this.rows][this.columns];
       
    }
    
    /**
     * Βοηθητική Μέθοδος για την υλοποίηση της συναρτήσεων "Solved" και "getNextPossNumber"
     * οι οποίες υλοποιούνται για λόγους ορθής σχεδίασης στην κλάση "SudokuLogic".
     * @return μεταβλητή τύπου int με διακριτές δυνατές τιμές 3 και το 2.
     */
    
    public int addSubSquareHelpSize(){
        if (rows==9 && columns==9)
        return rows*columns/(9*3);
        else 
        return rows*columns/(4*2);
        }
    
    /**
     * Συνάρτηση η οποία χρησημοποιείται από την κλάση ComputerInstance ώστε στην τρίτη 
     * παραλλαγή Sudoku, ο υπολογιστής να είναι σε θέση να επιστρέφει ένα κελί του πίνακα
     * το οποίο είναι κενό, και μάλιστα σε τιμές εντός των ορίων του πίνακα, μιας και 
     * επιστρέφει τιμές τύπου CheckPosition.
     * @return ένα ζευγάρι τιμών χ και ψ τύπου CheckPosition.
     */
    public CheckPosition getRandomEmpty() {
        ArrayList<CheckPosition> empty = new ArrayList<>();
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (cells[row][col] == null) {
                    empty.add(new CheckPosition(row, col));
                }
            }
        }
        return empty.get(random.nextInt(empty.size()));
    }
    
    
    /**
     * Μέθοδος η οποία επιστρέφει τυχαίες τιμές τύπου DiscreteValues, και χρησιμο-
     * ποιείται απο την computer ώστε στην τρίτη παραλλαγή Sudoku ο υπολογιστής να 
     * επιστρέφει τιμές έγκυρες.
     * @return τυχαίες τιμές τύπου DiscreteValues.
     * @throws NullPointerException 
     */
    public DiscreteValues getRandomValueforDui(int row,int column)  throws NullPointerException{
        Random r1=new Random();
        DiscreteValues PinakasTimvn[]=new DiscreteValues[4];
        DiscreteValues valid;
        PinakasTimvn[0]=DiscreteValues.A;
        PinakasTimvn[1]=DiscreteValues.B;
        PinakasTimvn[2]=DiscreteValues.C;
        PinakasTimvn[3]=DiscreteValues.D;
        do{
           valid=PinakasTimvn[r1.nextInt(4)];
            }while (!getvalidMoves(row,column,valid));
       try
            {
                return valid;
                
            }
            catch(NullPointerException e){
                return getRandomValueforDui(row,column);
                }
     }
    
  /**
   * Επιστέφει τον ταξινομημένο πίνακα σε μορφή WordDoku(με γράμματα αντί αριθμών) 
   * και τον εμφανίζει στην έξοδο output του Netbeans.Σε περίπτωση υλοποίησης γρα-
   * φικών θα χρειαστεί μία σχετικα μικρή τροποποίηση.
   */
    
    public void Show(){
        for (int i=0;i<rows;i++){
            System.out.println("");
            for (int j=0;j<columns;j++)
                System.out.print(cells[i][j]+"\t");  
            }
         
        }
 /**
   * Επιστέφει τον ταξινομημένο πίνακα σε μορφή Sudoku(με αριθμούς) και τον 
   * εμφανίζει στην έξοδο output του Netbeans.Σε περίπτωση υλοποίησης γραφικών 
   * θα χρειαστεί μία σχετικα μικρή τροποποίηση.
   * @throws NullPointerException 
 */
    
    public void ShowNumbers() throws NullPointerException{
        for (int i=0;i<rows;i++){
            System.out.println("");
            for(int j=0;j<columns;j++)
                if(cells[i][j]!=null)
                System.out.print(cells[i][j].getValue()+"\t");
                else {
                    cells[i][j]=null;
                    System.out.print(cells[i][j]+"\t");
                    }
                }
        }
    
   /**
    * Μέθοδος η οποία θέτει μία τιμή τύπου DiscreteValues σε ένα κελί του πίνακα.
    * @param row συντεταγμένη της γραμμής του πίνακα.
    * @param column συντεταγμένη της στήλης του πίνακα.
    * @param val τιμή τύπου DiscreteValues που γεμίζει το κελί του πίνακα με τις 
    * παραπάνω συντεταγμένες.
    */ 
     
   public void setV(int row,int column,DiscreteValues val){
       cells[row][column]=val;
    }
    
   
   /**
    * Μέθοδος η οποία ελέγχει αν ο πίνακας είναι γεμάτος-πλήρης.
    * @return true αν ο πίνακας είναι γεμάτος και false ακόμα και αν έστω ένα κελί
    * έχει τιμή null.
    */
    public boolean isFull() {
        for (int i = 0; i <rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (cells[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

/**
 * Mέθοδος η οποία επιστρέφει το πλήθος γραμμών του πίνακα.
 * @return την μεταβλητή rows του πίνακα.
 */
public int getRows(){
    return rows;
    }

/**
 * Mέθοδος η οποία επιστρέφει το πλήθος στηλών του πίνακα.
 * @return την μεταβλητή columns του πίνακα.
 */
public int getColumns(){
    return columns;
    }

/**
 * Mέθοδος η οποία επιστρέφει την τιμή ενός κελιού του πίνακα με συντεταγμένες row
 * για τη συντεταγμένη γραμμής, και column για την συντεταγμένη στήλης
 * @param row συντεταγμένη της γραμμής του πίνακα.
 * @param column συντεταγμένη της στήλης του πίνακα.
 * @return Η τιμή που επιστρέφει είναι τύπου DiscreteValues ή αλλιώς null αν το κελί το πίνακα είναι 
 * κενό.
 */
public DiscreteValues getCell(int row,int column){
    return cells[row][column];    
    }

 /**
  * Μέθοδος η οποία υλοποιεί την λειτουργεία της βοήθειας στον χρήστη, και 
  * του επιτρέπει να δει σε κάποιο κελί τις πιθανές τιμές οι οποίες μπορούν 
  * να μπούν.Η μέθοδος χρησημοποιείται στην κλάση της λογικής και από εκεί 
  * σε κάθε παραλλαγή.
  * @param row συντεταγμένη της γραμμής του πίνακα.
  * @param column συντεταγμένη της στήλης του πίνακα.
  * @return pinakas τύπου int που περιέχει τιμές τύπου DiscreteValues που επι-
  * τρέπονται να μπούν σε κάποιο μοναδικό κενό κελί του οποίου τις συντεταγμένες
  * τις περνιούνται στα ορίσματα row και column.
  */



public int[] NextPossNumber(int row,int column)throws NullPointerException{
         int limit_row;
         int limit_column;
         
         int pinakas[]=new int[rows];
         
         
         if (cells[row][column]==null){
             int count[]=new int[columns];
             
             //Έλεγχος Στηλών
             
             for (int col=0;col<columns;col++){     
                 if(cells[row][col]!=null){
                count[cells[row][col].ordinal()]++; 
                 }
             
             }
             //Έλεγχος Γραμμών
             
             for (int r=0;r<rows;r++){             
                 if(cells[r][column]!=null)
                count[cells[r][column].ordinal()]++;
                }
             
             
             //Έλεγχος τετραγώνων
             /**
              * Η help καλείται για να εξυπηρετήσει τα βήματα επανάληψης στις for
              * loops που ακολουθούν.Αυτό γίνεται διότι οι δύο πρώτες παραλλαγές
              * σε σύγκριση με την πρώτη, κατασκευάζουν διαφορετικού μεγέθους 
              * πίνακα, άρα και οι αντιστοιχίες τετραγώνων διαφοροποιούνται.
              *  
              */ 
             
             
             int help=addSubSquareHelpSize();
             
             if (row<help)
                 limit_row=0*help;
             else if (row>=help && row<2*help)
                 limit_row=help;
             else
                 limit_row=2*help;
            
             if (column<help)
                 limit_column=0*help;
             else if (column>=help && column<2*help)
                 limit_column=help;
             else
                 limit_column=2*help;
             
             
             for(int i=limit_row;i<(limit_row+help);i++){
                for (int j =limit_column;j<(limit_column+help);j++){
                    if(cells[i][j]!=null)
                    count[cells[i][j].ordinal()]++;
                    }
                }
             
           int counter=0;
           for(int m=0;m<rows;m++){
               if(count[m]==0){
                   pinakas[counter]=m+1;
               counter++;}
               
                }
           
             
         }
             
         return pinakas;
      }


    /**
    * Μέθοδος η οποία ελέγχει αν είναι επιτρεπτή μία κίνηση σε κάποιο κελί.Ελέγχει
    * δλδ αν η τιμή που θέλει ο χρήστης ή ο υπολογιστής να βάλει σε κάποιο συγκε-
    * κριμένο κελί, υπαρχει στον πίνακα valid ο οποίος παίρνει σαν είσοδο την έξοδο
    * της NextPossNumber στο ίδιο κελί.Χρησημοποιείται και στην μέθοδο "getRandom-
    * ValueforDui" ώστε ο υπολογιστής να επιστρέφει επιτρεπτή τιμή , σύμφωνα με την
    * λογική του παιχνιδιού.
    * @param row συντεταγμένη της γραμμής του πίνακα.
    * @param column συντεταγμένη της στήλης του πίνακα.
    * @return true αν είναι επιτρεπτή κίνηση και false διαφορετικά.
    */
      public boolean getvalidMoves(int row,int column,DiscreteValues val){                
         int valid[]=NextPossNumber(row,column);
            for(int i=0;i<rows;i++){
                if(valid[i]==val.getValue())
                    return true;
                }
            return false;
      }



}









             
      
    