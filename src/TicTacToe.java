
import java.util.Scanner;

public class TicTacToe {

    // Constants and game board
    private static final int ROWS = 3;
    private static final int COLS = 3;

    private static String board[][] = new String[ROWS][COLS];

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        boolean playAgain = true;

        // Continue playing while the players want to play again
        while (playAgain) {

            clearBoard();

            String player = "X";
            int moveCount = 0;
            boolean gameOver = false;

            System.out.println("\nWelcome to Tic Tac Toe!");

            // Main game loop
            while (!gameOver) {

                display();

                System.out.println("\nPlayer " + player + "'s turn.");

                // Get the player's move
                int rowMove = SafeInput.getRangedInt(
                        console, "Enter row", 1, ROWS);

                int colMove = SafeInput.getRangedInt(
                        console, "Enter column", 1, COLS);

                // Convert coordinates to array indexes
                int row = rowMove - 1;
                int col = colMove - 1;

                // Keep asking until the move is valid
                while (!isValidMove(row, col)) {

                    System.out.println("That space is already occupied. Try again.");

                    rowMove = SafeInput.getRangedInt(
                            console, "Enter row", 1, ROWS);

                    colMove = SafeInput.getRangedInt(
                            console, "Enter column", 1, COLS);

                    row = rowMove - 1;
                    col = colMove - 1;
                }

                // Record the player's move
                board[row][col] = player;

                moveCount++;

                // Check for a win
                if (isWin(player)) {

                    display();

                    System.out.println("\nPlayer " + player + " wins!");

                    gameOver = true;
                }

                // Check for a tie
                else if (isTie()) {

                    display();

                    System.out.println("\nThe game is a tie!");

                    gameOver = true;
                }

                // Switch players
                else {

                    if (player.equals("X")) {
                        player = "O";
                    } else {
                        player = "X";
                    }
                }
            }

            // Ask if players want another game
            playAgain = SafeInput.getYNConfirm(
                    console, "Would you like to play again?");
        }

        System.out.println("\nThanks for playing Tic Tac Toe!");

        console.close();
    }


    // Clear the board
    private static void clearBoard() {

        for (int row = 0; row < ROWS; row++) {

            for (int col = 0; col < COLS; col++) {

                board[row][col] = " ";
            }
        }
    }


    // Display the game board
    private static void display() {

        System.out.println();

        for (int row = 0; row < ROWS; row++) {

            System.out.print(" ");

            for (int col = 0; col < COLS; col++) {

                System.out.print(board[row][col]);

                if (col < COLS - 1) {
                    System.out.print(" | ");
                }
            }

            System.out.println();

            if (row < ROWS - 1) {
                System.out.println("---+---+---");
            }
        }

        System.out.println();
    }


    // Check whether a move is valid
    private static boolean isValidMove(int row, int col) {

        return board[row][col].equals(" ");
    }


    // Check whether a player has won
    private static boolean isWin(String player) {

        return isColWin(player)
                || isRowWin(player)
                || isDiagnalWin(player);
    }


    // Check for a column win
    private static boolean isColWin(String player) {

        for (int col = 0; col < COLS; col++) {

            if (board[0][col].equals(player)
                    && board[1][col].equals(player)
                    && board[2][col].equals(player)) {

                return true;
            }
        }

        return false;
    }


    // Check for a row win
    private static boolean isRowWin(String player) {

        for (int row = 0; row < ROWS; row++) {

            if (board[row][0].equals(player)
                    && board[row][1].equals(player)
                    && board[row][2].equals(player)) {

                return true;
            }
        }

        return false;
    }


    // Check for a diagonal win
    private static boolean isDiagnalWin(String player) {

        // Top-left to bottom-right
        if (board[0][0].equals(player)
                && board[1][1].equals(player)
                && board[2][2].equals(player)) {

            return true;
        }

        // Top-right to bottom-left
        if (board[0][2].equals(player)
                && board[1][1].equals(player)
                && board[2][0].equals(player)) {

            return true;
        }

        return false;
    }


    // Check for a tie
    private static boolean isTie() {

        // Check whether the board is completely full
        boolean fullBoard = true;

        for (int row = 0; row < ROWS; row++) {

            for (int col = 0; col < COLS; col++) {

                if (board[row][col].equals(" ")) {
                    fullBoard = false;
                }
            }
        }

        if (fullBoard) {
            return true;
        }

        // Check whether every possible winning line is blocked
        // A line is blocked if it contains both X and O.

        // Check rows
        for (int row = 0; row < ROWS; row++) {

            if (!lineBlocked(
                    board[row][0], board[row][1], board[row][2])) {
                return false;
            }
        }

        // Check columns
        for (int col = 0; col < COLS; col++) {

            if (!lineBlocked(
                    board[0][col], board[1][col], board[2][col])) {
                return false;
            }
        }

        // Check first diagonal
        if (!lineBlocked(board[0][0], board[1][1], board[2][2])) {
            return false;
        }

        // Check second diagonal
        if (!lineBlocked(board[0][2], board[1][1], board[2][0])) {
            return false;
        }

        return true;
    }


    // Check whether a possible winning line contains both players
    private static boolean lineBlocked(String a, String b, String c) {

        boolean hasX = a.equals("X") || b.equals("X") || c.equals("X");

        boolean hasO = a.equals("O") || b.equals("O") || c.equals("O");

        return hasX && hasO;
    }

}

