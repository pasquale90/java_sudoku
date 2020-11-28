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
 * Κλάση που κληρονομεί από την Computer.
 */
public class ComputerInstance extends Computer{
    /**
     * Μέθοδος η οποία υλοποιεί το τρόπο με τον οποίο παίζει ο υπολογιστής στην 
     * τρίτη παραλλαγή Sudoku.Τροποποιεί και επεκτείνει την play της κλάσης Computer.
     * Αναλυτικότερα, με την κλήση της μεθόδου, θέτεται εντός ορίων του πίνακα(CheckPosition)
     * μία τυχαία διακριτή επιτρεπτή τιμή τύπου DiscreteValues σε κάποιο κενό κελί του πίνακα.(με την 
     * κλήση της board.getRandomEmpty())
     * @param Παίρνει σαν όρισμα έναν ολόκληρο πίνακα board
     */
    @Override
    public void play(Board board)throws NullPointerException{
             CheckPosition checkposition = board.getRandomEmpty();
             board.setV(checkposition.getX(), checkposition.getY(),board.getRandomValueforDui(checkposition.getX(), checkposition.getY()));
   }
    
}
