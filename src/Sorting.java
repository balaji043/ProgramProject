package common;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = Array.getArray();
        new Frequency_Sorting(arr, arr.length);
    }
}

class Quick_Sort {
    int n;
    int[] a;

    Quick_Sort(int[] a, int n) {
        this.n = n;
        this.a = a;
        this.quick_Sort(0, n - 1);
        Array.printArray(this.a, this.n);
    }

    private void quick_Sort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quick_Sort(low, pivotIndex - 1);
            quick_Sort(pivotIndex + 1, high);
        }
    }

    private int partition(int low, int high) {
        int pivot = a[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (a[j] < pivot) {
                i++;
                swap(i, j);
            }
        }
        i++;
        swap(i, high);
        return i;
    }

    private void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

class Frequency_Sorting {
    int n;
    int[] a;

    Frequency_Sorting(int[] a, int n) {
        this.a = a;
        this.n = n;
        long startTime = System.nanoTime();
        Sorting();
        long total1 = System.nanoTime() - startTime;
        Array.printArray(a, n);
        System.out.println(TimeUnit.SECONDS.convert(total1, TimeUnit.MILLISECONDS));
        startTime = System.nanoTime();
        Sorting_Using_HashTable();
        long total2 = System.nanoTime() - startTime;
        Array.printArray(a, n);
        System.out.println(TimeUnit.SECONDS.convert(total2, TimeUnit.MILLISECONDS));
        if (total1 > total2) System.out.println("Sorting without hashTable");
        else System.out.println("with HashTable");
    }

    private void Sorting() {
        int temp;
        int c, size = 0;
        int[] value = new int[100];
        int[] count = new int[100];
        for (int i = 0; i < n; i++) {
            c = 0;
            if (!contains(a[i], value, size)) {
                for (int j = 0; j < n; j++) {
                    if (a[i] == a[j])
                        c++;
                }
                value[size] = a[i];
                count[size] = c;
                size++;
            }
        }
        int i;
        for (i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (count[i] < count[j]) {
                    temp = count[i];
                    count[i] = count[j];
                    count[j] = temp;
                    temp = value[i];
                    value[i] = value[j];
                    value[j] = temp;
                }
            }
        }
        System.out.println();
        int k = 0;
        for (i = 0; i < size; i++) {
            for (int j = 0; j < count[i]; j++) {
                a[k] = value[i];
                k++;
            }
        }
    }

    private boolean contains(int e, int[] value, int size) {
        for (int i = 0; i < size; i++) {
            if (value[i] == e) return true;
        }
        return false;
    }

    private void Sorting_Using_HashTable() {
        int temp;
        int c;
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        for (int i = 0; i < n; i++) {
            c = 0;
            for (int j = 0; j < n; j++) {
                if (a[i] == a[j])
                    c++;
            }
            hashtable.put(a[i], c);
        }
        int size = hashtable.size();
        int[] value = new int[size];
        int[] count = new int[size];
        int i = 0;
        for (Integer key : hashtable.keySet()) {
            value[i] = key;
            count[i] = hashtable.get(key);
            i++;
        }
        for (i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (count[i] < count[j]) {
                    temp = count[i];
                    count[i] = count[j];
                    count[j] = temp;
                    temp = value[i];
                    value[i] = value[j];
                    value[j] = temp;
                }
            }
        }
        System.out.println();
        int k = 0;
        for (i = 0; i < size; i++) {
            for (int j = 0; j < count[i]; j++) {
                a[k] = value[i];
                k++;
            }
        }
    }
}
