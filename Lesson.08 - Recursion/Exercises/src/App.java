public class App {
    static int x = 0;
    public static void main(String[] args) throws Exception {
        int[] vec = new int[5];

        for (int i = 0; i < vec.length; ++i) {
            vec[i] = i + 1;
        }

        stackOverflow();
    }

    private static void swap(int[] v, int i, int j) {
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }

    private static void print(int[] v) {
        for (int i = 0; i < v.length; ++i) {
            System.out.print(String.valueOf(v[i]) + " ");
        }

        System.out.println();
    }

    private static void stackOverflow() {
        System.out.println(String.valueOf(x));
        x++;
        stackOverflow();
    }
}