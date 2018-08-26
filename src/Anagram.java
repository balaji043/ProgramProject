import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] a) {
        isAnagram();
    }

    private static void isAnagram() {
        char[] c1 = scanner.next().toCharArray(), c2 = scanner.next().toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        String s1 = new String(c1);
        String s2 = new String(c2);
        if (s1.equalsIgnoreCase(s2))
            System.out.println("Anagram");
        else
            System.out.println("Not Anagram");

    }

}
