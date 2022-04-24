import java.util.Scanner;

public class Main {

    private static String binarySum(String a, String b){

        char[] aArray = new char[a.length()];
        char[] bArray = new char[b.length()];

        for (int i = 0; i < a.length(); i++){
            aArray[i] = a.charAt(a.length() - i -1);
        }

        for(int i = 0; i < b.length(); i++){
            bArray[i] = b.charAt(b.length() - i -1);
        }


        int[] result;
        char[] longerArray;
        int longer;
        int smaller;
        int held = 0;

        if(aArray.length > bArray.length){
            longer = aArray.length;
            smaller = bArray.length;
            longerArray = aArray;
        } else {
            longer = bArray.length;
            smaller = aArray.length;
            longerArray = bArray;
        }

        result = new int[longer + 1];
        int sum;
        for(int i = 0; i < smaller; i++) {
            sum = held + Integer.parseInt("" + aArray[i]) + Integer.parseInt("" + bArray[i]);
            if (sum == 0) {
                held = 0;
                result[i] = 0;
            } else if (sum == 1) {
                held = 0;
                result[i] = 1;
            } else if (sum == 2) {
                held = 1;
                result[i] = 0;
            } else if (sum == 3) {
                held = 1;
                result[i] = 1;
            }
        }

        for(int i = smaller; i < longer; i++) {
            sum = held + Integer.parseInt("" + longerArray[i]);
            if (sum == 0) {
                result[i] = 0;
                held = 0;
            } else if (sum == 1) {
                result[i] = 1;
                held = 0;
            } else if (sum == 2) {
                result[i] = 0;
                held = 1;
            }
        }

        if (held == 0)
            result[longer] = 0;
        else
            result[longer] = 1;

        sum = 0;

        for(int i = 0; i < result.length; i++){
            if (i == 0){
                sum += result[i];
            } else {
                sum += Math.pow(2 * result[i], i);
            }
        }

        return String.valueOf(sum);
    }

    public static void main (String[] args){

        try{
            Scanner sc = new Scanner(System.in);

            String a = sc.nextLine();
            String b = sc.nextLine();

            System.out.println("\n"+binarySum(a,b));
            sc.close();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println(">>>Program Ended!");
        }
    }
}
