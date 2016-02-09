package jeuvie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * @author Amélie Frappier
 * @version 1
 * on 2016-02-05.
 */
public class SimulationReader {

    private RandomAccessFile file;

    public SimulationReader(String prompt) {
        System.out.println(prompt);
        Scanner userInput = new Scanner(System.in);
        String filename = userInput.next();
        try {
            file = new RandomAccessFile(new File(filename), "r");
        }
        catch (FileNotFoundException ex) {
            System.out.println("Le fichier " + filename + " est introuvable.");
        }
        catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    
    public SimulationReader(String fileNameArgs, String prompt) {
        try{
            file = new RandomAccessFile(new File(fileNameArgs), "r");
        }catch(FileNotFoundException e){
            System.out.println(prompt);
            Scanner userInput = new Scanner(System.in);
            String filename = userInput.next();
            try {
                file = new RandomAccessFile(new File(filename), "r");
            }
            catch (FileNotFoundException ex) {
                System.out.println("Le fichier " + filename + " est introuvable.");
            }
            catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }
        
    }
    
    /**
     * Reads the file from left to right and returns the grid width
     * @return the width of the grid as read by the reader
     */
    public int readGridWidth() {
        int width = 0;

        try {
            file.seek(0);
            String firstLine = file.readLine();
            width = firstLine.length();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

        return width;
    }

    /**
     * Reads the file from top to bottom and returns the grid height
     * @return the height of the grid as read by the reader
     */
    public int readGridHeight(int width) {
        int height = 0;
        try {
            file.seek(0);
            height = (int)(file.length()-(2*width))/width;
            file.seek(0);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        
        if (width != height) {
            throw new IllegalArgumentException("La grille n'est pas carrée");
        }

        return height;
    }

    /**
     * Reads a grid from the file and
     * @param grid = the grid that is being filled with information from the file
     */
    public Grid readGrid(Grid grid) {
        try {
            file.seek(0);

            for (int i = 0; i < grid.getHeight(); i++) {
                String isAlive = file.readLine();
                for (int j = 0; j < grid.getWidth(); j++) {
                    if (isAlive.charAt(j) == '1') {
                        grid.isBorn(j,i);
                    }
                }
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return grid;
    }

    /**
     * Closes the simulation file
     */
    public void close() {
        try {
            file.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
