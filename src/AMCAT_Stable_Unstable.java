import java.util.Arrays;
import java.util.Scanner;

public class AMCAT_Stable_Unstable {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int stable = 0, unStable = 0;
        String s;
        for (int i = 0; i < 5; i++) {
            s = scanner.next();
            if (isStable(s)) stable += Integer.parseInt(s);
            else unStable += Integer.parseInt(s);
        }
        System.out.println(stable - unStable);
    }

    private static boolean isStable(String s) {
        char[] arr = s.toCharArray();
        int l = arr.length, first = 1, count, i, j = 0;
        Arrays.sort(arr);
        for (i = 1; i < l; i++) {
            if (arr[0] == arr[i]) {
                first++;
            } else {
                break;
            }
        }
        i = j;
        for (; i < l; i++) {
            count = 1;
            for (j = i + 1; j < l; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                } else break;
            }
            i = j - 1;
            if (count != first) return false;
        }
        return true;
    }
}

/*

4455
1122
123
1112
5

*/
