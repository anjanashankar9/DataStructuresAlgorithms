/**
 * @Author Anjana Shankar
 * @Created 2020-12-09
 */
public class Knapsack01 {

    int[][] memoization;
    int[][] dp;

    private void initialize(int w, int n) {
        memoization = new int[n+1][w+1];
        dp = new int[n+1][w+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=w; j++) {
                memoization[i][j] = -1;
            }
        }
    }


    // Memoization
    public int knapsackMemoization(int w, int[] wt, int[] val, int n) {
        if (n==0 || w == 0)
            return 0;

        if(memoization[n][w] != -1) {
            return memoization[n][w];
        }

        if(wt[n-1] <= w) {
            memoization[n][w] = Math.max(val[n-1] + knapsack(w-wt[n-1], wt, val, n-1),
                    knapsack(w, wt, val, n-1));
            return memoization[n][w];
        }
        else {
            memoization[n][w] = knapsack(w, wt, val, n - 1);
            return memoization[n][w];
        }
    }


    // Recursion
    public int knapsack(int w, int[] wt, int[] val, int n) {
        if (n==0 || w == 0)
            return 0;

        if(wt[n-1] <= w) {
            return Math.max(val[n-1] + knapsack(w-wt[n-1], wt, val, n-1),
                    knapsack(w, wt, val, n-1));
        }
        else
            return knapsack(w, wt, val, n-1);
    }

    // Bottom up Approach
    public int knapsackBottomUp(int w, int[] wt, int[] val, int n) {
       for(int i=1; i<=n; i++) {
           for(int j=1; j<=w; j++) {
               if(wt[i-1] <= j)
                   dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]],
                       dp[i-1][w]);
               else
                   dp[i][j] = dp[i-1][j];
           }

       }
       return dp[n][w];
    }

    public static void main(String[] args) {
        int[] value = {6,10,12};
        int[] weight = {1,2,3};

        int W = 5;

        int result = new Knapsack01().knapsack(W,weight, value, weight.length);
        System.out.println(result);

        Knapsack01 kp = new Knapsack01();
        kp.initialize(W, weight.length);
        result =  kp.knapsackMemoization(W,weight, value, weight.length);
        System.out.println(result);

        result =  kp.knapsackBottomUp(W,weight, value, weight.length);
        System.out.println(result);
    }
}

/*
You’re a burglar with a knapsack that can hold a total weight of capacity. You have a set of items (n items) each with fixed weight capacities and values. The weight and value are represented in an integer array. Create a function knapsack() that finds a subset or number of these items that will maximize value but whose total weight does not exceed the given number capacity.


Knapsack Question Variants
There are two major variants of this question, fractional or 0-1. The fractional variant allows you to break items to maximize the value in the pack. The 0-1 variant does not allow you to break items.

Another common variant is the constrained knapsack problem that restricts your program so you cannot select any item more than once. When an element is selected, the program must decide if it should place it in the pack or leave it.

At senior level interviews, you’ll encounter variants that add volume as a constrained attribute. In this case, each item also has a fixed volume, and the knapsack has a volume limit.
 */
