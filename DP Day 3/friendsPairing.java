import java.util.*;

class Solution {
	public int recur(int n){
		int md =(int) 1e9 + 7;
		if(n == 0) return 1;
		if(n == 1) return 1;
		
		int single = recur(n-1)%md;
		int pair = (((n-1)%md) * recur(n-2)%md)%md;
		return ((single%md) + pair%md)%md;
	}
	public int tabulation(int n){
		int[] dp = new int[n+1];
		int md =(int) 10000007 ;
		for(int i = 0;i<=n;i++){
			if(i <= 1){
				dp[i] = 1;
				continue;
			}
			int single = dp[i-1]%md;
			int pair = (((i-1)%md)*dp[i-2]%md)%md;
			dp[i] = ((single%md) + (pair%md))%md;
		}
		
		return dp[n]%md;
	}
    public int countFriendWays(int n) {
        // write your code here
		return tabulation(n);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.countFriendWays(N));

    }
}