import java.util.Scanner;
public class GameRunner {
    public static void main(String[] args){
        TicTacToe t = new TicTacToe();
        Scanner scan = new Scanner(System.in);

        while(true) {
            t.setup();
            System.out.println("Do you want to stop? ");
            String score = scan.nextLine();
            if(score.equals("y")){
                t.getScore();
                break;
            }

        }
    }
}


// 5 1 9 7 4 6 8 2 3

