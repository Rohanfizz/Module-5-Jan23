import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int sum = Integer.parseInt(line[1]);
        int[] arr = new int[n];
        line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        Solution sol = new Solution();
        Boolean ans = sol.subsetSum(arr, n, sum);
        if(ans) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

class Solution {

	public boolean recur(int[] arr,int idx,int csum){
		if(csum ==0) return true;
		if(idx == arr.length || csum<0) return false;
		
		boolean pick = recur(arr,idx+1,csum-arr[idx]);
		boolean notpick = recur(arr,idx+1,csum);

		return pick || notpick;
	}

	public boolean subsetSumTabulation(int[] arr,int sum){
		boolean[][] dp = new boolean[arr.length+1][sum+1];
		for(int i = 0;i<arr.length;i++){
			dp[i][0] = true;
		}
		for(int i = 1;i<=arr.length;i++){
			for(int j = 1;j<=sum;j++){
				// if we exclude
				boolean exc = dp[i-1][j];
				boolean include = j-arr[i-1]>=0?dp[i-1][j-arr[i-1]]:false;
				dp[i][j] = exc || include;
			}
		}
		return dp[arr.length][sum];
	}
	
    public boolean subsetSum(int[] arr, int n, int sum) {
		// return recur(arr,0,sum);
		return subsetSumTabulation(arr,sum);
    }
}
