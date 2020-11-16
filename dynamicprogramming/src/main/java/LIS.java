/**
 * @Author Anjana Shankar
 * @Created 2020-08-30
 */

/*
 * Longest Increasing Subsequence
 * The longest Increasing Subsequence (LIS) problem is to find the 
 * length of the longest subsequence of a given sequence such that
 * all elements of the subsequence are sorted in increasing order. 
 * For example, length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 }
 * is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 */
public class LIS {
	public static int findLongestIncreasingSubsequence(int [] arr){
		int dpTable[] = new int[arr.length];
		for(int i=0;i<arr.length;i++){
			dpTable[i] = 1;
		}
		printDp(dpTable);
		for(int i=1;i<arr.length;i++){
			for(int j=0;j<i;j++){
				if((arr[i]>arr[j]) && (dpTable[i]<dpTable[j]+1)){
					dpTable[i]=dpTable[j]+1;
				}
			}
			printDp(dpTable);
		}
		
		//findMax
		int max = dpTable[0];
		for(int i=1;i<arr.length;i++){
			max=Math.max(dpTable[i],max);
		}
		return max;
		
	}

	public static void printDp(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
