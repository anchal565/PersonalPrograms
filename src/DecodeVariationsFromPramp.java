//A message is a string of uppercase letters, and it is encoded first using this scheme. For example, 'AZB' -> '1262'
//
//Given a string of digits S from 0-9 representing an encoded message, return the number of ways to decode it.
public class DecodeVariationsFromPramp {
    static int decodeVariations(String S){
        int length = S.length();
        int[] result = new int[length];
        if(S.charAt(0) != '0')
            result[0] = 1;
        else
            return 0;
        if(S.length() == 1)
            return 1;
        int possibleCombination = checkPossibleCombination(S, 1);
        if(S.charAt(1) != '0') {
                result[1] = possibleCombination + 1;
        }
        else
            result[1] = possibleCombination;
        for (int i=2; i<length; i++){
            int previousCombination = checkPossibleCombination(S, i);
            if(previousCombination == 1)
                result[i] = result[i] + result[i-2];
            if(S.charAt(i) != '0')
                result[i] = result[i] + result[i-1];
        }
        return result[length-1];
    }

    static int checkPossibleCombination(String S, int index){
        if(index > 0 && S.charAt(index-1) != '0') {
            int value = Integer.parseInt(S.substring(index - 1, index+1));
            if(value > 0 && value <= 26)
                return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        String S = "12";
        int result = decodeVariations(S);
        System.out.println("Result is : "+ result);
    }
}
