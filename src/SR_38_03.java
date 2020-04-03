

import java.util.Scanner;

/*
Problem Statement :
    Given N students name and department,
    print the X students belonging to a specific department D
*/
public class SR_38_03 {
    private static Scanner scanner = new Scanner(System.in);
    private static int n = scanner.nextInt();
    private static String[][] s_Details = new String[n][2];

    public static void main(String[] args){
        for (int i = 0; i < n; i++) {
            s_Details[i][0] = scanner.next();
            s_Details[i][1] = scanner.next();
        }
        String department = scanner.next();
        for (int i = 0; i < n; i++) {
            if (s_Details[i][1].equals(department)) {
                System.out.println(s_Details[i][0]);
            }
        }
    }
}
