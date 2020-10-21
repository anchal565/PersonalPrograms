//https://leetcode.com/explore/featured/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3379/

import java.util.Arrays;

public class PrisonCellsAfterNdays {
    public static int[] afterEachIteration(int[] cells){
        int length = cells.length;
        cells[0] = 0;
        int curr=0, temp = cells[0];
        for(int i=1; i<length-1; i++){
            curr = cells[i];
            cells[i] = (temp ^ cells[i+1])^1;
            temp = curr;
        }
        cells[length-1] = 0;
        return cells;
    }
    public static int[] prisonAfterNDays(int[] cells, int N) {
        for(int i=1; i<=N; i++){
            cells = afterEachIteration(cells);
        }
        return cells;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,1,1,0,0,1};
        int N = 7;
        int[] result = prisonAfterNDays(arr, N);
        System.out.println(Arrays.toString(result));
    }
}
