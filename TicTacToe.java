import java.util.ArrayList;
import java.util.Scanner;

/**
 * The TicTacToe class represents the game logic and state for a game of Tic Tac Toe.
 */
public class TicTacToe {

    // Instance Variables
    private int cols = 3;
    private int rows = 3;
    private int totalTurns = 0;
    private int winner = -1;
    private int gameState;
    ArrayList<String> list = new ArrayList<>();

    /**
     * Enum to represent the state of the game.
     */
    enum GameState {
        OVER, RUNNING
    }

    // Current game state
    GameState currentState = GameState.OVER;

    // The game board
    GridSquare[][] board;

    // Player names
    private String name1;
    private String name2;

    /**
     * Constructor to initialize the players' names.
     * @param a the name of the first player
     * @param b the name of the second player
     */
    public TicTacToe(String a, String b) {
        name1 = a;
        name2 = b;
    }

    /**
     * Sets up the Tic Tac Toe game.
     * This method initializes or resets the game state and starts the game.
     */
    public void setup() {
        board = new GridSquare[rows][cols];
        int position = 1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                board[r][c] = new GridSquare(position);
                position++;
            }
        }
        currentState = GameState.RUNNING;
        playGame();
    }

    /**
     * Displays the current state of the game board.
     */
    public void displayBoard() {
        String boardDisplay = "";
        for (int r = 0; r < rows; r++) {
            String pieces = "";
            String divider = "";
            for (int c = 0; c < cols; c++) {
                pieces += " " + board[r][c].drawSpace() + " ";
                if (r != rows - 1) {
                    divider += "_____";
                } else {
                    divider += "   ";
                }
                if (c != cols - 1) {
                    pieces += " | ";
                }
            }
            boardDisplay += pieces + "\n" + divider + "\n";
        }
        System.out.println(boardDisplay);
    }

    /**
     * Prompts the current player to make a move and updates the game state.
     */
    public void makeMove() {
        System.out.println(getPlayer() + " choose a position: ");
        Scanner in = new Scanner(System.in);
        int pos = in.nextInt();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c].getState() == -1 && board[r][c].getPos() == pos) {
                    board[r][c].setState(totalTurns % 2);
                    totalTurns++;
                    checkWin(r, c, board[r][c].getState());
                }
            }
        }
    }

    /**
     * Displays the game over message and the winner.
     * If the game is a tie, it displays a tie message.
     */
    public void displayGameOver() {
        displayBoard();
        System.out.println("Game Over");
        if (winner == 0) {
            System.out.println(name1 + " Wins!");
            list.add(name1);
        } else if (winner == 1) {
            System.out.println(name2 + " Wins!");
            list.add(name2);
        } else if (totalTurns >= 8) {
            System.out.println("Tie game!");
            list.add("---");
        }
    }

    /**
     * Returns the name of the current player based on the total turns taken.
     * @return the name of the current player
     */
    private String getPlayer() {
        if (totalTurns % 2 == 0) {
            return name1;
        } else {
            return name2;
        }
    }

    /**
     * Checks if there is a winner or if the game is a tie after a move.
     * @param row the row of the last move
     * @param col the column of the last move
     * @param turn the current player's turn (0 or 1)
     */
    public void checkWin(int row, int col, int turn) {
        if (checkRow(row, turn) || checkColumn(col, turn) || checkDiagonals(turn)) {
            winner = turn;
            currentState = GameState.OVER;
        } else if (totalTurns == rows * cols) {
            winner = -1; // Indicate a tie
            currentState = GameState.OVER;
        }
    }

    /**
     * Checks if there is a winning row.
     * @param row the row to check
     * @param turn the current player's turn (0 or 1)
     * @return true if there is a winning row, false otherwise
     */
    private boolean checkRow(int row, int turn) {
        for (int c = 0; c < cols; c++) {
            if (board[row][c].getState() != turn) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if there is a winning column.
     * @param col the column to check
     * @param turn the current player's turn (0 or 1)
     * @return true if there is a winning column, false otherwise
     */
    private boolean checkColumn(int col, int turn) {
        for (int r = 0; r < rows; r++) {
            if (board[r][col].getState() != turn) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if there is a winning diagonal.
     * @param turn the current player's turn (0 or 1)
     * @return true if there is a winning diagonal, false otherwise
     */
    private boolean checkDiagonals(int turn) {
        boolean diag1 = true, diag2 = true;
        for (int i = 0; i < rows; i++) {
            if (board[i][i].getState() != turn) {
                diag1 = false;
            }
            if (board[i][rows - 1 - i].getState() != turn) {
                diag2 = false;
            }
        }
        return diag1 || diag2;
    }

    /**
     * Starts and runs the game loop until the game is over.
     */
    public void playGame() {
        while (currentState == GameState.RUNNING) {
            displayBoard();
            makeMove();
        }
        if (currentState == GameState.OVER) {
            displayGameOver();
        }
    }

    /**
     * Displays the score of the game.
     */
    public void getScore() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            System.out.print(" ");
        }
    }
}
