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
public class Cell {
    
    private boolean alive;

    /**
     * create a dead cell
     */
    public Cell() {
        alive = false;
    }
    
    /**
     * Get if the cell is alive
     *
     * @return the value of alive
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * Set if the cell is alive
     *
     * @param alive new value of alive
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

}
