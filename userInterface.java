/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeuvie;

/**
 *
 * @author sinottan
 */
public class UserInterface {
    char symbole[];

    /**
     * select the symbols to print
     * @param symbole 
     */
    public UserInterface(char[] symbole) {
        this.symbole = symbole;
    }
    
    /**
     * 
     * @param prompt the message to display to the user
     * @param error the message 
     * @return the number of generation
     * 
     */
    public int askNbGeneration(String prompt, String error){
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String input;
        int result;
   
        System.out.print(prompt);
        input = sc.next();

        while(!input.matches("\\d+|\\-\\d+")){
            System.out.println(error);
            System.out.print(prompt);
            input = sc.next();
        }

        result = Integer.parseInt(input); 
         
        return result;
    }
    
     public int askNbGeneration(int nbGeneration, String prompt, String error){
        if (nbGeneration > 0) {
            return nbGeneration;
        }
         
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String input;
        int result;
        System.out.print(prompt);
        input = sc.next();

        while(!input.matches("\\d+|\\-\\d+")){
            System.out.println(error);
            System.out.print(prompt);
            input = sc.next();
        }

        result = Integer.parseInt(input); 
         
        return result;
    }
    
    
    public void printGrid(Grid grid){
        for (int i = 0; i < grid.getHeight(); i++) {
            for (int j = 0; j < grid.getHeight(); j++) {
                char toPrint = (grid.isAlive(i,j))? symbole[0] : symbole[1];
                System.out.print(toPrint + " ");
            }
            System.out.print("\n");
        }
    }
}
