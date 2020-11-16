/**
 * @Author Anjana Shankar
 * @Created 2020-08-30
 */

/*
 * Given a value N, if we want to make change for N cents, and we have infinite supply
 *  of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? 
 *  The order of coins doesn�t matter.
 *  For example, for N = 4 and S = {1,2,3}, there are four solutions: 
 *  {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6}, 
 *  there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. 
 *  So the output should be 5.
 *  
 */
public class CoinChange {

    public static void coinChange(){
        int amount =4;
        int[] v= {1,2,3};
        int ways = coinChange(amount,v);
        System.out.println(ways);
    }

    private static int coinChange(int amount, int[] v) {
        int solution[][] = new int[v.length+1][amount+1];
        //if the amount is 0, there is exactly one solution, that is an empty set
        for(int i=0;i<v.length+1;i++){
            solution[i][0]=1;
        }
        //if there are no coins, there are 0 ways to reach the amount
        for(int i=1;i<amount+1;i++){
            solution[0][i] = 0;
        }

        for(int i=1;i<v.length+1;i++){
            for(int j=1;j<amount+1;j++){
                //if the coin value is less than the amount
                if(v[i-1] <= j){
                    solution[i][j] = solution[i-1][j] + solution[i][j-v[i-1]];
                } else {
                    solution[i][j] = solution[i-1][j];
                }
            }
        }
        return solution[v.length][amount];
    }

}
