public class App {
    public static void main(String[] args) throws Exception {
        int[][] inp = new int[10][10];

        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                inp[i][j] = Math.round((float) Math.random() * 10.0f);
                System.out.printf("%d\t", inp[i][j]);
            }

            System.out.printf("\n\n");
        }
        System.out.printf("\n");

        System.out.printf("Diagonal difference: %d\n", diagonalDifference(inp));
        System.out.printf("Min-Max sum: %d\n", minMaxSum(inp[0]));
        System.out.printf("Birthday cake candles: %d\n", birthDayCakeCandles(inp[0]));
    }

    /*
     * The following algorithms must be implemented using a single-pass loop.
     * You can use additional variables, but no additional arrays.
     */

    private static int diagonalDifference(int[][] m) {
        return 0;
    }

    private static int minMaxSum(int[] v) {
        return 0;
    }

    private static int birthDayCakeCandles(int[] v) {
        return 0;
    }
}
