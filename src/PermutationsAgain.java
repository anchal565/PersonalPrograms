import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PermutationsAgain {
    static List<List<Integer>> resultList = new ArrayList<>();
    public static void permute(int[] num, int index){
        if(index == num.length){
            List<Integer> subList = Arrays.stream(num).boxed().collect(Collectors.toList());
            resultList.add(subList);
            //System.out.println(Arrays.toString(num));
            return;
        }
        for(int i=index; i<num.length; i++){
            swap(index, i, num);
            permute(num, index+1);
            swap(index, i, num);
        }
    }

    public static void swap(int i, int j, int[] num){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    public static void main(String[] args) {
        int[] num = {1,2,3};
        permute(num, 0);
        for(List list : resultList){
            System.out.println(Arrays.asList(list));
        }
    }
}
