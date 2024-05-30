
/**
 * The GridSquare class represents a single square on the Tic Tac Toe board.
 */
public class GridSquare {

    // Instance variables
    // State: -1 = empty, 0 = X, 1 = O
    private int state;
    private int pos;

    /**
     * Constructor to initialize the grid square with a position.
     * The state is initially set to -1 (empty).
     * @param pos the position of the grid square on the board
     */
    public GridSquare(int pos) {
        this.pos = pos;
        this.state = -1;
    }

    /**
     * Draws the current state of the grid square.
     * @return 'X' if the state is 0, 'O' if the state is 1, 
     * or the position number if the state is -1 (empty)
     */
    public char drawSpace() {
        if (state == 0) {
            return 'X';
        } else if (state == 1) {
            return 'O';
        } else {
            return Integer.toString(pos).charAt(0);
        }
    }

    /**
     * Gets the current state of the grid square.
     * @return the state of the grid square (-1 for empty, 0 for X, 1 for O)
     */
    public int getState() {
        return state;
    }

    /**
     * Sets the state of the grid square.
     * @param x the new state of the grid square (-1 for empty, 0 for X, 1 for O)
     */
    public void setState(int x) {
        state = x;
    }

    /**
     * Gets the position of the grid square on the board.
     * @return the position of the grid square
     */
    public int getPos() {
        return pos;
    }

    /**
     * Sets the position of the grid square on the board.
     * @param x the new position of the grid square
     */
    public void setPos(int x) {
        pos = x;
    }
}

