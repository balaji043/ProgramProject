import java.util.*;

// Read only region start
class Wipro_Series_Generation {
    public static void main(String[] a) {
        Scanner s = new Scanner(System.in);
        System.out.println(seriesN(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt()));
    }

    private static int seriesN(int input1, int input2, int input3, int input4) {
        // Read only region end
        int i;
        int[] e = new int[input4];
        e[0] = input1;
        e[1] = input2;
        e[2] = input3;
        int d1 = e[1] - e[0], d2 = e[2] - e[1];
        for (i = 3; i < input4; i++) {
            if (i % 2 != 0) {
                e[i] = e[i - 1] + d1;
            } else {
                e[i] = e[i - 1] + d2;
            }
        }
        return e[input4 - 1];

    }
}