import java.util.Scanner;

public class Ass01_RockPaperScissors {

    private static String readMove(Scanner in, String playerLabel) {
        while (true) {
            System.out.print(playerLabel + " - enter your move (R, P, or S): ");
            System.out.flush();                          // ensure prompt prints before input
            String move = in.nextLine().trim();
            if (move.equalsIgnoreCase("R") || move.equalsIgnoreCase("P") || move.equalsIgnoreCase("S")) {
                move = move.toUpperCase();
                System.out.println(playerLabel + " entered: " + toWord(move));
                return move;
            }
            System.out.println("Invalid move. Please enter only R, P, or S.");
        }
    }

    private static String toWord(String move) {
        switch (move) {
            case "R": return "Rock";
            case "P": return "Paper";
            default:  return "Scissors";
        }
    }

    private static boolean beats(String a, String b) {
        return (a.equals("R") && b.equals("S")) ||
                (a.equals("P") && b.equals("R")) ||
                (a.equals("S") && b.equals("P"));
    }

    private static String actionPhrase(String winner, String loser) {
        if (winner.equals("R") && loser.equals("S")) return "Rock breaks Scissors";
        if (winner.equals("P") && loser.equals("R")) return "Paper covers Rock";
        return "Scissors cuts Paper";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // keep using Redirect input from inputs.txt for your screenshots

        System.out.println("Welcome to Rock, Paper, Scissors!");

        boolean playAgain = true;
        while (playAgain) {
            String a = readMove(in, "Player A");
            String b = readMove(in, "Player B");

            String aWord = toWord(a);
            String bWord = toWord(b);

            if (a.equals(b)) {
                System.out.println(aWord + " vs " + bWord + " — It's a Tie!");
            } else if (beats(a, b)) {
                System.out.println(aWord + " vs " + bWord + " — " + actionPhrase(a, b) + ". Player A wins!");
            } else {
                System.out.println(aWord + " vs " + bWord + " — " + actionPhrase(b, a) + ". Player B wins!");
            }

            System.out.print("Play again? [Y/N]: ");
            String ans = in.nextLine().trim();
            playAgain = ans.equalsIgnoreCase("Y");
            System.out.println();
        }

        System.out.println("Thanks for playing!");
        in.close();
    }
}
