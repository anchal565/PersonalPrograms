//https://leetcode.com/explore/featured/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3363/
public class SurroundedRegions {
    public static void solve(char[][] board) {
        int[] x_dir = {0, 0,  -1, 1};
        int[] y_dir = {-1, 1, 0,  0};
        int rows = board.length;
        int columns = board[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(board[i][j] == 'O' && i>0 && j<board[0].length -1){
                    board[i][j] = (board[i][0] != 'O')
                            ^ (board[0][j] != 'O')
                            ^ (board[i][columns-1] !='O')
                            ^ (board[rows-1][j] != 'O') ? '0' : 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solve(board);
        for(int i=0; i<board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
