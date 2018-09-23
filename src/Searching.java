import java.util.Arrays;
import java.util.Scanner;

public class Searching {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int a[] = Array.getArray();
        String s = Arrays.toString(a);
        System.out.println(s);
        int element = scanner.nextInt();
        new Binary_Search(a, a.length, element);
    }
}

class Binary_Search {
    private static int[] a;
    private static int element;

    Binary_Search(int a[], int n, int element) {
        Binary_Search.a = (new Quick_Sort(a, n)).a;
        Binary_Search.element = element;
        int result = Binary_Search.Search(0, n - 1);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }

    private static int Search(int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == element) return mid;
            if (a[mid] > element) return Search(low, mid - 1);
            return Search(mid + 1, high);
        }
        return -1;
    }
}