import java.util.Scanner;
public class XOR_X_Value {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), i, o;
        int[] a = new int[n];
        o = sc.nextInt();
        for (i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            o = o ^ a[i];
        }
        System.out.println(o);
    }
}