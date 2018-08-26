import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
public class TimeGeneration {
    private static Scanner scanner = new Scanner(System.in);
    private static int count = 1, n = 9, max = 0, countRev = 0;
    private static ArrayList<Integer> numbers = new ArrayList<>();
    private static TreeSet<Integer> time = new TreeSet<Integer>();

    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());// Array values
        }

        String hour = getTime(24);
        String min = getTime(60);
        String sec = getTime(60);

        System.out.println(hour + ":" + min + ":" + sec);
    }

    private static String getTime(int l) {
        time.clear();
        int[] selected = new int[2];
        combinations(selected, 0, 0, l);               // All possible combinations
        max = time.last();
        String hour = ("" + max);
        if (hour.length() == 1) {
            numbers.remove(numbers.indexOf(max));
            hour = '0' + hour;
        } else {
            numbers.remove(numbers.indexOf(max / 10));
            numbers.remove(numbers.indexOf(max % 10));
        }
        return hour;
    }

    private static void combinations(int[] selected, int i, int j, int l) {
        count = 0;
        countRev = 0;
        if (j == 1) {
                time.add(selected[0]);
        }
        if (j == 2) {
            count = selected[0] * 10 + selected[1];
            if (count < l)
                time.add(count);
            StringBuilder stringBuilder = new StringBuilder("" + count);
            countRev = Integer.parseInt(stringBuilder.reverse().toString());
            if (countRev < l)
                time.add(countRev);
        }
        if (i == numbers.size() || j == 2)
            return;

        combinations(selected, i + 1, j, l);
        selected[j] = numbers.get(i);
        combinations(selected, i + 1, j + 1, l);

    }
}
