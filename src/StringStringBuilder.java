public class StringStringBuilder {

    public static void concat(String str){
        //str=str+"If I am mad";

        //If not explicitly assigned then it does not change
        str=str.concat("If I am mad");
        System.out.println("In concat : "+str);

    }

    public static void main(String[] arg){
        String str="To Test";
        concat(str);
        System.out.println("In main : "+str);
    }
}
