/**
 * @Author Anjana Shankar
 * @Created 2020-08-30
 */

public class DPMain {
	public static void main(String[] args){
//		callLIS();
		callCoinChange();
	}

	private static void callCoinChange() {
		CoinChange.coinChange();
	}

	private static void callLIS(){
		int [] arr = {10, 22, 9, 33, 21, 50, 41, 60,80 };
		int length = LIS.findLongestIncreasingSubsequence(arr);
		System.out.println("Longest Increasing Subsequence is of length : "+length);
	}
}
