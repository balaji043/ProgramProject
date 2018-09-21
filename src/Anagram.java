import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String a = scanner.next(), b = scanner.next();
        if (isAnagram(a, b)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean isAnagram(String a, String b) {
        char[] c1 = a.toCharArray(), c2 = b.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        String s1 = new String(c1);
        String s2 = new String(c2);
        return s1.equalsIgnoreCase(s2);
    }

}
