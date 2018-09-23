public class Sorting {
    public static void main(String args[]) {
        int[] arr = Array.getArray();
        new Quick_Sort(arr, arr.length);
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