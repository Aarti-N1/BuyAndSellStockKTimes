package hard;

public class BuySellStockKTimes_188 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] prices = {3,2,6,5,0,3};
		int[] prices = {2,4,1};
		System.out.println(maxProfit(3, prices));
	}

	public static int maxProfit(int k, int[] prices) {
//memoization table
		int[][] T = new int[k+1][prices.length];
// initializing day 0 and txn 0
		/* No need as default value is already 0
		  for(int j=0; j<prices.length; j++)
		   	T[0][j] =0; 
		  for(int i=0; i<k; i++) 
		  	T[i][0] =0;
		 */
		for(int i=1; i<k+1; i++) {
			int maxDiff = -prices[0];
			System.out.println("initial MaxDiff= "+ maxDiff);

			for(int j=1;j<prices.length;j++) {
				T[i][j]= Math.max(T[i][j-1],
								maxDiff + prices[j]);
//calculating maxDiff for next iteration maxDiff = max(maxDiff, T[i-1][j]-prices[j]) 
				maxDiff = Math.max(maxDiff, T[i-1][j] - prices[j]);
			}
		}
		printT(T, k+1, prices.length);
		return T[k][prices.length-1];
	}
	public static void printT(int[][] T, int rows, int cols) {
		for(int i=0; i<rows; i++) {
			for(int j=0;j<cols;j++) {
				System.out.print(T[i][j]+ ", ");
			}
			System.out.println();
		}
	}
}
