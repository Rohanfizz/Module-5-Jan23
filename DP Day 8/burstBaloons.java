import java.util.*;

class Solution {
	public int recur(int[] nums,int i,int j,int[][] dp){
		if(i>j) return 0;
		if(dp[i][j] != 0) return dp[i][j];
		int best = 0;
		for(int k = i;k<=j;k++){
			int left = recur(nums,i,k-1,dp);
			int right = recur(nums,k+1,j,dp);
			int val = nums[k];
			if(i != 0) val *= nums[i-1];
			if(j != nums.length-1) val *= nums[j+1];
			int myVal = left + val + right;
			best = Math.max(best,myVal);
		}
		return dp[i][j] = best;
	}
    public int maxCoins(int[] nums) {
        //Write your code here
		int n = nums.length;
		int[][] dp = new int[n][n];

		for(int g = 0;g<n;g++){
			for(int i = 0,j = g;j<n;i++,j++){
				if(g == 0){
					int leftAdj = i==0?1:nums[i-1];
					int rightAdj = j == n-1?1:nums[j+1];
					dp[i][j] = leftAdj * nums[i] * rightAdj;
				}else{
					int best= 0;
					for(int k = i;k<=j;k++){
						int leftHalf = k-1<i?0:dp[i][k-1];
						int rightHalf = k+1>j?0:dp[k+1][j];
						
						int leftAdj = i==0?1:nums[i-1];
						int rightAdj = j == n-1?1:nums[j+1];
						int myVal = (leftAdj * nums[k] * rightAdj);
						int myAns = leftHalf + rightHalf + myVal;
						best = Math.max(best,myAns);
					}
					dp[i][j] = best;
				}
			}
		}
		return dp[0][n-1];
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int arr[] = new int[N];
        for(int i=0; i<N; i++){
            arr[i]= sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.maxCoins(arr));

    }
}