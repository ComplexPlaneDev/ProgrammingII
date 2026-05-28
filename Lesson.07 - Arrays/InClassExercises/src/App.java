public class App {
    public static void main(String[] args) throws Exception {
        int[] x = new int[100];
        int myLength = 5;
        
        x[0] = 3;
        x[1] = 4;
        x[2] = 0;
        x[3] = 10;
        x[4] = 7;

        
        x[5] = 1;

        x[6] = 2;

        // myLength = insert(x, myLength, myLength, 11);
        // reverse(x, myLength);
        int sL = secondLarge(x, myLength);
        System.out.println("Hello, World!");
    }

    private static int insert(int[] v, int length, int pos, int value) {

        for (int i = length - 1; i >= pos; --i) {
            v[i + 1] = v[i];
        }

        v[pos] = value;
        return length + 1;
    }

    private static int delete(int[] v, int length, int pos) {
        for (int i = pos; i < length - 1; ++i) {
            v[i] = v[i + 1];
        }

        return length - 1;
    }

    private static void reverse(int[] v, int length) {
        int mid = length % 2 == 1 ? length / 2 + 1 : length / 2;

        for (int i = 0; i < mid; ++i) {
            int temp = v[i];
            v[i] = v[length - i - 1];
            v[length - i - 1] = temp;
        }
    }

    private static Integer secondLarge(int[] v, int length) {
        int max = v[0];
        Integer secondMax = null;

        for (int i = 1; i < length; ++i) {
            if (v[i] > max) {
                secondMax = max;
                max = v[i];
            }

            if (v[i] > secondMax && v[i] < max) {
                secondMax = v[i];
            }
        }

        /*
        if (v[length - 1] > secondMax && v[length - 1] < max) {
            secondMax = v[length - 1];
        }
        */

        return secondMax;
    }
}

