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
public class JeuVie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length > 3) throw new IllegalArgumentException("Il y a plus que 3 arguments");
        
        String filename = null;
        int nbGeneration = 0;
        boolean showAll = true;
        
        try{
            filename = args[0];
            nbGeneration = Integer.parseInt(args[1]);
            showAll = Boolean.parseBoolean(args[2]);
        }catch(ArrayIndexOutOfBoundsException e){
            
        }finally{
            Simulation sim = new Simulation(filename, nbGeneration, showAll);
        }
    }
        
}
