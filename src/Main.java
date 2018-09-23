import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static LinkedList<Integer> frames = new LinkedList<>();

    public static void main(String args[]) {
        //regexFunctions();
        System.out.println(LRU_Algorithm(3, Array.getArray()));
    }

    private static boolean isPrime(int n) {
        if (n == 1 || n <= 0) return false;
        for (int i = 2; i < n / 2 + 1; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    private static void regexFunctions() {
        //String string = scanner.next();
        //System.out.println(string.replaceAll("[1]","5"));
        //System.out.println(string.replaceAll("[0-9]",""));
        //System.out.println(string.replaceAll("[0-9]","*"));
        String a = Arrays.toString(Array.getArray());
        System.out.println(a);
        System.out.println(a.replaceAll("[\\[\\]][,]", ""));


    }

    private static int LRU_Algorithm(int size, int[] pages) {
        int fault = 0;
        int k = 0;
        for (int i : pages) {
            if (!contains(i)) {
                if (frames.size() >= size) {
                    fault++;
                    frames.add(k, i);
                    k++;
                } else {
                    frames.add(i);
                }
            }
        }
        return fault;
    }

    private static boolean contains(int i) {
        for (Integer frame : frames) {
            if (frame == i) {
                return true;
            }
        }
        return false;
    }
}