/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ergasiajavasudoku;

import java.io.Serializable;

/**
 * @author Πασχάλης Μελισσάς ΑΕΜ:1901
 * @version 27/1/2014
 */

/**
 * Βοηθητική κλάση ελέγχου που χρησημοποιείται για την τρίτη παραλλαγή Sudoku της εργασί-
 * ας ώστε ο υπολογιστής να επιστρέφει τιμές εντός ορίων του πίνακα. 
 * @param x συντεταγμένη γραμμής του πίνακα.
 * @param y συντεταγμένη στήλης του πίνακα.
 */
public class CheckPosition implements Serializable {
    int x;
    int y;
    /**
     * Κατασκευαστής κλάσης ο οποίος αρχικοποιεί τα πεδία του μόνο εφ όσον πάρουν
     * τις επιθυμητές τιμές που απαιτούνται για την εισαγωγή έγκυρων τιμών του 
     * υπολογιστή
     * @param aX αντίστοιχη συντεταγμένη γραμμής του πίνακα.
     * @param aY αντίστοιχη συντεταγμένη στήλης του πίνακα.
     */
    public CheckPosition(int aX, int aY) {
       
        if (aX < 0 || aX > 3) {
            throw new IllegalArgumentException("aX must be between 0 and  3 for Duidoku");
        }
        x = aX;
        if (aY < 0 || aY > 3) {
            throw new IllegalArgumentException("aY must be between 0 and  3 for Duidoku");
        }
        y = aY;
    }
    /**
     * @return int η συντεταγμένη γραμμής του πίνακα.
     */
    public int getX() {
        return x;
    }
    /**
     * @return int η συντεταγμένη στήλης του πίνακα.
     */
    public int getY() {
        return y;
    }
}
