/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int[][] b = new int[a.length][a.length];
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                b[i][j] = a[i][j];
            }
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < a.length; j++) {
                if (b[i][j] > 0 && b[i - 1][j - 1] > 0 && b[i - 1][j] > 0 && b[i][j - 1] > 0) {
                    if (b[i][j - 1] >= b[i - 1][j - 1] && b[i - 1][j] >= b[i - 1][j - 1]) {
                        b[i][j] = b[i - 1][j - 1] + 1;
                    }
                    else b[i][j] =
                            Math.min(b[i - 1][j], b[i][j - 1]) + 1;

                }

            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {

                ;
                cnt = Math.max(cnt, b[i][j]);
            }
        }
        return cnt;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {


        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = StdIn.readInt();
            }
        }
        StdOut.println(size(a));

    }
}
