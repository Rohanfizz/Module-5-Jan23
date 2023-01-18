
import java.util.*;
import java.lang.*;
import java.io.*;
class Solution{
    public static int longestPalindromeSubseq(String s) {
        //Write your code here
		int n = s.length();
		int[][] dp = new int[n][n];

		for(int g = 0;g<n;g++){
			for(int i = 0,j = g;j<n;i++,j++){
				if(g == 0) dp[i][j] = 1;
				else if(g == 1) dp[i][j] = s.charAt(i) == s.charAt(j)?2:1;
				else{
					if(s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i+1][j-1] + 2;
					else dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
				}
			}
		}
		return dp[0][n-1];
    }
    
    
}
/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.print(Solution.longestPalindromeSubseq(s));

	}
}

