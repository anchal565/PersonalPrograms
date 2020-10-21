import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsWithOutRepetions_1 {
    public static void permute(String input, List<String> output){
        if(input.isEmpty())
            return;
        char check = input.charAt(input.length()-1);
        if(!input.isEmpty()){
            List<String> newList = new ArrayList<>();
            if(output.size() == 0){
                output.add(check+"");
            }
            else {
                for (int i = 0; i < output.size(); i++) {
                    for (int j = 0; j <= output.get(i).length(); j++) {
                        String temp = output.get(i).substring(0, j)
                                + check +
                                output.get(i).substring(j, output.get(i).length());
                        newList.add(temp);
                    }
                }
                output.clear();
                output.addAll(newList);
            }
            permute(input.substring(0,input.length()-1), output);
        }
    }

    public static List<String> permute(String input){
        List<String> newList = new ArrayList<>();
        if(!input.isEmpty()){
            List<String> subList = permute(input.substring(1));
            char check = input.charAt(0);
            if(subList.size() == 0){
                newList.add(check+"");
            }
            else {
                for (int i = 0; i < subList.size(); i++) {
                    for (int j = 0; j <= subList.get(i).length(); j++) {
                        String temp = subList.get(i).substring(0, j)
                                + check +
                                subList.get(i).substring(j, subList.get(i).length());
                        newList.add(temp);
                    }
                }
            }

        }
        return newList;
    }

    public static void main(String[] args) {
        String inputStr = "ABCD";
        List<String> output = new ArrayList<>();
        permute(inputStr, output);
        System.out.println("Result is : "+ Arrays.asList(output));
        List<String> finalOutput2 = permute(inputStr);
        System.out.println("Result is : "+ Arrays.asList(finalOutput2));
    }
}
