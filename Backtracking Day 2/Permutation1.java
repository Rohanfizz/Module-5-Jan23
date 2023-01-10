
import java.util.*;

class Solution {
	public static void solve(int[] coins,int tar,String asf,boolean[] vis){
		if(tar == 0){
			System.out.println(asf);
			return;
		}
		if(tar<0) return;
		for(int i = 0;i<coins.length;i++){
			if(vis[i]) continue;
			vis[i] = true;
			solve(coins,tar-coins[i],asf+coins[i]+" ",vis);
			vis[i] = false;
		}
	}
    public static void coinChange(int[] coins, int amt){
        //Write your code here
		boolean[] vis = new boolean[coins.length];
		solve(coins,amt,"",vis);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int amt = sc.nextInt();

        Solution Obj = new Solution();
        Obj.coinChange(coins, amt);
    }
}