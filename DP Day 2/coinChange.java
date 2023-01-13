import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int sum = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Solution s = new Solution();
        System.out.println(s.coinChange(arr, sum));
    }
}

class Solution {

	public int recur(int[] arr,int idx,int csum){
		if(csum == 0) return 1;
		if(csum<0 || idx == arr.length) return 0;
		int stay = recur(arr,idx,csum-arr[idx]);
		int move = recur(arr,idx+1,csum);
		return stay + move;
	}

	public int tabulation(int[] arr,int sum){
		int[][] dp = new int[arr.length][sum+1];
		for(int idx = arr.length-1;idx>=0;idx--){
			for(int csum = 0;csum<=sum;csum++){
				if(csum == 0){
					dp[idx][csum] = 1;
					continue;
				}
				int stay = csum-arr[idx]>=0?dp[idx][csum-arr[idx]]:0;//recur(arr,idx,csum-arr[idx]);
				int move = idx+1<arr.length?dp[idx+1][csum]:0;//recur(arr,idx+1,csum);
				dp[idx][csum] = stay + move;
			}
		}
		return dp[0][sum];
	}
	
    public int coinChange(int[] arr, int sum) {
		// return recur(arr,0,sum);
		return tabulation(arr,sum);
    }
}














