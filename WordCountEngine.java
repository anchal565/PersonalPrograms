import java.util.Arrays;

public class WordCountEngine {

    public static void wordCountEngine(String document){
     String[] wordsArr = document.split("[^a-zA-Z']+");
        System.out.println(Arrays.toString(wordsArr));
        for(int i=0;i<wordsArr.length;i++){
            if(wordsArr[i].contains("\'")){
                //wordsArr[i].trim().
            }
        }
    }

    public static void main(String[] args) {
        String document = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
        wordCountEngine(document);
    }
}
