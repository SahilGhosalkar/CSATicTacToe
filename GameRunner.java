import java.util.Scanner;

/**
 * The main class to run the TicTacToe game.
 */
public class GameRunner {

    /**
     * The main method to start the TicTacToe game.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // User input
        System.out.println("Player one name: ");
        String name1 = scan.nextLine();
        System.out.println("Player two name: ");
        String name2 = scan.nextLine();

        // Object instantiated
        TicTacToe t = new TicTacToe(name1, name2);

        while (true) {
            t.setup();
            System.out.println("Do you want to stop? ");
            String score = scan.nextLine();
            if (score.equals("y")) {
                t.getScore();
                break;
            }
        }
    }
}
// 1 2 3 6 5 7 4 9 8