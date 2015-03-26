import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public static boolean isValidSudoku(char[][] board) {
        // columns have keys 'c0', 'c1', 'c2'...
        // rows have keys 'r0', 'r1', 'r2'...
        // sections have keys '00', '01', '02' (for first row), then '10', '11', '12' (for 2nd row) ...
        
        Map<String, HashSet<Character>> map = new HashMap<String, HashSet<Character>>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                 
                 // Get current char and check if filled
                 char c = board[i][j];
                 if (c == '.') continue;
                 
                 // Calculate keys for hash map
                 String rk = "r" + i;
                 String ck = "c" + j;
                 String sk = "" + (i/3) + (j/3);
                 
                 // Get the sets pertaining to their keys
                 HashSet<Character> rSet = map.containsKey(rk) ? map.get(rk) : new HashSet<Character>();
                 HashSet<Character> cSet = map.containsKey(ck) ? map.get(ck) : new HashSet<Character>();
                 HashSet<Character> sSet = map.containsKey(sk) ? map.get(sk) : new HashSet<Character>();

                 if (rSet.isEmpty()) map.put(rk, rSet);
                 if (cSet.isEmpty()) map.put(ck, cSet);
                 if (sSet.isEmpty()) map.put(sk, sSet);
                 
                 // If any of the sets contains the char, sodoku is invalid
                 if (rSet.contains(c) || cSet.contains(c) || sSet.contains(c)) return false;
                 
                 rSet.add(c);
                 cSet.add(c);
                 sSet.add(c);
                 
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'.','.','4','.','.','.','6','3','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'5','.','.','.','.','.','.','9','.'},
            {'.','.','.','5','6','.','.','.','.'},
            {'4','.','3','.','.','.','.','.','1'},
            {'.','.','.','7','.','.','.','.','.'},
            {'.','.','.','5','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'}
        };
        System.out.println(isValidSudoku(board));
    }
}