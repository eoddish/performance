/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Ramanujan {


    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {

        for (long a = 1; a <= Math.cbrt(n); a++) {
            long a3 = a * a * a;
            if (a3 > n) break;

            if (Math.cbrt(n - a3) % 1 == 0) {

                for (long c = a + 1; c <= Math.cbrt(n); c++) {
                    long c3 = c * c * c;
                    if (c3 > n) break;
                    if (Math.cbrt(n - c3) % 1 == 0 && Math.cbrt(n - c3) != 1.0 * a) {


                        return true;
                    }
                }
            }
        }

        return false;
    }


    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);

        System.out.println(isRamanujan(n));
    }
}
