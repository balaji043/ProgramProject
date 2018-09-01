import java.util.HashMap;
import java.util.Scanner;

public class HashMapTry {
    private static HashMap<String, String> hashMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]) {
        int breaker = 1, option = 1;
        String menu[] = {"Add-1", "Show-2", "Show All-3", "Exit-4", "Enter Your Option"};
        while (breaker == 1) {
            System.out.printf("%20s\n%20s\n%20s\n%20s\n\n%20s", menu[0], menu[1], menu[2], menu[3], menu[4]);
            option = scanner.nextInt();
            switch (option) {
                case 1:{
                    add();
                    break;}
                case 2:{
                    show();
                    break;}
                case 3:{
                    showAll();
                    break;}
                case 4:{
                    breaker=0;
                    break;}
                default:{
                    break;
                }
            }
        }
    }

    private static void add() {
        String key=scanner.next();
        String value = scanner.next();
        hashMap.put(key, value);
    }

    private static void show() {
        System.out.println(hashMap.get(scanner.next()));
    }

    private static void showAll() {
        for (String k : hashMap.keySet()) {
            System.out.println(hashMap.get(k));
        }
    }
}
