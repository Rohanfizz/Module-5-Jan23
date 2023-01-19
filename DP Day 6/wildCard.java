
import java.util.*;
import java.lang.*;
import java.io.*;
class Solution{
    

    public static boolean isMatch(String s, String p) {
        //write your code here 
		int n = p.length();
		int m = s.length();
		boolean[][] dp = new boolean[n+1][m+1];
		dp[0][0] = true;
		for(int i = 1;i<=n;i++){
			if(p.charAt(i-1) != '*') break;
			dp[i][0] = true;
		}

		for(int i = 1;i<=n;i++){
			for(int j = 1;j<=m;j++){
				if(p.charAt(i-1) == '*') dp[i][j] = dp[i-1][j] || dp[i-1][j-1] || dp[i][j-1];
				else if(p.charAt(i-1) == '?') dp[i][j]= dp[i-1][j-1];
				else{
					if(p.charAt(i-1) == s.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
					else dp[i][j] = false;
				}
			}
		}
		return dp[n][m];
		
    }
}
/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        String pattern = sc.next();
        System.out.print(Solution.isMatch(text,pattern));
	}
}

