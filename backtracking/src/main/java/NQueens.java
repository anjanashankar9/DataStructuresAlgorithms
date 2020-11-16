/**
 * @Author Anjana Shankar
 * @Created 2020-08-18
 */

public class NQueens {

    /*
    Helper Function to print the board.
    1 indicates Queen is placed in this grid.
    0 indicates a free grid
    */
    private static void printSolution(int board[][], int N) {
        for (int i=0; i<N; i++) {
            for (int j=0 ;j<N; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /*
    A utility function to check if its safe to place a queen in [row][col]
    This will only be checking for clashes with already placed queens,
    that is till [row-1][col-1]
     */
    private static boolean isSafe(int board[][], int row, int col, int N) {
        // Check if a queen is already placed on this row.
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (int i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    private static boolean solveNQUtil(int[][] board, int col, int N) {
        // Base Case: All queens are placed
        if (col >= N)
            return true;

        for (int i = 0; i < N; i++) {
            // Check if the queen can be placed on board[i][col]
            if (isSafe(board, i, col, N)) {
                // Place this queen in board[i][col]
                board[i][col] = 1;

                /* recur to place rest of the queens */
                if (solveNQUtil(board, col + 1, N) == true)
                    return true;

                /* Since placing queen in board[i][col]
                doesn't lead to a solution then
                remove queen from board[i][col] */
                board[i][col] = 0; // BACKTRACK FROM HERE
            }
        }

        /* Queen could not be placed on any row for this col */
        return false;
    }

    private static void solveNQueen(int N) {
        int board[][] = new int[N][N];

        if (solveNQUtil(board, 0, N) == false) {
            System.out.println("Solution does not exist");
            return;
        }

        printSolution(board, N);
    }

    public static void main(String args[]) {
        int N = 4; // Number of Queens

        solveNQueen(N);
    }

}


