/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ergasiajavasudoku;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Πασχάλης Μελισσάς ΑΕΜ:1901
 * @version 27/1/2014
 */
public class NewGame {
    private HashMap <String,HashSet<Integer>>usersList; //String niknames , kai Integer ot id tou sudoku.
    private User user;
    private SudokuLogic logic;
    
    public NewGame(User user,String style,boolean paused){
        this.user=user;
        usersList=new HashMap<>();
        if(!paused){
            switch (style) {
                case "Hyper":
                    logic=new HyperSudoku();
                    break;
                case "Duidoku":
                    logic=new Duidoku();
                    break;
                default:
                    logic=new SimpleSudoku() ;
                    break;
        
             }
        }
    }
    /**
     * @param user
     */
    
     //   public void RegisterUser(){
            
            
       // }
        
        
        
        
    
    
    
    
 /*   public void addGame(String name, String number) {
        if (usersList.containsKey(user.getNickName())) {
            HashSet<String> numbers = usersList.get(name);
            if (numbers.contains(number)) {
                System.out.printf("Ξ¤ΞΏ Ξ½ΞΏΟ�ΞΌΞµΟ�ΞΏ %s ΞµΞ―Ξ½Ξ±ΞΉ Ξ®Ξ΄Ξ· ΞΊΞ±Ο„Ξ±Ο‡Ο‰Ο�Ξ·ΞΌΞ­Ξ½ΞΏ ΟƒΟ„Ξ·Ξ½ ΞµΟ€Ξ±Ο†Ξ® %s%n", number, name);
            } else {
                numbers.add(number);
                usersList.put(, numbers);
                System.out.printf("Ξ�Ξ±Ο„Ξ±Ο‡Ο‰Ο�Ξ®ΞΈΞ·ΞΊΞµ Ο„ΞΏ Ξ½Ξ­ΞΏ Ξ½ΞΏΟ�ΞΌΞµΟ�ΞΏ %s ΟƒΟ„Ξ·Ξ½ Ο…Ο€Ξ¬Ο�Ο‡ΞΏΟ…ΟƒΞ± ΞµΟ€Ξ±Ο†Ξ® %s%n", number, name);
            }
        } else {
            HashSet<String> numbers = new HashSet<>();
            numbers.add(number);
            phonebook.put(name, numbers);
            System.out.printf("Ξ�Ξ±Ο„Ξ±Ο‡Ο‰Ο�Ξ®ΞΈΞ·ΞΊΞµ Ξ½Ξ­Ξ± ΞµΟ€Ξ±Ο†Ξ® %s ΞΌΞµ Ξ½ΞΏΟ�ΞΌΞµΟ�ΞΏ %s%n", name, number);
        }
    }
*/
    
    
}
