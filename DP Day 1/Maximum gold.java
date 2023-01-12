import java.io.*;
import java.util.*;

class Main{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int M[][] = new int[n][m];
        for(int i = 0;i < n*m;i++){
            M[i/m][i%m] = sc.nextInt();
        }
        
        Solution ob = new Solution();
        System.out.println(ob.maxGold(n, m, M));
    }
} 

class Solution{

	static int recur(int i,int j,int[][] M){
		if(i<0 || j<0 || i==M.length || j==M[0].length) return 0;
		if(j==M[0].length) return M[i][j];
		int diagUp = recur(i-1,j+1,M);
		int right = recur(i,j+1,M);
		int diagDown = recur(i+1,j+1,M);
		return Math.max(diagUp,Math.max(right,diagDown)) + M[i][j];
	}
	static int recur(int ii,int jj,int[][] M,int[][] dp){
		for(int j = M[0].length-1;j>=0;j--){
			for(int i = 0;i<M.length;i++){
				if(j==M[0].length-1){
					 dp[i][j] = M[i][j];
					continue;
				}
				if(dp[i][j] != 0) continue;
				int diagUp = i-1>=0?dp[i-1][j+1]:0;
				int right = dp[i][j+1];
				int diagDown =i+1<M.length?dp[i+1][j+1]:0;
				dp[i][j] = Math.max(diagUp,Math.max(right,diagDown)) + M[i][j];
			}
		}
		return dp[ii][jj];
		
	}
	
    static int maxGold(int n, int m, int[][] M){
        //Write code here
		int ans = 0;
		int[][] memo = new int[n][m];
		for(int i = 0;i<n;i++){
			ans = Math.max(ans,recur(i,0,M,memo));
		}
		return ans;
    }   
}