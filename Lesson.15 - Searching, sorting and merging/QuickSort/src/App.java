public class App {
    public static void main(String[] args) throws Exception {
        int[] x = { 2, -4, 1, 0, 7, 10, 20, 15, -5, 9, 6, 11, 12, 1, 90, -20, 17, 3, 7 };

        quickSort(x, 0, x.length - 1);
    }

    private static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(int arr[], int begin, int end) {
        int pivot = arr[begin];
        int L = begin - 1;
        int R = end + 1;

        while (true) {
            // Find leftmost element >= pivot
            do {
                L++;
            } while (arr[L] < pivot);

            // Find rightmost element <= pivot
            do {
                R--;
            } while (arr[R] > pivot);

            // If pointers cross, partition is complete
            if (L >= R) {
                return R;
            }

            // Swap elements
            int temp = arr[L];
            arr[L] = arr[R];
            arr[R] = temp;
        }
    }
}
