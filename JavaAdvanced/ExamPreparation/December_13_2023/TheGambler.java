package ExamPreparation.December_13_2023;

import java.util.Scanner;

public class TheGambler {
    static boolean isWonJackpot = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] board = new String[n][];

        for (int i = 0; i < n; i++) {
            board[i] = scanner.nextLine().split("");
        }

        int gamblerRow = 0;
        int gamblerCol = 0;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col].equals("G")) {
                    gamblerRow = row;
                    gamblerCol = col;
                    break;
                }
            }
        }

        int amount = 100;


        String command;
        while (!"end".equals(command = scanner.nextLine())) {
            if (isWonJackpot) {
                break;
            }
            if ("up".equals(command)) {
                board[gamblerRow][gamblerCol] = "-";
                gamblerRow--;
                if (gamblerRow >= 0) {
                    amount = gamblerUpdate(board, gamblerRow, gamblerCol, amount);
                } else {
                    gameOver();
                    return;
                }
            } else if ("down".equals(command)) {
                board[gamblerRow][gamblerCol] = "-";
                gamblerRow++;
                if (gamblerRow <= board.length - 1) {
                    amount = gamblerUpdate(board, gamblerRow, gamblerCol, amount);
                } else {
                    gameOver();
                    return;
                }
            } else if (("left".equals(command))) {
                board[gamblerRow][gamblerCol] = "-";
                gamblerCol--;
                if (gamblerCol >= 0) {
                    amount = gamblerUpdate(board, gamblerRow, gamblerCol, amount);
                } else {
                    gameOver();
                    return;
                }

            } else if (("right".equals(command))) {
                board[gamblerRow][gamblerCol] = "-";
                gamblerCol++;
                if (gamblerCol <= board.length - 1) {
                    amount = gamblerUpdate(board, gamblerRow, gamblerCol, amount);
                } else {
                    gameOver();
                    return;
                }
            }

            if (amount <= 0) {
                gameOver();
                return;
            }
        }

        if (isWonJackpot) {
            System.out.println("You win the Jackpot!");
            System.out.printf("End of the game. Total amount: %d$\n", amount);
        } else {
            System.out.printf("End of the game. Total amount: %d$\n", amount);
        }

        for (String[] row : board) {
            for (String el : row) {
                System.out.print(el);
            }

            System.out.println();
        }
    }

    private static void gameOver() {
        System.out.println("Game over! You lost everything!");
    }

    private static int gamblerUpdate(String[][] board, int gamblerRow, int gamblerCol, int amount) {
        switch (board[gamblerRow][gamblerCol]) {
            case "-":
                break;
            case "W":
                amount += 100;
                break;
            case "P":
                amount -= 200;
                break;
            case "J":
                amount += 100000;
                isWonJackpot = true;
                break;
        }
        board[gamblerRow][gamblerCol] = "G";
        return amount;
    }
}
