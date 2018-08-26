import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static java.lang.Character.*;

public class SplitString {
    public static void main(String args[]) {
        long startTime = System.nanoTime();
        Split();//Splitting String into front middle end and form string of f,m,e and toggle e strings;
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(TimeUnit.SECONDS.convert(totalTime, TimeUnit.MILLISECONDS));
    }
    private static void Split(){
        String input1, input2, input3, op1, op2, op3, temp;
        Scanner scanner = new Scanner(System.in);

        input1 = scanner.next();
        input2 = scanner.next();
        input3 = scanner.next();

        String ans1[] = splitString(input1);
        String ans2[] = splitString(input2);
        String ans3[] = splitString(input3);

        op1 = ans1[0] + ans2[0] + ans3[0];
        op2 = ans1[1] + ans2[1] + ans3[1];
        temp = ans1[2] + ans2[2] + ans3[2];

        op3 = toggle(temp);

        System.out.println(op1 + " " + op2 + " " + op3);
    }
    private static String[] splitString(String input1) {

        int  length = input1.length(),s=length/3;
        String ans[] = new String[3];

        if (length % 3 == 0) {
            ans[0] = "" + input1.substring(0, s);
            ans[1] = "" + input1.substring(s, s * 2);
            ans[2] = "" + input1.substring(s * 2, length);
        } else if (length % 3 == 1) {
            ans[0] = "" + input1.substring(0, s);
            ans[1] = "" + input1.substring(s, s * 2 + 1);
            ans[2] = "" + input1.substring(s * 2 + 1, length);
        } else {
            ans[0] = "" + input1.substring(0, s + 1);
            ans[1] = "" + input1.substring(s + 1, s * 2 + 1);
            ans[2] = "" + input1.substring(s * 2 + 1, length);
        }

        return ans;

    }
    private static String toggle(String string) {

        String ans = "";

        for (int i = 0; i < string.length(); i++)
            if (isUpperCase(string.charAt(i))) {
                ans = String.format("%s%s", ans, toLowerCase(string.charAt(i)));
            } else {
                ans = String.format("%s%s", ans, toUpperCase(string.charAt(i)));
            }

        return ans;

    }
}
/*

john
johny
janarthanan

*/