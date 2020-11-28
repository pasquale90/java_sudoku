/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ergasiajavasudoku;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
/**
 * @author Πασχάλης Μελισσάς ΑΕΜ:1901
 * @version 27/1/2014
 */


/**
 * Κλάση που υλοποιεί την λογική του παιχνιδιού.Είναι τύπου abstract.
 */
public abstract class SudokuLogic implements Help {
    private Board board;
    private Random random;
   
    /**
     * Κατασκευαστής της κλάσης.
     * @param rows το πλήθος γραμμών του πίνακα που θα δημιουργηθεί.
     * @param columns το πλήθος στηλών του πίνακα που θα δημιουργηθεί.
     */
    
    public  SudokuLogic(int rows,int columns) {
        
        random = new Random();
        board = new Board(rows,columns);
    }
    
    
    /**
    * Μέθοδος η οποία θέτει μία τιμή τύπου DiscreteValues σε ένα κελί του πίνακα.
    * Η υλοποίηση της βρίσκεται στις κληρονομούσες κλάσεις σύμφωνα με τις απαιτήσεις
    * της κάθε μίας ξεχωριστά.
    * @param row συντεταγμένη της γραμμής του πίνακα.
    * @param column συντεταγμένη της στήλης του πίνακα.
    * @param val τιμή τύπου DiscreteValues που γεμίζει το κελί του πίνακα με τις 
    * παραπάνω συντεταγμένες.
    */ 
    abstract public void playHuman(int row, int column,DiscreteValues val);
    
    
    /**
     * 
     * @return to πεδίο board  της κλάσης.
     */
     public Board getBoard() {
        return board;
    }
     
     
     /**
      * 
      * @return το πεδίο random της κλάσης.
      */
     public Random getRandom() {
        return random;
    }
     
     /**
      * Μέθοδος που ελέγχει αν έχει τελειώσει το παιχνίδι.Στις κληρονομούσες κλά-
      * σεις HyperSudoku και Duidoku η μέθοδος τροποποιείτα κατάλληλα.
      * @return true αν είναι λυμμένο σωστά ή αν είναι γεμάτος ο πίνακας και false
      * σε διαφορέτική περίπτωση.
      */
     
     public boolean getFinished() {
        return (Solved() || board.isFull());
    }
     
     /**
      * Μέθοδος η οποία εμφανίζει το περιεχόμενο ενός κελιού του πίνακα.
      * @param row συντεταγμένη της γραμμής του πίνακα.
      * @param column συντεταγμένη της στήλης του πίνακα.
      * @return  Η τιμή που επιστρέφει είναι τύπου DiscreteValues ή αλλιώς null αν το κελί το πίνακα είναι 
      * κενό.
      */
     public DiscreteValues getCellValue(int row, int column) {
        return board.getCell(row,column);
    }
     
   
    
     /**
      * Μέθοδος η οποία ελεγχει αν ένα Sudoku είναι ολοκληρωμένο και μάλιστα σωστά
      * λυμμένο.Η μέθοδος τροποποιείται κατάλληλα στις παραλλαγές HyperSudoku και
      * Duidoku μέσω της getFinished().
      * @return true αν είναι λυμμένο και false διαφορετικά. 
      */
     public boolean Solved(){
        boolean flag_rows=false;
        boolean flag_columns=false;
        boolean flag_squares=false;
        
        
        //Έλεγχος Στηλών
        
        for(int col=0;col<board.getColumns();col++){
            int count[]=new int [board.getColumns()];
            for(int row=0;row<board.getRows();row++){
                if (board.getCell(row,col) == null) {
                    return false;
                }
                count[board.getCell(row,col).ordinal()]++;
                }
            for(int i=0;i<board.getColumns();i++){
                if (count[i]>1)
                    return false;
                 }
            flag_columns=true;
        }
        
        
    //Έλεγχος Γραμμών  
        for(int r=0;r<board.getRows();r++){
            int count[]=new int [board.getRows()];
          for(int col=0;col<board.getColumns();col++)  {
                if (board.getCell(r, col) == null) {
                    return false;
               }
                count[board.getCell(r,col).ordinal()]++;
                }
            for(int i=0;i<board.getRows();i++){
                if (count[i]>1)
                    return false;
                }
            flag_rows=true;
            } 
        
        //Έλεγχος τετραγώνων
             /**
              * Η help καλείται για να εξυπηρετήσει τα βήματα επανάληψης στις for
              * loops που ακολουθούν.Αυτό γίνεται διότι οι δύο πρώτες παραλλαγές
              * σε σύγκριση με την πρώτη, κατασκευάζουν διαφορετικού μεγέθους 
              * πίνακα, άρα και οι αντιστοιχίες τετραγώνων διαφοροποιούνται.
              *  
              */ 
            
            int help=board.addSubSquareHelpSize(); 
       
       for (int r_square=0;r_square<board.getRows();r_square+=help){
            for (int c_square=0;c_square<board.getColumns();c_square+=help){
                int count[]=new int [board.getRows()];
                    for (int row=r_square;row<(r_square+help);row++){
               // int count[]=new int [rows];
                        for (int col=c_square;col<(c_square+help);col++){
                            if (board.getCell(r_square,col) == null) {
                            return false;
                            }
                        count[board.getCell(row,col).ordinal()]++;
                        }
                    }
                for(int i=0;i<board.getRows();i++){
                    if (count[i]>1)
                    return false;
                }
            flag_squares=true;
            }
       }
        
    
        if ( flag_rows==true && flag_columns==true && flag_squares==true  )
            return true;
        else return false;
    
    
    }
   
    
     /**
      * Μέθοδος που φορτώνει 10 διαφορετικά puzzle για κάθε μία απ τις δύο πρώτες
      * παραλλαγές Sudoku, δλδ SimpleSudoku και HyperSudoku.
      * 
      * @SOS Σημειωτέον ότι για να φορτώσει τα αρχεία θα πρέπει ο χρήστης να αλλάξει το 
      * path και να το αντικαταστήσει με αυτό που είναι τοποθετημένος ο φάκελος της 
      * εφαρμογής "ErgasiaJavaSudoku" στον υπολογιστή του.
      * 
      * @param folder παίρνει τιμές "SimpleSudoku" για φορτωση puzzle τύπου SimpleSudoku 
      * και"HyperSudoku" για φορτωση puzzle τύπου HyperSudoku.
      * @param filename παίρνει τιμές από το 0 μέχρι το 9.
      * @throws IOException 
      */
     public void readSudokuFile(String folder,String filename)throws IOException{
         String path;
         
         //CHANGE THIS PATH ACCORDINGLY
         path="C:\\Users\\Melissas_90\\Desktop\\Java\\Εργαστήριο\\Εργαστήριο 5\\ErgasiaJavaSudoku\\SudokuFiles\\"+folder+"\\"+filename+".txt";
         BufferedReader in = new BufferedReader(new FileReader(path));
         
         
                   String line;
                   int val;
                    
                    while ((line = in.readLine()) != null){
                       String[] values = line.split("\\W+");
                       int x=0;
                      for (int i = 0; i < 9; i++){
			   for (int j = 0; j < 9; j++){
                              
                               
                                 val=Integer.parseInt(values[x++]); //Μετατροπή της values από String σε int.
                                 if(val!=0){
                                    for(DiscreteValues v: DiscreteValues.values()){
                                        if(v.getValue()==val)
                                            board.setV(i,j,v);
                                    }
                                 }
                           }
                       }    
                   
                         
                   }
                    in.close();
    }

      /**
      * Μέθοδος η οποία υλοποιεί την λειτουργεία της βοήθειας στον χρήστη, και 
      * του επιτρέπει να δει σε κάποιο κελί τις πιθανές τιμές οι οποίες μπορούν 
      * να μπούν.Επίσης αποτελεί μία μέθοδο ελέγχου η οποία θα κληθεί στην κλάση 
      * γραφικών πριν την είσοδο κάποιας τιμής σε κάποιο κενό κελί, αποτρέποντας
      * τον χρήστη να βάλει μη έγκυρες τιμές στο αντίστοιχο κενό κελί.Στην παραλ-
      * λαγή ΗyperSudoku η συνάρτηση τροποποιείται κατάλληλα.
      * @param row συντεταγμένη της γραμμής του πίνακα.
      * @param column συντεταγμένη της στήλης του πίνακα.
      * @return pinakas τύπου int που περιέχει τιμές τύπου DiscreteValues που επι-
      * τρέπονται να μπούν σε κάποιο μοναδικό κενό κελί του οποίου τις συντεταγμένες
      * τις περνιούνται στα ορίσματα row και column.
      */
     
     @Override
     public int[] getNextPossNumber(int row,int column){
        return board.NextPossNumber(row, column);
     }
     
     /**
      * Μέθοδος η οποία ελέγχει αν είναι επιτρεπτή μία κίνηση σε κάποιο κελί.
      * @param row συντεταγμένη της γραμμής του πίνακα.
      * @param column συντεταγμένη της στήλης του πίνακα.
      * @return true αν είναι επιτρεπτή κίνηση και false διαφορετικά.
      */
     @Override
     public boolean validMoves(int row,int column,DiscreteValues val){                
         return board.getvalidMoves(row, column, val);
      }
}         
          
         
         
    
