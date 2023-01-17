import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cost[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            cost[i][0] = sc.nextInt();
            cost[i][1] = sc.nextInt();
            cost[i][2] = sc.nextInt();
        }

        Solution obj = new Solution();
        int ans = obj.solve(cost, n);
        System.out.println(ans);

        sc.close();

    }
}

class Solution {

	public int recur(int cost[][],int idx,int color){
		if(idx == 0) return cost[idx][color];

		if(color == 0){
			int pb = recur(cost,idx-1,1);
			int pg = recur(cost,idx-1,2);
				return Math.min(pb,pg) + cost[idx][color];
		}else if(color == 1){
			int pr = recur(cost,idx-1,0);
			int pg = recur(cost,idx-1,2);
			return Math.min(pr,pg) + cost[idx][color];
		}else{
			int pr = recur(cost,idx-1,0);
			int pb = recur(cost,idx-1,1);
			return Math.min(pr,pb) + cost[idx][color];
		}
	}

	public int tabulation(int cost[][]){
		int[][] dp = new int[cost.length][3];
		int n= cost.length;
		for(int idx = 0;idx<cost.length;idx++){
			for(int color = 0;color<3;color++){
				if(idx == 0){
					dp[idx][color]= cost[idx][color];
					continue;
				}
				if(color == 0){
					int pb = dp[idx-1][1];
					int pg = dp[idx-1][2];
					dp[idx][color] = Math.min(pb,pg) + cost[idx][color];
				}else if(color == 1){
					int pr = dp[idx-1][0];
					int pg = dp[idx-1][2];
					dp[idx][color] = Math.min(pr,pg) + cost[idx][color];
				}else{
					int pr = dp[idx-1][0];
					int pb = dp[idx-1][1];
					dp[idx][color] =  Math.min(pr,pb) + cost[idx][color];
				}
				
			}
		}
		return Math.min(dp[n-1][0] , Math.min(dp[n-1][1],dp[n-1][2]));
	}
	
	
    public int solve(int cost[][], int n) {
        // Your code here
		// return Math.min(recur(cost,n-1,0),Math.min(recur(cost,n-1,1),recur(cost,n-1,2)));
		return tabulation(cost);
    }
}















