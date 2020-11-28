/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ergasiajavasudoku;

import java.util.Iterator;

/**
 * @author Πασχάλης Μελισσάς ΑΕΜ:1901
 * @version 27/1/2014
 */

/**
 * Εnumeration στο οποίο σε κάθε γράμμα αντιστοιχίζεται μία τιμή τύπου int.
 * Έτσι επιτυγχάνεται η εναλλακτική αναπαράσταση της εφαρμογής καθώς επίσης 
 * και η διακριτικοποίηση στην είσοδο τιμών από υπολογιστή και χρήστη.
 * Αποτελεί δηλαδή και μία κλάση ελέγχου.
 */
public enum DiscreteValues {
   A(1) , B(2) , C(3) , D(4) , E(5) , F(6) , G(7) , H(8) , I(9);

   /**
    * Μέθοδος στην οποία σε κάθε γράμμα αντιστοιχίζεται μία τιμή τύπου int.
    */
  private int value;
   DiscreteValues(int value){
    this.value=value;
    }
   
   
   /**
    * @return την τιμή int που αντιστοιχεί σε κάποιο γράμμα .
    */
   public int getValue(){
    return value;
    }
}
