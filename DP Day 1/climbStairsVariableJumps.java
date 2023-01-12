import java.util.*;

class Solution {

	public int recur(int[] jump,int idx,int[] memo){
		if(idx == jump.length) return 1;
		if(memo[idx] > 0) return memo[idx];
		int myAns = 0;
		for(int i = 1;i<=jump[idx] && i+idx<=jump.length;i++){
			myAns+=recur(jump,idx+i,memo);
		}
		return memo[idx] = myAns;
	}

	public int tabulation(int[] jump,int[] dp){
		for(int idx = jump.length;idx>=0;idx--){
			if(idx == jump.length){
				dp[idx] = 1; continue;
			}
			int myAns = 0;
			for(int i = 1;i<=jump[idx] && i+idx<=jump.length;i++){
				myAns+=dp[idx+i];//recur(jump,idx+i,dp);
			}
			dp[idx] = myAns;
		}
		return dp[0];
	}
	
    public int stairWays(int[] jump) {
        //Write code here
		int[] dp = new int[jump.length+1];
		return tabulation(jump,dp);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        int res = Obj.stairWays(arr);
        System.out.println(res);
        sc.close();
    }
}