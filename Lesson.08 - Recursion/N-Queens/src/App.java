public class App {
    static int solutionCount = 0;
    public static void main(String[] args) throws Exception {
        int[][] board = new int[8][8];

        // queens(board, 0);
        onlyOneQueens(board, 0);
    }

    private static boolean queenOk(int[][] board, int qRow, int qCol) {
        for (int col = qCol - 1; col >= 0; --col) {
            if (board[qRow][col] == 1) {
                return false;
            }
        }

        for (int row = qRow - 1, col = qCol - 1; row >= 0 && col >= 0; --row, --col) {
            if (board[row][col] == 1) {
                return false;
            }
        }


        for (int row = qRow + 1, col = qCol - 1; row < 8 && col >= 0; ++row, --col) {
            if (board[row][col] == 1) {
                return false;
            }
        }

        return true;
    }

    private static void queens(int[][] board, int col) {
        if (col == 8) {
            ++solutionCount;
            System.out.printf("Solution no. %d\n", solutionCount);
            printBoard(board);
            return;
        }

        for (int qRow = 0; qRow < 8; ++qRow) {
            board[qRow][col] = 1;
         
            if (queenOk(board, qRow, col)) {
                queens(board, col + 1);
            }

            board[qRow][col] = 0;
        }
    } 

    private static boolean onlyOneQueens(int[][] board, int col) {
        for (int qRow = 0; qRow < 8; ++qRow) {
            board[qRow][col] = 1;
         
            if (queenOk(board, qRow, col)) {
                // TRY TO FIGURE OUT THE SOLUTION
            }

            board[qRow][col] = 0;
        }

        return false;
    } 

    private static void printBoard(int[][] b) {
        for (int i = 0; i < b.length; ++i) {
            for (int j = 0; j < b[i].length; ++j) {
                System.out.printf("%c\t", b[i][j] == 0 ? '*' : 'Q');
            }

            System.out.println();
            System.out.println();
        }
    }
}
