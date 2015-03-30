import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;


/* Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution. 
 */
public class Solution {

    public static void solveSudoku(char[][] board) {
        trySolve(board, 0, 0);
    }

    // Try to solve the sudoku by looping through entire board and trying different numbers via backtracking.
    private static boolean trySolve(char[][] board, int i, int j) {
        // check bounds
        if (j >= 9) {
            i++;
            j = 0;
        }
        if (i >= 9) {
            return true;
        }
        
        // check if blank
        if (board[i][j] == '.') {
            // try solving
            for (int tryNum = 49; tryNum < 58; tryNum++) {
                if (tryInsert(board, i, j, tryNum)) {
                    if (trySolve(board, i, j + 1)) return true;
                } 
            }

            board[i][j] = '.';

        } else {
            if (trySolve(board, i, j + 1)) return true;
        }

        return false;

    }

    // Try to fill in a number into spot board[i][j]. Return true if number was inserted, else false
    // because invalid insert.
    private static boolean tryInsert(char[][] board, int i, int j, int insertNum) {
        char c = (char)insertNum;

        // Check row
        for (int col = 0; col < 9; col++) {
            if (board[i][col] == c) return false;
        }

        // Check col
        for (int row = 0; row < 9; row++) {
            if (board[row][j] == c) return false;
        }

        // Check section
        int sr = (i / 3) * 3;
        int sc = (j / 3) * 3;
        for (int x = sr; x < sr+3; x++) {
            for (int y = sc; y < sc+3; y++) {
                if (board[x][y] == c) return false;
            }
        }

        board[i][j] = c;

        return true;
    }


    public static void printBoard(char[][] board) {
        String s = 
            "------------------------------------\n" +
            "| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " | " + board[0][3] + " | " + board[0][4] + " | " + board[0][5] + " | " + board[0][6] + " | " + board[0][7] + " | " + board[0][8] + " |\n" +
            "------------------------------------\n" +
            "| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " | " + board[1][3] + " | " + board[1][4] + " | " + board[1][5] + " | " + board[1][6] + " | " + board[1][7] + " | " + board[1][8] + " |\n" +
            "-------------------------------------\n" +
            "| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " | " + board[2][3] + " | " + board[2][4] + " | " + board[2][5] + " | " + board[2][6] + " | " + board[2][7] + " | " + board[2][8] + " |\n" +
            "-------------------------------------\n" +
            "| " + board[3][0] + " | " + board[3][1] + " | " + board[3][2] + " | " + board[3][3] + " | " + board[3][4] + " | " + board[3][5] + " | " + board[3][6] + " | " + board[3][7] + " | " + board[3][8] + " |\n" +
            "------------------------------------\n" +
            "| " + board[4][0] + " | " + board[4][1] + " | " + board[4][2] + " | " + board[4][3] + " | " + board[4][4] + " | " + board[4][5] + " | " + board[4][6] + " | " + board[4][7] + " | " + board[4][8] + " |\n" +
            "-------------------------------------\n" +
            "| " + board[5][0] + " | " + board[5][1] + " | " + board[5][2] + " | " + board[5][3] + " | " + board[5][4] + " | " + board[5][5] + " | " + board[5][6] + " | " + board[5][7] + " | " + board[5][8] + " |\n" +
            "-------------------------------------\n" +
            "| " + board[6][0] + " | " + board[6][1] + " | " + board[6][2] + " | " + board[6][3] + " | " + board[6][4] + " | " + board[6][5] + " | " + board[6][6] + " | " + board[6][7] + " | " + board[6][8] + " |\n" +
            "------------------------------------\n" +
            "| " + board[7][0] + " | " + board[7][1] + " | " + board[7][2] + " | " + board[7][3] + " | " + board[7][4] + " | " + board[7][5] + " | " + board[7][6] + " | " + board[7][7] + " | " + board[7][8] + " |\n" +
            "-------------------------------------\n" +
            "| " + board[8][0] + " | " + board[8][1] + " | " + board[8][2] + " | " + board[8][3] + " | " + board[8][4] + " | " + board[8][5] + " | " + board[8][6] + " | " + board[8][7] + " | " + board[8][8] + " |\n" +
            "-------------------------------------\n";

        System.out.println(s);
    }

    public static void main(String[] args) {
        char[][] problem = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        solveSudoku(problem);

        printBoard(problem);
    }
}