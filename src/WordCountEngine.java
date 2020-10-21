import java.util.Arrays;

public class WordCountEngine {
    static String[][] wordCountEngine(String document) {
        String[] splitString = document.split("\\s+");
        for(int i=0; i<splitString.length; i++){
            System.out.println("Hii"+ splitString[i]);
        }
        String[][] result = new String[splitString.length][];
        return result;
    }

    public static void main(String[] args) {
        String document = "Practice makes perfect. you'll only"
        +"get Perfect by practice. just practice!";
        wordCountEngine(document);
    }
}
