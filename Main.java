import java.util.ArrayList;


class Sort {

    public static void insert(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void selection(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void bubble(int[] arr){
        int n = arr.length;
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    public static void merge(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            merge(arr, l, m);
            merge(arr, m + 1, r);

            mergesort(arr, l, m, r);
        }
    }
    private static void mergesort(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void shell(int[] arr) {
        int n = arr.length;
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < n; i += 1)
            {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }
    public static void shellHibbart(int[] arr) {
        int n = arr.length;
        for (int i = 1; i <= Math.log(n - 1); i++)
        {
            int gap = (int)Math.pow(2, i) - 1;
            for (int j = gap; j < n; j += 1)
            {
                int temp = arr[j];
                int k;
                for (k = j; k >= gap && arr[k - gap] > temp; k -= gap) {
                    arr[k] = arr[k - gap];
                }
                arr[k] = temp;
            }
        }
    }
    public static void shellPratt(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> gaps = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                int gap = (int) (Math.pow(2, i) * Math.pow(3, j));
                if (gap > n/2) break;
                gaps.add(gap);
            }
        }
        for (int gap : gaps)
        {
            for (int j = gap; j < n; j += 1)
            {
                int temp = arr[j];
                int k;
                for (k = j; k >= gap && arr[k - gap] > temp; k -= gap) {
                    arr[k] = arr[k - gap];
                }
                arr[k] = temp;
            }
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }
    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

}

class Arrays{
    public static int[] sorted(int size){
        int[] a = new int[size];
        for (int i = 0; i < size; i++){
            a[i] = i;
        }
        return a;
    }

    public static int[] backSorted(int size){
        int[] a = new int[size];
        for (int i = 0; i < size; i++){
            a[i] = size - i;
        }
        return a;
    }

    public static int[] almostSorted(int size){
        int[] a = new int[size];
        for (int i = 0; i < size; i++){
            if (i < 0.9 * size) a[i] = i;
            else a[i] = (int)(size - i + (0.9 * size) - 1);
        }
        return a;
    }

    public static int[] random(int size){
        int[] a = new int[size];
        for (int i = 0; i < size; i++){
            a[i] = (int)(Math.random() * 5 * size);
        }
        return a;
    }
}
class Main{
    public static void main(String[] args){
//        int[] size1 = new int[] {5000, 10000, 12000, 15000, 17000, 20000};
//        int[] size2 = new int[] {20000, 100000, 200000, 350000, 500000, 700000};
          int[] arr = new int[10000];
          long start = System.nanoTime();
          arr = Arrays.sorted(arr.length);
          long end = System.nanoTime();
          long time = end - start;
          System.out.println(time/1000000);
          System.out.println("Массив:");
          for (int i : arr) System.out.println(arr[i]);

    }
}
