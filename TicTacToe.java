

import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe{

    //Instance Vars
    int cols = 3;
    int rows = 3;
    int totalTurns = 0;

    int winner = -1;
     int gameState;
    ArrayList<String> list = new ArrayList<>();



    //enums are mini classes that represent values
    enum GameState{
        OVER, RUNNING
    }
    //currentState is an instance Var
    GameState currentState = GameState.OVER;

    GridSquare[][] board;

    public void setup(){
        // a 2d array is an array of arrays int[][]. The first [] shows the row, and the second [] shows the collum
        board = new GridSquare[rows][cols];
        int position = 1;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                board[r][c] = new GridSquare(position);
                position++;

            }
        }
        currentState = GameState.RUNNING;
        playGame();

    }

    public void displayBoard() {
        String boardDisplay = "";
        for (int r = 0; r < rows; r++) {
            String pieces = "";
            String divider = "";
            for (int c = 0; c < cols; c++) {
                pieces += " " + board[r][c].drawSpace() + " ";
                if(r != rows - 1){
                    divider += "_____";
                }else{
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
    public void makeMove() {
        System.out.println("Player " + getPlayer() + " choose a position: ");
        Scanner in = new Scanner(System.in);
        int pos = in.nextInt();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c].state == -1 && board[r][c].pos == pos){
                    board[r][c].state = (totalTurns % 2);
                    totalTurns++;
                    checkWin(r,c,board[r][c].state);
                }
            }
        }
    }
    public void displayGameOver() {
        //Draw the board one last time
        displayBoard();
        //Print out "Game Over"
        System.out.println("Game Over");
        //Display winner
        if (winner == 0) {
            System.out.println("X wins!");
            list.add("x");
        }
        else if (winner == 1) {
            System.out.println("O wins!");
            list.add("o");
        }
            //Check for a tie
        else if(totalTurns >= 8) {
            System.out.println("Tie game!");
            list.add("---");
        }
    }

    private char getPlayer(){
        if (totalTurns % 2 == 0){
            return 'X';

        }else{
            return 'O';
        }

    }

    public void checkWin(int row, int col, int turn) {
        if (checkRow(row, turn) || checkColumn(col, turn) || checkDiagonals(turn)) {
            winner = turn;
            currentState = GameState.OVER;
        } else if (totalTurns == rows * cols) {
            winner = -1; // Indicate a tie
            currentState = GameState.OVER;
        }
    }

    private boolean checkRow(int row, int turn) {
        for (int c = 0; c < cols; c++) {
            if (board[row][c].state != turn) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int col, int turn) {
        for (int r = 0; r < rows; r++) {
            if (board[r][col].state != turn) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonals(int turn) {
        boolean diag1 = true, diag2 = true;
        for (int i = 0; i < rows; i++) {
            if (board[i][i].state != turn) {
                diag1 = false;
            }
            if (board[i][rows - 1 - i].state != turn) {
                diag2 = false;
            }
        }
        return diag1 || diag2;
    }
    public void playGame(){
        while (currentState == GameState.RUNNING){
            displayBoard();
            makeMove();
        }
        if(currentState == GameState.OVER){
            displayGameOver();
        }

    }

    public void getScore(){
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i));
            System.out.print(" ");
        }
    }

}

