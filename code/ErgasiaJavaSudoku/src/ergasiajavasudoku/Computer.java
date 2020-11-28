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
 * Κλάση που υλοποιεί τη λειτουργεία του υπολογιστή.Είναι τύπου abstract, γι αυτό 
 * και δε περιέχει κάποιο block εντολών.
 */
public abstract class Computer {
    
  /**
   * Μέθοδος η οποία υλοποιεί τη λειτουργεία του υπολογιστή..Το block εντολών της 
   * μεθόδου υλοποιείται στην αντιστοιχη μέθοδο της κληρονομούσας κλάσης CοmputerInstance. 
   * @param Παίρνει σαν όρισμα έναν ολόκληρο πίνακα board
   */

public abstract void play(Board board);
    
    
}