import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Time {

    private static int hour, minute, second;

    public static void main(String args[]) {
        long startTime = System.nanoTime(); //Start Time Of the program

        int h, m, s;

        var scanner = new Scanner(System.in);
        h = scanner.nextInt();
        m = scanner.nextInt();
        s = scanner.nextInt();

        setTime(h, m, s);
        System.out.println(toMilitary());
        System.out.println(toStandard());

        System.out.println(TimeUnit.SECONDS.convert(System.nanoTime() - startTime, TimeUnit.MILLISECONDS));
    }

    private static void setTime(int h, int m, int s) {
        hour = ((h >= 0 && h < 24) ? h : 0);
        minute = ((m >= 0 && m < 60) ? m : 0);
        second = ((s >= 0 && s < 60) ? s : 0);
    }

    private static String toMilitary() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    private static String toStandard() {
        return String.format("%d:%02d:%02d%s", ((hour == 0 || hour == 12) ? 12 : hour % 12),
                minute, second, ((hour < 12) ? "AM" : "PM"));
    }
}
