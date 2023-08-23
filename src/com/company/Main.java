package com.company;

public class Main {
    //решение судоку 3040
    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0, 8, 0, 7, 0, 0, 0},
                {0, 0, 9, 0, 0, 0, 6, 0, 4},
                {0, 0, 0, 0, 0, 0, 0, 8, 0},
                {0, 0, 0, 5, 8, 0, 0, 0, 0},
                {7, 0, 0, 0, 0, 0, 0, 0, 9},
                {4, 0, 5, 0, 0, 0, 0, 0, 2},
                {0, 6, 0, 0, 3, 0, 0, 4, 0},
                {0, 0, 0, 0, 0, 0, 2, 7, 0},
                {0, 5, 0, 9, 0, 2, 0, 0, 0}
        };

        if (solveSudoku(board)) {
            printSudoku(board);
        } else {
            System.out.println("No solution exists.");
        }
    }

    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            if (solveSudoku(board)) {
                                return true;
                            }

                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void printSudoku(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
