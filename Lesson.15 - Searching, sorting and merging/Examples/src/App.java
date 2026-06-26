public class App {
    public static void main(String[] args) throws Exception {
        int[] x = {8, 2, 3, 5, 4, 6, 7, 1, 9, 10};

        // System.out.println(binarySearch(x, 8));
        // System.out.println(binarySearch(x, -3));

        bubbleSort(x);
    }

    /*
   private static int linearWithSentinel() {
        int[] x = {1, 2, 3, 4, 5};

        int p = 6;
        int i = 0;
        int len = 5;
        for (i = 0; x[i] != p; i++) ;

        if (i == len) {
            // not found
        }
   }
         */

  /*
   private static int binarySearch(int[] x, int v) {
    int si = 0;
    int ei = x.length - 1;

    do {
        int middle = (si + ei) / 2;
        if (x[middle] == v) {
            return middle;
        }

        if (v > x[middle]) {
            si = middle;
        } else {
            ei = middle;
        }
    } while (si < ei);

    return -1;
  }

  private void selectionSort(int[] x) {
    for (int i = 0; i < x.length; ++i) {
        int minIdx = minElement(x, i);

        int temp = x[i];
        x[i] = x[minIdx];
        x[minIdx] = temp;
    }
  }
 */

  private static void bubbleSort(int[] x) {
    boolean swapped = false;

    do {
        swapped = false;
        for (int i = 0; i < x.length - 1; ++i) {
            if (x[i] > x[i + 1]) {
                int temp = x[i];
                x[i] = x[i + 1];
                x[i + 1] = temp;

                swapped = true;
            }
        }
    } while (swapped);
  }
}
