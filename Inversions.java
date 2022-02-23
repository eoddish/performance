/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long cnt = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (i < j && a[i] > a[j]) cnt++;
            }
        }
        return cnt;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {

        int[] a = new int[n];
        if (n == 0 && k == 0) return a;
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        if (k >= n - 1) {
            int c = 0;
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                if (k + c >= n - 1) {
                    b[i] = a[n - 1 - i];
                    k = k - n + 1 + c;
                    c++;
                }
                else {

                    b[n - 1 - i + c] = a[n - 1 - i];
                }


            }
            for (int j = 1; k > 0; j++) {

                int temp = b[n - 1 - j];
                b[n - 1 - j] = b[n - 1];
                b[n - 1] = temp;
                k--;
            }

            a = b;

        }
        else {
            for (int i = 0; k >= 0; i++) {

                int temp = a[n - 1 - i];
                a[n - 1 - i] = a[n - 1];
                a[n - 1] = temp;
                k--;
            }
        }

        return a;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int[] a = generate(n, k);
        for (int i = 0; i < n; i++) {
            StdOut.print(a[i] + " ");
        }


    }
}
