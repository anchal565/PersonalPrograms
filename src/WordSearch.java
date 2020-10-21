//Given a 2D board and a word, find if the word exists in the grid.
//
//The word can be constructed from letters of sequentially adjacent cell,
// where "adjacent" cells are those horizontally or vertically neighboring.
// The same letter cell may not be used more than once.
public class WordSearch {

    //MY CORRECT CODE
    /*public static boolean exist(char[][] board, String word) {
        char[] possibleWord = new char[word.length()];
        int M = board.length;
        int N = board[0].length;
        boolean result=false;
        boolean[][] visited;
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(board[i][j] == word.charAt(0)){
                    visited = new boolean[M][N];
                    visited[i][j] = true;
                    possibleWord[0] = board[i][j];
                    result=recur(board, i,j, possibleWord, word, visited, 1);
                }
                if(result == true)
                    return true;
            }
        }
        return false;
    }


    public static boolean recur(char[][] board, int i, int j, char[] possibleWord, String word, boolean[][] visited, int k){
        if(k == word.length()){
            int l=0;
            for(l=0; l<k; l++){
                if(possibleWord[l] != word.charAt(l)){
                    return false;
                }

            }
            if(l == k)
                return true;
        }
        //right
        if(j+1 < board[0].length && visited[i][j+1] == false && board[i][j+1] == word.charAt(k)){
            possibleWord[k] = board[i][j+1];
            visited[i][j+1] = true;
            boolean result = recur(board, i, j+1, possibleWord, word, visited, k+1);
            visited[i][j+1] = false;
            if(result == true)
                return true;
        }
        //bottom
        if(i+1 < board.length && visited[i+1][j] == false && board[i+1][j] == word.charAt(k)){
            possibleWord[k] = board[i+1][j];
            visited[i+1][j] = true;
            boolean result = recur(board, i+1, j, possibleWord, word, visited, k+1);
            visited[i+1][j] = false;
            if(result == true)
                return true;
        }
        //left
        if(j>0 && visited[i][j-1] == false && board[i][j-1] == word.charAt(k)){
            possibleWord[k] = board[i][j-1];
            visited[i][j-1] = true;
            boolean result = recur(board, i, j-1, possibleWord, word, visited, k+1);
            visited[i][j-1] = false;
            if(result == true)
                return true;
        }
        //top
        if(i>0 && visited[i-1][j] == false && board[i-1][j] == word.charAt(k)){
            possibleWord[k] = board[i-1][j];
            visited[i-1][j] = true;
            boolean result = recur(board, i-1, j, possibleWord, word, visited, k+1);
            visited[i-1][j] = false;
            if(result == true)
                return true;
        }
        return false;
    }
*/

    //Akshit's simplified code
    public static boolean exist(char[][] board, String word) {
        int M = board.length;
        int N = board[0].length;
        boolean result=false;
        boolean[][] visited;

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(board[i][j] == word.charAt(0)){
                    visited = new boolean[M][N];
                    result=checkValidWord(board, i,j, word, visited, 0);
                }
                if(result == true)
                    return true;
            }
        }
        return false;
    }


    public static boolean checkValidWord(char[][] board, int i, int j, String word, boolean[][] visited, int k){

        int M = board.length;
        int N = board[0].length;

        if (i<M && i>=0 && j<N && j>=0 && visited[i][j] == false) {
            if (board[i][j] == word.charAt(k)) {

                visited[i][j] = true;

                if (k == word.length()-1) {
                    return true;
                }

                boolean result = checkValidWord(board, i,j+1, word, visited, k+1) ||
                        checkValidWord(board, i+1,j, word, visited, k+1) ||
                        checkValidWord(board, i,j-1, word, visited, k+1) ||
                        checkValidWord(board, i-1,j, word, visited, k+1);

                visited[i][j] = false;
                return result;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }

    }
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
       boolean result = exist(board, "Z");
        System.out.println("Result is : "+result);
    }
}
