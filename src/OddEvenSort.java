import java.util.Arrays;
import java.util.Scanner;
public class OddEvenSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), i, o = 0, e = 0;
        int[] odd = new int[n/2];
        int[] even = new int[n/2];
        for (i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                odd[o] = sc.nextInt();      o++;
            } else {
                even[e] = sc.nextInt();     e++;
            }
        }

        Arrays.sort(odd);
        Arrays.sort(even);

        for (i = 1; i <= n; i++) {
            if (i % 2 != 0){
                System.out.print(odd[o]);           o++;
            }
            else{
                System.out.print(" " + even[e]);    e++;
            }
        }
    }
}