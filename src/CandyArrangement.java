import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CandyArrangement {

    public static int noOfPermutations(int index, char[] input, int K){
        if(index == input.length){
            System.out.println(Arrays.toString(input));
            return 1;
        }
        Set<Character> uniqueElemets = new HashSet<>();
        int count = 0;
        for (int i=index; i<input.length; i++){
            if((!uniqueElemets.contains(input[i])) && checkNeighboursCount(K, input, index, i)){
                uniqueElemets.add(input[i]);
                swap(i, index, input);
                count += noOfPermutations(index+1, input, K);
                swap(i, index, input);
            }
        }
        return count;
    }

    public static boolean checkNeighboursCount(int K, char[] input, int index, int i){
        if(K>index)
            return true;
        for (int j = index - K; j < index; j++) {
            if (input[i] != input[j])
                return true;
        }
        return false;
    }

    public static void swap(int i, int j, char[] input){
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        int A = 3;
        int B = 4;
        char[] input = new char[A+B];
        int i=0;
        for(; i<A; i++)
            input[i] = 'A';
        for(; i<A+B; i++)
            input[i] = 'B';
        //System.out.println(Arrays.toString(input));
        int count = noOfPermutations(0, input, 3);
        System.out.println(count);

    }
}

