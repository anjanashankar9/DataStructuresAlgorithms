/**
 * @Author Anjana Shankar
 * @Created 2020-08-24
 */
// Print Nth row of Pascal triangle without
// storing in a 2D array.

public class PascalTriangle {

    /*
    Triangle is
    1 1
    1 2 1
    1 3 3 1
    1 4 6 4 1

    If you observe the Nth row is
    nC0, nC1, nC2, ..., nCn
     */
    public static void main(String[] args) {
        int N = 5;
        generateNthRow(N);

    }

    private static void generateNthRow(int n) {
        int prev = 1;
        System.out.print(prev);

        for (int i=1; i<= n; i++) {
            // nCr = (nC(r-1) + (n-r+1)/r)
            int curr = (prev * (n-i+1))/i;
            System.out.print(", " + curr);
            prev = curr;
        }
    }
}
