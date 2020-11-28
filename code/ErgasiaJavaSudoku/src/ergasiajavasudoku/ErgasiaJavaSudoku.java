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
public class ErgasiaJavaSudoku {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException,NullPointerException {
       
        
        
     
        DiscreteValues a=DiscreteValues.A;
        DiscreteValues b=DiscreteValues.B;
        DiscreteValues c=DiscreteValues.C;
        DiscreteValues d=DiscreteValues.D;
        DiscreteValues e=DiscreteValues.E;
        DiscreteValues f=DiscreteValues.F;
        DiscreteValues g=DiscreteValues.G;
        DiscreteValues h=DiscreteValues.H;
        DiscreteValues i=DiscreteValues.I;
         
       //1.Dhmiourgia SimpleSudoku,fortwsh tuxaiou puzzle,kai emfanish tou pinaka me enallaktikous tropous.Xrhsh "getNextPossNumber"
       /*  
        SimpleSudoku simple=new SimpleSudoku();
        simple.loadSudoku();
        simple.getBoard().Show();
        System.out.println("");
        System.out.println("");
        simple.getBoard().ShowNumbers();
        
        System.out.println("");
        int[] poss=simple.getNextPossNumber(0,0);
        for(int itr=0;itr<9;itr++){
            if(poss[itr]!=0)
                System.out.println("Possible Number:"+poss[itr]);
        }
        */
        
      // 2. Dhmiourgia HyperSudoku,fortwsh tuxaiou puzzle,emfanish tou pinaka,kai elegxos sto shmeio 0,0.
        /*
        HyperSudoku hyper=new HyperSudoku();
        hyper.loadSudoku();
        hyper.getBoard().ShowNumbers();
        System.out.println("");
        System.out.println("");
        boolean bo1=hyper.validMoves(0,0,a);
        boolean bo2=hyper.validMoves(0,0,b);
        boolean bo3=hyper.validMoves(0,0,c);
        boolean bo5=hyper.validMoves(0,0,e);
        System.out.println("1:"+bo1+" ");
        System.out.println("2:"+bo2+" ");
        System.out.println("3:"+bo3+" ");
        System.out.println("5:"+bo5+" ");
        */
        
      // 3.Dhmiourgia Duidoku,diadoxh kinhsewn apo xrhsth kai Computer.Elegxos getFinished.
       /* 
        Duidoku dui=new Duidoku();
        dui.getBoard().Show();
        System.out.println("");
        System.out.println("");
        dui.playHuman(0, 0, a);
        dui.getBoard().ShowNumbers();
        dui.playHuman(0, 1, b);    //Se periptwsh pou o upologisths exei valei hdh timh sto 
        System.out.println("");    //keli (0,1) h timh poudinei o xrhsths den kataxwreitai.
        System.out.println("");
        dui.getBoard().Show();
        System.out.println("");
        System.out.println("");
        System.out.print("finished:"+dui.getFinished());
       */
        
        
      // 4.Dhmiourgia neou xrhsth,energeies sta statistika tou xrhsth kai sto istoriko paixnidiwn,kai epanafortwsh tou xrhsth.
       /*
        User melissas=new User("melisaskarampas");
        melissas.addGame(2);
        melissas.addGame(3);
        melissas.addGame(7);
        melissas.addSurrender();
        melissas.addWin();
        melissas.addSurrender();
        melissas.saveStatistics();   //Mε την εντολη αυτή αποθηκεύονται τα στατιστικά στο αρχείο <<user>>_statistics.txt
        melissas.loadUser("melissaskarampas"); //Ελέγχει στο αρχείο χρηστών αν υπάρχει το όνομα μέσα. 
        melissas.loadUser("meLisSasKarAmpAs");
        melissas.loadStatistics();    //Ανανεώνει τα στατιστικά χρήστη.
        */
        
        
      
        
        
    }   
    
    
}
