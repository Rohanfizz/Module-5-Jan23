import java.util.*;
class Solution{
public static int superEggDrop(int eggs, int floors,int[][] dp) {
        // Your code here
	if(floors == 0) return 0;
	if(floors == 1) return 1;
	if(eggs == 1) return floors;
	if(dp[eggs][floors] != 0) return dp[eggs][floors];

	int myAns = Integer.MAX_VALUE;
	for(int cf = 1;cf<=floors;cf++){
		int breaks = superEggDrop(eggs-1,cf-1,dp);
		int survives = superEggDrop(eggs,floors-cf,dp);
		int myMoves = 1 + Math.max(breaks,survives);
		myAns = Math.min(myAns,myMoves);
	}
	return dp[eggs][floors] = myAns;
}
}
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
		int[][] dp = new int[k+1][n+1];
        sc.close();
        System.out.println(Solution.superEggDrop(k, n,dp));
    }
}