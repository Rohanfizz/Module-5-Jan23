
import java.util.*;

class Solution {

	public static void solve(int[] coins,int tar,String asf){
		if(tar == 0){
			System.out.println(asf);
			return;
		}
		if(tar<0) return;
		for(int coin: coins){
			solve(coins,tar-coin,asf+coin+" ");
		}
	}
	
    public static void coinChange2(int[] coins, int amt){
        //Write your code here
		solve(coins,amt,"");
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
        Obj.coinChange2(coins, amt);
    }
}