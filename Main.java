package game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Board board = null;
    private static Scanner in;
    private static Player player1, player2;
    private static final String[] resultText = new String[]{ "Draw.", "First (X) won.", "Second (O) won." };

    public static void main(String[] args) {
        in = new Scanner(System.in);
        enterData();

        final int result = new Game(
                board,
                player1,
                player2
        ).play(false);

        System.out.print("FINAL RESULT: ");
        System.out.println(resultText[result]);
    }

    private static void enterData() {
        System.out.println("Enter type of board [mnk/hex]:");
        String typeOfBoard;
        while (true) {
            typeOfBoard = in.next();
            if (typeOfBoard.equals("mnk") || typeOfBoard.equals("hex")) {
                break;
            }
            System.out.println("Enter valid type of board [mnk/hex]:");
        }

        System.out.println("Enter size of board and parameter \"k\":");
        int m, n, k;
        while (true) {
            try {
                m = Integer.parseInt(in.next());
                n = typeOfBoard.equals("mnk") ? Integer.parseInt(in.next()) : m;
                k = Integer.parseInt(in.next());
                if (m > 0 && n > 0 && k > 0) {
                    break;
                } else {
                    throw new AssertionError();
                }
            } catch (NumberFormatException | InputMismatchException | AssertionError e) {
                System.out.println("Enter valid data:");
            }
        }

        System.out.println("Enter numbers of HumanPlayers [0-2]:");
        int numOfPlayers;
        while (true) {
            try {
                numOfPlayers = in.nextInt();
                if (numOfPlayers < 0 || numOfPlayers > 2) {
                    throw new AssertionError("Enter valid numbers of HumanPlayers [0-2]:");
                }
                player1 = (numOfPlayers == 0) ? new RandomPlayer(m, n, k) : new HumanPlayer(m, n, k);
                player2 = (numOfPlayers == 2) ? new HumanPlayer(m, n, k) : new RandomPlayer(m, n, k);
                break;
            } catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
        }

        board = new BoardGame(m, n, k, numOfPlayers, typeOfBoard);
    }
}
