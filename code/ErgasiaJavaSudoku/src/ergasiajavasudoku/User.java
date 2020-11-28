/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ergasiajavasudoku;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author Πασχάλης Μελισσάς ΑΕΜ:1901
 * @version 27/1/2014
 */


/**
 * Κλάση η οποία υλοποιεί τη ύπαρξη χρηστών σύμφωνα με τα ζητούμενα της εργασίας
 * @param nickname το ψευδόνυμο και πρωτεύον κλειδί του κάθε χρήστη.
 * @param statistics διθέσιος πίνακας στατιστικών τύπου Integet.Η πρώτη θέση δηλώνει τις 
 * νίκες του αντίστοιχου χρήστη, ενώ η δεύτερη αντιπροσωπεύει το πλήθος τον puzzles που 
 * δεν κατάφερε να λύσει.
 * @param random πίνακας
 */
public class User {
    private String nickname;
    private Integer statistics[];
    String path;
    String folder;
    FileOutputStream GamesPlayed;
    FileWriter StatisticsWriter,UsersWriter;
    File user_dir;
    BufferedReader StatisticsReader,UsersReader;
    File file;
    
    FileInputStream a;
    
   /**
    * Κατασκευαστής κλάσης User.Aφορά χρήστες με επώνυμη αλληλεπίδραση.Καλώντας τον
    * κατασκευαστή, αρχικοποιούνται τα πεδία της κλάσης, και δημηοθργείται αυτόματα
    * ένας νέος φάκελος με όνομα το nickname του χρήστη,μέσα στον φάκελο Users που
    * βρίσκεται στα αρχεία του προγράμματος.Μέσα σε κάθε φάκελο δημιουργούνται δύο
    * ξεχωριστά αρχεία με όνομα "<<nickname>>_gamesPlayed.txt" και "<<nickname>>_Statistics".
    * Το πρώτο αφορά την αποθήκευση των puzzles που έχει λύσει ο χρήστης σύμφωνα με τις απαι-
    * τησεις της εργασίας, και το δεύτερο αφορά τα στατιστικά χρήστη. 
    * 
    * @SOS Προυπόθεση για να τρέξει σωστά η φόρτωση και η δημιουργία φακέλων και αρχείων,θα πρέπει 
    * ο χρήστης να αλλάξει το path1 και να το αντικαταστήσει με αυτό που είναι τοποθετημένος ο φάκελος της 
    * εφαρμογής "ErgasiaJavaSudoku" στον υπολογιστή του. 
    * 
    * @param nickname το αναγνωριστικό προσωνύμιο του χρήστη.
    * @throws IOException 
    */
   
    public User(String nickname)throws IOException{
        this.nickname=nickname;
       
        statistics=new Integer[2];
        statistics[0]=0;                                //wins
        statistics[1]=0;                                //surrs
        
        
        //CHANGE THESE PATHS ACCORDINGLY
        folder="Users\\";
        path="C:\\Users\\Melissas_90\\Desktop\\Java\\Εργαστήριο\\Εργαστήριο 5\\ErgasiaJavaSudoku\\";
       
        user_dir=new File(folder+"\\"+nickname);
        user_dir.mkdir();
        
        GamesPlayed=new FileOutputStream(path+folder+nickname+"\\"+nickname+"_gamesPlayed.txt");
        StatisticsWriter=new FileWriter(path+folder+nickname+"\\"+nickname+"_Statistics.txt");
        UsersWriter=new FileWriter(path+"Users_nicks.txt");
        file=new File(path+folder);
        StatisticsReader = new BufferedReader( new FileReader(path+folder+nickname+"\\"+nickname+"_Statistics.txt"));
        RegisterUser();
    }
   /**
    * Κατασκευαστής κλάσης που χρησημοποιείται για χρήστες με ανώνυμη αλληλεπίδραση.
    * Επίσης χρησημοπιείται στην μέθοδο loginUser, ώστε για κάποιον προυπάρχων χρήστη
    * να μην αρχικοποιούνται τα προσωπικά του αρχεία δεδομένων, και να παραμένουν από-
    * θηκευμένα.
    */
   public User() throws FileNotFoundException{ 
     
   }
   

   /**
    * Μέθοδος η οποία αποθηκεύει τα αναγνωριστικά id των αποθηκευμένων puzzles που
    * έχει λύσει ο χρήστης σε ένα αρχείο με όνομα <<nickaname>>_gamesPlayed.txt που 
    * βρίσκεται στον αντίστοιχο φάκελο του χρήστη μέσα στον φάκελο Users.Η μέθοδος 
    * πρέπει να καλείται κάθε φορά μετά το τέλος ενός παιχνιδιού, εφόσον ο χρήστης
    * έχει σημειώσει "νίκη".
    * @param id τύπου int.Αντιπροσωπεύει το όνομα του αρχείου .txt του puzzle το ο-
    * ποίο έλυσε ο χρήστης.
    * @throws IOException 
    */
   public void addGame(Integer id)throws IOException{
       String s=id.toString();                           //Μετατροπή int σε String.
       DataOutputStream os=new DataOutputStream(GamesPlayed);
       try { 
           os.writeChars(s);
            os.flush();
           } catch (IOException e) { 
               System.out.println("IO Error"); }
   }
   
   
   /**
    * Μέθοδος η οποία αποθηκεύει τα πεδία στατιστικών του χρήστη σε ένα αρχείο με 
    * όνομα <<nickaname>>_Statistics.txt που βρίσκεται στον αντίστοιχο φάκελο του
    * χρήστη μέσα στον φάκελο Users.Το αρχείο , κάθε φορά που καλείται η μέθοδος
    * κλείνει και ξανανοίγει με αποτέλεσμα κάθε φορά που καλούμε την μέθοδο το 
    * παλιό περιεχόμενο σβήνει και αντικαθίσταται από τα νέα στατιστικά.Η μέθοδος 
    * πρέπει να καλείται κάθε φορά μετά το τέλος ενός παιχνιδιού.
    * @throws IOException 
    */
   public void saveStatistics()throws IOException{
     StatisticsWriter.close();
     StatisticsWriter=new FileWriter(path+folder+nickname+"\\"+nickname+"_Statistics.txt");
     String newline = System.getProperty("line.separator");
     String s1=statistics[0].toString();
     String s2=statistics[1].toString();
            try { StatisticsWriter.write("Wins:"+newline+s1+newline+"Surrenders:"+newline+s2); } 
            catch  (IOException e){
            System.out.println("IO Error");}
            finally { if (StatisticsWriter != null) { 
                   try { StatisticsWriter.close(); }
                   catch (IOException e) {  System.out.println("IO Error");} }}
    
   }
   
   
   /**
    * @return το αναγνωριστικό προσωνύμιο του χρήστη τύπου String.
    */
   public String getNickName(){
    return nickname;
    }
   
   
   /**
    * Μέθοδος η οποία τραβάει τα δεδομένα στατιστικών του χρήστη από το αρχείο 
    * όπου είναι αποθηκευμένα.
    * @throws IOException 
    */
   public void loadStatistics()throws IOException{
       String l;
       int i=0;
       String helpBoard[]=new String[4];
            while((l = StatisticsReader.readLine()) != null) {
                helpBoard[i]=l;
                i++;
            }
         Integer wins=Integer.parseInt(helpBoard[1]);
         Integer surs=Integer.parseInt(helpBoard[3]);
            statistics[0]=wins;
            statistics[1]=surs;
   }
   
   
   /**
    * Μέθοδος που προσθέτει μία νίκη του χρήστη στα στατιστικά του.
    * @return το πλήθος τύπου int παιχνιδιών που έλυσε ο χρήστης αυξημένο κατά 1. 
    */
   public int addWin(){
       return ++statistics[0];
    }
   
   /**
    * Μέθοδος που προσθέτει μία "ήττα" του χρήστη στα στατιστικά του.
    * @return το πλήθος τύπου int παιχνιδιών που παραδώθηκε ο χρήστης αυξημένο κατά 1. 
    */
   public int addSurrender(){
       return ++statistics[1];
    }
   
   
   
   /**
    * Μέθοδος που τυπώνει στην οθόνη τα στατιστικά χρήστη.
    */
   public void showStatistics(){
       String newline = System.getProperty("line.separator");
    System.out.println("Wins:"+statistics[0]+newline+"Surrenders:"+statistics[1]+newline);
    }
   
   
   /**
    * Μέθοδος η οποία καλείται και στον κατασκευαστή και αποθηκεύει τα ονόματα των 
    * υπάρχων χρηστών στο αρχείο Users_nicks.txt έτσι ώστε ακόμα και να τερματίσει 
    * εφαρμογή, τα ονόματα των χρηστών που κάναν register να παραμείνουν αποθηκευμέ-
    * να και προσβάσιμα.
    * @throws IOException 
    */
   public void RegisterUser() throws IOException{
     String[] directories = file.list(new FilenameFilter() {
     @Override
     public boolean accept(File dir, String name) {
        return new File(dir, name).isDirectory();
     }
     });
    // System.out.println(Arrays.toString(directories));
      try { UsersWriter.write(Arrays.toString(directories)); } 
            catch  (IOException e){
            System.out.println("IO Error");}
       finally { if (UsersWriter != null) { 
                   try { UsersWriter.close(); }
                   catch (IOException e) {  System.out.println("IO Error");} }}
    
     
   }
   
   /**
    * Μέθοδος η οποία τραβάει το όνομα εγγεγραμένου χρήστη και το επιστρέφει.
    * Σημειωτεον ότι λαμβάνει υπ' όψιν του χαρακτήρες του ονόματος αγνοώντας αν
    * είναι κεφαλαία η μικρά.
    * @param nicknam παράμετρος που δηλώνει το όνομα προυπάρχων χρήστη που αναζη-
    * τούμε από την βάση δεδομένων του προγράμματος.
    * @return true αν υπάρχει το όνομα χρήστη στο αρχείο και false  διαφορετικά.
    * @throws IOException
    * @throws NullPointerException 
    */
   public final boolean loadUser(String nicknam)throws IOException,NullPointerException{
       String l,nick_toLow;
       nick_toLow=nicknam.toLowerCase();
       int i=0;
       String helpBoard[]=new String[20];  //Θέτουμε ανώτατο όριο χρηστών το 20 για λόγους απλοποίησης.
       try{
          UsersReader=new BufferedReader( new FileReader(path+"Users_nicks.txt"));
          }
       catch(FileNotFoundException e){System.out.print("Didn t found file");}
            
       while((l = UsersReader.readLine()) != null ) {
                String[] values = l.split("\\p{Punct}");
           for (String val : values) {
               if(values[i]!=null)
                   helpBoard[i]=values[i].trim().toLowerCase();
               i++;
  
           }
            }
        
       for (String helpB : helpBoard) {
            if(helpB!=null){
                if (helpB.equals(nick_toLow) ) {
                return true;
                }
            }
        }    
    return false; 
   }
    
}
