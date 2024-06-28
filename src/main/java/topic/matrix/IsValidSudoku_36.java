package topic.matrix;

import java.util.HashSet;

/**
 * 36. Valid Sudoku
 * Determine if a 9 x 9 Sudoku board is valid.
 * Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * Note:
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */
public class IsValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        // check line
        for (int i = 0; i < 9; i++) {
            char[] line = new char[9];
            char[] row = new char[9];
            for(int j = 0; j < 9; j++) {
                line[j] = board[i][j];
                row[j] = board[j][i];
            }
            if (!checkNine(line) || !checkNine(row)) {
                return false;
            }
        }

        for(int i = 0; i < 9; i += 3) {
            for(int j = 0; j < 9; j += 3) {
                char[] nine = new char[9];
                int index = 0;
                for(int m = i; m < i + 3; m++) {
                    for(int n = j; n < j + 3; n++) {
                        nine[index++] = board[m][n];
                    }
                }
                if (!checkNine(nine)) {
                    return false;
               }
           }
        }
        return true;
    }

    public boolean checkNine(char[] nineChar) {
        HashSet<Character> set = new HashSet<>();
        for (char c : nineChar) {
            if (c != '.') {
                if (set.contains(c)) {
                    return false;
                }
                set.add(c);
            }
        }
        return true;
    }

    public static void main(String[] args)
    {

    }
}
