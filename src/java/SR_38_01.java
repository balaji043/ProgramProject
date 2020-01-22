package java;

import java.util.Scanner;
import java.util.TreeSet;

public class SR_38_01 {
    private static Scanner scanner = new Scanner(System.in);
    private static TreeSet<Integer> treeSet1 = new TreeSet<Integer>();
    private static TreeSet<Integer> treeSet2 = new TreeSet<Integer>();
    private static int i, j, n = scanner.nextInt(), m;

    public static void main(String[] args) {
        for (i = 0; i < n; i++) {
            treeSet1.add(scanner.nextInt());
            treeSet2.add(scanner.nextInt());
        }
        m = scanner.nextInt();
        if (treeSet1.contains(m)) {
            System.out.println(treeSet1.size());
        } else {
            System.out.println(treeSet2.size());
        }
        System.out.println(treeSet1);
        System.out.println(treeSet2);
    }
}
