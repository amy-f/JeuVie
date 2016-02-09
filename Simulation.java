package jeuvie;

/**
 * @author Amélie Frappier
 * @version 1
 * on 2016-02-05.
 *
 * Handles the actual simulation using a grid of cells
 *
 */
public class Simulation {

    private Grid grid;
    private int nbGenerations;
    private UserInterface simulInterface;

    /**
     * Constructor without parameters
     * Constructs a simulation and determines parameters using user input
     */
    public Simulation(String fileName, int nbGeneration, boolean printAll) {
        char[] symbol = {'O', '_'};
        simulInterface = new UserInterface(symbol);
        
        SimulationReader reader = new SimulationReader(fileName, "Le nom passé en paramètre n'est pas valide, veuillez saisir le nom du fichier : ");
        
        int gridWidth = reader.readGridWidth();
        int gridHeight = reader.readGridHeight(gridWidth); 
        grid = new Grid(gridWidth, gridHeight);
        simulInterface.printGrid(grid);
        
        grid = reader.readGrid(grid);
        simulInterface.printGrid(grid);
        nbGenerations = simulInterface.askNbGeneration("Veuillez saisir le nombre de générations à afficher:" ,
                "Le nombre de générations doit être un nombre entier positif.");
        reader.close();
    }

    /**
     * Starts a new simulation based on the sent parameters
     */
    public void start() {
        for (int i = 0; i < nbGenerations; i++) {
            simulInterface.printGrid(grid);
            grid = createNewGeneration(grid);
        }
    }

    /**
     * Creates a new generation of cells based on the current cell generation
     * @param g = the grid containing the current generation of cells
     * @return the grid containin the new generation
     */
    public Grid createNewGeneration(Grid g) {
        Grid newGrid = new Grid(g.getWidth(), g.getHeight());
        for (int i = 0; i < g.getHeight(); i++) {
            for (int j = 0; j < g.getWidth(); j++) {
                checkAdjacentTiles(i, j, grid, newGrid);
            }
        }
        return newGrid;
    }

    /**
     * Checks adjacent tiles and changes tiles in the new grid accordingly
     * @param height = the height index the grid is currently at
     * @param width = the width index the grid is currently at
     * @param oldGrid = the old grid where the conditions are checked
     * @param newGrid = the new grid where the new cell
     */
    public void checkAdjacentTiles(int height, int width, Grid oldGrid, Grid newGrid) {

        int cellCounter = 0;

        for (int i = height - 1; i <= height + 1; i++) {
            for (int j = width - 1; j <= width + 1; j++) {

                try {

                    //if not out of bounds, count adjacent tiles
                    if (i >= 0 && i < height && j >= 0 && j < width) {
                        if (oldGrid.isAlive(j,i)) {
                            cellCounter++;
                        }
                    }

                    //check is next gen cell is alive depending on adjacent cells
                    if (oldGrid.isAlive(width, height)) {
                        if (cellCounter >= 1 && cellCounter <= 3) {
                            newGrid.isBorn(width, height);
                        }
                    }
                    else {
                        if (cellCounter == 3) {
                            newGrid.isBorn(width, height);
                        }
                    }


                }
                catch (IndexOutOfBoundsException ex) {
                    System.out.println(ex.toString());
                }


            }
        }
    }


}
