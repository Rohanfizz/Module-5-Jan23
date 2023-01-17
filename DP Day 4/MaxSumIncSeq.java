import java.io.*;
import java.util.*; 

class Main{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; ++i){
            array[i] = sc.nextInt();
        }
        Solution ob = new Solution();
        System.out.println(ob.maxSumIncreasingSubsequence(n,array));
    } 
} 

class Solution 
{

	static int solve(int[] a){
		int[] dp = new int[a.length];
		for(int i = 0;i<a.length;i++){
			int prevBest = 0;
			for(int j= i-1;j>=0;j--){
				if(a[j] >= a[i]) continue;
				prevBest = Math.max(prevBest,dp[j]);
			}
			dp[i] = prevBest + a[i];
		}
		int ans= 0;
		for(int x:dp) ans = Math.max(x,ans);
		return ans;
	}

	
    static int maxSumIncreasingSubsequence(int size, int a[])
    {
        // code here
		return solve(a);
    }
} 












