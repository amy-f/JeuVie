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
public class Grid {
    private Cell[][] grid;
    private int height;
    private int width;

    /**
     * constructor
     * @param height the size of the grid
     * (precondition: size > 0)
     * @param width the width of the grid
     * (precondition: width > 0)
     * (postcondition: make a valid table)
     */
    public Grid(int width, int height) {
        if (height > 0) {
            this.height = height;
        }else{
           throw new IllegalArgumentException("La hauteur doit être positive"); 
        }

        if (width > 0) {
            this.width = width;
        }else{
           throw new IllegalArgumentException("La largeur doit être positive");
        }
        
        grid = new Cell[height][width];
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = new Cell();
            } 
        }
    }

    /**
     * @return the height of the grid
     */
    public int getHeight() {return height;}

    /**
     * @return the width of the grid
     */
    public int getWidth() { return width; }
    
    /**
     * put a cell alive 
     * @param x the coordinate in x
     * (precondition: x >= 0 && x < size)
     * @param y the coordinate in y
     * (precondition: y >= 0 && y < width)
     * (postcondition: put a valid cell alive)
     */
    public void isBorn(int x, int y){
         if (x < 0 || x > width) {
            throw new IllegalArgumentException("l'indice n'est pas dans le tableau: " + x);
         }else if(y < 0 || y > height){
            throw new IllegalArgumentException("l'indice n'est pas dans le tableau: " + y);
         }else{
            grid[y][x].setAlive(true);
         } 
    }
    
    /**
     * kill a cell
     * @param x the coordinate in x
     * (precondition: x >= 0 && x < size)
     * @param y the coordinate in y
     * (precondition: y >= 0 && y < width)
     * (postcondition: kill a valid cell)
     */
    public void kill(int x, int y){
      if (x < 0 || x > width) {
            throw new IllegalArgumentException("l'indice n'est pas dans le tableau: " + x);
      }else if(y < 0 || y > height){
            throw new IllegalArgumentException("l'indice n'est pas dans le tableau: " + y);
      }else{
            grid[y][x].setAlive(false);
      } 
    }

    /**
     * @param x = the coordinate in x
     * @param y = the coordinate in y
     * @return if cell at given index is currently alive
     */
    public boolean isAlive(int x, int y){
        return grid[x][y].isAlive();
    }
    
}
