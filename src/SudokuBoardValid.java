import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SudokuBoardValid {

    public boolean isValidSudoku(char[][] board) {
        Set<Character> setForUnique;
        for(int i=0; i<board.length; i++){
            setForUnique = new HashSet<>();
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] != ' ' && setForUnique.contains(board[i][j])){
                    return false;
                }
                else {
                    setForUnique.add(board[i][j]);
                }
            }
        }

        for(int i=0; i<board.length; i++){
            setForUnique = new HashSet<>();
            for(int j=0; j<board[0].length; j++){
                if(setForUnique.contains(board[j][i])){
                    return false;
                }
                else {
                    setForUnique.add(board[i][j]);
                }
            }
        }
        int counter = 0;
        while(counter < 9){
            int r=0, s=0, i=0, j=0;
            setForUnique = new HashSet<>();
            for(i=r; i<r+3;i++){
                for(j=s; j<s+3; j++){
                    if(setForUnique.contains(board[i][j])){
                        return false;
                    }
                    else {
                        setForUnique.add(board[i][j]);
                    }
                }
            }
            if(j==8){
                r=r+3;
                s = 0;
            }
            else{
                s=s+3;
            }
            counter++;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }
}
