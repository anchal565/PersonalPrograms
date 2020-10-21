import java.util.Scanner;

public class ValidateIPAddress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.next();
        boolean validateIp= validateIP(ip);
        System.out.println(validateIp);

    }

    static boolean validateIP(String ip) {

            String[] arrayOfIps = ip.split("\\.");
            int count =0;
            for(int i =0; i<ip.length(); i++){
                if(ip.charAt(i) == '.')
                    count++;
            }
            if(count!=3)
                return false;
            int[] arrayOfIpsInIntegers = new int[arrayOfIps.length];
            if(arrayOfIps.length == 0)
                return false;
            for (int i = 0; i < arrayOfIps.length; i++) {

                if (arrayOfIpsInIntegers.length != 4) {
                    //System.out.println("No");
                    return false;
                }
                if(arrayOfIps[i].isEmpty())
                    return false;
                if(arrayOfIps[i].length()>1 && arrayOfIps[i].charAt(0) == '0')
                    return false;
                /*if(arrayOfIps[i].contains("00"))
                    return false;*/
                if(arrayOfIps[i].length()>3)
                    return false;

                if(!arrayOfIps[i].matches("[0-9]+"))
                    return false;
                arrayOfIpsInIntegers[i] = (Integer.parseInt(arrayOfIps[i]));

                if (arrayOfIpsInIntegers[i] > 255) {
                    //System.out.println("No");
                    return false;
                }

            }
            return true;

    }
}
